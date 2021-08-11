package com.lagou.controller;

import com.lagou.domain.User;
import com.lagou.vo.QueryVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: UserController
 * @Author: CYJ
 * @Date: 2021-08-02 08:55:01
 * @Description:
 */


@Controller
@RequestMapping("/user")
//@RestController("/user")
//RestController等于 ResponseBody+RequestMapping
@SessionAttributes("username")
public class UserController {
    /**
     * requestMapping可以应用在类上也可以应用在方法上.
     * 如果是应用在类上,那么请求的时候,需要拼接上一级\二级.用在类上主要是为了对项目进行 模块化管理
     * <p>
     * 其中requestMapping的参数
     * value,path 代表的路径
     * params 限定了参数,是否必须携带指定参数名的参数
     * <p>
     * method 限定方法,限定是post还是get等方法
     *
     * @return
     */
    @RequestMapping(value = "/quick", params = {"name"})
    public String quick() {
        System.out.println("quick running...");
        return "success";
    }

    //    params的参数名称会自动映射到下面方法的参数上
    @RequestMapping(value = "/pojoParam")
    public String pojoParam(User user) {
        System.out.println(user);
        return "success";
    }

    //    params的参数名称会自动映射到下面方法的参数上
    @RequestMapping(value = "/arrays")
    public String arrays(String[] nameArrays) {
        List<String> nameList = Arrays.asList(nameArrays);
        for (String s : nameList) {
            System.out.println(s);
        }
        return "success";
    }


    @RequestMapping(value = "/queryParam")
    public String queryParam(QueryVO queryVO) {
        System.out.println(queryVO);
        return "success";
    }

    //  参数转换
    @RequestMapping(value = "/converterParam",method = RequestMethod.GET)
    public String converterParam(Date data) {
        System.out.println(data);
        return "success";
    }
    //  RequestParam参数配置
/*    使用requestParam解决前端与后端传值不同的问题
    参数
            Name    前端参数名
                    defaultValue 默认值
                    required 是否必须  默认是true  如果有默认值 那么是false*/
    @RequestMapping(value = "/findByPage")
    public String findByPageNo(@RequestParam(name = "pageNo", defaultValue = "1") Integer pageNum,
                               @RequestParam(name = "pageSize", required = false) Integer pageSize) {
        System.out.println(pageNum);
        System.out.println(pageSize);
        return "success";
    }


    //  获取请求头
    @RequestMapping(value = "/getHeader")
    public String getHeader(@RequestHeader("cookie") String cookie) {
        System.out.println(cookie);
        return "success";
    }

    //  获取Cookie中的指定值
    @RequestMapping(value = "/getCookie")
    public String getCookies(@CookieValue("JSESSIONID") String JSESSIONID) {
        System.out.println(JSESSIONID);
        return "success";
    }

    //servletAPI
    @RequestMapping(value = "/servletAPI")
    public String servletAPI(HttpServletRequest request, HttpServletResponse response, HttpSession session) {
        System.out.println(request);
        System.out.println(response);
        System.out.println(session);
        return "success";
    }


    //转发和重定向
    // 1.以字符串的形式返回   2.使用servlet API   3.使用ModuleAndView
    @RequestMapping(value = "/returnString")
    public String returnString() {
        return "success";
    }

    @RequestMapping(value = "/returnVoid")
    public void returning(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("return void ");

        //转发带入数据
//        request.setAttribute("username","晋升完成");
//        request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request, response);

        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    //    使用转发和重定向
    //如果用了forward：则路径必须写成实际视图url，不能写逻辑视图。它相当于：
// request.getRequestDispatcher("url").forward(request,response)
    @RequestMapping(value = "/forward")
    public String forward(Model model) {
        model.addAttribute("username", "果冻");
        return "forward:/WEB-INF/pages/success.jsp";
    }

    //我们可以不写虚拟目录，springMVC框架会自动拼接，并且将Model中的数据拼接到url地址上
    @RequestMapping(value = "/redirect")
    public String redirect(Model model) {
        model.addAttribute("username", "切糕");
        return "redirect:/index.jsp";
    }

    //    使用ModelAndView来进行视图转发 方式一
//    ModelAndView 可以存入数据  通过 视图名称的设置来进行跳转.因为会经过视图解析器,所以会自动拼接前后路径
    @RequestMapping(value = "/returnModelAndView1")
    public ModelAndView returnModelAndView1() {

        ModelAndView modelAndView=new ModelAndView();
        //数据是存在request中的,只会 存在一次请求.如果想要下一次也获取到需要通过类上的注解SessionAttribute进行配置
        modelAndView.addObject("username","霓虹");
        modelAndView.setViewName("success");
        return modelAndView;
    }
//使用ModelAndView来进行视图转发 方式二
    @RequestMapping(value = "/returnModelAndView2")
    public ModelAndView returnModelAndView2(ModelAndView modelAndView) {
        modelAndView.addObject("username","彩虹");
        modelAndView.setViewName("success");
        return modelAndView;
    }



}


