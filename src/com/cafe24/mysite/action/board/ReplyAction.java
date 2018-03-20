package com.cafe24.mysite.action.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cafe24.mvc.action.Action;
import com.cafe24.mvc.util.WebUtil;
import com.cafe24.mysite.dao.BoardDao;
import com.cafe24.mysite.vo.BoardVo;

public class ReplyAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String no = request.getParameter("no");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String groupNo = request.getParameter("groupNo");
		String orderNo = request.getParameter("orderNo");
		String depth = request.getParameter("depth");
		String writerNo = request.getParameter("writerNo");

		System.out.println("g" + groupNo);
		System.out.println("o" + orderNo);
		System.out.println("d" + depth);

		BoardVo vo = new BoardVo();
		vo.setNo(Long.parseLong(no));
		vo.setTitle(title);
		vo.setContent(content);
		vo.setGroupNo(Long.parseLong(groupNo));
		vo.setOrderNo(Long.parseLong(orderNo));
		vo.setDepth(Long.parseLong(depth));
		vo.setWriterNo(Long.parseLong(writerNo));

		BoardDao dao = new BoardDao();

		dao.replyUpdate(vo);
		dao.replyInsert(vo);  

		WebUtil.redirect(request, response, "/mysite/board?a=list&page=1");
	}

}
