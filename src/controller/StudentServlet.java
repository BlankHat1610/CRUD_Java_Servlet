package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Student;
import entities.Class;
import model.ClassModel;
import model.DBUtils;
import model.StudentModel;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rq = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        int a = 1;
        Integer b;
        b = null;
        a = b;
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action == null) {
			action = "LIST";
		}
		switch (action) {
			case "LIST":
				listStudents(request, response);
				break;
			case "EDIT":
				getSingleStudent(request,response);
				break;
			case "DELETE":
				deleteStudent(request,response);
				break;
			default:
				listStudents(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String masv      = request.getParameter("masv");
		String hoten     = request.getParameter("hoten");
		String gioitinh  = request.getParameter("gioitinh");
		String dienthoai = request.getParameter("dienthoai");
		String email     = request.getParameter("email");
		String tenlop    = request.getParameter("tenlop");
		Student student  = new Student(masv,hoten,gioitinh,dienthoai,email,tenlop);
		if(StudentModel.idStudentExists(masv)) {
			// update student
			if(StudentModel.updateStudent(student)) {
				request.setAttribute("message", "Cập nhật thành công!");
			}
		}else {
			// insert student
			if(StudentModel.save(student)) {
				request.setAttribute("message", "Thêm thành công!");
			}
		}
		listStudents(request, response);
	}
	
	public void listStudents(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// get data from db
			try {
				List<Student>listStudent = StudentModel.getAllStudent();
				List<Class> listIdClass  = ClassModel.getAllClass();
				request.setAttribute("listStudent", listStudent);
				request.setAttribute("listIdClass", listIdClass);
			} catch (ClassNotFoundException e) {
					e.printStackTrace();
			} catch (SQLException e) {
					e.printStackTrace();
			}
			
			rq = request.getRequestDispatcher("all-student.jsp");
			rq.forward(request, response);
	}
	
	public void getSingleStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Student singleStudent = StudentModel.getSingleStudent(id);
		request.setAttribute("singleStudent", singleStudent);
		
		rq = request.getRequestDispatcher("student_edit.jsp");
		rq.forward(request, response);
	}
	
	public void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String masv      = request.getParameter("id");
		if(StudentModel.deleteStudent(masv)) {
			request.setAttribute("message", "Xóa thành công!");
			listStudents(request, response);
		}
	}
	

}
