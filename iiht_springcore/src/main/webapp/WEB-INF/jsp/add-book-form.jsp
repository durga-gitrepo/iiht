<%@ page language="java" contentType="text/html;"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</head>
<body>
 <div class="container">
   <div class="panel panel-info">
    <div class="panel-heading">
     <div class="panel-title">Add Book</div>
    </div>
    <div class="panel-body">
     <form:form action="create" cssClass="form-horizontal" method="post" modelAttribute="book">
      <div class="form-group">
       <label for="subjectId" class="col-md-3 control-label">Subject Id</label>
       <div class="col-md-9"><form:input path="subjectId" cssClass="form-control" /></div>
      </div>
      <div class="form-group">
       <label for="title" class="col-md-3 control-label">Title</label>
       <div class="col-md-9"><form:input path="title" cssClass="form-control" /></div>
      </div>
      <div class="form-group">
       <label for="volume" class="col-md-3 control-label">Volume</label>
       <div class="col-md-9"><form:input path="volume" cssClass="form-control" /></div>
      </div>
      <div class="form-group">
       <label for="price" class="col-md-3 control-label">Price</label>
       <div class="col-md-9"><form:input path="price" cssClass="form-control" /></div>
      </div>
      <div class="form-group">
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
        <input type="button" value="Cancel" onclick="window.location.href='../book/list'; return false;" class="btn btn-primary" />
       </div>
      </div>
     </form:form>
   </div>
  </div>
 </div>
</body>
