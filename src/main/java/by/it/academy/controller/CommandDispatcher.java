package by.it.academy.controller;

import by.it.academy.controller.impl.*;

import java.util.HashMap;
import java.util.Map;


public class CommandDispatcher {

    private final Map<CommandName, Command> commands = new HashMap<>();

    public CommandDispatcher() {
        commands.put(CommandName.GO_TO_AUTHORIZATION_PAGE, new AuthorizationPage());
        commands.put(CommandName.GO_TO_REGISTRATION_PAGE, new RegistrationPage());
        commands.put(CommandName.GO_TO_MAIN_PAGE, new MainPage());
        commands.put(CommandName.GO_TO_NEWS_PAGE, new NewsPage());
        commands.put(CommandName.UNKNOWN_COMMAND, new ErrorPage());
    }

    public Command getCommand(String name) {
        if (name == null) {
            name = CommandName.UNKNOWN_COMMAND.toString();
        }

        CommandName commandName;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
        } catch (IllegalArgumentException e) {
            commandName = CommandName.UNKNOWN_COMMAND;
        }

        return commands.get(commandName);
    }

}
