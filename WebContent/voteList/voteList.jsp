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
				<td>${VL.v_name}</td>

				
				<c:set var="jumin" value="${VL.v_jumin}"/>
				<c:set var="juminLength" value="${fn:length(jumin)}"/>
				<c:set var="first" value="${fn:substring(jumin,0,2)}"/>
				<c:set var="middle" value="${fn:substring(jumin,2,4)}"/>
				<c:set var="last" value="${fn:substring(jumin,4,6)}"/>
				<td> <c:if test="${!empty jumin}"> <c:out value="19${first}년${middle}월${last}일"/> </c:if> </td>
				

				<!--  현재 날짜 정보 가져오기  -->
				<c:set var="now" value="<%=new java.util.Date()%>" />
				<c:set var="sysYear"><fmt:formatDate value="${now}" pattern="yyyy" /></c:set>
				<c:set var="year" value="${fn:substring(sysYear,2,4)}"/>
				
			
				<!--db에서 가져온 주민번호 -->
				<c:set var="age" value='${VL.v_jumin}'/>
				
				<c:set value="${fn:substring(age,0,2)}" var="age1"/>
				
				 <c:set var = "age2" value="${100-age1+1 }"/>
				
				
				   <!-- 계산한나이-->
				<c:set var = "nowAge" value="${age2+year}" />
				
				   <td> <c:out value="만 ${nowAge}세"></c:out> </td> 
					




				<c:set var="type" value="${VL.v_jumin}"/>
				<c:set var="typeLength" value="${fn:length(type)}"/>
				<c:set var="t1" value="${fn:substring(type,6,7)}"/>
				<td> 
					<c:if test="${! empty type}">
						<c:if test="${t1==2}">
							여
						</c:if>  
						<c:if test="${t1==1}">
							남
						</c:if> 
					</c:if> 
				</td>
				

				<td>${VL.m_no}</td>	
				
				<c:set var="time" value="${VL.v_time}"/>
				<c:set var="timeLength" value="${fn:length(time)}"/>
				<c:set var="first" value="${fn:substring(time,0,2)}"/>
				<c:set var="last" value="${fn:substring(time,2,timeLength)}"/>
				<td> <c:if test="${!empty time}"> <c:out value="${first}:${last}"/> </c:if> </td>
				
				

				<c:if test="${VL.v_confirm eq 'N'}">
					<td>미확인</td>
				</c:if>
				<c:if test="${VL.v_confirm eq 'Y'}">
					<td>확인</td>
				</c:if>
				
			</tr>
		</c:forEach>
	</table>
</div>
<%@ include file="../footer/footer.jsp" %>
</body>

</html>