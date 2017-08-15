package main.java;

import java.io.IOException;

public class ClearTerminal {
	public final static void clearConsole()
	{try {
        if (System.getProperty("os.name").contains("Windows"))
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
            Runtime.getRuntime().exec("clear");
    } catch (IOException | InterruptedException ex) {}
	}

}
