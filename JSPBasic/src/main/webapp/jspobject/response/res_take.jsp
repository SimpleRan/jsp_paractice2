<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
 <%-- 우선 age를 받아서 정수로 변환해주시고  *Integer.parselnt()
   변환된 정수가 20이상면 성인입니다. 20미만이면 미성년자입니다. 
   라고 화면에 띄워주는 로직을 작성해서 보내주세요--%>
 <% 
 	String strAge = request.getParameter("age");
 	System.out.println(strAge);// 콘솔에서 확인
 	out.println(strAge);// 브라우저에서 확인 
 	
 	//대소비교를 하기 위해 정수로 바꿔줍니다.
 	int age = Integer.parseInt(strAge); // 숫자로 이루어진 문자를 정수로 변환
 	if(age >= 20){
 		//out.println("<h1>당신은 성인입니다</h1>"); <페이지가 넘어가므로 생략>
 		response.sendRedirect("http://localhost:8181/JSPBasic/jspobject/response/res_adult.jsp");//네이버로 강제이동
 	}else if (age < 20) {
 		//out.println("<h1>당신은 미성년자입니다</h1>");
 		response.sendRedirect("http://localhost:8181/JSPBasic/jspobject/response/res_kids.jsp"); //다음으로 강제이동
 	}
 %>
 
 <!-- res_adult.jsp 를 생성해주시고 "성인입니다. 주류 구매가 가능합니다."라는 문장을 
body 태그 내에 작성해주시면 됩니다.

리다이렉트 위치를 res_adult.jsp로 바꿔주세요(페이지 실행 후 주소 복붙)

res_kids.jsp 도 마찬가지고 위처럼 처리해주시되 문장은 "미성년자는 주류 구매가 불가능합니다"라고 바꿔서 처리해주세요. -->
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

   

</body>
</html>