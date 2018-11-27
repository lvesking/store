package cn.tedu.store.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

//定义拦截器
public class LoginInterceptor implements HandlerInterceptor{

	//执行控制器方法之前执行
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//1.获取session对象,取出user对象
		HttpSession session=request.getSession();
		Object obj=session.getAttribute("user");
		//2.Object obj==null;说明未登录,则跳转到登录页面
		if(obj==null){
			//获取该项目上下文
			String path=request.getContextPath()+"/user"+"/showlogin.do";
			response.sendRedirect(path);
			return false;
		}else{
			//3.登录了就放行,return true;
			return true;
		}
		
		
		
		
		
		
		
		
		
	}

	//执行控制器方法之后执行,响应页面之前执行
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		
	}
	//响应页面之后执行
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		
	}

	
}
