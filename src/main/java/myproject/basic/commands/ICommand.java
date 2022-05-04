package myproject.basic.commands;

import myproject.basic.general.Bank;

public interface ICommand {

    public String getCommandName();

    public void execute(Bank bank);

}
