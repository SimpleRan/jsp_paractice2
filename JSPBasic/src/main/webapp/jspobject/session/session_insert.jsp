<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	/*
		세션은 쿠키와 마찬가지로 http 통신 데이터를 유지하기 위한 수단으로 사용합니다. 
		
		세션에 데이터를 저장할 때는 JP내장객체 session이 지원하는
		setAttribute() 메서드를 활용합니다.
		
		해당 메서드에 첫 번째 값으로 세선의 이름을 적어주고 
		두 번째 값으로 저장할 데이터를 정해주면 됩니다.
 	*/
 							//세션아이디    세션데이터
 	session.setAttribute("id_session", "abcd1234");
 	session.setAttribute("name_session", "김말이");
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--session_check.jsp를 만들어서 목적지로 넣어주세요. --%>
<a href="http://localhost:8181/JSPBasic/jspobject/session/session_check.jsp">세션확인하러가기</a>

<!-- session_login_form.jsp를 만들어주세요
해당 jsp파일 내부에는 form태그를 만들어주시고
form태그의 목적지는 session_login_check.jsp로 해 주세요.
form에서 전달하는 데이터는 id, pw입니다.
name 속성도 각각 id, pw로 해 주시고 
session_login_check.jsp에서 우선 request.getParameter로 받아서 콘솔에 찍게 해주세요 
------------------------------------------
과제 
아이디"abcd1234", 비번"1111"이 확인되는 경우만 session_id 세션명으로 세션을 발급해주세요
저장데이터는 로그인한 아이디 입니다.-->

</body>
</html>