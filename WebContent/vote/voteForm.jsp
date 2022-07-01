<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>투표하기</title>
<link type="text/css" rel="stylesheet" href="./css/vote.css?">
</head>
<body>
<%@ include file="../header/header.jsp" %>
<%@ include file="../nav/nav.jsp" %>
	<div class="container" align="center">
		<h1>투표하기</h1>
		<form action="VS?command=vote_action" method="post" name="frm">
			<table>
				<tr>
					<th>주민번호</th>
					<td>
						<input type="text" name="v_jumin" id="v_jumin"> 예 : 8906153154726
					</td>
				</tr>
				<tr>
					<th>성명</th>
					<td>
						<input type="text" name="v_name" id="v_name" >
					</td>
				</tr>
				<tr>
					<th>투표번호</th>
					<td>
						<select name="m_no" id="m_no">
							<c:if test="${memberList != null}">
									<option></option>
								<c:forEach var="member" items="${memberList}">
									<option value="${member.m_no}">[${member.m_no}] ${member.m_name}</option>
								</c:forEach>
							</c:if>
						</select>
					</td>
				</tr>
				<tr>
					<th>투표시간</th>
					<td>
						<input type="text" name="v_time" id="v_time" >
					</td>
				</tr>
				<tr>
					<th>투표장소</th>
					<td>
						<input type="text" name="v_area" id="v_area">
					</td>
				</tr>
				<tr>
					<th>유권자확인</th>
					<td>
						<input type="radio" name="v_confirm" id="v_confirmY" value="y"> 확인
						<input type="radio" name="v_confirm" id="v_confirmN" value="n"> 미확인
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="button" value="투표하기" onclick="check()">
						<input type="reset" value="다시하기">
					</td>
				</tr>
			
			
			</table>
		</form>
	</div>
<%@ include file="../footer/footer.jsp" %>
<script type="text/javascript">

	 function check() {
		 	 
			var v_jumin = document.getElementById("v_jumin").value;
			var v_name = document.getElementById("v_name").value;
			var m_no = document.getElementById("m_no").value;
			var v_time = document.getElementById("v_time").value;
			var v_area = document.getElementById("v_area").value;
			var v_confirmY = document.getElementById("v_confirmY");
			var v_confirmN = document.getElementById("v_confirmN");
			
			if (v_jumin == "") {
				alert("주민번호가 입력되지 않았습니다!");
				v_jumin.focus();
				return false;
			};
			
			if (v_name == "") {
				alert("성명이 입력되지 않았습니다!");
				v_name.focus();
				return false;
			};
			
			if (m_no == "") {
				alert("후보번호가 선택되지 않았습니다!");
				m_no.focus();
				return false;
			};
			
			if (v_time == "") {
				alert("투표시간이 입력되지 않았습니다!");
				v_time.focus();
				return false;
			};
			
			if (v_area == "") {
				alert("투표장소가 입력되지 않았습니다!");
				v_area.focus();
				return false;
			};
			
			if (!v_confirmY.checked && !v_confirmN.checked) {
				alert("유권자확인이 선택되지 않았습니다!");
				return false;
			};
			
			alert("투표하기 정보가 정상적으로 등록 되었습니다!");
			document.frm.submit();
		}

</script>	
</body>
</html>