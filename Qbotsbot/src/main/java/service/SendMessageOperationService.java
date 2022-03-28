package service;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;

import java.util.ArrayList;
import java.util.List;

import static constant.VarConstant.*;
import static java.util.Arrays.asList;

public class SendMessageOperationService {
    private final  ButtonsService buttonsService = new ButtonsService();
    private final  String FIRST_MESSAGE = "Введите Ваше имя и номер телефона ";
    private final String HELLO_MESSAGE = "Сізді Qbots компаниясының онлайн-кеңесшісі қарсы алуда! Сізден интерфейс тілін таңдауды сұраймыз" +
            "\nВас приветствует онлайн-консультант компании Qbots! Просим Вас выбрать язык интерфейса";

    public SendMessage createHelloInformation(Update update){
        SendMessage message = createSimpleMessage(update, FIRST_MESSAGE);
        return message;
    }

    public  SendMessage createSecondMessage(Update update){
        SendMessage message = createSimpleMessage(update,HELLO_MESSAGE);
        ReplyKeyboardMarkup keyboardMarkup = buttonsService.
                setButtons(buttonsService.createButtons(asList(KAZAKH_LANGUAGE, RUSSIAN_LANGUAGE)));
        keyboardMarkup.setResizeKeyboard(true);
        message.setReplyMarkup(keyboardMarkup);
        return message;
    }

    public  SendMessage createKazakhMessage(Update update){
        SendMessage message = createSimpleMessage(update,"Негізгі мәзір");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("Компания жайлы");
        inlineKeyboardButton2.setText("Чат-боттар жайлы");
        inlineKeyboardButton3.setText("Кері хабарласу");
        inlineKeyboardButton1.setCallbackData("ABOUT_COMQ");
        inlineKeyboardButton2.setCallbackData("ABOUT_BOTSQ");
        inlineKeyboardButton3.setCallbackData("CALLQ");
        inlineKeyboardButtonList.add(inlineKeyboardButton1);
        inlineKeyboardButtonList.add(inlineKeyboardButton2);
        inlineKeyboardButtonList.add(inlineKeyboardButton3);
        inlineButtons.add(inlineKeyboardButtonList);
        inlineKeyboardMarkup.setKeyboard(inlineButtons);
        message.setReplyMarkup(inlineKeyboardMarkup);
        return message;
    }

    public  SendMessage createRussianMessage(Update update){
        SendMessage message = createSimpleMessage(update,"Главное меню");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText(ABOUT_COM);
        inlineKeyboardButton2.setText(ABOUT_BOTS);
        inlineKeyboardButton3.setText(CALL);
        inlineKeyboardButton1.setCallbackData("ABOUT_COM");
        inlineKeyboardButton2.setCallbackData("ABOUT_BOTS");
        inlineKeyboardButton3.setCallbackData("CALL");
        inlineKeyboardButtonList.add(inlineKeyboardButton1);
        inlineKeyboardButtonList.add(inlineKeyboardButton2);
        inlineKeyboardButtonList.add(inlineKeyboardButton3);
        inlineButtons.add(inlineKeyboardButtonList);
        inlineKeyboardMarkup.setKeyboard(inlineButtons);
        message.setReplyMarkup(inlineKeyboardMarkup);
        return message;
    }

    public  SendMessage createAboutCompanyMessage(SendMessage message){
        message.setText("О компании");
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> inlineButtons = new ArrayList<>();
        List<InlineKeyboardButton> inlineKeyboardButtonList = new ArrayList<>();
        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        inlineKeyboardButton1.setText("О нас");
        inlineKeyboardButton2.setText("Новости");
        inlineKeyboardButton1.setCallbackData("ABOUT_US");
        inlineKeyboardButton2.setCallbackData("NEWS");
        inlineKeyboardButton2.setUrl("www.qbots.kz");
        inlineKeyboardButtonList.add(inlineKeyboardButton1);
        inlineKeyboardButtonList.add(inlineKeyboardButton2);
        inlineButtons.add(inlineKeyboardButtonList);
        inlineKeyboardMarkup.setKeyboard(inlineButtons);
        message.setReplyMarkup(inlineKeyboardMarkup);
        return message;
    }

    public  SendMessage createAboutUsMessage(SendMessage message){
        message.setText("Компания Qbots  занимается разработкой подсистемного " +
                "программного обеспечения для мессенджера Telegram. Мы реализовали " +
                "более 50 крупных проектов для 10 отраслей экономики как, государственные " +
                "организации, национальные компании.\nАдрес: 050000, г. Алматы, ул. Байзакова 17, офис 4,\n" +
                "БИН: 1705400769\n" +
                "Е-mail: qbots2020@gmail.com,\n" +
                "www.qbots.kz\n" +
                "Контакты: 8 778 349 99 94 Нурлан\n");
        return message;
    }

    public SendMessage createAboutBotsMessage(SendMessage message){
        message.setText("Чат-бот или другими словами «Виртуальный ассистент» — это универсальный менеджер который работает 24 часа в сутки, 7 дней в неделю и выполняет следующие задачи:\n" +
                "Разгрузит контактный центр до 80% и ответит на стандартные вопросы \n" +
                "Организует и проконтролирует работу ваших сотрудников\n" +
                "Управляет счетами, заказами и доставкой\n" +
                "Презентует ваш продукт клиенту, поможет оформить заказ и оплатить его онлайн\n" +
                "Интеграция со всеми популярными CRM системами\n");
        return message;
    }

    public SendMessage createAboutCallMessage(SendMessage message){
        message.setText("Если Вы хотите заказать «Обратный звонок» просим написать " +
                "Ваше имя и номер контактного телефона");
        return message;
    }

    private SendMessage createSimpleMessage(Update update,String message){
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(String.valueOf(update.getMessage().getChatId()));
        sendMessage.setText(message);
        return sendMessage;
    }
}
