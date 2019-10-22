<%@ page language="java" contentType="text/html"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head><%@ page isELIgnored="false" %>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>SUBJECT DETAILS</h2>
   <hr/>

   <input type="button" value="Add Subject" onclick="window.location.href='add-subject-form'; return false;" class="btn btn-primary" />
   <br/><br/>
   <div class="panel panel-info">
    	<div class="panel-heading">
     	<div class="panel-title">Subject List</div>
    </div>
    
    <div class="panel-body">
    <table class="table table-striped table-bordered">
      <tr>
       <th>Subject Id</th>
       <th>Subject Title</th>
       <th>Duration (in Hrs)</th>
       <th>Action</th>
      </tr>

      <!-- loop over and print our customers -->
      <c:forEach var="tempSubject" items="${subjects}">

       <!-- construct an "delete" link with customer id -->
       <c:url var="deleteSubject" value="/subject/delete">
        <c:param name="subjectId" value="${tempSubject.subjectId}" />
       </c:url>

       <tr>
       <td>${tempSubject.subjectId}</td>
        <td>${tempSubject.subjectTitle}</td>
        <td>${tempSubject.durationHrs}</td>
        <td>
         <a href="${deleteSubject}" onclick="if (!(confirm('Are you sure you want to delete this subject?'))) return false">Delete</a>
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
