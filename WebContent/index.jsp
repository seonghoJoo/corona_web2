<%@page import="org.corona.vo.Trip"%>
<%@page import="org.corona.dao.TripDAO"%>
<%@page import="java.util.List"%>
<%@page import="org.corona.vo.PageVO"%>
<%@page import="org.corona.util.PaginateUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	int pageNo = 1;
	String pageStr = request.getParameter("pageNo");
	try{
		pageNo = Integer.parseInt(pageStr);
	}catch(Exception e){
		e.printStackTrace();	
	}
	
	
	
	int total = TripDAO.selectTotal(); 
	int numPage = 5;	
	int numBlock = 3; // 블록 개수
	
	String url = "/index.jsp"; // 페이지 주소
	String param = "pageNo=";
	String paginate = PaginateUtil.getPaginate(pageNo,
	        total,
	        numPage,
	         numBlock,
	         url,
	         param);
	
	PageVO pageVO = new PageVO(pageNo,numPage);
	
	List<Trip> trips = TripDAO.selectList(pageVO);	
	// 1페이지가 아니고 만약 글이 없으면 1페이지로 이동
	if(pageNo!= 1 && trips.isEmpty()){
		response.sendRedirect("/index.jsp?pageNo=1");
	}//if end
%>
<!DOCTYPE html>
<html lang="ko">
	<head>
		<meta charset="utf-8">
		<title>확진자 방문 장소 리스트</title>
		<!-- index.html, writeForm.html의 공통된 CSS를 default.css에 -->
		<%@ include file="/WEB-INF/template/link.jsp" %>
	 	<link rel="stylesheet" href="/css/index.css" /> 
	</head>
	<body>
		<%@ include file="/WEB-INF/template/header.jsp" %>
			<ul>
			<%if(trips.size() == 0){ %>
				<li class="no"><i class="fas fa-times-circle"></i> 확진자가 없습니다.</li>
				<%
				}else{
					
				for(Trip trip : trips){
				%>
				<li>
					<h3>
						<strong>
							<i class="fas fa-<%=trip.getMask()=='M'?"check":"times"%>"></i>
							<%=trip.getGu() %> 확진자
						</strong>
						<time><i class="fas fa-clock"></i>
						<%= trip.getRegdate() %></time>
						<a href="/delete.guest?no=<%=trip.getNo() %>" class="delete btn"><i class="far fa-trash-alt"></i> 삭제</a>
						<a href="/editForm.jsp?no=<%=trip.getNo() %>" class="update btn"><i class="far fa-edit"></i> 수정</a>
					</h3>
					<p><%= trip.getPlace() %></p>
					<p><%= trip.getCity() + trip.getGu() %></p>
					<p><%= trip.getStartMonth()%>월 <%=trip.getStartDay()%>일 ~ <%= trip.getEndMonth()%>월 <%=trip.getEndDay()%>일</p>
					<p id="time"></p>
				</li>
			<%} }%>
				</ul><!-- #// ul end -->
				<div class="btn_box">
					<a class="btn" href="/writeForm.jsp"><i class="fas fa-pencil-alt"></i> 글쓰기</a>
					<button class="btn"><i class="fas fa-pencil-alt"></i> 최근</button>
				</div>
				<%= paginate%>
		<%@ include file="/WEB-INF/template/footer.jsp" %>
</body>
</html>
		