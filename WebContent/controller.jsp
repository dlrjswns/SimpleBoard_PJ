<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.ArrayList,model.BoardVO"%>
<jsp:useBean id="dao" class="model.BoardDAO"/>
<%
	// index C에게 main페이지 요청 
	// C main페이지는 ... 데이터가 있어야되는데...
	//		M 데이터 가져와.
	//		DB연동하여 데이터가져옴
	// C main페이지 완성됬으니까 가져가서보여줘 
	// V main페이지 사용자에게 보여줌(브라우저V)
	
	String action = request.getParameter("action");

	if(action.equals("main")){
		System.out.println("main");
		ArrayList<BoardVO> datas = dao.selectAll();
		//1. M에게서 데이터를 받아옴
		
		request.setAttribute("datas", datas);
		//2. V한테 데이터를 전달
		pageContext.forward("main.jsp");
	}
	else if(action.equals("insert")){
		//글 추가해줘.
	}
	else{
		out.println("<script>alert('action파라미터의 값이 올바르지않습니다!')</script>");
	}
%>