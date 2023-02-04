<%
	request.getSession().setAttribute("matricula", null);
	session.invalidate();
	response.sendRedirect("login.jsp");
%>