<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>

<sf:form modelAttribute="user" action="executeRegistry">
	<label for="name">Name:</label>
	<sf:input path="name"/>
	
	<label for="email">Email:</label>
	<sf:input path="email"/>
	
	<label for="login">User Name (login):</label>
	<sf:input path="login"/>
	
	<label for="password">Password:</label>
	<sf:password path="password"/>
	
	<input type="submit" value="Save"/>
	
</sf:form>