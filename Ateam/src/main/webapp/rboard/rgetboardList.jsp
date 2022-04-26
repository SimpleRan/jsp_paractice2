<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 반복해서 출력하려면 JSTL을 활용하는것이 일반적임 -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>/boardList 로 연결된 임시페이지입니다.</h1>
	<table border="1">
		<thead>
			<tr>
				<td>글번호</td>
				<td>예약인</td>
				<td>전화번호</td>
				<td>예약날짜</td>
				<td>예약시간</td>
				<td>예약인원</td>
				<td>리뷰넘버</td>
				
			</tr>
		</thead>
			<!-- JSTL c:forEach와 ${boardList}를 활용하면 됩니다.
			전체 글 정보를 테이블 형식으로 보여주세요. getAllBoardList.jsp 참고해주세요.-->
			<tbody>
				<c:forEach var="board" items="${boardList}">
					<tr>
						<td>${board.boardNum}</td>
						<td><a href="http://localhost:8181/Ateam/rboard/rboardDetail?board_num=${board.boardNum}">${board.num}</a></td>						
						<td>${board.name}</td>
						<td>${board.phone}</td>
						<td>${board.uDate}</td>
						<td>${board.uTime}</td>
						<td>${board.person}</td>
						<td>${board.review}</td>
					</tr>
				</c:forEach>
			</tbody>
	</table>	
	<a href="http://localhost:8181/Ateam/rboard/rboardInsertForm.jsp"><button>예약확정</button></a>
</body>
</html>