package by.it.academy.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse httpres = (HttpServletResponse) response;
        httpres.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        httpres.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        httpres.setDateHeader("Expires", 0); // Proxies.
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
