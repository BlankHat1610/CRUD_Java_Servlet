package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Class;
import entities.Student;
import model.ClassModel;
import model.StudentModel;

/**
 * Servlet implementation class ClassServlet
 */
public class ClassServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	RequestDispatcher rq = null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ClassServlet() {
        super();
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
				listClasses(request, response);
				break;
			case "EDIT":
				getSingleClass(request,response);
				break;
			case "DELETE":
				listClasses(request,response);
				break;
			default:
				listClasses(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String malop = request.getParameter("malop");
		String gvcn = request.getParameter("gvcn");
		String nganh = request.getParameter("nganh");
		Class classes = new Class(malop, gvcn, nganh);
		if (ClassModel.idClassExists(malop)) {
			if(ClassModel.updateClass(classes)) {
				request.setAttribute("message", "Sửa thành công!");
				listClasses(request, response);
			}
		}else {
			if(ClassModel.save(classes)) {
				request.setAttribute("message", "Thêm thành công!");
				listClasses(request, response);
			}
		}
	}
	
	public void listClasses(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get data from db
		try {
			List<Class> listClass = ClassModel.getAllClass();
			request.setAttribute("listClass", listClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
									
		RequestDispatcher rq = request.getRequestDispatcher("all-class.jsp");
		rq.forward(request, response);
	}
	
	public void getSingleClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Class singleClass = ClassModel.getSingleClass(id);
		request.setAttribute("singleClass", singleClass);
		
		rq = request.getRequestDispatcher("class_edit.jsp");
		rq.forward(request, response);
	}
}
