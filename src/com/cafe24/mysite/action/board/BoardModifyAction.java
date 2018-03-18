package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

public class BoardModifyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String title = request.getParameter("title");

		String content = request.getParameter("content");
		String no = request.getParameter("no");

		System.out.println("1: " + title + "2: " + content + "3: " + no);

		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setNo(Long.parseLong(no));

		BoardDao dao = new BoardDao();
		dao.update(vo);

		WebUtil.redirect(request, response, "/mysite/board");
	}

}
