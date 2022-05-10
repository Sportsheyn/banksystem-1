package myproject.basic;

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

        try {
            Class<?> clGrantCredit = Class.forName("myproject.pro.commands.GrantCredit");
            Constructor<?> cGrantCredit = clGrantCredit.getConstructor();
            ICommand oGrantCredit = (ICommand) cGrantCredit.newInstance();
            commands.put(oGrantCredit.getCommandName(), oGrantCredit);
        } catch (Exception ignored) {
            System.out.println(ignored);
        }


        try {
            Class<?> clPayInterest = Class.forName("myproject.pro.commands.PayInterest");
            Constructor<?> cPayInterest = clPayInterest.getConstructor();
            ICommand cmdPayInterest = (ICommand) cPayInterest.newInstance();
            commands.put(cmdPayInterest.getCommandName(), cmdPayInterest);
        } catch (Exception ignored) {
            System.out.println(ignored);
        }

        try {
            Class<?> clRepayCredit = Class.forName("myproject.pro.commands.RepayCredit");
            Constructor<?> cRepayCredit = clRepayCredit.getConstructor();
            ICommand cmdRepayCredit = (ICommand) cRepayCredit.newInstance();
            commands.put(cmdRepayCredit.getCommandName(), cmdRepayCredit);
        } catch (Exception ignored) {
            System.out.println(ignored);
        }

        return commands;

    }

}
