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
import application.paging.PageRequest;
import application.paging.Pageble;
import application.service.ICategoryService;
import application.service.INewService;
import application.sort.Sorter;
import application.utils.FormUtil;
import application.utils.MessageUtil;

@WebServlet(urlPatterns = { "/admin-new" })
public class NewController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Inject
	private INewService newService;

	@Inject
	private ICategoryService categoryService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		New vm = FormUtil.toModel(New.class, req);
		String view = "";
		if (vm.getType().equals(SystemConstant.LIST)) {
			Pageble pageble = new PageRequest(vm.getPage(), vm.getMaxPageItem(),
					new Sorter(vm.getSortName(), vm.getSortBy()));
			vm.setListResult(newService.findAll(pageble));
			vm.setTotalItem(newService.getTotalItem());
			vm.setTotalPage((int) Math.ceil((double) vm.getTotalItem() / vm.getMaxPageItem()));
			view = "/views/admin/news/list.jsp";

		} else if (vm.getType().equals(SystemConstant.EDIT)) {
			if (vm.getId() != null) {
				vm = newService.findOne(vm.getId());
			}
			req.setAttribute("categories", categoryService.findAll());
			view = "/views/admin/news/edit.jsp";

		}
		MessageUtil.showMessage(req);
		req.setAttribute(SystemConstant.VM, vm);
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
}
