package com.green.vote.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.vote.dao.VoteDAO;
<<<<<<< HEAD
=======
import com.green.vote.vo.VoteVO;
>>>>>>> 62d62c79e8b909c68e2e6785c0c6618c012ba147
import com.green.vote.vo.VoteVOForSelect;

public class VoteExaminationAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "vote/voteExamination.jsp";
		VoteDAO dao = VoteDAO.getInstance();
		

		List<VoteVO> list = dao.selectVoteList();
		
		request.setAttribute("voteExaminationList", list);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
