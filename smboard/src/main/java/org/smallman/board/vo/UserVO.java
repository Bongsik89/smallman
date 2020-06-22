package org.smallman.board.vo;

import java.sql.Timestamp;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class UserVO {
	
	private String u_id;
	private String u_pwd;
	private String u_name;
	private String u_sex;
	private String u_birthday;
	private String u_email;
	private String u_phone_number;
	private String u_email_active_key;
	private int u_active_state;
	private Timestamp u_reg_date;
	private Timestamp u_latest_login_date;
	private Timestamp u_recommend_active_time;

}
