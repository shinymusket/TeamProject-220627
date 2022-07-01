package com.green.rank.controller.action;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.green.rank.dao.RankDao;
import com.green.rank.vo.RankVo;

public class RankFormAction implements Action {

		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String url = "Rank/Rank.jsp";
			
			RankDao dao = RankDao.getInstance();
			List<RankVo> list = dao.VoteRank();
			
			request.setAttribute("VoteRank", list);
			
			request.getRequestDispatcher(url).forward(request, response);

		}

	}


