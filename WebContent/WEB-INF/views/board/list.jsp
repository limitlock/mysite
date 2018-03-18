<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/mysite/assets/css/board.css" rel="stylesheet"
	type="text/css">
</head>
<body>
	<div id="container">
		<c:import url="/WEB-INF/views/includes/header.jsp" />
		<div id="content">
			<div id="board">
				<form id="search_form" action="/mysite/board" method="post">
					<input type="hidden" name="a" value="search"> <input
						type="text" id="kwd" name="kwd" value=""> <input
						type="submit" value="찾기">
				</form>
				<table class="tbl-ex">
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>글쓴이</th>
						<th>조회수</th>
						<th>작성일</th>
						<th>&nbsp;</th>
					</tr>
					<c:set var="count" value="${fn:length(list) }" />
					<c:forEach items="${list }" step="1" var="vo" varStatus="status">
						<tr>
							<td>${count -status.count +1 }</td>
							<td style="text-align: left; padding-left: ${20*vo.depth}px">
								<c:choose>
									<c:when test="${vo.oNo > 1}">
										<img src="/mysite/assets/images/reply.png" />
										<a href="/mysite/board?a=view&no=${vo.no }">${vo.title }</a>
									</c:when>
									<c:otherwise>
										<a href="/mysite/board?a=view&no=${vo.no }">${vo.title }</a>
									</c:otherwise>
								</c:choose>
							</td>
							<td>${vo.writer }</td>
							<td>${vo.hit }</td>
							<td>${vo.curDate }</td>
							<c:choose>
								<c:when test="${authUser.no == vo.writerNo }">
									<td><a
										href="/mysite/board?a=deleteform&userNo=${authUser.no }&no=${vo.no}"
										class="del">삭제</a></td>
								</c:when>
							</c:choose>
						</tr>
					</c:forEach>
				</table>
				<div id="underpoint" class="pager">
					<ul>
						<c:set var="count" value="${fn:length(list) }" />
						<li><a href="">◀ ${ss = count/5 }</a></li>
						<c:forEach begin="1" end="5" step="1" var="i" varStatus="status">
							<p style="display: none">${index = count%10 }</p>
							<c:choose>
								<c:when test="${index ==  0}">
									<li><a href="/mysite/board?a=list&page=${i }">${i }</a></li>
								</c:when>
								<c:otherwise>
									<li>${i }</li>
								</c:otherwise>
							</c:choose>
						</c:forEach>
						<li><a href="">▶</a></li>
					</ul>
				</div>
				<c:choose>
					<c:when test="${not empty authUser }">
						<div class="bottom">
							<a href="/mysite/board?a=writeform" id="new-book">글쓰기</a>
						</div>
					</c:when>
				</c:choose>
			</div>
		</div>
		<c:import url="/WEB-INF/views/includes/navigation.jsp">
			<c:param name="menu" value="board" />
		</c:import>
		<c:import url="/WEB-INF/views/includes/footer.jsp" />
	</div>
</body>
</html>