package com.github.telegramBot.telegrambot.command;

import com.github.telegramBot.telegrambot.bot.BybkaProjectBot;
import com.github.telegramBot.telegrambot.service.SendMessageBotService;
import com.github.telegramBot.telegrambot.service.SendMessageBotServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

abstract class AbstractCommandTest {

    protected BybkaProjectBot bybkaProjectBot = Mockito.mock(BybkaProjectBot.class);
    protected SendMessageBotService sendMessageBotService = new SendMessageBotServiceImpl(bybkaProjectBot);

    abstract String getCommandName();

    abstract String getCommandMessage();

    abstract Command getCommand();

    @Test
    public void shouldProperlyExecuteCommand() throws TelegramApiException {
        //given
        Long chatId = 1234567824356L;

        Update update = new Update();
        Message message = Mockito.mock(Message.class);
        Mockito.when(message.getChatId()).thenReturn(chatId);
        Mockito.when(message.getText()).thenReturn(getCommandName());
        update.setMessage(message);

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId.toString());
        sendMessage.setText(getCommandMessage());
        sendMessage.enableHtml(true);

        //when
        getCommand().execute(update);

        //then
        Mockito.verify(bybkaProjectBot).execute(sendMessage);
    }
}
