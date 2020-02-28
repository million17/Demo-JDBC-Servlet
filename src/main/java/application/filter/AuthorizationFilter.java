package application.filter;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import application.constant.SystemConstant;
import application.model.User;
import application.utils.SessionUtil;

public class AuthorizationFilter implements Filter {

	private ServletContext context;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String url = req.getRequestURI();
		if (url.startsWith(req.getContextPath() + "/admin")) {
			User model = new User();
			model = (User) SessionUtil.getInstance().getValue(req, "USERMODEL");
			if (model != null) {
				if (model.getRole().getCode().equals(SystemConstant.ADMIN)) {
					filterChain.doFilter(request, response);
				} else if (model.getRole().getCode().equals(SystemConstant.USER)) {
					resp.sendRedirect(req.getContextPath() + "/login?action=login&message=not_permission&alert=danger");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/login?action=login&message=not_login&alert=danger");
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {

	}

}
