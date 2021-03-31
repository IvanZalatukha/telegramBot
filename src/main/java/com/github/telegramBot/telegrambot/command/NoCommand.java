package com.github.telegramBot.telegrambot.command;

import com.github.telegramBot.telegrambot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NoCommand implements Command {

    private final SendMessageBotService sendMessageBotService;

    public static final String NO_MESSAGE = "Я поддерживаю команды, начинающиеся со слеша(/).\n"
            + "Чтобы посмотреть список команд введите /help";

    public NoCommand(SendMessageBotService sendBotMessageService) {
        this.sendMessageBotService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
