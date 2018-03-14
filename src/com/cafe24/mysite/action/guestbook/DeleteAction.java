package com.cafe24.mysite.action.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.GuestBookDao;
import com.cafe24.mysite.vo.GuestBookVo;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String no = request.getParameter("no");
		String password = request.getParameter("password");

		GuestBookVo vo = new GuestBookVo();
		vo.setNo(Long.parseLong(no));
		vo.setPassword(password);

		GuestBookDao dao = new GuestBookDao();
		dao.delete(vo);

		WebUtil.redirect(request, response, "/mysite/guestbook");
	}

}
