package com.green.rank.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.green.rank.vo.RankVo;

import DBPKG.DBManager;

public class RankDao {
	private RankDao() {}
	private static RankDao dao = new RankDao();
	
	public static RankDao getInstance() {
		return dao;
	}
	
	
	public List<RankVo> VoteRank()  {
		List<RankVo> list = new ArrayList<>();//데이터를 변수에 타입하고 데이터하고 같은 클래스로 만든다예외적으로 
		//다형성에 있어서 관계로 인한 구현 
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
			stmt  = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
				RankVo rVo =new RankVo();
				rVo.setC_number(rs.getString(1));
				rVo.setC_mame(rs.getString(2));
				rVo.setC_voteSum(rs.getString(3));
			
				list.add(rVo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, stmt, rs);
		}
		return list;
		
		
		
		
	}
	
	
}
