package by.htp.ex.controller.impl;

import java.io.IOException;

import by.htp.ex.controller.Command;
import by.htp.ex.service.ServiceException;
import by.htp.ex.service.ServiceProvider;
import by.htp.ex.service.UserService;
import by.htp.ex.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DoLogination implements Command {

	private final UserService service = ServiceProvider.getInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login;
		String password;

		login = request.getParameter("login");
		password = request.getParameter("password");

		// small validation

		try {

			boolean result = service.logination(login, password);

			if (result) {
				// go to main.jsp
			} else {
				// go to index-logination with message
			}

		} catch (ServiceException e) {
			// logging e
			// go-to error page

		}

		// response.getWriter().print("do logination");

	}

}
