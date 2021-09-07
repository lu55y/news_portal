package by.it.academy.filter;

import jakarta.servlet.*;
import java.io.IOException;

public class CharsetEncodingFilter implements Filter {

    private String encoding;
    private String characterEncoding = "characterEncoding";
    private ServletContext context;


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter(characterEncoding);
        context = filterConfig.getServletContext();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        context.log("Charset was set.");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
