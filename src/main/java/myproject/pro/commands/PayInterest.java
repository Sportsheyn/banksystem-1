package myproject.pro.commands;

import myproject.basic.commands.ICommand;
import myproject.basic.general.Bank;

import java.util.Map;

public class PayInterest implements ICommand {


    @Override
    public String getCommandName() {
        return null;
    }

    @Override
    public void execute(Bank bank, Map<String, Object> params) {

    }
}
