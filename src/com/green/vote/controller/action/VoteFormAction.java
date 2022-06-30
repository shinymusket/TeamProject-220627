package com.green.vote.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.vote.dao.MemberDAO;
import com.green.vote.vo.MemberVO;

public class VoteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "vote/voteForm.jsp";
		
		MemberDAO dao = MemberDAO.getInstance();
		List<MemberVO> memberList = dao.selectMember();
		request.setAttribute("memberList", memberList);
		
		
		request.getRequestDispatcher(url).forward(request, response);

	}

}
