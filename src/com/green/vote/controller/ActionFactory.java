package com.green.vote.controller;

import com.green.vote.controller.action.Action;
import com.green.vote.controller.action.IndexAction;
import com.green.vote.controller.action.VoteListAction;

public class ActionFactory {
	private ActionFactory() {}
	private static ActionFactory af = new ActionFactory();
	public static ActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if (command.equals("home")) {
			action = new IndexAction();
		} 
		else if (command.equals("vote_List")) {  // 홈 -> 투표검수조회 페이지 이동 클래스
			action = new VoteListAction();
		}
		
		
		
		return action;
	}
	
	
}
