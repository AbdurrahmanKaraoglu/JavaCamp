package layeredE_commerceBackend.core.concretes;

import layeredE_commerceBackend.core.abstracts.LoggerService;
import layeredE_commerceBackend.jLogger.JLoggerManager;

public class JLoggerManagerAdapter implements LoggerService{

	@Override
	public void logToSystem(String message) {
		JLoggerManager manager = new JLoggerManager();
		manager.log(message);
	}

}
