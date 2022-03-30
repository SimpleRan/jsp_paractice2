<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	<form action="http://localhost:8181/JSPBasic/jspobject/session/session_login_check.jsp" method="post">
	  <input type="text" name="id" placeholder="아이디" ><br/>
	  <input type="password" name="pw"placeholder="비밀번호" ><br/>
	  <input type = "submit" value="로그인"><br/>
	  </form>
</body>
</html>