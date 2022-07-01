package com.green.rank.controller;

import com.green.rank.controller.action.Action;
import com.green.rank.controller.action.IndexAction;
import com.green.rank.controller.action.RankFormAction;

public class RankActionFactory {
	private RankActionFactory() {}
	private static RankActionFactory af = new RankActionFactory();
	public static RankActionFactory getInstance() {
		return af;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		if (command.equals("home")) {
			action = new IndexAction();
		}else if (command.equals("RankFormAction")) {
			action = new RankFormAction();
		}
		
		
		
		return action;
	}
	
	
}
