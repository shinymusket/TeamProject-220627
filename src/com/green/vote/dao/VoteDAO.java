package com.green.vote.dao;

import java.sql.Connection;
<<<<<<< HEAD
import java.sql.PreparedStatement;
import java.sql.Statement;
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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
<<<<<<< HEAD
=======
<<<<<<< HEAD
=======
>>>>>>> 786cd2957d36b9cde2758fd2e40ec173c2abce0a
>>>>>>> 818c2ba5ca562288cbe6d3103d4a545f2c5481c4
>>>>>>> 4ba5cae3352f2f019deb3ab7a161a779d5abe615

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
			e.printStackTrace();
		} finally {
			DBManager.close(conn, psmt);;
		}
		
	}

	//////////////////////////////////////////////////////
	//1. 투표 검수 조회를 위한 메서드
	
	
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
				VoteVO vVo = new VoteVO();
				vVo.setV_name(rs.getString("v_name"));
				vVo.setV_jumin(rs.getString("v_jumin"));
				vVo.setM_no(rs.getString("m_no"));
				vVo.setV_time(rs.getString("v_time"));
				vVo.setV_confirm(rs.getString("v_confirm"));
				
				list.add(vVo);
			}
			
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBManager.close(conn, stmt, rs);
		}


		return list;
	}
	

}



