package listeners;

import core.CommandHandler;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import util.STATIC;

public class CommandListener extends ListenerAdapter{

    public void onMessageReceived(MessageReceivedEvent event) {

        if(event.getMessage().getContent().startsWith(STATIC.PREFIX) &&
                event.getMessage().getAuthor().getId() != event.getJDA().getSelfUser().getId()) {
            CommandHandler.handleCommand(CommandHandler.parse.parser(event.getMessage().getContent(), event));
        }
    }
}
