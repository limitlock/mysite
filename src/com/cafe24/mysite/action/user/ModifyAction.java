package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.UserDao;
import com.cafe24.mysite.vo.UserVo;

public class ModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String password = request.getParameter("password");
		String no = request.getParameter("no");

		UserVo vo = new UserVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setGender(gender);
		vo.setNo(Long.parseLong(no));

		if ("".equals(vo.getName())) {
			/* 인증실패 */
			request.setAttribute("name", "이름을 입력하세요");
			WebUtil.forward(request, response, "WEB-INF/views/user/modifyform.jsp");
			return;
		}

		UserDao dao = new UserDao();
		dao.update(vo);

		WebUtil.redirect(request, response, "/mysite/user?a=modifysuccess");

	}

}
