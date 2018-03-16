package com.cafe24.mysite.action.board;

import com.cafe24.mvc.action.AbstractActionFactory;
import com.cafe24.mvc.action.Action;

public class BoardActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;

		if ("view".equals(actionName)) {
			// action = new ViewFormAction();
		} else if ("writeform".equals(actionName)) {
			action = new WriteFormAction();
		} else if ("write".equals(actionName)) {
			action = new WriteAction();
		} else if ("deleteform".equals(actionName)) {
			action = new DeleteFormAction();
		}else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		}else {
			action = new ListAction();
		}

		return action;
	}

}
