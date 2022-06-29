package com.green.vote.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.vote.vo.MemberVO;
import com.green.vote.vo.MemberVOForRanking;
import com.green.vote.vo.MemberVOForSelect;

import DBPKG.DBManager;

public class MemberDAO {
	private MemberDAO() {}
	private static MemberDAO dao = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public List<MemberVO> selectMember() { // 후보자 리스트  가져오기
		List<MemberVO> list = new ArrayList<>();
		String sql = "SELECT * FROM  tbl_member_202005";
				
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				MemberVO mVo = new MemberVO();
				mVo.setM_no(rs.getString(1));
				mVo.setM_name(rs.getString(2));
				mVo.setP_code(rs.getString(3));
				mVo.setP_shool(rs.getString(4));
				mVo.setM_jumin(rs.getString(5));
				mVo.setM_city(rs.getString(6));
				
				list.add(mVo);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt);
		}
		
		
		return list;
	}
	
	public String selectMemberAcademicAbilityByNum(String p_shool) { // 후보자 학력 번호로 학력 값 가져오기
		String academicAbility = null;
		
		if (p_shool.equals("1")) {
			academicAbility = "고졸";
		} else if (p_shool.equals("2")) {
			academicAbility = "학사";
		} else if (p_shool.equals("3")) {
			academicAbility = "석사";
		} else if (p_shool.equals("4")) {
			academicAbility = "박사";
		}
		
		return academicAbility;
	}
	
	public List<MemberVOForSelect> selectMemberForSelect() { // 후보조회 뷰  가져오기
		List<MemberVOForSelect> list = new ArrayList<>();
		String sql = "SELECT m_no, m_name, p_name, p_shool, m_jumin, m_city, p_tel1, p_tel2, p_tel3 " + 
				" FROM tbl_member_202005 m INNER JOIN tbl_party_202005 p " + 
				" ON m.p_code = p.p_code";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberVOForSelect mVo = new MemberVOForSelect();
				mVo.setM_no(rs.getString(1));
				mVo.setM_name(rs.getString(2));
				mVo.setP_name(rs.getString(3));
				mVo.setP_shool(selectMemberAcademicAbilityByNum(rs.getString(4)));
				
				String juminStr = rs.getString(5);
				String jumin = juminStr.substring(0, 6) + "-" + juminStr.substring(6);
				
				
				mVo.setM_jumin(jumin);
				mVo.setM_city(rs.getString(6));
				mVo.setP_tel(rs.getString(7) + "-" + rs.getString(8) + "-" + rs.getString(9));
				list.add(mVo);
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		return list;
	}
	
	public List<MemberVOForRanking> selectMemberRankingVote() {
		List<MemberVOForRanking> list = new ArrayList<>();
		String sql = "SELECT m.m_no, m.m_name, COUNT(m.m_no) " + 
				" FROM tbl_member_202005 m INNER JOIN TBL_VOTE_202005 v " + 
				" ON m.m_no = v.m_no " + 
				" GROUP BY m.m_no, m.m_name " + 
				" ORDER BY COUNT(m.m_no) DESC";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			conn = DBManager.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				MemberVOForRanking mVo = new MemberVOForRanking();
				mVo.setM_no(rs.getString(1));
				mVo.setM_name(rs.getString(2));
				mVo.setVote_count(rs.getInt(3));
				
				list.add(mVo);
			}
			
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		
		
		return list;
	}
	
}
