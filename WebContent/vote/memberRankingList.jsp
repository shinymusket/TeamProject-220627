<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보자등수</title>
<link type="text/css" rel="stylesheet" href="./css/vote.css?">
</head>
<body>
<%@ include file="../header/header.jsp" %>
<%@ include file="../nav/nav.jsp" %>
	<div class="container" align="center">
		<h1>후보자등수</h1>
		<c:if test="${memberRankingList != null}">
			<table>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>총투표건수</th>
				</tr>

				<c:forEach var="member" items="${memberRankingList}">
					<tr>
						<td>${member.m_no}</td>
						<td>${member.m_name}</td>
						<td>${member.vote_count}</td>
					</tr>	
				</c:forEach>
			</table>
		</c:if>
	</div>
<%@ include file="../footer/footer.jsp" %>
</body>
</html>