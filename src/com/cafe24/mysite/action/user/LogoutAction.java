package com.cafe24.mysite.action.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.vo.UserVo;

public class LogoutAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		// // 로그인이 안되어 있는 경우
		// if (session == null) {
		// WebUtil.redirect(request, response, "/mysite/main");
		// return;
		// }
		// UserVo authUser = (UserVo) session.getAttribute("authUser");
		// if (authUser == null) {
		// WebUtil.redirect(request, response, "/mysite/main");
		// return;
		// }

		// logout과 로그인 인증 처리
		if (session != null && (UserVo) session.getAttribute("authUser") != null) {
			session.removeAttribute("authUser");
			session.invalidate();
		}

		WebUtil.redirect(request, response, "/mysite/main");
	}

}
