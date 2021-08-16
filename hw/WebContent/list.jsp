<%@page import="kr.or.kosta.dto.empDTO"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.kosta.dao.empDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
//ffffggggg
	empDAO dao=empDAO.getInstance();
	List<empDTO> list=dao.getList();
%>
<table>
	<thead>
		<tr><th>사원번호</th><th>이름</th><th>입사일</th>
		<th>급여</th><th>부서코드</th></tr>
	</thead>
	<tbody>
		<%
			for(empDTO dto:list)
			{
		%>
			<tr><td><%=dto.getEmployee_id() %></td>
			<td><%=dto.getFirst_name() %></td>
			<td><%=dto.getHire_date() %></td>
			<td><%=dto.getSalary() %></td>
			<td><%=dto.getDepartment_id() %></td>
		<%
			}
		%>
		
	</tbody>
</table>
</body>
</html>