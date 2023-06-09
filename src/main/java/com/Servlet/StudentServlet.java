package com.Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.Dao.CourseDao;
import com.Dao.RegistrationDao;
import com.Dao.StudentDao;
import com.Entity.Course;
import com.Entity.Student;
import com.Entity.User;

/**
 * Servlet implementation class StudentServlet
 */
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session=request.getSession();
		User user=(User)session.getAttribute("loggedinuser");
		String studentId=user.getId();
		String name="";
		RegistrationDao registrationDao=new RegistrationDao();
		StudentDao studentDao=new StudentDao();
		CourseDao courseDao=new CourseDao();
		try {
			
			List<Course>courses=registrationDao.getRegisteredCourseByStudentId(studentId);
			
			Student student  =studentDao.getStudentById(studentId);
			name=student.getName();
			String deptName=student.getDepartment().getName();
			
			List<Course>courses2=courseDao.getUnenrolledCoursesByStudent(studentId, deptName);
			request.setAttribute("courses2", courses2);
			request.setAttribute("name",name);
			request.setAttribute("courses", courses);
			RequestDispatcher view=request.getRequestDispatcher("/pages/StudentPage.jsp");
			view.forward(request, response);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
