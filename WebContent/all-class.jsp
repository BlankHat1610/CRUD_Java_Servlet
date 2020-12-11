<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entities.Class" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8"/>
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
    	<p>${message}</p>
        <h3 class="title">Danh sách các lớp</h3>
        <a href="class_add.jsp" class="insert action_btn"><i class="fas fa-plus-circle"></i> Thêm lớp</a>
        <div class="table-responsive">
            <table class="table table-striped table-inverse table-hover">
                <thead class="thead-inverse">
                    <tr>
                        <th>Mã lớp</th>
                        <th>Giảng viên chủ nhiệm</th>
                        <th>Ngành</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listClass}" var="classes"> 
                          <tr>
                            <td>${classes.malop}</td>
                            <td>${classes.gvcn}</td>
                            <td>${classes.nganh}</td>
                            <td>
                            	<a href="all-class?action=EDIT&id=${classes.malop}" class="edit action_btn"><i class="fas fa-edit"></i> Sửa</a>
                            	<a href="#" class="delete action_btn"><i class="fas fa-trash-alt"></i> Xóa</a>
                              </td>
                          </tr>
                        </c:forEach>
                    </tbody>
            </table>
        </div>
    </div>
</body>
</html>