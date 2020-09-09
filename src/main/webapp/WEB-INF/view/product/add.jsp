<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add new product</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-6 m-auto">
				<h5 class="text-center">Add new product</h5>
				<form action='<c:url value="/product/add" />' method="POST">
				  	<div class="form-group">
					    <label>Id:</label>
					    <input type="text" name="id" class="form-control">
			    	</div>

			    	<div class="form-group">
                        <label>Category</label>
                        <select name="cateId" class="form-control" >
                            <c:forEach items="${categories}" var="item">
                                <option value="${item.id}">${item.name}</option>
                            </c:forEach>
                        </select>
                    </div>
			    	
			    	<div class="form-group">
					    <label>Name:</label>
					    <input type="text" name="name" class="form-control">
			    	</div>
			    	
			    	<div class="form-group">
					    <label>Amount:</label>
					    <input type="text" name="amount" class="form-control">
			    	</div>
			    	
			    	<div class="form-group">
					    <label>Price:</label>
					    <input type="text" name="price" class="form-control">
			    	</div>
			    	
				  	<button type="submit" class="btn btn-primary">Add</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>