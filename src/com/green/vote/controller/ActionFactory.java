package com.green.vote.controller;

import com.green.vote.controller.action.Action;
import com.green.vote.controller.action.IndexAction;
<<<<<<< HEAD
<<<<<<< HEAD
=======
=======

>>>>>>> 4ba5cae3352f2f019deb3ab7a161a779d5abe615
>>>>>>> 62d62c79e8b909c68e2e6785c0c6618c012ba147
import com.green.vote.controller.action.MemberListAction;
import com.green.vote.controller.action.MemberRankingAction;
import com.green.vote.controller.action.VoteAction;
import com.green.vote.controller.action.VoteExaminationAction;
import com.green.vote.controller.action.VoteFormAction;
<<<<<<< HEAD
=======
import com.green.vote.controller.action.VoteListAction;
>>>>>>> 50dd2f48c37d2f44a8c660e11dadfe4ea81f26a7
=======
import com.green.vote.controller.action.VoteListAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if (command.equals("home")) { // 홈페이지
			action = new IndexAction();
		} else if (command.equals("vote_form_action")) {  // 투표하기 폼 요청
			action = new VoteFormAction();
		} else if (command.equals("vote_action")) { // 투표하기
			action = new VoteAction();
		} else if (command.equals("member_list_action")) { // 후보 조회
			action = new MemberListAction();
		} else if (command.equals("vote_List")) {  // 홈 -> 투표검수조회 페이지 이동 클래스
			action = new VoteListAction();
		} else if (command.equals("member_ranking_action")) { // 후보자등수 (한수님)
			action = new MemberRankingAction();
		}
				
		return action;
	}
	
	
}
