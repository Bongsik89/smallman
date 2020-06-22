package org.smallman.board.vo;

import java.sql.Timestamp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ReplyVO {
	
	private String r_id;
	private String r_content;
	private Timestamp r_reg_date;
	private int r_index;
	private int b_num;

}
