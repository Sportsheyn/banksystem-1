package myproject.basic.commands;


import myproject.basic.helper.Bootstrap;

import java.util.Map;

public class ShowCommands implements ICommand {

    @Override
    public String getCommandName() {
        return "showcommands";
    }

    @Override
    public void execute(Map<String, Object> params) {

        Bootstrap bootstrap = new Bootstrap();
        Map<String, ICommand> commandMap = bootstrap.createCommandMap();

        System.out.println("Available commands:");
        for (Map.Entry<String, ICommand> e: commandMap.entrySet()) {
            System.out.println(e.getKey());
        }

    }

    @Override
    public String info() {
        return "";
    }
}
