package myproject.basic.helper;

import myproject.basic.commands.*;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Bootstrap {

    public Map<String, ICommand> createCommandMap() {

        Map<String, ICommand> commands = new HashMap<>();

        commands.put("createaccount", new CreateAccount());
        commands.put("withdraw", new Withdraw());
        commands.put("deposit", new Deposit());
        commands.put("transfer", new Transfer());
        commands.put("getbalance", new GetBalance());

        //Pro commands
        try {
            Class<?> clGrantCredit = Class.forName("myproject.basic.commands.professionell.GrantCredit");
            Constructor<?> cGrantCredit = clGrantCredit.getConstructor();
            ICommand oGrantCredit = (ICommand) cGrantCredit.newInstance();
            commands.put(oGrantCredit.getCommandName(), oGrantCredit);
        } catch (Exception e) {

        }

        try {
            Class<?> clPayInterest = Class.forName("myproject.basic.commands.professionell.PayInterest");
            Constructor<?> cPayInterest = clPayInterest.getConstructor();
            ICommand cmdPayInterest = (ICommand) cPayInterest.newInstance();
            commands.put(cmdPayInterest.getCommandName(), cmdPayInterest);
        } catch (Exception e) {

        }

        try {
            Class<?> clRepayCredit = Class.forName("myproject.basic.commands.professionell.RepayCredit");
            Constructor<?> cRepayCredit = clRepayCredit.getConstructor();
            ICommand cmdRepayCredit = (ICommand) cRepayCredit.newInstance();
            commands.put(cmdRepayCredit.getCommandName(), cmdRepayCredit);
        } catch (Exception e) {

        }

        return commands;

    }

}
