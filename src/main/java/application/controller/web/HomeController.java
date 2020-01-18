package application.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.controller.service.ICategoryService;
import application.controller.service.INewService;

@WebServlet(urlPatterns = { "/home" })
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private INewService newService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long categoryId = 1L;
		req.setAttribute("news", newService.findByCategoryId(categoryId));
		req.setAttribute("categories", categoryService.findAll());
		RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/home.jsp");

		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

}
