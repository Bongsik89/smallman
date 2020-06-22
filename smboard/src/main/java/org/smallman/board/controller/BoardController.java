package org.smallman.board.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.smallman.board.common.paging.PageCriteria;
import org.smallman.board.common.paging.PageMaker;
import org.smallman.board.common.paging.ReplyPageCriteria;
import org.smallman.board.service.BoardService;
import org.smallman.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
		// 메인 화면 호출
		// pc에 담기는 파라미터 page, perPageNum
		@RequestMapping(value = "/", method = RequestMethod.GET)
		public String responseIndex(@ModelAttribute("pc") PageCriteria pc, Model model) throws Exception {
			// view > controller
			// Controller에서 view가 전송하는 parameter를 받는 여러가지 방법이 있다
			// 아래 예시(변수타입은 파라미터에 맞게 변경)
			// - @RequestParam String 변수명 (파라미터 1개)
			// - @RequestParam("키값") String 변수명 (데이터 커맨드를 키값으로 명시)
			// - @RequestParam String 변수명, @RequestParam int 변수명 (파라미터 2개)
			// 받아올 파라미터가 많아지게 되는 경우
			// - @RequestParam HashMap<String, Object> 변수명 (파라미터 여러개)
			// - 데이터모델(custom) 변수명 (파라미터 여러개)
			// - @ModelAttribute("키값") 데이터모델(custom) 변수명 (파라미터 여러개)
			// view(.jsp)에서 ${키값.데이터명}으로 값을 불러올 수 있다

			// 데이터 커맨드 객체로 pc를 매개변수로 넣어주고 넘어오는 page와 perPageNum 정보를 받는다
			// pc를 이용해서 service > dao > mapper.xml 순으로 접근하면서 DB 처리를 하여
			// 현재 페이지 정보를 기준으로 BoardVO 객체를 담은 ArrayList "list"가 반환된다
			List<BoardVO> bvo = boardService.listPageCriteria(pc);

			// view(.jsp)에서 페이징 처리를 위해 사용할 PageMaker 객체 생성
			PageMaker pageMaker = new PageMaker();
			pageMaker.setPc(pc);
			Integer totalPageNum = boardService.totalCount();
			pageMaker.setTotalCount(totalPageNum);

			// controller > view
			// Model vs ModelAndView
			// Model return URL경로 지정, ModelAndView return mv객체(뷰 경로 따로 지정)
			// view(.jsp)에서 페이징 처리를 위해 pageMaker 객체 저장
			// view(.jsp)에 게시글을 뿌려주기 위해 BoardVO bvo 객체 저장
			model.addAttribute("pageMaker", pageMaker);
			model.addAttribute("list", bvo);

			return "index";
		}
		
		// 글 내용 보기
		// params에 담기는 파라미터 page, perPageNum, b_num
		// rpc에 담기는 파라미터 replyPage, replyPerPageNum
		@RequestMapping("board/view")
		public String responseRead(ReplyPageCriteria rpc, @RequestParam HashMap<String, Object> params, Model model, HttpSession session) throws Exception{
			//글 내용 가져오기
			BoardVO bvo = boardService.boardRead(params);
			
			int b_num = Integer.parseInt((String) params.get("b_num"));
			
			HashMap<String, Object> reply_params = new HashMap<String, Object>();
			reply_params.put("b_num", b_num);
			reply_params.put("replyPageStart", rpc.getReplyPageStart());
			reply_params.put("replyPerPageNum", rpc.getReplyPerPageNum());
			
			//댓글 리스트 불러오기
			
			return "board/writeForm";
		}

}
