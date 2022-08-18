package org.apache.camel.springboot.cli.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.cli.command.HelpExample;
import org.springframework.boot.cli.command.OptionParsingCommand;
import org.springframework.boot.cli.command.options.OptionHandler;
import org.springframework.boot.cli.command.status.ExitStatus;

import joptsimple.OptionSet;
import joptsimple.OptionSpec;

/**
 * @author vinod.pahuja@gmail.com
 */

public class CamelRunnerCommand extends OptionParsingCommand {

	public static final Log log = LogFactory.getLog(CamelRunnerCommand.class);

	private static final Collection<HelpExample> EXAMPLES = new ArrayList<>();

	static {
		EXAMPLES.add(new HelpExample("Show version", "spring camel --version"));
	}

	public CamelRunnerCommand() {
		super("camel", "Start Spring Camel", new CamelOptionHandler());
	}

	@Override
	public Collection<HelpExample> getExamples() {
		return EXAMPLES;
	}

	private static class CamelOptionHandler extends OptionHandler {

		private OptionSpec<Void> versionOption;

		@Override
		protected void options() {
			this.versionOption = option(Arrays.asList("version", "v"),
					"Show the version (don't launch anything)");
		}

		@Override
		protected synchronized ExitStatus run(OptionSet options) throws Exception {
			if (options.has(this.versionOption)) {
				System.out.println("Spring Boot Camel C L I v" + getClass().getPackage().getImplementationVersion());
				return ExitStatus.OK;
			}
			try {
                System.out.println("Spring Boot Camel C L I");
			}
			catch (Exception e) {
				log.error("Error running spring camel", e);
				return ExitStatus.ERROR;
			}

			return ExitStatus.OK;
		}

	}

}