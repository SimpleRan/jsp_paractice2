<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	// 실행된 화면을 보고 만들어주세요
	 int total = 1; %>
<%	total ++;
 	int num = (int)(Math.random() * 8) + 2; 
 %>

<p>
 	페이지 누적요청수 : <%= total %> <br/>
 	매 <b>10</b>번째 방문자에게는 기프트콘을 드립니다.<br/>
 	<%if(total % 10 == 0){ %>
 	   당첨되셨습니다!!
 	  <% } %>
 	  </p>
 	  <hr>
 	  
 	  <h2>랜덤 구구단(<%=num %>)</h2>
 	   <p>
 	      이번에 나온 구구단은 <%= num %>단 입니다.
  </p>
 	    <p>
 	      <% for(int i= 1; i<=9; i++){ %>
 	      	<%= num %> X <%= i %>= <%= num *i %> <br>
 	      <% } %>	
 	    
 	    </p>
</body>
</html>