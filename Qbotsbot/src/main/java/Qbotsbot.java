import core.CoreBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Qbotsbot{

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi botsApi =  new TelegramBotsApi(DefaultBotSession.class);
        botsApi.registerBot(new CoreBot());
    }

}
