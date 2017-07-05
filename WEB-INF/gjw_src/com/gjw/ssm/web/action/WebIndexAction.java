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
		System.out.println("用户请求参数值为："+name);
		
		Map<String, Object> mapBean = new HashMap<String, Object>();
		mapBean.put("success", true);
		mapBean.put("data", name);
		mapBean.put("reason", "操作成功");
		
		model.addAttribute("mapBean", mapBean);
		return "index";
	}
	
	/**
	 * 去往登录页面
	 */
	@RequestMapping(path="/tologin")
	public String toLogin()
	{
		return "login";
	}
	
	/**
	 * 退出登录
	 */
	@RequestMapping(path="/tologout")
	public String toLogout(HttpServletRequest request,Model model)
	{
		Map<String, Object> mapBean = new HashMap<String, Object>();
		mapBean.put("success", true);
		mapBean.put("data", "");
		mapBean.put("reason", "操作成功");
		model.addAttribute("mapBean", mapBean);
		
		System.out.println("当前用户退出登录！");
		request.getSession().removeAttribute("userinfo");
		return "index";
	}
	
	/**
	 * 会员登录
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
			mapBean.put("reason", "请求参数有误");
			mv.addObject("mapBean", mapBean);
			return mv;
		}
		UserAccount con = new UserAccount();
		con.setU_ACCOUNT(userName);
		con.setU_PWD(userPwd);
		//查询获取用户信息
		UserAccount user = userAccountService.get(con);
		if(user==null)
		{
			mapBean.put("reason", "该用户不存在");
			mv.addObject("mapBean", mapBean);
			return mv;
		}
		//保存登录信息到session中
		request.getSession().setAttribute("userInfo", user);
		mapBean.put("success", true);
		mapBean.put("reason", user.getU_NAME()+"登陆成功");
		mv.addObject("mapBean", mapBean);
		return mv;
	}
	
	/**
	 * 去往注册页面
	 */
	@RequestMapping(path="/toreg")
	public String toReg()
	{
		return "commen/reg";
	}
	
	/**
	 * 会员注册
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
			logger.info("参数不合法，注册失败");
			mapBean.put("reason", "参数不合法，注册失败");
			model.addAttribute("mapBean", mapBean);
			return "result";
		}
		UserAccount users = userAccountService.getObjByAcct(uAccount.getU_ACCOUNT());
		if(ParamFilter.isExist(users))
		{
			logger.info("该账号已存在，注册失败");
			mapBean.put("reason", "该账号已存在，注册失败");
			model.addAttribute("mapBean", mapBean);
			return "result";
		}
		logger.info("该账号不存在，可以注册******");
		uAccount.setC_TIME(new Date());
		uAccount.setU_STATUS(1);
		int a = userAccountService.save(uAccount);
		logger.info("会员注册，返回影响行数******"+a);
		if(a==1)
		{
			mapBean.put("success", true);
			mapBean.put("reason", "该账号注册成功");
			model.addAttribute("mapBean", mapBean);
			return "result";
		}
		mapBean.put("reason", "注册信息保存失败，请重试");
		model.addAttribute("mapBean", mapBean);
		return "result";
	}
	
}