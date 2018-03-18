package com.cafe24.mysite.action.comment;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.CommentDao;
import com.cafe24.mysite.vo.CommentVo;

public class CommentDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String no = request.getParameter("no");
		String password = request.getParameter("password");
		String boardNo = request.getParameter("boardNo");

		CommentVo vo = new CommentVo();
		vo.setNo(Long.parseLong(no));
		vo.setPassword(password);
		vo.setBoardNo(Long.parseLong(boardNo));

		CommentDao dao = new CommentDao();
		dao.delete(vo);

		WebUtil.redirect(request, response, "/mysite/comment?boardNo=" + vo.getBoardNo());
	}

}
