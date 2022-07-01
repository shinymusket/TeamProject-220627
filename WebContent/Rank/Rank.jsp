<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>후보자등수</title>
</head>
<link type="text/css" rel="stylesheet" href="./css/rank.css?2334">
<body>
<%@ include file="../header/header.jsp" %>
<%@ include file="../nav/nav.jsp" %>


<div class="container" align="center">
		<h1>후보자 등수</h1>
			<table>
					<tr>
						<th>후보번호</th>
						<th>성명</th>
						<th>총 투표건수</th>
					</tr>
					
				<c:forEach var="Rank" items="${VoteRank}">
					<tr>
						<td>${Rank.c_number}</td>
						<td>${Rank.c_mame}</td>
						<td>${Rank.c_voteSum}</td>
					</tr>
				</c:forEach>
			</table>
	
</div>
<%@ include file="../footer/footer.jsp" %>
</body>
</html>