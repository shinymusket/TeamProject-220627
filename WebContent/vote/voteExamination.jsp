<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>          
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표검수조회</title>
<link type="text/css" rel="stylesheet" href="./css/vote.css?">
</head>
<body>
<%@ include file="../header/header.jsp" %>
<%@ include file="../nav/nav.jsp" %>
	<div class="container" align="center">
		<h1>투표검수조회</h1>
		<c:if test="${voteExaminationList != null}">
			<table>
				<tr>
					<th>성명</th>
					<th>생년월일</th>
					<th>나이</th>
					<th>성별</th>
					<th>후보번호</th>
					<th>투표시간</th>
					<th>유권자확인</th>
				</tr>
				
				<c:forEach var="voteList" items="${voteExaminationList}">
					<tr>
						<td>${voteList.v_name}</td>
						<td>${voteList.v_birth}</td>
						<td>${voteList.v_age}</td>
						<td>${voteList.v_sex}</td>
						<td>${voteList.m_no}</td>
						<td>${voteList.v_time}</td>
						<td>${voteList.v_confirm}</td>
					</tr>
				</c:forEach>
			</table>		
		</c:if>
	</div>
<%@ include file="../footer/footer.jsp" %>
</body>
</html>