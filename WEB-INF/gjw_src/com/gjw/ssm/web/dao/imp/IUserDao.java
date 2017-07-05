package com.gjw.ssm.web.dao.imp;

import java.util.List;

import com.gjw.ssm.web.bean.UserAccount;


public interface IUserDao {
	
	/*
	* 新增
	*/
	public int saveObj(UserAccount uAccount);
	
	/*
	* 删除
	*/
	public int deleteObj(UserAccount uAccount);
	
	/*
	* 修改
	*/
	public int editObj(UserAccount uAccount);
	/*
	 * 登录查询
	 */
	public UserAccount getObj(UserAccount uAccount);
	/*
	 * 根据账号查询
	 */
	public UserAccount getObjByAcct(String accout);
	
	/*
	*列表
	*/
	public List<UserAccount> listObj(UserAccount page);
    
}