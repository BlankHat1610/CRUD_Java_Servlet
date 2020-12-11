<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="entities.Student" %>
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
	<% 
		request.getSession().setAttribute("listIdClass", request.getAttribute("listIdClass"));
	%> 
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
        <h3 class="title">Danh sách sinh viên</h3>
        <a href="student_add.jsp" class="insert action_btn"><i class="fas fa-plus-circle"></i> Thêm sinh viên</a>
        <div class="table-responsive">
            <table class="table table-striped table-inverse table-hover">
                <thead class="thead-inverse">
                    <tr>
                        <th>Mã sinh viên</th>
                        <th>Họ tên</th>
                        <th>Giới tính</th>
                        <th>Số điện thoại</th>
                        <th>Email</th>
                        <th>Lớp</th>
                        <th>Action</th>
                    </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listStudent}" var="student"> 
                          <tr>
                            <td>${student.maSV}</td>
                            <td>${student.hoTen}</td>
                            <td>${student.gioiTinh}</td>
                            <td>${student.dienThoai}</td>
                            <td>${student.email}</td>
                            <td>${student.sv_Malop}</td>
                            <td>
                            	<a href="all-student?action=EDIT&id=${student.maSV}" class="edit action_btn"><i class="fas fa-edit"></i> Sửa</a>
                            	<a href="all-student?action=DELETE&id=${student.maSV}" class="delete action_btn" onclick="return confirm('Bạn có chắc là muốn xóa sinh viên này không?')">
                            		<i class="fas fa-trash-alt"></i> Xóa
                            	</a>
                              </td>
                          </tr>
                        </c:forEach>
                    </tbody>
            </table>
        </div>
    </div>
</body>
</html>