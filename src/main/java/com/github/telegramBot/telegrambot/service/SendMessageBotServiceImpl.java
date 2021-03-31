package com.github.telegramBot.telegrambot.service;

import com.github.telegramBot.telegrambot.bot.BybkaProjectBot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class SendMessageBotServiceImpl implements SendMessageBotService {

    private final BybkaProjectBot bybkaProjectBot;

    @Autowired
    public SendMessageBotServiceImpl(BybkaProjectBot bybkaProjectBot) {
        this.bybkaProjectBot = bybkaProjectBot;
    }

    @Override
    public void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);
        sendMessage.setText(message);

        try {
            bybkaProjectBot.execute(sendMessage);
        } catch (TelegramApiException e) {
            //todo add logging to the project.
            e.printStackTrace();
        }
    }
}
