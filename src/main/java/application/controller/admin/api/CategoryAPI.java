package application.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import application.model.Category;
import application.model.User;
import application.service.ICategoryService;
import application.utils.HttpUtil;
import application.utils.SessionUtil;

@WebServlet(urlPatterns = { "/api-admin-category" })
public class CategoryAPI extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Category category = HttpUtil.of(req.getReader()).toModel(Category.class);
		categoryService.save(category);
		objectMapper.writeValue(resp.getOutputStream(), category);
		System.out.println("Success");
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		Category category = HttpUtil.of(req.getReader()).toModel(Category.class);
		categoryService.delete(category.getId());
		objectMapper.writeValue(resp.getOutputStream(), "Success");
	}
}
