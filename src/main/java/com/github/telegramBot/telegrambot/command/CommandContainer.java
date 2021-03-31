package com.github.telegramBot.telegrambot.command;

import com.github.telegramBot.telegrambot.service.SendMessageBotService;
import com.google.common.collect.ImmutableMap;

import static com.github.telegramBot.telegrambot.command.CommandName.*;

public class CommandContainer {

    private final ImmutableMap<String, Command> commandMap;
    private final Command unknownCommand;

    public CommandContainer(SendMessageBotService sendMessageBotService) {

        commandMap = ImmutableMap.<String, Command>builder()
                .put(START.getCommandName(), new StartCommand(sendMessageBotService))
                .put(STOP.getCommandName(), new StopCommand(sendMessageBotService))
                .put(HELP.getCommandName(), new HelpCommand(sendMessageBotService))
                .put(NO.getCommandName(), new NoCommand(sendMessageBotService))
                .build();

        unknownCommand = new UnknownCommand(sendMessageBotService);
    }

    public Command retrieveCommand(String commandIdentifier) {
        return commandMap.getOrDefault(commandIdentifier, unknownCommand);
    }


}
