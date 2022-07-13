package by.epam.webex.logic.impl;

import java.util.List;

import by.epam.webex.controller.JspPageName;
import by.epam.webex.controller.RequestParameterName;
import by.epam.webex.dao.XMLDAOFactory;
import by.epam.webex.dao.XMLDao;
import by.epam.webex.dao.XMLDaoException;
import by.epam.webex.logic.CommandException;
import by.epam.webex.logic.ICommand;
import jakarta.servlet.http.HttpServletRequest;

public class DoAnythingCommand implements ICommand{
	
	@Override
	public String execute(HttpServletRequest request) throws CommandException{
		String page =null;
		XMLDao dao = null;
		
		try {
			dao = XMLDAOFactory.getInstance().getDAO(XMLDAOFactory.DAOType.SAX);
			List<Object> info = dao.parse(request.getParameter(RequestParameterName.FILE_INFO));
			request.setAttribute(RequestParameterName.SIMPLE_INFO, info); 
			page = JspPageName.USER_PAGE;
		}catch (XMLDaoException e) {
			throw new CommandException("cann`t get DAO",e);
		}
		return page;
	}

}
