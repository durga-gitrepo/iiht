<%@ page language="java" contentType="text/html"%>
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
     <div class="panel-title">Add Subject</div>
    </div>
    <div class="panel-body">
     <form:form action="create" cssClass="form-horizontal" method="post" modelAttribute="subject">
      <div class="form-group">
       <label for="subjectId" class="col-md-3 control-label">Subject Id</label>
       <div class="col-md-9"><form:input path="subjectId" cssClass="form-control" /></div>
      </div>
      <div class="form-group">
       <label for="subjectTitle" class="col-md-3 control-label">Subject Title</label>
       <div class="col-md-9"><form:input path="subjectTitle" cssClass="form-control" /></div>
      </div>
      <div class="form-group">
       <label for="durationHrs" class="col-md-3 control-label">Duration</label>
       <div class="col-md-9"><form:input path="durationHrs" cssClass="form-control" /></div>
      </div>
      <div class="form-group">
       <div class="col-md-offset-3 col-md-9">
        <form:button cssClass="btn btn-primary">Submit</form:button>
        <input type="button" value="Cancel" onclick="window.location.href='../subject/list'; return false;" class="btn btn-primary" />
       </div>
      </div>
     </form:form>
   </div>
  </div>
 </div>
</body>
