<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<h1>${articles}</h1>
<c:if test="${not empty articles}">
<c:forEach items="${articles}" var="article" varStatus="vs">  
         <tr> 
             <td>${article.getTitle()}         </td>  
             <td>${article.getAuthor()}           </td>  
             <td>${article.getCategory()}          </td>  
             <td><fmt:formatDate value="${article.getPublishTime()}" pattern="yyyy-MM-dd HH:mm:ss"/></td>  
             <td>${article.getDescription()}       </td>  
             <td>${article.getArticleContent()}         </td>  
         </tr>  
         <br>
         <br>
</c:forEach>
</c:if>

</body>
</html>