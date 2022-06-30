<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표검수조회</title>
<link type="text/css" rel="stylesheet" href="css/vote.css?">
</head>
<body>
<%@ include file="../header/header.jsp" %>
<%@ include file="../nav/nav.jsp" %>

<!-- 투표 검수 조회 JSP -->

<div class="container" align="center">

	<h2>투표검수조회</h2>
	<table>
		<tr>
			<th>성명</th>
			<th>생년월일</th>
			<th>나이</th>
			<th>성별</th>
			<th>후보번호</th>
			<th>투표시간</th>
			<th>유권자 확인</th>
		</tr>
		
		<c:forEach items="${VoteList}" var="VL">
			<tr>
				<!-- 이름 -->
				<td>${VL.v_name}</td>
				<td>${VL.birth}</td>
				<td>만  ${VL.age}세</td>
				<td>${VL.sex}</td>
				<td>${VL.m_no}</td>
				<td>${VL.v_time}</td>
				<td>${VL.v_confirm}</td>
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="../footer/footer.jsp" %>
</body>

</html>