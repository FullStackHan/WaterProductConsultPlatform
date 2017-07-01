<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<h1>欢迎：${sessionScope.user.getUserName()}</h1>
<h1>用户状态：${sessionScope.user.getStatus()}</h1>

<h1><a href="http://localhost:8080/IA/zhishiku/articlePage">显示知识库文章</a></h1>
<h1><a href="http://localhost:8080/IA/zhishiku/insertPage">插入文章</a></h1>

<h1><a href="/IA/zhishiku/auditPage">文章审核界面</a></h1>

<h1>${result}</h1>
<!--高速版-->
<div id="SOHUCS" sid="test"></div>
<script charset="utf-8" type="text/javascript" src="http://changyan.sohu.com/upload/changyan.js" ></script>
<script type="text/javascript">
window.changyan.api.config({
appid: 'cyt5th2t9',
conf: 'prod_7cc9b765e3ca1a8157c3aba672329e7f'
});
</script>

</body>
</html>