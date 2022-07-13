package by.epam.webex.controller;

import java.io.IOException;

import by.epam.webex.logic.CommandException;
import by.epam.webex.logic.CommandHelper;
import by.epam.webex.logic.ICommand;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Controller() {
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String commandName = request.getParameter(RequestParameterName.COMMAND_NAME);
		ICommand command = CommandHelper.getInstance().getCommand(commandName);
		
		String page = null;
		
		try {
			
			page=command.execute(request);
		}catch(CommandException e) {
			page= JspPageName.ERROR_PAGE;
			
		}catch (Exception e) {
			page = JspPageName.ERROR_PAGE;
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		if(dispatcher!=null) {
			dispatcher.forward(request,response	);
			
		}else {
			errorMessageDireclyFromresponse(response);
		}
	}
	private void errorMessageDireclyFromresponse(HttpServletResponse response) throws IOException{
		response.setContentType("text/html");
		response.getWriter().println("E R R O R");
	}

}
