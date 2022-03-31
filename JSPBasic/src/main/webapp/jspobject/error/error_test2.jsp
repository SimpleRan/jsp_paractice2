<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page errorPage="error_page.jsp" %>
 <%
 	int a = 3 / 0;
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	나누기의 결과값은 <%=a %>입니다.
</body>
<!-- error_test3.jsp를 만들어주세요.
0으로 나누기 말고 다른 종류의 예외를 발생시켜주시고

error_page2.jsp를 만들어서
본인이 만든 에러에 대한 해설을 적어서 예외 발생시 처리되도록 만들어서

1:1채팅으로 error_test3.jsp와 error_page2.jsp의 코드를 보내주시면 됩니다. -->
</html>