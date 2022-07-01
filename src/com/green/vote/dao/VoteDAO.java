package com.green.vote.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
<<<<<<< HEAD
=======
import java.sql.ResultSet;
import java.sql.Statement;
<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.green.vote.vo.VoteVO;
import com.green.vote.vo.VoteVOForSelect;
=======
=======
=======
<<<<<<< HEAD
import java.sql.PreparedStatement;
import java.sql.Statement;
=======
<<<<<<< HEAD
import java.sql.PreparedStatement;
import java.sql.Statement;
=======
>>>>>>> 818c2ba5ca562288cbe6d3103d4a545f2c5481c4
>>>>>>> 4ba5cae3352f2f019deb3ab7a161a779d5abe615
>>>>>>> 62d62c79e8b909c68e2e6785c0c6618c012ba147
>>>>>>> member3
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 786cd2957d36b9cde2758fd2e40ec173c2abce0a
>>>>>>> 818c2ba5ca562288cbe6d3103d4a545f2c5481c4
>>>>>>> 4ba5cae3352f2f019deb3ab7a161a779d5abe615
>>>>>>> 62d62c79e8b909c68e2e6785c0c6618c012ba147
>>>>>>> member3

import com.green.vote.vo.VoteVO;
>>>>>>> 50dd2f48c37d2f44a8c660e11dadfe4ea81f26a7

import DBPKG.DBManager;

public class VoteDAO {
	
	// 싱글톤 패턴
	
	private VoteDAO() {}
	
	private static VoteDAO dao = new VoteDAO();
	
