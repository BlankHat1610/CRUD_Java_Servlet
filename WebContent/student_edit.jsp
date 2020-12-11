<%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
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
        	<h3 class="title">Sửa sinh viên</h3>
			<form class="form-horizontal m-4" method="POST">
				<div class="form-group">
					<label for="default" class="col-sm-2 control-label">Mã sinh viên</label>
					<div class="col-sm-9">
						<input readonly type="text" name="masv" class="form-control" id="" value="${singleStudent.maSV}" required="required" autocomplete="off">
					</div>
				</div>

				<div class="form-group">
					<label for="default" class="col-sm-2 control-label">Họ tên</label>
					<div class="col-sm-9">
						<input type="text" name="hoten" class="form-control" id="" value="${singleStudent.hoTen}" required="required" autocomplete="off">
					</div>
				</div>
	
				<div class="form-group">
					<label for="default" class="col-sm-2 control-label">Giới tính</label>
					<div class="col-sm-9">
						<c:choose>
   							<c:when test="${(singleStudent.gioiTinh).equalsIgnoreCase('Nam')}">
                              <input id="nam" type=radio name=gioitinh value=Nam required=required checked="checked"> <label for="nam">Nam</label>
                              <input id="nu" type=radio name=gioitinh value=Nữ required=required>  <label for="nu">Nữ</label>
   							</c:when>
   							<c:otherwise >
   								   <input id="nam" type=radio name=gioitinh value=Nam required=required> <label for="nam">Nam</label>
                                   <input id="nu" type=radio name=gioitinh value=Nữ required=required checked="checked">  <label for="nu">Nữ</label>
   							</c:otherwise>
						</c:choose>
					</div>
				</div>
	
				<div class="form-group">
					<label for="default" class="col-sm-2 control-label">Số điện thoại</label>
					<div class="col-sm-9">
						<input type="text" name="dienthoai" class="form-control" id="" value="${singleStudent.dienThoai}" required="required" autocomplete="off">
					</div>
				</div>
	
				<div class="form-group">
					<label for="default" class="col-sm-2 control-label">Email</label>
					<div class="col-sm-9">
						<input type="email" name="email" class="form-control" id="" value="${singleStudent.email}" required="required" autocomplete="off">
					</div>
				</div>
	
				<div class="form-group">
					<label for="default" class="col-sm-2 control-label">Tên lớp: </label>
					<div class="col-sm-9">
						<select name="tenlop">
						  <c:forEach items="${listIdClass}" var="idclass">
						    <option value="${idclass.malop}">
						        ${idclass.malop}
						    </option>
						  </c:forEach>
						</select>
					</div>
				</div>
	
				<div class="col-sm-10 float-right">
					<button type="submit" name="submit-save" class="btn btn-primary">Save</button>
				</div>
			</form>
    </div>
</body>
</html>