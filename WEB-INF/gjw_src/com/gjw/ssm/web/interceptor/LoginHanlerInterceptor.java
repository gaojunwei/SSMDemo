package com.gjw.ssm.web.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginHanlerInterceptor extends HandlerInterceptorAdapter {
    
    private List<String> excludedUrls;
    
	public void setExcludedUrls(List<String> excludedUrls) {
		this.excludedUrls = excludedUrls;
	}

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String requestUri = request.getRequestURI();
		System.out.println("�û���¼��¼�ɹ������ٽ����¼ҳ��-�����������ص�ַ��"+requestUri);
		
        for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
            	HttpSession session = request.getSession();
                if (session.getAttribute("userinfo") == null)
                {
                	return true;//����
                }else
                {
                	response.sendRedirect(request.getContextPath() + "/web/index");
                    return false;
                }
            }else
            {
            	return true;//����
            }
        }
        return true;//����
        
    }

}
