package myproject.basic.commands;


import myproject.basic.helper.Bootstrap;

import java.io.PrintWriter;
import java.util.Map;

public class Help implements ICommand {

    @Override
    public String getCommandName() {
        return "help";
    }

    @Override
    public void execute(Map<String, Object> params) {

        PrintWriter out = (PrintWriter) params.get("out");

        Bootstrap bootstrap = new Bootstrap();
        Map<String, ICommand> commandMap = bootstrap.createCommandMap();

        System.out.println("Available commands:");
        for (Map.Entry<String, ICommand> e: commandMap.entrySet()) {
            out.print(e.getKey() + ", ");
        }
        out.println();

    }

    @Override
    public String info() {
        return "";
    }
}
