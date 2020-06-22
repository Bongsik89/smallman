package org.smallman.board.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class ReplyDAOIpml {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	final static String NAMESPACE_BOARD = "org.smallman.board.mappers.replyMapper";

}
