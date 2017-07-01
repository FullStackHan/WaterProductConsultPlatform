<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h3>插入文章页面</h3>
<form action="../zhishiku/insertArticle" method="post">
     <table>
         <tr>
         	<td><label>文章名: </label></td>
             <td><input type="text" id="title" name="title" ></td>
         </tr>
         <tr>
         	<td><label>文章分类: </label></td>
             <td><input type="text" id="category" name="category"></td>
         </tr>
         <tr>
         	<td><label>描述: </label></td>
             <td><input type="text" id="description" name="description"></td>
         </tr>
         <tr>
         	<td><label>内容: </label></td>
             <td><input type="text" id="articleContent" name="articleContent"></td>
         </tr>       
         <tr>
             <td><input id="submit" type="submit" value="发布"></td>
         </tr>
     </table>
</form>
<h1>${result}</h1>
</body>
</html>