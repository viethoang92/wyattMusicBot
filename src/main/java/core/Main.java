package core;

import commands.CmdPing;
import commands.Music;
import listeners.CommandListener;
import listeners.ReadyListener;
import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import util.SECRETS;

import javax.security.auth.login.LoginException;

public class Main {
    static JDABuilder builder;

    public static void main(String[] args) {
        builder =  new JDABuilder(AccountType.BOT);

        builder.setToken(SECRETS.TOKEN);
        builder.setAutoReconnect(true);

        builder.setStatus(OnlineStatus.DO_NOT_DISTURB);

        addListeners();
        addCommands();


        try {
            JDA jda = builder.buildBlocking();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (RateLimitedException e) {
            e.printStackTrace();
        }
    }

    public static void addCommands() {

        CommandHandler.commands.put("ping", new CmdPing());
        CommandHandler.commands.put("m", new Music());
        CommandHandler.commands.put("music", new Music());
    }

    public static void addListeners() {
        builder.addEventListener(new ReadyListener());
        builder.addEventListener(new CommandListener());
    }

}
