package com.green.vote.controller;

import com.green.vote.controller.action.Action;
import com.green.vote.controller.action.IndexAction;
import com.green.vote.controller.action.VoteAction;
import com.green.vote.controller.action.VoteFormAction;

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
		} else if (command.equals("vote_form_action")) {
			action = new VoteFormAction();
		} else if (command.equals("vote_action")) {
			action = new VoteAction();
		}
		
		
		
		return action;
	}
	
	
}
