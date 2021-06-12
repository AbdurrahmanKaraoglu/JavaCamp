package kodlamaio.hrms.entities.dtos;

import java.time.LocalDate;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ForeignLanguageKnowledgeDto {
	@JsonIgnore
	private int id;
	private int resumeId;
	private String foreignLanguageName;
	private char foreignLanguageLevel;
	private LocalDate creationDate;
}