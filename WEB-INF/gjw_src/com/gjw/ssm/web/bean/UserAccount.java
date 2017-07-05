package com.gjw.ssm.web.bean;

import java.util.Date;


public class UserAccount {
	private int U_ID;
	private String U_ACCOUNT;
	private String U_PWD;
	private String U_NAME;
	private String U_PHONE;
	private String U_EMAIL;
	private int U_SEX;
	private int U_STATUS;
	private Date C_TIME;
	
	public int getU_ID() {
		return U_ID;
	}
	public void setU_ID(int u_ID) {
		U_ID = u_ID;
	}
	public String getU_ACCOUNT() {
		return U_ACCOUNT;
	}
	public void setU_ACCOUNT(String u_ACCOUNT) {
		U_ACCOUNT = u_ACCOUNT;
	}
	public String getU_NAME() {
		return U_NAME;
	}
	public void setU_NAME(String u_NAME) {
		U_NAME = u_NAME;
	}
	public String getU_PHONE() {
		return U_PHONE;
	}
	public void setU_PHONE(String u_PHONE) {
		U_PHONE = u_PHONE;
	}
	public String getU_EMAIL() {
		return U_EMAIL;
	}
	public void setU_EMAIL(String u_EMAIL) {
		U_EMAIL = u_EMAIL;
	}
	public int getU_SEX() {
		return U_SEX;
	}
	public void setU_SEX(int u_SEX) {
		U_SEX = u_SEX;
	}
	public int getU_STATUS() {
		return U_STATUS;
	}
	public void setU_STATUS(int u_STATUS) {
		U_STATUS = u_STATUS;
	}
	public Date getC_TIME() {
		return C_TIME;
	}
	public void setC_TIME(Date c_TIME) {
		C_TIME = c_TIME;
	}
	public String getU_PWD() {
		return U_PWD;
	}
	public void setU_PWD(String u_PWD) {
		U_PWD = u_PWD;
	}
}
