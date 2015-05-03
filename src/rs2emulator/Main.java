package rs2emulator;

import java.util.logging.Logger;

import rs2emulator.engine.Engine;

/**
 * The main class of RS2Emulator. This class contains the {@link #main(String[])} 
 * method which is responsible for booting the server.
 * 
 * @author Michael P
 *
 */
public class Main {

	private static final Logger logger = Logger.getLogger(Main.class.getName());
	
	public static void main(String[] args) {
		if (args.length != 2) {
			throw new IllegalArgumentException("Illegal argument use! Legal use -> [world], [revision]");
		}
		Engine.create();
		logger.info("RS2Emulator is now online!");
	}

}
