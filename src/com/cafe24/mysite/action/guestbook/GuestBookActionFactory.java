package com.cafe24.mysite.action.guestbook;

import com.cafe24.mvc.action.AbstractActionFactory;
import com.cafe24.mvc.action.Action;
import com.cafe24.mysite.action.main.IndexAction;

public class GuestBookActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;

		if ("deleteform".equals(actionName)) {
			action = new DeleteformAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else if ("add".equals(actionName)) {
			action = new AddAction();
		} else {
			action = new ListAction();
		}

		return action;
	}
}
