package core;

import org.checkerframework.checker.units.qual.C;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import service.SendMessageOperationService;

import static constant.VarConstant.*;
//import static constant.VarConstant.HELLO_MESSAGE;

public class CoreBot extends TelegramLongPollingBot {
    SendMessageOperationService sendMessageOperationService = new SendMessageOperationService();

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage() && update.getMessage().hasText()){
            switch (update.getMessage().getText()){
                case START:
                    executeMessage(sendMessageOperationService.createHelloInformation(update));
                    break;
                case KAZAKH_LANGUAGE:
                    executeMessage(sendMessageOperationService.createKazakhMessage(update));
                    break;
                case RUSSIAN_LANGUAGE:
                    executeMessage(sendMessageOperationService.createRussianMessage(update));
                    break;
                default:
                    executeMessage(sendMessageOperationService.createSecondMessage(update));
                    break;
            }
        }
        else if(update.hasCallbackQuery()){
            Message message = update.getCallbackQuery().getMessage();
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String data =   callbackQuery.getData();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(String.valueOf(message.getChatId()));
            //about company
            if(data.equals("ABOUT_COM")){
                executeMessage(sendMessageOperationService.createAboutCompanyMessage(sendMessage));
            }
            else if(data.equals("ABOUT_US")){
                executeMessage(sendMessageOperationService.createAboutUsMessage(sendMessage));
            }

            //about chat bots
            else if(data.equals("ABOUT_BOTS")){
                executeMessage(sendMessageOperationService.createAboutBotsMessage(sendMessage));
            }

            //about call back
            else if(data.equals("CALL")){
                executeMessage(sendMessageOperationService.createAboutCallMessage(sendMessage));

            }
        }
    }

    @Override
    public String getBotUsername() {
        return "q_botsbot";
    }

    @Override
    public String getBotToken() {
        return "5183125175:AAFQ9BmCKFM1R9NhpH7fVb0wMHdrhuDdarg";
    }

    private <T extends BotApiMethod>  void executeMessage(T sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("Не удалось отправить сообщения "+e.getCause());
        }
    }
}
