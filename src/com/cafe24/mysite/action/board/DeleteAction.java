package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String no = request.getParameter("no");
		String password = request.getParameter("password");
		String userNo = request.getParameter("userNo");
		System.out.println(no + password);

		BoardVo vo = new BoardVo();
		vo.setNo(Long.parseLong(no));
		vo.setPassword(password);
		vo.setWriterNo(Long.parseLong(userNo));

		BoardDao dao = new BoardDao();
		dao.delete(vo);

		WebUtil.redirect(request, response, "/mysite/board");
	}

}
