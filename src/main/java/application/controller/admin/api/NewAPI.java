package application.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import application.controller.utils.HttpUtil;
import application.model.New;
import application.service.INewService;

@WebServlet(urlPatterns = { "/api-admin-new" })
public class NewAPI extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Inject
	private INewService newSerive;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		New newModel = HttpUtil.of(req.getReader()).toModel(New.class);
		newModel = newSerive.save(newModel);
		mapper.writeValue(resp.getOutputStream(), newModel);
		// tra nguoc la client
		System.out.println(newModel);
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		New updateNew = HttpUtil.of(req.getReader()).toModel(New.class);
		updateNew = newSerive.update(updateNew);
		mapper.writeValue(resp.getOutputStream(), updateNew);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");
		New newModel = HttpUtil.of(req.getReader()).toModel(New.class);
		newSerive.delete(newModel.getIds());
		mapper.writeValue(resp.getOutputStream(), (""));
	}

}