	public static VoteDAO getInstance() {
		
		return dao;
	}


	
	//////////////////////////////////////////////////////
	//1. 투표 검수 조회를 위한 메서드

	
	public void insertVote(VoteVO vVo) { // 투표하기
		String sql = "INSERT INTO TBL_VOTE_202005 VALUES(?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement psmt = null;
		
		try {
			conn = DBManager.getConnection();
			psmt  = conn.prepareStatement(sql);
			
			psmt.setString(1, vVo.getV_jumin());
			psmt.setString(2, vVo.getV_name());
			psmt.setString(3, vVo.getM_no());
			psmt.setString(4, vVo.getV_time());
			psmt.setString(5, vVo.getV_area());
			psmt.setString(6, vVo.getV_confirm());
			
			psmt.executeUpdate();
			
		
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);;
		}
		
	}
	
	 public List<VoteVOForSelect> selectVote() { // 투표검수 조회
		 List<VoteVOForSelect> list = new ArrayList<>();
		 String sql = "SELECT v_name, v_jumin, m_no, v_time, v_confirm FROM TBL_VOTE_202005 WHERE v_area='제1투표장'";
		 
		 Connection conn = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 
		 try {
			 conn = DBManager.getConnection();
			 stmt = conn.createStatement();
			 rs = stmt.executeQuery(sql);
			 
			 while (rs.next()) {
				 VoteVOForSelect vVo = new VoteVOForSelect();
				 vVo.setV_name(rs.getString(1));
				 String jumin = rs.getString(2);
				 
				 vVo.setV_birth(getBirthByJumin(jumin)); // 생년월일
				 vVo.setV_age(getAgeByJumin(jumin));
				 vVo.setV_sex(getSexByJumin(jumin));
				 
				 vVo.setM_no(rs.getString(3));
				 
				 String timeStr = rs.getString(4);
				 String time = timeStr.substring(0,2) + ":" + timeStr.substring(2) ;
				 
				 vVo.setV_time(time);
				 
				 String v_confirm = rs.getNString(5);
				 
				 String confirm = null;
				 if (v_confirm.equalsIgnoreCase("y")) {
					 confirm = "확인";
				 } else if (v_confirm.equalsIgnoreCase("n")) {
					 confirm = "미확인";
				 }
				
				 vVo.setV_confirm(confirm);
				 
				 list.add(vVo);
			 }
			 
			 
		 } catch(Exception e) {
			 
		 } finally {
			 DBManager.close(conn, stmt, rs);
		 }
		 
		 return list;
	 }
	 
	 public String getBirthByJumin(String juminStr) { // 주민등록번호로 생년월일 가져오기 
		 	String birth = null;
		 	
		 	String birthYearStr = juminStr.substring(0, 2); // 앞자리중 맨앞 두자리
		 	String birthMonthStr = juminStr.substring(2, 4); // 앞자리중 가운데 두자리
		 	String birthDateStr = juminStr.substring(4, 6); // 앞자리중 끝 두자리	
		 	
		 	String juminBackFirstNumStr = juminStr.substring(6, 7); // 끝자리 제일 앞 번호
		 	
		 	int  juminBackFirstNum = Integer.parseInt(juminBackFirstNumStr);
		 	
		 	if ((juminBackFirstNum == 3) || (juminBackFirstNum == 4)) { // 뒷번호 앞자리가 3이나 4라면 2000년대 생
		 		birth = "20" +  birthYearStr + "년" +  birthMonthStr + "월" + birthDateStr + "일생";
		 	} else if ((juminBackFirstNum == 1) || (juminBackFirstNum == 2)) { // 뒷번호 앞자리가 1이나 2라면 1900년대 생
		 		birth = "19" +  birthYearStr + "년" +  birthMonthStr + "월" + birthDateStr + "일생";
		 	}
		 
		 	return birth;
	 }
	 
	 public String getAgeByJumin(String juminStr) { // 주민등록번호로 만 나이 가져오기
		 String age = null;
		 int ageInt = 0;
		 String birthYearStr = null;
		 
		 // 오늘 날짜 가져오기
		 Date date = new Date();
		 SimpleDateFormat yy = new SimpleDateFormat("yyyy");
		 SimpleDateFormat md = new SimpleDateFormat("MMdd");
		 
		 String yearStr = yy.format(date);
		 int year = Integer.parseInt(yearStr);
		 
		 String MonthDateStr = md.format(date);
		 int MonthDate = Integer.parseInt(MonthDateStr);
		 
		 
		
		 

		 String juminBackFirstNumStr = juminStr.substring(6, 7); // 끝자리 제일 앞 번호
		 	
	 	 int  juminBackFirstNum = Integer.parseInt(juminBackFirstNumStr);
		 	
	 	 if ((juminBackFirstNum == 3) || (juminBackFirstNum == 4)) { // 뒷번호 앞자리가 3이나 4라면 2000년대 생
	 		 birthYearStr = "20" + juminStr.substring(0, 2); // 앞자리중 맨앞 두자리
		 	} else if ((juminBackFirstNum == 1) || (juminBackFirstNum == 2)) { // 뒷번호 앞자리가 1이나 2라면 1900년대 생
		 	 birthYearStr = "19" + juminStr.substring(0, 2); // 앞자리중 맨앞 두자리
		 	}
		 
	 	 String birthMonthDateStr = juminStr.substring(2, 6); // 앞자리중 가운데부터 끝자리
		 int birthYear = Integer.parseInt(birthYearStr);
		 int birthMonthDate = Integer.parseInt(birthMonthDateStr);
	 	 
	 	 if (birthMonthDate < MonthDate) {
	 		ageInt = year-birthYear;
	 	 } else {
	 		ageInt = year-birthYear-1;
	 	 }
		 
	 	age = "만 " + Integer.toString(ageInt) + "세";
		 
		 return age;
	 }
	 
	 public String getSexByJumin(String juminStr) { // 주민등록번호로 성별 가져오기
		 String sex = null;
		 
		 String juminBackFirstNumStr = juminStr.substring(6, 7); // 끝자리 제일 앞 번호
		 int  juminBackFirstNum = Integer.parseInt(juminBackFirstNumStr);
		 
		 if ((juminBackFirstNum == 1) || (juminBackFirstNum == 3)) {  //  뒷번호 앞자리가 1이나 3이라면 남자
			 sex = "남";
		 } else if ((juminBackFirstNum == 2) || (juminBackFirstNum == 4)) { //  뒷번호 앞자리가 2이나 4이라면 여자
			 sex = "여";
		 }
		 
		 return sex;
		 
	 }

	
	
	public List<VoteVO> selectVoteList() {
		
		String sql = "SELECT v_name, v_jumin, m_no, v_time, v_confirm FROM TBL_VOTE_202005 WHERE v_area='제1투표장'";
		
		List<VoteVO> list = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			
			// 쿼리문을 통해서 투표이력 테이블에서 정보 가져오기
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				VoteVO vVo  = new VoteVO();
				
				
				// 이름 가져오기
				vVo.setV_name(rs.getString("v_name"));
				
				
				// 주민번호 가져오기
				String jumin = rs.getString("v_jumin");
				
				
				
				// 생년월일 가져오기
				vVo.setBirth(birthByJumin(jumin));  // 생년월일
				vVo.setAge(ageByJumin(jumin));  // 만 나이
				vVo.setSex(sexByjumin(jumin));  // 성별
				
				
				
				// 후보자 가져오기
				vVo.setM_no(rs.getString("m_no"));
				
				
				
				// 시간 가져오기
				String times = rs.getString("v_time");
				String time = times.substring(0,2) + ":" + times.substring(2);
				
				vVo.setV_time(time);
				
				
				// 유권자 확인
				String confirms = rs.getString("v_confirm");
				
				String confirm = null;
				
				if(confirms.equalsIgnoreCase("Y")) {  // 유권자 확인
					confirm ="확인";
				}else if (confirms.equalsIgnoreCase("N")) {  // 유권자 미확인
					confirm ="미확인";
				}
				
				vVo.setV_confirm(confirm);

				list.add(vVo);
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}


		return list;
	}
	
	
	// 주민번호로 생년월일 구하기
	public String birthByJumin(String jumin) {
		
		String birth = null;
		
		String firstBirth = jumin.substring(0,2);
		String middleBirth = jumin.substring(2,4);
		String lastBirth = jumin.substring(4, 6);
		
		// 주민번호 뒷 번호
		String backJumins = jumin.substring(6,7);
		
		int backJumin = Integer.parseInt(backJumins);
		
		
		if((backJumin==3)||(backJumin==4)) { // 만약, 주민 번호 뒷번호 첫번째 자리가 3 또는 4 이면 2000년대생
			birth = "20" + firstBirth + "년" + middleBirth + "월" + lastBirth + "일";
		}else if((backJumin==1)||(backJumin==2)) { // 만약, 주민 번호 뒷번호 첫번째 자리가 1 또는 2 이면 1900년대생
			birth = "19" + firstBirth + "년" + middleBirth + "월" + lastBirth + "일";
		}
		
		return birth;
	}
	
	

	// 주민번호로 만 나이 가져오기
	public int ageByJumin(String jumin) {

		String today = "";
		int age = 0;
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		today = formatter.format(new Date()); 		
		
		
		int todayYear = Integer.parseInt(today.substring(0, 4));
		int todayMonth = Integer.parseInt(today.substring(4, 6));
		int todayDay = Integer.parseInt(today.substring(6, 8));
		
		
		 int ssnYear = Integer.parseInt(jumin.substring(0, 2));
		 int ssnMonth = Integer.parseInt(jumin.substring(2, 4));
		 int ssnDay = Integer.parseInt(jumin.substring(4,6));
		
		
		 
		 String backJumin = jumin.substring(6,7);

	     

	        if(backJumin.equals("1") || backJumin.equals("2")) {
	        	ssnYear += 1900;
	            
	        } else if(backJumin.equals("3") || backJumin.equals("4")) {
	        	ssnYear += 2000;
	        } 
		 
		 
		 
		age = todayYear - ssnYear;
		
		
		
		
		
		if (todayMonth < ssnMonth) { // 생년월일 "월"이 지났는지 체크           
			age--;
		} else if (todayMonth == ssnMonth) { // 생년월일 "일"이 지났는지 체크            
			if (todayDay < ssnDay) {
				age--; // 생일 안지났으면 (만나이 - 1)            }        }
			}
		}
		
		

		return age;
		
	}
	
	
	// 주민번호로 성별 가져오기
	
	public String sexByjumin(String jumin) {
		
		String sex = null;
		
		int backJumin =  Integer.parseInt(jumin.substring(6,7));
		
		if((backJumin==3)||(backJumin==1)) {
			sex = "남";
		} else if((backJumin==2)||(backJumin==4)) {
			sex = "여";
		}
		
		
		return sex;
	}





	//투표하기
	public void insertVote(VoteVO vVo) {
		String sql = "INSERT INTO TBL_VOTE_202005 VALUES(?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement psmt = null;

		try {
		conn = DBManager.getConnection();
		psmt  = conn.prepareStatement(sql);

		psmt.setString(1, vVo.getV_jumin());
		psmt.setString(2, vVo.getV_name());
		psmt.setString(3, vVo.getM_no());
		psmt.setString(4, vVo.getV_time());
		psmt.setString(5, vVo.getV_area());
		psmt.setString(6, vVo.getV_confirm());

		psmt.executeUpdate();


		} catch(Exception e) {

		} finally {
		DBManager.close(conn, psmt);
		}

	}
	
	
	
}
