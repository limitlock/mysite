<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="navigation">
	<ul>
		<c:choose>
			<c:when test='${param.menu == "main" }'>
				<li class="selected"><a href="/mysite/main">안대혁</a></li>
				<li><a href="/mysite/guestbook?a=list">방명록</a></li>
				<li><a href="/mysite/board?a=list&page=1">게시판</a></li>
			</c:when>
			<c:when test='${param.menu == "guestbook" }'>
				<li><a href="/mysite/main">안대혁</a></li>
				<li class="selected"><a href="/mysite/guestbook?a=list">방명록</a></li>
				<li><a href="/mysite/board?a=list">게시판</a></li>
			</c:when>
			<c:when test='${param.menu == "board" }'>
				<li><a href="/mysite/main">안대혁</a></li>
				<li><a href="/mysite/guestbook?a=list">방명록</a></li>
				<li class="selected"><a href="/mysite/board?a=list">게시판</a></li>
			</c:when>
			<c:otherwise>
				<li><a href="/mysite/main">안대혁</a></li>
				<li><a href="/mysite/guestbook?a=list">방명록</a></li>
				<li><a href="/mysite/board?a=list">게시판</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>