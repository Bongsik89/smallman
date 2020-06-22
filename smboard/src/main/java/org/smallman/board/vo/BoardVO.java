package org.smallman.board.vo;

import java.sql.Timestamp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class BoardVO {
	
	private int b_num;
	private String b_title;
	private String b_content;
	private String b_writer;
	private int b_hit;
	private int b_recommend;
	private Timestamp b_reg_date;
	private int b_reply_count;

}
