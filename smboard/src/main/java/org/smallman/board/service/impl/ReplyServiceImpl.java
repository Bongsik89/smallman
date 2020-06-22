package org.smallman.board.service.impl;

import org.smallman.board.dao.ReplyDAO;
import org.smallman.board.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReplyServiceImpl implements ReplyService{
	
	@Autowired
	ReplyDAO replyDAO;

}
