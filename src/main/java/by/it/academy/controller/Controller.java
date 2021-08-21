package by.it.academy.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private static final String COMMAND_REQUEST_PARAM = "command";

	private final CommandDispatcher dispatcher = new CommandDispatcher();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String commandName = req.getParameter(COMMAND_REQUEST_PARAM);
		Command command = dispatcher.getCommand(commandName);
		command.execute(req, resp);
	}


}
