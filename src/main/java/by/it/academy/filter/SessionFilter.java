package by.it.academy.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class SessionFilter implements Filter {

	private static final String REDIRECT_URL = "index.jsp";

	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {
			HttpServletRequest request = (HttpServletRequest) req;
	        HttpServletResponse response = (HttpServletResponse) res;
	        HttpSession session = request.getSession(false);
	        if (session == null) {
	        	System.out.println("Session is null");
	            response.sendRedirect(REDIRECT_URL);
	        }else {
				chain.doFilter(req, res);
			}
	}

	public void init(FilterConfig config) throws ServletException {
	}

}
