package com.green.vote.controller.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.vote.dao.VoteDAO;
import com.green.vote.vo.VoteVO;

public class VoteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = ""; // 투표검수 조회 Action
		String v_jumin = request.getParameter("v_jumin");
		String v_name = request.getParameter("v_name");
		String m_no = request.getParameter("m_no");
		String v_time = request.getParameter("v_time");
		String v_area = request.getParameter("v_area");
		String v_confirm = request.getParameter("v_confirm");
		
		VoteVO vVo = new VoteVO();
		vVo.setV_jumin(v_jumin);
		vVo.setV_name(v_name);
		vVo.setM_no(m_no);
		vVo.setV_time(v_time);
		vVo.setV_area(v_area);
		vVo.setV_confirm(v_confirm);
		
		VoteDAO dao = VoteDAO.getInstance();
		dao.insertVote(vVo);
		
		request.getRequestDispatcher(url).forward(request, response);
	}

}
