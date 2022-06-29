package com.green.vote.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.vote.dao.VoteDAO;
import com.green.vote.vo.VoteVO;

public class VoteListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 투표검수조회 홈페이지 이동 클래스
		
		String url ="vote/voteList.jsp";
		
		VoteDAO dao = VoteDAO.getInstance();
		
		List<VoteVO> VoteList = dao.selectVoteList();
		
		request.setAttribute("VoteList", VoteList);
		
		request.getRequestDispatcher(url).forward(request, response);
		

	}

}
