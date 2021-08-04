package by.it.academy.controller;

import by.it.academy.controller.impl.*;
import by.it.academy.local.ChangeLocal;

import java.util.HashMap;
import java.util.Map;


public class CommandDispatcher {

	private final Map<CommandName, Command> commands = new HashMap<>();
	
	public CommandDispatcher() {
		commands.put(CommandName.AUTHORIZATION_PAGE, new AuthorizationPage());
		commands.put(CommandName.REGISTRATION_PAGE, new RegistrationPage());
		commands.put(CommandName.MAIN_PAGE, new MainPage());
		commands.put(CommandName.NEWS_PAGE, new NewsPage());
		commands.put(CommandName.UNKNOWN_COMMAND, new ErrorPage());
		commands.put(CommandName.CHANGE_LACAL,new ChangeLocal());
	}
	
	public Command getCommand(String name) {
		if (name == null) {
			name = CommandName.UNKNOWN_COMMAND.toString();
		}
		
		CommandName commandName;
		try {
		    commandName = CommandName.valueOf(name.toUpperCase());
		}catch(IllegalArgumentException e) {
			commandName = CommandName.UNKNOWN_COMMAND;	
		}

		return commands.get(commandName);
	}
	
}
