package info.apoluna.kosui;

import java.util.List;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.internal.Lists;

public class CommandLineArguments {
	@Parameter
	public List<String> parameters = Lists.newArrayList();

	@Parameter(names = { "-log", "-verbose" }, description = "Level of verbosity")
	public Integer verbose = 1;

}
