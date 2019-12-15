package cn.zs.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor {
    /**
     * 预处理方法，会在调用Handler之前进行执行。多个拦截器之间的预处理方法顺序执行。
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("MyInterceptor1：我是预处理方法，会在调用Handler之前进行执行。");
        return true;
    }

    /**
     * 后调方法，会在调用handler之后执行。多个拦截器之间的方法倒序执行的。
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor1：后调方法，在调用完handler之后执行，我是倒序执行的....");
    }

    /**
     * 回调方法，在视图渲染之后进行执行，和后调方法一样，也是倒序执行的。
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor1：我是回调方法在视图渲染完以后执行，我也是倒序执行的。");
    }
}
