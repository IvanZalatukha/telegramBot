package com.github.telegramBot.telegrambot.command;

import com.github.telegramBot.telegrambot.service.SendMessageBotService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{

    private final SendMessageBotService sendMessageBotService;

    public final static String START_MESSAGE = "Привет Бубка. Я Bybka Telegram Bot. Я помогу тебе ничего не забывать";

    public StartCommand(SendMessageBotService sendMessageBotService) {
        this.sendMessageBotService = sendMessageBotService;
    }

    @Override
    public void execute(Update update) {
        sendMessageBotService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
