package com.green.vote.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.vote.dao.MemberDAO;
import com.green.vote.vo.MemberVOForRanking;

public class MemberRankingAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "vote/memberRankingList.jsp";
		MemberDAO dao = MemberDAO.getInstance();
		
		List<MemberVOForRanking> list = dao.selectMemberRankingVote();
		
		request.setAttribute("memberRankingList", list);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
