<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	${board}
	<h1>${board.boardNum } 예약하기</h1><br/>
	예약날짜 : <input type="date" value="${board.uDate }">  <br/>
	예약시간 : <input type="time" value="${board.uTime}"> <br/>
	예약인 : <input type="text" value="${board.Name }"><br/>
	전화번호 : <input type="text" value="${board.Phone}"><br/>
	<!--  요청사항 : <textarea cols="40" rows="10">${board.content }</textarea><br/>-->
	예약인원 : <input type="text" value="${board.person }"><br/>
	요청사항 : <textarea cols="40" rows="5">${board.content }</textarea><br/>
	<hr/>
	<a href="http://localhost:8181/Ateam/rboard/rgetboardList"><button>예약확정하기</button></a>
	<a href="http://localhost:8181/Ateam/rboard/rgetboardList"><button>목록으로 돌아가기</button></a>
	<!-- 삭제번호를 서블릿 boardDelete로 보내야함 -->
	<form action="http://localhost:8181/Ateam/rboardDelete" method="post">
		<!-- 삭제용 글 번호는 노출시킬 필요가 없으므로 hidden타입으로 숨겨서 보냄 -->
		<input type="hidden" name="board_num" value="${board.boardNum }">
		<input type="submit" value="삭제">
	</form>
	<form action="http://localhost:8181/Ateam/rboardList" method="post">
		<!-- 삭제용 글 번호는 노출시킬 필요가 없으므로 hidden타입으로 숨겨서 보냄 -->
		<input type="hidden" name="board_num" value="${board.boardNum }">
		<input type="submit" value="수정">
	</form>
</body>
</html>