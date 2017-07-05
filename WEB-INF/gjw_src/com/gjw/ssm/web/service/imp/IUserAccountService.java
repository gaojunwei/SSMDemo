package com.gjw.ssm.web.service.imp;

import java.util.List;

import com.gjw.ssm.web.bean.UserAccount;

public interface IUserAccountService {
    
    /*
	* 新增
	*/
	public int save(UserAccount uAccount);
	
	/*
	* 删除
	*/
	public int delete(UserAccount uAccount);
	
	/*
	* 修改
	*/
	public int edit(UserAccount uAccount);
	/*
	 * 单条查询
	 */
	public UserAccount get(UserAccount uAccount);
	/*
	 * 单条查询
	 */
	public UserAccount getObjByAcct(String accout);
	/*
	*列表
	*/
	public List<UserAccount> list(UserAccount uAccount);
}
