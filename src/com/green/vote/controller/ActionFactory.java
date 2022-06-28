package com.green.vote.controller;

import com.green.vote.controller.action.Action;
import com.green.vote.controller.action.IndexAction;

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
		
		return action;
	}
	
	
}
