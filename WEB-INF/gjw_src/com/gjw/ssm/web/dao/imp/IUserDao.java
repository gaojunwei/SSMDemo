package com.gjw.ssm.web.dao.imp;

import java.util.List;

import com.gjw.ssm.web.bean.UserAccount;


public interface IUserDao {
	
	/*
	* ����
	*/
	public int saveObj(UserAccount uAccount);
	
	/*
	* ɾ��
	*/
	public int deleteObj(UserAccount uAccount);
	
	/*
	* �޸�
	*/
	public int editObj(UserAccount uAccount);
	/*
	 * ��¼��ѯ
	 */
	public UserAccount getObj(UserAccount uAccount);
	/*
	 * �����˺Ų�ѯ
	 */
	public UserAccount getObjByAcct(String accout);
	
	/*
	*�б�
	*/
	public List<UserAccount> listObj(UserAccount page);
    
}