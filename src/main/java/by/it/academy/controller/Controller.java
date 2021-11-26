package by.it.academy.controller;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

public class Controller extends HttpServlet {

	@Serial
	private static final long serialVersionUID = 1L;
	private static final String COMMAND_REQUEST_PARAM = "command";
	private final CommandDispatcher provider = new CommandDispatcher();

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String commandName = request.getParameter(COMMAND_REQUEST_PARAM);
		Command command = provider.getCommand(commandName);
		command.execute(request, response);
	}
}
