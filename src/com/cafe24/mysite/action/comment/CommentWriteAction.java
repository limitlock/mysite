package com.cafe24.mysite.action.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.CommentDao;
import com.cafe24.mysite.vo.CommentVo;

public class CommentWriteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		String content = request.getParameter("content");
		String boardNo = request.getParameter("boardNo");

		CommentVo vo = new CommentVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setContent(content);
		vo.setBoardNo(Long.parseLong(boardNo));

		CommentDao dao = new CommentDao();
		dao.insert(vo);

		WebUtil.redirect(request, response, "/mysite/comment?boardNo=" + vo.getBoardNo());
	}

}
