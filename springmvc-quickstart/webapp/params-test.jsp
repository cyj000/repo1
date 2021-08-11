<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/8/2
  Time: 9:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/user/quick?name=1234" >简单参数</a>


对象输入
<form action="${pageContext.request.contextPath}/user/pojoParam" method="post">
    用户年龄
    <input type="text" name="age" />
    用户姓名
    <input type="text" name="name" />
    <input type="submit" name="提交数据" />
</form>

数组传递
<form action="${pageContext.request.contextPath}/user/arrays" method="post">
    选择喜欢的运动:
    <input type="checkbox" name="nameArrays" value="跑步"/>跑步<br>
    <input type="checkbox" name="nameArrays" value="跳水"/>跳水<br>
    <input type="checkbox" name="nameArrays" value="打乒乓"/>打乒乓<br>
    <input type="submit" name="提交数据" />
</form>

复杂对象的传递
<form action="${pageContext.request.contextPath}/user/queryParam" method="post">
 关键字输入:
    <input type="text" name="keyWord" />
选择喜欢的运动:
    <input type="checkbox" name="nameArray" value="跑步"/>跑步<br>
    <input type="checkbox" name="nameArray" value="跳水"/>跳水<br>
    <input type="checkbox" name="nameArray" value="打乒乓"/>打乒乓<br>
用户列表 list:
    第一个用户:
    年龄<input type="text" name="userList[0].age" value="12"/>
    名字<input type="text" name="userList[0].name" value="水冰月"/>
    第二个用户:
    年龄<input type="text" name="userList[1].age" value="15"/>
    名字<input type="text" name="userList[2].name" value="牛王"/>
map:
    第一个元素
    年龄<input type="text" name="userMap['k1'].age" value="78"/>
    名字<input type="text" name="userMap['k1'].name" value="冰月"/>
    <input type="submit" name="提交数据" />
</form>


类型转换
<form action="${pageContext.request.contextPath}/user/converterParam" method="get">
    胜利日期输入
    <input type="text" name="data" />
    <input type="submit" value="自定义类型转换器"/>
</form>

前端传值
<form action="${pageContext.request.contextPath}/user/converterParam" method="post">
    胜利日期输入
    <input type="text" name="data" />
    <input type="submit" value="自定义类型转换器"/>
</form>


<a href="${pageContext.request.contextPath}/user/findByPage?pageNo=2">
    分页查询
</a>


ajax 异步提交
<button id="btn1">ajax异步提交</button>

文件上传
<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/upload">
    姓名:<input type="text" name="username" /><br/>
    文件:<input type="file" name="file" />
    <input type="submit" value="文件上传" />
</form>


多文件上传

<form method="post" enctype="multipart/form-data" action="${pageContext.request.contextPath}/uploadFiles">
    姓名:<input type="text" name="username" /><br/>
    文件1:<input type="file" name="files" /><br/>
    文件2:<input type="file" name="files" /><br/>
    文件3:<input type="file" name="files" /><br/>
    文件4:<input type="file" name="files" /><br/>
    <input type="submit" value="文件上传" />
</form>
<script src="${pageContext.request.contextPath}/js/jquery-2.1.0.min.js"></script>
<script>
    $("#btn1").click(function(){
        let url='${pageContext.request.contextPath}/user/ajaxRequest';
        let data='[{"id":1,"name":"张三"},{"id":2,"name":"李四"}]';

        $.ajax({
            type:'POST',
            url:url,
            data:data,
            contentType:'application/json;charset=utf-8',
            success:function (resp){
                alert(JSON.stringify(resp))
            }
        })
    })
</script>
</body>
</html>

