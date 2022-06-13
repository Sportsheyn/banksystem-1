package myproject.basic.commands;

import myproject.basic.general.Bankaccount;
import myproject.basic.general.Bank;

import java.util.Map;

import static java.lang.Integer.parseInt;

public class GetBalance implements ICommand {

    @Override
    public String getCommandName() {
        return "getbalance";
    }

    @Override
    public void execute(Map<String, Object> params) {

    }

    @Override
    public String info() {
        return "Please enter your accountnumber and your pin.";
    }
}
