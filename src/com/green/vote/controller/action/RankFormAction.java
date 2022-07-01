package com.green.vote.controller.action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.vote.dao.RankDao;
import com.green.vote.vo.RankVo;

public class RankFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "vote/rank.jsp";
		
		RankDao dao = RankDao.getInstance();
		List<RankVo> list = dao.VoteRank();
		
		request.setAttribute("VoteRank", list);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}

}
