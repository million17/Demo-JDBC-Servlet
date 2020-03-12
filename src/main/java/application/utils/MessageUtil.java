package application.utils;

import javax.servlet.http.HttpServletRequest;

import application.constant.MessageConstant;

public class MessageUtil {
	public static void showMessage(HttpServletRequest req) {
		if (req.getParameter("message") != null) {
			String messageResponse = "";
			String alert = "";
			String message = req.getParameter("message");
			if (message.equals("insert_success")) {
				messageResponse = "Insert success";
				alert = MessageConstant.SUCCESS;
			} else if (message.equals("update_success")) {
				messageResponse = "Update success";
				alert = MessageConstant.SUCCESS;
			} else if (message.equals("delete_success")) {
				messageResponse = "Delete success";
				alert = MessageConstant.SUCCESS;
			} else if (message.equals("error_system")) {
				messageResponse = "Error system";
				alert = MessageConstant.DANGER;
			}
			req.setAttribute("message", messageResponse);
			req.setAttribute("alert", alert);
		}
	}
}
