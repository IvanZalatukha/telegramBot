package com.github.telegramBot.telegrambot.command;

import com.github.telegramBot.telegrambot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.github.telegramBot.telegrambot.command.CommandName.*;

public class HelpCommand implements Command {

    private final SendMessageBotService sendMessageBotService;

    public static final String HELP_MESSAGE = String.format("<b>Дотупные команды</b>\n\n"
                    + "%s - начать работу со мной\n"
                    + "%s - приостановить работу со мной\n\n"
                    + "%s - получить помощь в работе со мной\n",
            START.getCommandName(), STOP.getCommandName(), HELP.getCommandName());

    public HelpCommand(SendMessageBotService sendBotMessageService) {
        this.sendMessageBotService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), HELP_MESSAGE);
    }
}
