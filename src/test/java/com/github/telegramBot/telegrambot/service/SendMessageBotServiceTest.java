package com.github.telegramBot.telegrambot.service;

import com.github.telegramBot.telegrambot.bot.BybkaProjectBot;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendMessageBotServiceTest")
class SendMessageBotServiceTest {

    private SendMessageBotService sendMessageBotService;
    private BybkaProjectBot bybkaProjectBot;

    @BeforeEach
    public void init() {
        bybkaProjectBot = Mockito.mock(BybkaProjectBot.class);
        sendMessageBotService = new SendMessageBotServiceImpl(bybkaProjectBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        //when
        sendMessageBotService.sendMessage(chatId, message);

        //then
        Mockito.verify(bybkaProjectBot).execute(sendMessage);
    }
}