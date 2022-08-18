package org.apache.camel.springboot.cli.command;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.boot.cli.command.Command;
import org.springframework.boot.cli.command.CommandFactory;

/**
 * @author vinod.pahuja@gmail.com
 */

public class CamelCommandFactory implements CommandFactory {

	@Override
	public Collection<Command> getCommands() {
		return Arrays.<Command>asList(new CamelRunnerCommand());
	}

}
