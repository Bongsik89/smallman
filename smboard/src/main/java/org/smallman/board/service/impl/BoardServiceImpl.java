package org.smallman.board.service.impl;

import java.util.HashMap;
import java.util.List;

import org.smallman.board.common.paging.PageCriteria;
import org.smallman.board.dao.BoardDAO;
import org.smallman.board.service.BoardService;
import org.smallman.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO boardDAO;

	@Override
	public List<BoardVO> listPageCriteria(PageCriteria pc) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.listPageCriteria(pc);
	}

	@Override
	public Integer totalCount() throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.totalCount();
	}

	@Override
	public BoardVO boardRead(HashMap<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		return boardDAO.boardRead(params);
	}

	@Override
	public void countHit(int b_num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boardWrite(HashMap<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boardUpdate(HashMap<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void boardDelete(HashMap<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void countReply(int b_num) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<BoardVO> searchBoard(HashMap<String, Object> search_params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer searchTotalCount(HashMap<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void countRecommned(HashMap<String, Object> params) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	

}
