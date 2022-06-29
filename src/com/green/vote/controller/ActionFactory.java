package com.green.vote.controller;

import com.green.vote.controller.action.Action;
import com.green.vote.controller.action.IndexAction;
import com.green.vote.controller.action.MemberListAction;
import com.green.vote.controller.action.MemberRankingAction;
import com.green.vote.controller.action.VoteAction;
import com.green.vote.controller.action.VoteExaminationAction;
import com.green.vote.controller.action.VoteFormAction;

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
		} else if (command.equals("vote_examination_action")) { // 투표검수조회 (수연님)
			action = new VoteExaminationAction();
		} else if (command.equals("member_ranking_action")) { // 후보자등수 (한수님)
			action = new MemberRankingAction();
		}
				
		return action;
	}
	
	
}
