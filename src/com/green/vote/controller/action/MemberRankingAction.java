package com.green.vote.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import com.green.vote.dao.MemberDAO;
import com.green.vote.vo.MemberVOForRanking;
=======
<<<<<<< HEAD
import com.green.vote.dao.VoteDAO;
import com.green.vote.vo.VoteVO;
=======
import com.green.vote.dao.MemberDAO;
import com.green.vote.vo.MemberVOForRanking;
>>>>>>> 4ba5cae3352f2f019deb3ab7a161a779d5abe615
>>>>>>> 62d62c79e8b909c68e2e6785c0c6618c012ba147

public class MemberRankingAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "vote/memberRankingList.jsp";

		VoteDAO dao = VoteDAO.getInstance();
		
		List<VoteVO> list = dao.selectVoteList();

		request.setAttribute("memberRankingList", list);
		request.getRequestDispatcher(url).forward(request, response);

	}

}
