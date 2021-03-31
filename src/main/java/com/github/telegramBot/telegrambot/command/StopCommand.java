package com.github.telegramBot.telegrambot.command;

import com.github.telegramBot.telegrambot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command {

    private final SendMessageBotService sendMessageBotService;

    public static final String STOP_MESSAGE = "Пока, ещё увидимся.";

    public StopCommand(SendMessageBotService sendBotMessageService) {
        this.sendMessageBotService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
