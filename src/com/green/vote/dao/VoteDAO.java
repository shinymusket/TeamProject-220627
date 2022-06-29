package com.green.vote.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.vote.vo.VoteVO;

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
