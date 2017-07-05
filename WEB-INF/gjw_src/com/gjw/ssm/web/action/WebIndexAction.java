package com.gjw.ssm.web.action;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gjw.ssm.web.bean.UserAccount;
import com.gjw.ssm.web.service.imp.IUserAccountService;
import com.gjw.ssm.web.utils.ParamFilter;


@Controller
@RequestMapping(path="/web")
public class WebIndexAction {
	
	private static Logger logger = Logger.getLogger(WebIndexAction.class);
	
	@Autowired
	IUserAccountService userAccountService;
	
	@RequestMapping(path="/index")
	public String index(HttpServletRequest request,HttpServletResponse response,Model model) {
		String name = request.getParameter("name");
		System.out.println("�û��������ֵΪ��"+name);
		
		Map<String, Object> mapBean = new HashMap<String, Object>();
		mapBean.put("success", true);
		mapBean.put("data", name);
		mapBean.put("reason", "�����ɹ�");
		
		model.addAttribute("mapBean", mapBean);
		return "index";
	}
	
	/**
	 * ȥ����¼ҳ��
	 */
	@RequestMapping(path="/tologin")
	public String toLogin()
	{
		return "login";
	}
	
	/**
	 * �˳���¼
	 */
	@RequestMapping(path="/tologout")
	public String toLogout(HttpServletRequest request,Model model)
	{
		Map<String, Object> mapBean = new HashMap<String, Object>();
		mapBean.put("success", true);
		mapBean.put("data", "");
		mapBean.put("reason", "�����ɹ�");
		model.addAttribute("mapBean", mapBean);
		
		System.out.println("��ǰ�û��˳���¼��");
		request.getSession().removeAttribute("userinfo");
		return "index";
	}
	
	/**
	 * ��Ա��¼
	 */
	@RequestMapping(path="/login")
	public ModelAndView login(HttpServletRequest request,String userName,String userPwd)
	{
		ModelAndView mv = new ModelAndView();
		mv.setViewName("result");
		
		Map<String, Object> mapBean = new HashMap<String, Object>();
		mapBean.put("success", false);
		mapBean.put("data", "");
		mapBean.put("reason", "");
		if(!ParamFilter.isExist(userName) || !ParamFilter.isExist(userPwd))
		{
			mapBean.put("reason", "�����������");
			mv.addObject("mapBean", mapBean);
			return mv;
		}
		UserAccount con = new UserAccount();
		con.setU_ACCOUNT(userName);
		con.setU_PWD(userPwd);
		//��ѯ��ȡ�û���Ϣ
		UserAccount user = userAccountService.get(con);
		if(user==null)
		{
			mapBean.put("reason", "���û�������");
			mv.addObject("mapBean", mapBean);
			return mv;
		}
		//�����¼��Ϣ��session��
		request.getSession().setAttribute("userInfo", user);
		mapBean.put("success", true);
		mapBean.put("reason", user.getU_NAME()+"��½�ɹ�");
		mv.addObject("mapBean", mapBean);
		return mv;
	}
	
	/**
	 * ȥ��ע��ҳ��
	 */
	@RequestMapping(path="/toreg")
	public String toReg()
	{
		return "commen/reg";
	}
	
	/**
	 * ��Աע��
	 */
	@RequestMapping(path="/userreg")
	public String userReg(HttpServletRequest request,UserAccount uAccount,Model model)
	{
		Map<String, Object> mapBean = new HashMap<String, Object>();
		mapBean.put("success", false);
		mapBean.put("data", "");
		mapBean.put("reason", "");
		logger.info("come in user reg Methed********");
		if(!ParamFilter.isExist(uAccount.getU_ACCOUNT()) || 
			!ParamFilter.isExist(uAccount.getU_NAME()) || 
			!ParamFilter.isExist(uAccount.getU_PWD()))
		{
			logger.info("�������Ϸ���ע��ʧ��");
			mapBean.put("reason", "�������Ϸ���ע��ʧ��");
			model.addAttribute("mapBean", mapBean);
			return "result";
		}
		UserAccount users = userAccountService.getObjByAcct(uAccount.getU_ACCOUNT());
		if(ParamFilter.isExist(users))
		{
			logger.info("���˺��Ѵ��ڣ�ע��ʧ��");
			mapBean.put("reason", "���˺��Ѵ��ڣ�ע��ʧ��");
			model.addAttribute("mapBean", mapBean);
			return "result";
		}
		logger.info("���˺Ų����ڣ�����ע��******");
		uAccount.setC_TIME(new Date());
		uAccount.setU_STATUS(1);
		int a = userAccountService.save(uAccount);
		logger.info("��Աע�ᣬ����Ӱ������******"+a);
		if(a==1)
		{
			mapBean.put("success", true);
			mapBean.put("reason", "���˺�ע��ɹ�");
			model.addAttribute("mapBean", mapBean);
			return "result";
		}
		mapBean.put("reason", "ע����Ϣ����ʧ�ܣ�������");
		model.addAttribute("mapBean", mapBean);
		return "result";
	}
	
}