<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf" %>
<%@ page contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Edit person</title>
<style>
.error {
	color: #ff0000;
}
</style>
</head>
<body>
 <div align="center">
<h1>Fourth page to edit person</h1>

<sf:form modelAttribute="person" method="put" action="${person.id}">
 <table cellpadding="8">
<tr>
	<th><sf:label path="name">Name</sf:label></th>
	<td><sf:input path="name" value="${person.name}"/></td>
	<td><sf:errors path="name" cssClass="error"/></td>
</tr> 
<tr>
	<th><sf:label path="surname">Surname</sf:label></th>
	<td><sf:input path="surname" value="${person.surname}"/></td>
	<td><sf:errors path="surname" cssClass="error"/></td>
</tr>
<tr>
	<th><sf:label path="birthday">Birthday</sf:label></th>
	<td><sf:input path="birthday" value="${person.birthday}"/></td>
	<td><sf:errors path="birthday" cssClass="error"/></td>
</tr>
<tr>
	<th><sf:label path="money">Money</sf:label></th>
	<td><sf:input path="money" value="${person.money}" pattern="\-?\d+(\.\d{0,})?"/></td>
	<td><sf:errors path="money" cssClass="error"/></td>
</tr>

</table>
  <br>
 <input type="submit" value="Save" />
</sf:form>
 </div>
</body>
</html>