<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>후보조회</title>
<link type="text/css" rel="stylesheet" href="./css/vote.css?">
</head>
<body>
<%@ include file="../header/header.jsp" %>
<%@ include file="../nav/nav.jsp" %>
	<div class="container" align="center">
		<h1>후보조회</h1>
		<c:if test="${memberList != null}">
			<table>
				<tr>
					<th>후보번호</th>
					<th>성명</th>
					<th>소속정당</th>
					<th>학력</th>
					<th>주민번호</th>
					<th>지역구</th>
					<th>대표전화</th>
				</tr>

				<c:forEach var="member" items="${memberList}">
					<tr>
						<td>${member.m_no}</td>
						<td>${member.m_name}</td>
						<td>${member.p_name}</td>
						<td>${member.p_shool}</td>
						<td>${member.m_jumin}</td>
						<td>${member.m_city}</td>
						<td>${member.p_tel}</td>
					</tr>	
				</c:forEach>
			</table>
		</c:if>
	</div>
<%@ include file="../footer/footer.jsp" %>
</body>
</html>