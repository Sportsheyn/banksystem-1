package myproject.basic.commands;

import myproject.basic.general.Bank;

import java.util.Map;

/**
 * The ICommand interface should be implemented by any class whose want to be an available command.
 */
public interface ICommand {

    /**
     * Returns the name of the command
     * @return the name of the command
     */
    public String getCommandName();

    /**
     * Contains the logic of the command.
     *
     * @param bank   - the bank that manages the accounts
     * @param params
     */
    public void execute(Bank bank, Map<String, Object> params);


    // public String info();

}
