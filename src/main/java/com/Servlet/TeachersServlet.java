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

import org.hibernate.Session;

import com.Dao.CourseDao;
import com.Entity.Course;
import com.Entity.User;

/**
 * Servlet implementation class TeachersServlet
 */
public class TeachersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeachersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CourseDao courseDao=new CourseDao();
		HttpSession httpSession=request.getSession();
		User user=(User)httpSession.getAttribute("loggedinuser");
		System.out.println(user.getId());
		String name="";
		try {
			
			List<Course> courses=courseDao.getCourseByTeacher(user.getId());
			for (Course course : courses) {
				name=course.getTeacher().getName();
				break;
			}
			
			request.setAttribute("name", name);
			request.setAttribute("courses", courses);
			RequestDispatcher view =request.getRequestDispatcher("/pages/TeacherPage.jsp");
			view.forward(request, response);
		}
		catch (Exception e) {
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
