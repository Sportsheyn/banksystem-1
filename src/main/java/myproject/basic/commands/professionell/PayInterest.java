package myproject.basic.commands.professionell;

import myproject.basic.commands.ICommand;
import myproject.basic.general.Bank;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class PayInterest implements ICommand {


    @Override
    public String getCommandName() {
        return "payinterest";
    }

    @Override
    public void execute(Map<String, Object> params) {
        Bank bank = (Bank) params.get("bank");
        bank.payinterest();
    }

    @Override
    public String info() {
        return null;
    }
}
