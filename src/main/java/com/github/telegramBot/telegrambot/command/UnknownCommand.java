package com.github.telegramBot.telegrambot.command;

import com.github.telegramBot.telegrambot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;


public class UnknownCommand implements Command {

    public static final String UNKNOWN_MESSAGE = "Не понимаю тебя \uD83D\uDE1F, напишите /help чтобы узнать что я понимаю.";

    private final SendMessageBotService sendMessageBotService;

    public UnknownCommand(SendMessageBotService sendBotMessageService) {
        this.sendMessageBotService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), UNKNOWN_MESSAGE);
    }
}
