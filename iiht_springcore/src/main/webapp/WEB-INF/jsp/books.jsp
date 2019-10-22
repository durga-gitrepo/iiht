<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>Book DETAILS</h2>
   <hr/>

   <input type="button" value="Add Book" onclick="window.location.href='add-book-form'; return false;" class="btn btn-primary" />
   <br/><br/>
   <div class="panel panel-info">
    	<div class="panel-heading">
     	<div class="panel-title">Book List</div>
    </div>
    
    <div class="panel-body">
    <table class="table table-striped table-bordered">
      <tr>
       <th>Book Id</th>
       <th>Book Title</th>
       <th>Price</th>
       <th>Volume</th>
       <th>Publish Date</th>
       <th>Subject Title</th>
       <th>Action</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempBook" items="${books}">

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteBook" value="/book/delete">
        <c:param name="bookId" value="${tempBook.bookId}" />
       </c:url>

       <tr>
        <td>${tempBook.subjectId}</td>
        <td>${tempBook.title}</td>
        <td>${tempBook.price}</td>
        <td>${tempBook.volume}</td>
        <td>${tempBook.publishDate}</td>
        <td>${tempBook.subject.subjectTitle}</td>
        <td>
         <a href="${deleteBook}" onclick="if (!(confirm('Are you sure you want to delete this subject?'))) return false">Delete</a>
        </td>
       </tr>
      </c:forEach>
     </table>

    </div>
    </div>
    
     <input type="button" value="Go Back" onclick="window.location.href='../'; return false;" class="btn btn-primary" />
    </div>
</body>
</html>
