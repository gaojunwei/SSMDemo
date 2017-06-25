package com.gjw.ssm.web.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gjw.ssm.web.bean.User;
import com.gjw.ssm.web.utils.ParamFilter;


@Controller
@RequestMapping(path="/web")
public class WebIndexAction {
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
	
	@RequestMapping(path="/tologin")
	public String toLogin()
	{
		return "login";
	}
	
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
	
	@RequestMapping(path="/login")
	public ModelAndView login(HttpServletRequest request,String userName,String userPwd)
	{
		ModelAndView mv = new ModelAndView();
		Map<String, Object> mapBean = new HashMap<String, Object>();
		mapBean.put("success", false);
		mapBean.put("data", "");
		mapBean.put("reason", "");
		if(!ParamFilter.isExist(userName) || !ParamFilter.isExist(userPwd))
		{
			mapBean.put("reason", "�����������");
			mv.setViewName("result");
			mv.addObject("mapBean", mapBean);
			return mv;
		}
		if(userName.equals("gjw") && userPwd.equals("123456"))
		{
			User user = new User();
			user.setName(userName);
			user.setPwd(userPwd);
			
			request.getSession().setAttribute("userinfo", user);
			
			mapBean.put("success", true);
			mapBean.put("reason", "��¼�ɹ�");
			mv.setViewName("redirect:index");//�ض���
			mv.addObject("mapBean", mapBean);
			return mv;
		}
		mapBean.put("reason", "�û������������");
		mv.setViewName("result");
		mv.addObject("mapBean", mapBean);
		return mv;
	}
	
}
