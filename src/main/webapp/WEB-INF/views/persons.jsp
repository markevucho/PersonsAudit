<!DOCTYPE html> 
<%@ page  contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All persons</title>
</head>
<body>
<div align="center">
<h1>Persons list</h1>

<table cellpadding="10">
 <thead bgcolor="green">
  <tr>
   <th><label>First Name</label></th>
    <th><label>Surname</label></th>
   <th><label>Birthday</label></th>
   <th><label>Money</label></th>
   <th colspan="3"><label>Actions</label></th>
  </tr>
 </thead>
 <tbody>
 <c:forEach items="${persons}" var="person">
 	<c:url var="editUrl" value="persons/${person.id}" />
	<c:url var="deleteUrl" value="persons/${person.id}" />
  <tr>
   <td><c:out value="${person.name}"/></td>
   <td><c:out value="${person.surname}" /></td>
   <td><c:out value="${person.birthday}" /></td>
   <td><c:out value="${person.money}" /></td>
   <td><sf:form action="${editUrl}" method="get"><input type="submit" value="Edit" /></sf:form></td>
   <td><sf:form action="${deleteUrl}" method="delete"><input type="submit" value="Delete" /></sf:form></td>
  </tr>
 </c:forEach>
 </tbody>
</table>

<c:if test="${empty persons}">
 There are currently no persons in the list.
</c:if>
<br>
<br>
<sf:form action="persons/add" method="get">
 <input type="submit" value="Add new person"/>
</sf:form>
</div>

</body>
</html>