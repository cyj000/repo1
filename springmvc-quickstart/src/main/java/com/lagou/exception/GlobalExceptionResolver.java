package com.lagou.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @ClassName: GlobalExceptionResovler
 * @Author: CYJ
 * @Date: 2021-08-02 17:40:56
 * @Description: 全局异常配置
 */
//@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        ModelAndView modelAndView = new ModelAndView();
        //保存错误信息
        modelAndView.addObject("error", e.getMessage());
        modelAndView.setViewName("error");
        return modelAndView;
    }

}
