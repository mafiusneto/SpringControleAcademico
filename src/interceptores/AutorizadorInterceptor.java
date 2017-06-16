package interceptores;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AutorizadorInterceptor extends HandlerInterceptorAdapter{ 

	   @Override 
	   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object controller) throws  	Exception{

	       HttpSession session = request.getSession();
	       String uri = request.getRequestURI(); 
	       String urlBase = request.getServletContext().getContextPath(); // "/horafacil"
	       if(uri.equals(urlBase+"/") || uri.equals(urlBase+"/logar")){ 
	           return true; 
	       } 
	       if(session.getAttribute("usuario") != null) {  
	         return true; 
	       } 
	       response.sendRedirect(urlBase+"/"); 
	       return false; 
	   } 
	} 
