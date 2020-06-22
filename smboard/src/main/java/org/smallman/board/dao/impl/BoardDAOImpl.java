package org.smallman.board.dao.impl;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.smallman.board.common.paging.PageCriteria;
import org.smallman.board.dao.BoardDAO;
import org.smallman.board.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	final static String NAMESPACE_BOARD = "org.smallman.board.mappers.boardMapper";

	@Override
	public List<BoardVO> listPageCriteria(PageCriteria pc) throws Exception {
		return sqlSession.selectList(NAMESPACE_BOARD + ".listPageCriteria", pc);
	}

	@Override
	public Integer totalCount() throws Exception {
		return sqlSession.selectOne(NAMESPACE_BOARD + ".totalCount");
	}

	@Override
	public BoardVO boardRead(HashMap<String, Object> params) throws Exception {
		return sqlSession.selectOne(NAMESPACE_BOARD + ".boardRead", params);
	}

	@Override
	public void countHit(int b_num) throws Exception {
		sqlSession.update(NAMESPACE_BOARD + ".countHit", b_num);

	}

	@Override
	public void boardWrite(HashMap<String, Object> params) throws Exception {
		sqlSession.insert(NAMESPACE_BOARD + ".boardWrite", params);

	}

	@Override
	public void boardUpdate(HashMap<String, Object> params) throws Exception {
		sqlSession.update(NAMESPACE_BOARD + ".boardUpdate", params);

	}

	@Override
	public void boardDelete(HashMap<String, Object> params) throws Exception {
		sqlSession.delete(NAMESPACE_BOARD + ".boardDelete", params);

	}

	@Override
	public void countReply(int b_num) throws Exception {
		sqlSession.update(NAMESPACE_BOARD + ".countReply", b_num);

	}

	@Override
	public List<BoardVO> searchBoard(HashMap<String, Object> search_params) throws Exception {
		return sqlSession.selectList(NAMESPACE_BOARD + ".searchBoard", search_params);
	}

	@Override
	public Integer searchTotalCount(HashMap<String, Object> params) throws Exception {
		return sqlSession.selectOne(NAMESPACE_BOARD + ".searchTotalCount", params);
	}

	@Override
	public void countRecommned(HashMap<String, Object> params) throws Exception {
		sqlSession.update(NAMESPACE_BOARD + ".countRecommend", params);

	}

}
