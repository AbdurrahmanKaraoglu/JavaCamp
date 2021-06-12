package kodlamaio.hrms.entities.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmEmployerDto {
	@JsonProperty(access = Access.READ_ONLY)
	private int id;
	private String employerCompanyName;
	private String employerEmail;
	private String employerWebAddress;
	private String employerPhoneNumber;
	private boolean employerIsConfirmed;
}