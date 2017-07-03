package com.gjw.ssm.web.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		UserAccount user = userAccountService.getUserInfoByCon(" and u_acount ='"+userName+"'");
		if(user==null)
		{
			mapBean.put("reason", "该用户不存在");
			mv.addObject("mapBean", mapBean);
			return mv;
		}
		mapBean.put("success", true);
		mapBean.put("reason", user.getU_name()+"登陆成功");
		mv.addObject("mapBean", mapBean);
		return mv;
	}
	
	/**
	 * 去往注册页面
	 */
	@RequestMapping(path="/toreg")
	public String toReg()
	{
		return "reg";
	}
	
	/**
	 * 会员注册
	 */
	@RequestMapping(path="/userreg")
	public String userReg(HttpServletRequest request,Model model)
	{
		Map<String, Object> mapBean = new HashMap<String, Object>();
		mapBean.put("success", false);
		mapBean.put("data", "");
		mapBean.put("reason", "");
		
		
		if(request.getAttribute("u_acount")==null || request.getAttribute("u_pwd")==null || request.getAttribute("u_name")==null)
		{
			mapBean.put("reason", "参数不合法，注册失败");
			model.addAttribute("mapBean", mapBean);
			return "result";
		}
		String u_acount = request.getAttribute("u_acount").toString();
		String u_pwd = request.getAttribute("u_pwd").toString();
		String u_name = request.getAttribute("u_name").toString();
		String u_phone = request.getAttribute("u_phone")==null?"":request.getAttribute("u_phone").toString();
		String u_email = request.getAttribute("u_email")==null?"":request.getAttribute("u_email").toString();
		String u_sex = request.getAttribute("u_sex")==null?"":request.getAttribute("u_sex").toString();
		
		
		
		
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
					
		return "reg";
	}
	
}