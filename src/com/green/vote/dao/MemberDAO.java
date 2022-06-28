package com.green.vote.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.vote.vo.MemberVO;

import DBPKG.DBManager;

public class MemberDAO {
	private MemberDAO() {}
	private static MemberDAO dao = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return dao;
	}
	
	public List<MemberVO> selectMemberNum() { // 후보자 리스트  가져오기
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
	
}
