package myproject.basic.commands;


import myproject.basic.helper.Bootstrap;

import java.util.Map;

public class Help implements ICommand {

    @Override
    public String getCommandName() {
        return "help";
    }

    @Override
    public void execute(Map<String, Object> params) {

        Bootstrap bootstrap = new Bootstrap();
        Map<String, ICommand> commandMap = bootstrap.createCommandMap();

        System.out.println("Available commands:");
        for (Map.Entry<String, ICommand> e: commandMap.entrySet()) {
            System.out.print(e.getKey() + ", ");
        }
        System.out.println();

    }

    @Override
    public String info() {
        return "";
    }
}
