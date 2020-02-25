package application.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.model.User;
import application.service.ICategoryService;
import application.service.INewService;
import application.service.IUserService;
import application.utils.FormUtil;
import application.utils.SessionUtil;

@WebServlet(urlPatterns = { "/home", "/login", "/logout" })
public class HomeController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;

	@Inject
	private INewService newService;

	@Inject
	private IUserService userService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/login/login.jsp");
			dispatcher.forward(req, resp);
		} else if (action != null && action.equals("logout")) {
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			resp.sendRedirect(req.getContextPath() + "/home");
		} else {
			req.setAttribute("categories", categoryService.findAll());
			RequestDispatcher dispatcher = req.getRequestDispatcher("/views/web/home.jsp");
			dispatcher.forward(req, resp);
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null && action.equals("login")) {
			User user = FormUtil.toModel(User.class, req);
			user = userService.findByUserNameAndPasswordAndStatus(user.getUserName(), user.getPassword(), 1);
			if (user != null) {
				SessionUtil.getInstance().putValue(req, "USERMODEL", user);
				if (user.getRole().getCode().equals("USER")) {
					resp.sendRedirect(req.getContextPath() + "/home");
				} else if (user.getRole().getCode().equals("ADMIN")) {
					resp.sendRedirect(req.getContextPath() + "/admin");
				}

			} else {
				resp.sendRedirect(req.getContextPath() + "/login?action=login");
			}
		}
	}

}
