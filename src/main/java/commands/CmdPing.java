package commands;

import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import util.STATIC;

public class CmdPing implements Command{

    public boolean called(String[] args, MessageReceivedEvent event) {
        return false;
    }

    public void action(String[] args, MessageReceivedEvent event) {
        event.getTextChannel().sendMessage("Pong").queue();
    }

    public void executed(boolean success, MessageReceivedEvent event) {
        System.out.println("[INFO] command '" + STATIC.PREFIX+ "ping' executed");
    }

    public String help() {
        return null;
    }
}
