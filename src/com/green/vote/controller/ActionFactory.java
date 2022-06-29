package com.green.vote.controller;

import com.green.vote.controller.action.Action;
import com.green.vote.controller.action.IndexAction;
<<<<<<< HEAD
import com.green.vote.controller.action.MemberListAction;
import com.green.vote.controller.action.VoteAction;
import com.green.vote.controller.action.VoteFormAction;
=======
import com.green.vote.controller.action.VoteListAction;
>>>>>>> 786cd2957d36b9cde2758fd2e40ec173c2abce0a

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
<<<<<<< HEAD
		} else if (command.equals("vote_form_action")) {  // 투표하기 폼 요청
			action = new VoteFormAction();
		} else if (command.equals("vote_action")) { // 투표하기
			action = new VoteAction();
		} else if (command.equals("member_list_action")) { // 후보 조회
			action = new MemberListAction();
=======
		} 
		else if (command.equals("vote_List")) {  // 홈 -> 투표검수조회 페이지 이동 클래스
			action = new VoteListAction();
>>>>>>> 786cd2957d36b9cde2758fd2e40ec173c2abce0a
		}
		
		
		
		return action;
	}
	
	
}
