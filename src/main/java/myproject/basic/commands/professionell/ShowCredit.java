package myproject.basic.commands.professionell;

import myproject.basic.commands.ICommand;

import java.util.Map;

public class ShowCredit implements ICommand {

    @Override
    public String getCommandName() {
        return "showcredit";
    }

    @Override
    public void execute(Map<String, Object> params) {

    }

    @Override
    public String info() {
        return null;
    }
}
