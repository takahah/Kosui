package info.apoluna.kosui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import bsh.EvalError;
import bsh.Interpreter;

import com.beust.jcommander.JCommander;

public class Cui {
	public Cui(CommandLineArguments args) {

	}

	public void execute() {
		Interpreter i = new Interpreter();
		try {
			i.eval("import org.openqa.selenium.*;");
			i.eval("import java.util.*;");
			i.eval("import info.apoluna.kosui.*;");
		} catch (EvalError e1) {
			e1.printStackTrace();
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			try {
				String line = br.readLine();
				if (line != null && "exit".equals(line)) {
					break;
				}
				i.eval(line);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (EvalError e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CommandLineArguments cla = new CommandLineArguments();
		new JCommander(cla, args);

		Cui logic = new Cui(cla);
		logic.execute();
	}

}
