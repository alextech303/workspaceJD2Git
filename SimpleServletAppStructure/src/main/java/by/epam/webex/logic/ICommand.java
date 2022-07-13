package by.epam.webex.logic;

import jakarta.servlet.http.HttpServletRequest;

public interface ICommand {
	public String execute(HttpServletRequest request) throws CommandException;

}
