package com.cafe24.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cafe24.mysite.vo.BoardVo;
import com.cafe24.mysite.vo.GuestBookVo;

public class BoardDao {

	private static final int LIST_COUNT = 10;
	
	public boolean delete(BoardVo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();
			String sql = " delete from board where no = (select * from (select b.no from users a, board b where a.no = b.user_no and a.no = ? and b.no = ? and password = password(?)) a)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, vo.getWriterNo());
			pstmt.setLong(2, vo.getNo());
			pstmt.setString(3, vo.getPassword());

			int count = pstmt.executeUpdate();
			result = (count == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	public boolean insert(BoardVo vo) {
		boolean result = false;

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = getConnection();

			String sql = "insert into board values(null, ?, ?, (select if(isnull(g_no), 1, max(g_no)+1) from board a), 1, 0, now(),0, ?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setLong(3, vo.getWriterNo());
			// pstmt.setLong(4, vo.getoNo());
			// pstmt.setLong(5, vo.getDepth());

			int count = pstmt.executeUpdate();
			result = (count == 1);

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return result;
	}

	public List<BoardVo> getList(int page) {
		List<BoardVo> list = new ArrayList<>();

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = getConnection();
			String sql = "select b.no, title, cur_date, hit, a.name, g_no, o_no, depth, user_no "
					+ "from users a, board b " + "where a.no=b.user_no " + "order by g_no desc, o_no asc "
					+ "limit ?,?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setLong(1, (page - 1) * LIST_COUNT);
			pstmt.setLong(2, LIST_COUNT);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				Long no = rs.getLong(1);
				String title = rs.getString(2);
				String curDate = rs.getString(3);
				Long hit = rs.getLong(4);
				String writer = rs.getString(5);

				Long gNo = rs.getLong(6);
				Long oNo = rs.getLong(7);
				Long depth = rs.getLong(8);

				Long writerNo = rs.getLong(9);

				BoardVo vo = new BoardVo();

				vo.setNo(no);
				vo.setTitle(title);
				vo.setCurDate(curDate);
				vo.setHit(hit);
				vo.setWriter(writer);

				vo.setgNo(gNo);
				vo.setoNo(oNo);
				vo.setDepth(depth);

				vo.setWriterNo(writerNo);

				list.add(vo);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		return list;
	}

	private Connection getConnection() throws SQLException {
		Connection conn = null;
		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2.연결하기
			String url = "jdbc:mysql://localhost/webdb";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패 " + e);
		}
		return conn;
	}

}
