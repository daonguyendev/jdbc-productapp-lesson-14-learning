<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Category</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6 m-auto">
			
				<h5 class="text-center">Edit Category</h5>
				
				<form action='<c:url value="/category/edit" />' method="POST">
				
				  <div class="form-group">
				    <input type="hidden" name="id" value="${category.id}" class="form-control" />
				  </div>
				  
				  <div class="form-group">
				    <label>Name</label>
				    <input type="text" name="name" value="${category.name}" class="form-control" />
				  </div>
				  
				  <div class="form-group">
				    <label>Description</label>
				    <input type="text" name="desc" value="${category.description}" class="form-control" />
				  </div>
				  
				  <button class="btn btn-primary">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>