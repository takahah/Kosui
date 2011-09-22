package info.apoluna.kosui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import bsh.EvalError;
import bsh.Interpreter;

import com.beust.jcommander.JCommander;

public class Cui {
	Interpreter i;

	public Cui(CommandLineArguments args) {

	}

	public void finalize() {
		if (i != null) {
			try {
				i.eval("quit()");
				i = null;
			} catch (EvalError e) {
				e.printStackTrace();
			}
		}
	}

	public void execute() {
		i = new Interpreter();
		try {
			i.source("common.bsh");
		} catch (EvalError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
