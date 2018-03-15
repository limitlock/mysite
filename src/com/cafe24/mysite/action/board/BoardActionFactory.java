package com.cafe24.mysite.action.board;

import com.cafe24.mvc.action.AbstractActionFactory;
import com.cafe24.mvc.action.Action;

public class BoardActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		if("view".equals(actionName)) {
			//action = new ViewFormAction();
		}else if("write".equals(actionName)) {
			action = new WriteFormAction();
		}
		else {
			action = new ListAction();
		}
		
		
		
		return action;
	}

}
