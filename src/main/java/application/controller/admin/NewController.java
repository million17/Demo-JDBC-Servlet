package application.controller.admin;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.constant.SystemConstant;
import application.model.New;
import application.service.INewService;
import application.utils.FormUtil;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private INewService newService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		New vm = FormUtil.toModel(New.class, req);
		Integer offset = (vm.getPage() - 1) * vm.getMaxPageItem();
		vm.setListResult(newService.findAll(offset, vm.getMaxPageItem()));
		vm.setTotalItem(newService.getTotalItem());
		vm.setTotalPage((int) Math.ceil((double) vm.getTotalItem() / vm.getMaxPageItem()));
		req.setAttribute(SystemConstant.VM, vm);
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/news/list.jsp");
		rd.forward(req, resp);

	}
}
