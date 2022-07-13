package by.epam.webex.logic;

import java.util.HashMap;
import java.util.Map;

import by.epam.webex.logic.impl.DoAnythingCommand;
import by.epam.webex.logic.impl.NoSuchCommand;

public class CommandHelper {
	
	
	private static final CommandHelper instance = new CommandHelper();
	private Map<CommandName, ICommand> commands = new HashMap<>();
	
	public CommandHelper() {
		commands.put(CommandName.DO_ANYTHING_COMMAND, new DoAnythingCommand());
		commands.put(CommandName.NO_SUCH_COMMAND, new NoSuchCommand());
			}
	
	public static CommandHelper getInstance() {
		return instance;
	}
	
	public ICommand getCommand(String commandName) {
		
		CommandName name = CommandName.valueOf(commandName.toUpperCase());
		ICommand command;
		if(null!=name) {
			command=commands.get(name);
					
		}else {
			command=commands.get(CommandName.NO_SUCH_COMMAND);
		}
		return command;
	}

}
