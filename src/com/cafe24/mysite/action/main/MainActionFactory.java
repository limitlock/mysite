package com.cafe24.mysite.action.main;

import com.cafe24.mvc.action.AbstractActionFactory;
import com.cafe24.mvc.action.Action;

public class MainActionFactory extends AbstractActionFactory {

	@Override
	public Action getAction(String actionName) {
		// TODO Auto-generated method stub
		return new IndexAction();
	}

}
