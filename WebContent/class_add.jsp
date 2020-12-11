<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link rel="stylesheet" href="vendors/css/bootstrap.min.css">
    <link rel="stylesheet" href="vendors/fontawesome/css/all.min.css">
    <link rel="stylesheet" href="resources/css/index.css">
</head>
<body>
	<header>
        <div class="container_fluid">
            <div class="row mr-0">
                <div class="col-lg-3 pl-5">JSP CRUD</div>
            </div>
        </div>
    </header>
    <div class="sidebar">
        <ul>
            <li><a class="home" href="index.jsp"><i class="fas fa-home"></i>Trang chủ</a></li>
            <li><a class="student" href="all-student"><i class="fas fa-users"></i>Sinh viên</a></li>
            <li><a class="class" href="all-class"><i class="fas fa-chalkboard"></i>Lớp</a></li>
        </ul>
    </div>
    <div class="main_content">
        <h3 class="title">Thêm lớp</h3>
        <form action="all-class" class="form-horizontal m-4" method="POST">
			<div class="form-group">
				<label for="default" class="col-sm-3 control-label">Mã lớp</label>
				<div class="col-sm-9">
					<input type="text" name="malop" class="form-control" id="" value="" required="required" autocomplete="off">
				</div>
			</div>
			
			<div class="form-group">
				<label for="default" class="col-sm-3 control-label">Giảng viên chủ nhiệm</label>
				<div class="col-sm-9">
					<input type="text" name="gvcn" class="form-control" id="" value="" required="required" autocomplete="off">
				</div>
			</div>

			<div class="form-group">
				<label for="default" class="col-sm-3 control-label">Ngành</label>
				<div class="col-sm-9">
					<input type="text" name="nganh" class="form-control" id="" value="" required="required" autocomplete="off">
				</div>
			</div>

			<div class="col-sm-10">
				<button type="submit" name="submit-add" class="btn btn-primary">Thêm</button>
			</div>
		</form>
    </div>
</body>
</html>