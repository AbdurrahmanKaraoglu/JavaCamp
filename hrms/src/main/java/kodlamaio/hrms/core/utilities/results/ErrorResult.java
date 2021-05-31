package kodlamaio.hrms.core.utilities.results;

public class ErrorResult extends Result {

	public ErrorResult(boolean succes) {
		super(false);
	}

	public ErrorResult(String message) {
		super(false, message);
	}
}
