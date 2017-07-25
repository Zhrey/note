package cc.zhrey.note.utils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Zhrey
 * Date: 2017/6/12
 */
public class SetCharacterEncodingFilter implements Filter {

    private String encoding = null;

    public void init(FilterConfig filterConfig) throws ServletException {


        //获取编码格式
        encoding = filterConfig.getServletContext().getInitParameter("configCharacterEncoding");
    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        if (null != encoding && !"".equals(encoding)) {

            //设置编码
            request.setCharacterEncoding(encoding);
            response.setCharacterEncoding(encoding);
        }
       /**
        * 使用doFilter方法调用链中的下一个过滤器或目标资源（servlet或JSP页面）。
        * chain.doFilter处理过滤器的其余部分（如果有的话），最终处理请求的servlet或JSP页面。
        */
        filterChain.doFilter(request,response);
    }

    public void destroy() {

    }
}