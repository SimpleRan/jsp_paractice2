<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 	${board }
 	<h1>${board.boardNum }번 글 조회중입니다.</h1><br/>
 	제목 : <input type="text" value="${board.title}">
 	조회수 : <input type="text" vlaue="${board.hit }"><br/>
 	본문 : <textarea rows="10" cols="40">${board.content }</textarea><br/>
 	글쓴이 : <input type="text" value="${board.writer }"><br/>
 	쓴날짜 : ${board.bDate }<br/>
 	마지막 수정날짜 : ${board.mDate }<br/>
</body>
</html>