<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product List</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-12">
				<h4 class="my-4">Product List</h4>
				<a href='<c:url value="/product/add" />' class="btn btn-primary mb-3">Add New Product</a>
			    <table class="table table-bordered">
				    <thead>
				      <tr>
				        <th>Id</th>
				        <th>Name</th>
				        <th>Amount</th>
				        <th>Price</th>
				        <th>Category</th>
				        <th>#</th>
				      </tr>
				    </thead>
				    <tbody>
					  <c:forEach items="${products}" var="product">
					      <tr>
					        <td>${product.id}</td>
					        <td>${product.name}</td>
							<td>
                                <c:choose>
                                    <c:when test="${product.amount > 0}">
                                        ${product.amount}
                                    </c:when>
                                    <c:otherwise>Out Of Stock</c:otherwise>
                                </c:choose>
                            </td>
                            <td>${product.price}</td>
                            <td>${product.cateId}</td>
					        <td>
					        	<a href='<c:url value="/product/edit?id=${product.id}" />' class="btn btn-sm btn-info">Edit</a>
					        	<a href='<c:url value="/product/remove?id=${product.id}" />' class="btn btn-sm btn-danger">Remove</a>
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