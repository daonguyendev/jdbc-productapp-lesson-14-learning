<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Category List</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
			<h4 class="my-4">Category List</h4>
			<a href='<c:url value="/category/add" />' class="btn btn-primary mb-3">Add New Category</a>
			<table class="table table-bordered">
			    <thead>
			      <tr>
			        <th>Id</th>
			        <th>Name</th>
			        <th>Description</th>
			        <th>#</th>
			      </tr>
			    </thead>
			    <tbody>
			      <c:forEach items="${categories}" var="item">
			      	<tr>
				        <td>${item.id}</td>
				        <td>${item.name}</td>
				        <td>${item.description}</td>
				        <td>
				        	<a href='<c:url value="/category/edit?id=${item.id}" />' class="btn btn-sm btn-info">Edit</a>
				        	<a href='<c:url value="/category/remove?id=${item.id}" />' class="btn btn-sm btn-danger">Remove</a>
				        </td>
				      </tr>
			      </c:forEach>
			      
			    </tbody>
			  </table>
			</div>
		</div>
	</div>
</body>
</html>