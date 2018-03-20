package com.cafe24.mysite.action.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		
		BoardDao dao = new BoardDao();
		//List<BoardVo> list = dao.getList();
		
		List<BoardVo> list = dao.getList(Integer.parseInt(page));
		BoardVo maxNo = dao.get();
		
		request.setAttribute("maxNo", maxNo.getMaxNo());
		request.setAttribute("list", list);

		WebUtil.forward(request, response, "/WEB-INF/views/board/list.jsp");

	}

}
