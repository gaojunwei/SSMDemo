package com.gjw.ssm.web.service.imp;

import java.util.List;

import com.gjw.ssm.web.bean.UserAccount;

public interface IUserAccountService {
    
    /*
	* ����
	*/
	public int save(UserAccount uAccount);
	
	/*
	* ɾ��
	*/
	public int delete(UserAccount uAccount);
	
	/*
	* �޸�
	*/
	public int edit(UserAccount uAccount);
	/*
	 * ������ѯ
	 */
	public UserAccount get(UserAccount uAccount);
	/*
	 * ������ѯ
	 */
	public UserAccount getObjByAcct(String accout);
	/*
	*�б�
	*/
	public List<UserAccount> list(UserAccount uAccount);
}
