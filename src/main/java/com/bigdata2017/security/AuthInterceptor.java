package com.bigdata2017.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.bigdata2017.mysite.vo.UserVo;

public class AuthInterceptor extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler)
	throws Exception {
		//1. handler 종류 확인
		if (handler instanceof HandlerMethod == false) {
			return true;
		}
		//2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
				
		//3-1. Method 객체에서 @Auth 받아오기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		//3-2. Method에 @Auth가 없다면, Class(Type)에 붙어있는 @Auth를 받아오기
		if (auth == null) {
			auth = handlerMethod.getMethod().getDeclaringClass().getAnnotation(Auth.class);
		}
				
		//4. @Auth가 붙어있지 않은 경우
		if (auth == null) {	
			return true;
		}
		
		//5. @Auth가 붙어 있기 때문에 인증여부 체크
		HttpSession session = request.getSession();
		if(session == null) { //인증되지 않았을 경우
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		UserVo authUser = (UserVo)session.getAttribute("authUser");
		if( authUser == null ) { //인증되지 않았을 경우
			response.sendRedirect( request.getContextPath() + "/user/login" );
			return false;
		}
		
		Auth.Role role = auth.role();
		//todo
		return true;
	}
	
}
