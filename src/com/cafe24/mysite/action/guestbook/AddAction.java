package com.cafe24.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.GuestBookDao;
import com.cafe24.mysite.vo.GuestBookVo;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String content = request.getParameter("content");

		GuestBookVo vo = new GuestBookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setContent(content);

		GuestBookDao dao = new GuestBookDao();
		dao.insert(vo);

		WebUtil.redirect(request, response, "/mysite/guestbook");

	}

}
