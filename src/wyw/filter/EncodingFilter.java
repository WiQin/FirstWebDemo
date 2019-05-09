package wyw.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @ClassName EncodingFilter
 * @Description 解决中文字符集乱码
 * @Author Wangyw
 */
public class EncodingFilter implements Filter {

    public EncodingFilter() {
        System.out.println("构造器");

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse reponse, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        reponse.setContentType("text/html;charset = utf-8");
        chain.doFilter(request,reponse);
    }

    @Override
    public void destroy() {
        System.out.println("销毁");
    }
}
