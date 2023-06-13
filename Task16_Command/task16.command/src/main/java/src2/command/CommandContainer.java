package src2.command;

import src2.Mediator.BotModeService;

import java.util.HashMap;

public class CommandContainer {
    HashMap<String, Command> commandMap = new HashMap();
    private final Command unknownCommand;

    public CommandContainer(BotModeService botModeService) {
        commandMap.put("/start", new CommandStart(botModeService));
        unknownCommand = new CommandUnknown(botModeService);
    }

    public Command getCommand(String commandIdentf){
        return commandMap.getOrDefault(commandIdentf, unknownCommand);
    }
}
