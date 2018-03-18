package com.cafe24.mysite.action.comment;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.CommentDao;
import com.cafe24.mysite.vo.CommentVo;

public class CommentListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("boardNo");
		
		CommentDao dao = new CommentDao();
		List<CommentVo> list = dao.GetList(Long.parseLong(boardNo));

		request.setAttribute("list", list);
		
		WebUtil.forward(request, response, "/WEB-INF/views/board/comment/commentform.jsp");
	}

}
