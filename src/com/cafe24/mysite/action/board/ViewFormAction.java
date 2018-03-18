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

public class ViewFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String boardNo = request.getParameter("no");

		BoardDao dao = new BoardDao();
		List<BoardVo> list = dao.viewGetList(Integer.parseInt(boardNo));

		BoardVo vo = new BoardVo();
		vo.setNo(Long.parseLong(boardNo));

		dao.hitUpdate(vo);

		request.setAttribute("list", list);

		WebUtil.forward(request, response, "/WEB-INF/views/board/view.jsp");

	}

}
