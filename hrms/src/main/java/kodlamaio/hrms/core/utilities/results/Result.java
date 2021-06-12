package kodlamaio.hrms.core.utilities.results;

public class Result {
	private boolean succes;
	private String message;

	public Result(boolean succes) {
		super();
		this.succes = succes;
	}

	public Result(boolean succes, String message) {
		super();
		this.succes = succes;
		this.message = message;
	}

	public boolean isSucces() {
		return succes;
	}

	public String getMessage() {
		return message;
	}

}