package com.cafe24.mysite.action.comment;

import com.cafe24.mvc.action.AbstractActionFactory;
import com.cafe24.mvc.action.Action;
import com.cafe24.mysite.action.main.IndexAction;

public class CommentActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;

		if ("commentWrite".equals(actionName)) {
			action = new CommentWriteAction();
		} else if ("commentdeleteform".equals(actionName)) {
			action = new CommentDeleteFormAction();
		} else if ("delete".equals(actionName)) {
			action = new CommentDeleteAction();
		} else {
			action = new CommentListAction();
		}

		return action;
	}
}
