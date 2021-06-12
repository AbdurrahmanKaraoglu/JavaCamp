package kodlamaio.hrms.core.utilities.customize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidationError {

	private boolean success;
	private String message;
	private String details;

}