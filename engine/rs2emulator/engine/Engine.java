package rs2emulator.engine;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

/**
 * The main engine thread class. This thread is responbile for executing the main
 * game logic such as, but is not limited to the following: 
 * <ul><li>Game task(s)</li>
 * <li>Networking logic (e.g. packets)</li>
 * <li>World processing</li></ul>
 * 
 * @version 1.0
 * @author Michael P
 *
 */
public final class Engine implements Runnable {

	private static final ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryBuilder().setNameFormat(
	        "Engine").setPriority(Thread.MAX_PRIORITY).build());
	private static Engine singleton;
	
	public static void create() {
		final Engine engine = new Engine();
		setSingleton(engine);
		executor.scheduleAtFixedRate(engine, 0, 0x258, TimeUnit.MILLISECONDS);
	}
	
	public static void destroy() {
		if (singleton == null) {
			throw new IllegalStateException("The engine singleton has already been destroyed - please create a new singleton before attempting to destroy one!");
		}
		executor.shutdown();
		singleton = null;
	}
	
	@Override
	public void run() {
		try {
			// TODO Logic processing
		} catch (Exception e) {
			
		}
	}

	public static Engine getSingleton() {
		return singleton;
	}

	private static void setSingleton(Engine singleton) {
		if (Engine.singleton != null) {
			throw new IllegalStateException("An engine singleton has already been created - please destroy the existing singleton before attempting to create a new one!");
		}
		Engine.singleton = singleton;
	}

}
