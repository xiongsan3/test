<%--
  Created by IntelliJ IDEA.
  User: С��û�г�
  Date: 2023/10/9
  Time: 18:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page  language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>
<html>
  <head>
    <title>傻逼李城</title>
  </head>
  <body>
  <!--servlet优化：
	在发送请求时，
	传递一个标记，
	当前请求的参数
 -->
  <a href="${ctx}/beanServlet?action=add">添加商品</a>
  <a href="${ctx}/beanServlet?action=del">删除商品</a>
  <a href="${ctx}/beanServlet?action=update">更新商品</a>
  <div>
    ${returns}
  </div>

  </body>
</html>
