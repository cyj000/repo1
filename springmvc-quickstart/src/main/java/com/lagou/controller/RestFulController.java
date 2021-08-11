package com.lagou.controller;

import com.lagou.domain.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName: RestFulController
 * @Author: CYJ
 * @Date: 2021-08-02 15:10:23
 * @Description:
 */
@RestController
public class RestFulController {
    //    接受ajax请求  将结果以json的形式返回
    /*produces = "application/json;charset=utf-8" 响应返回数据的mime类型和编码，默认为
            json*/
/*    @RequestMapping(value = "/ajaxRequest",method = RequestMethod.POST)
    @ResponseBody*/
    @GetMapping("/ajaxRequest")
    public List<User> ajaxRequest(@RequestBody List<User> list) {
        System.out.println(list);
        return list;
    }

    @GetMapping("/user")
    public List<User> findUser() {

        return null;
    }

    @PostMapping("/user")
    public int insertUser(@RequestBody User user) {
        return 0;
    }

    @PutMapping("/user")
    public int updateUser(@RequestBody User user) {
        return 0;
    }

    @DeleteMapping("/user/{id}")
    public int deleteUser(@PathVariable Integer integer) {
        return 0;
    }

//    单文件上传
    @PostMapping("/upload")
    public String upload(String fileName, MultipartFile file){

        try {
            file.transferTo(new File("E:\\"+fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "success";
    }
    @PostMapping("/uploadFiles")
    public String uploadFiles(HttpServletRequest request,MultipartFile[] files) throws IOException {
        String path="E:\\";
        int i=0;
        String username = request.getParameter("username");
        for (MultipartFile file : files) {

            String pathName=path+username+(i++);
            file.transferTo(new File(pathName));
        }
        return "success";
    }

    @GetMapping("/exception")
    public void exceptionResolver(){
        int i=0;
        i=i/0;
    }





}






