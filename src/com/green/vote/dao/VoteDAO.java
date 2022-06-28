package com.green.vote.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.green.vote.vo.VoteVO;

import DBPKG.DBManager;

public class VoteDAO {
	private VoteDAO() {}
	private static VoteDAO dao = new VoteDAO();
	
	public static VoteDAO getInstance() {
		return dao;
	}
	
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
			DBManager.close(conn, psmt);;
		}
		
	}
	
}
