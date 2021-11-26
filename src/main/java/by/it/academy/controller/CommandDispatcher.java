package by.it.academy.controller;

import by.it.academy.controller.impl.comments_command.DeleteComment;
import by.it.academy.controller.impl.comments_command.PublishComment;
import by.it.academy.controller.impl.main_command.*;
import by.it.academy.controller.impl.news_command.AddNews;
import by.it.academy.controller.impl.main_command.GoToAllNewsPage;
import by.it.academy.controller.impl.main_command.GoToReadSelectedNews;
import by.it.academy.controller.impl.news_command.DeleteSelectedNews;
import by.it.academy.controller.impl.news_command.MakePublishedSelectedNews;
import by.it.academy.controller.impl.news_command.UpdateSelectedNews;
import by.it.academy.controller.impl.user_command.*;

import java.util.HashMap;
import java.util.Map;


public class CommandDispatcher {

    private final Map<CommandName, Command> commands = new HashMap<>();

    public CommandDispatcher() {
        commands.put(CommandName.UNKNOWN_COMMAND, new ErrorPage());
        commands.put(CommandName.GO_TO_AUTHORIZATION_PAGE, new GoToAuthorizationPage());
        commands.put(CommandName.GO_TO_REGISTRATION_PAGE, new GoToRegistrationPage());
        commands.put(CommandName.GO_TO_MAIN_PAGE, new GoToMainPage());
        commands.put(CommandName.GO_TO_NEWS_PAGE, new GoToAllNewsPage());
        commands.put(CommandName.GO_TO_NEWS_FROM_ID, new GoToReadSelectedNews());
        commands.put(CommandName.GO_TO_OFFER_NEWS_PAGE, new GoToOfferNews());
        commands.put(CommandName.GO_TO_ABOUT_PAGE, new GoToAboutPage());
        commands.put(CommandName.GO_TO_USER_PAGE, new GoToUserPage());
        commands.put(CommandName.GO_TO_ADMIN_PAGE, new GoToAdminPage());
        commands.put(CommandName.GO_TO_UPDATE_NEWS, new GoToUpdateNewsPage());
        commands.put(CommandName.GO_TO_COMMENTS_PAGE, new GoToReadComments());
        commands.put(CommandName.ADD_NEWS, new AddNews());
        commands.put(CommandName.DELETE_NEWS, new DeleteSelectedNews());
        commands.put(CommandName.PUBLISHED_NEWS, new MakePublishedSelectedNews());
        commands.put(CommandName.UPDATE_NEWS, new UpdateSelectedNews());
        commands.put(CommandName.LOG_IN, new LogInUser());
        commands.put(CommandName.LOG_OUT, new LogOutUser());
        commands.put(CommandName.DELETE_USER, new DeleteUser());
        commands.put(CommandName.UPDATE_USER_PROFILE, new UpdateUser());
        commands.put(CommandName.REGISTER_NEW_USER, new UserRegistration());
        commands.put(CommandName.PUBLISH_COMMENT, new PublishComment());
        commands.put(CommandName.DELETE_COMMENT, new DeleteComment());
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
