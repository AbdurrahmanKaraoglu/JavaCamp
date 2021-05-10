package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jobpositions")
public class JobPosition {
	
	@Id
	@GeneratedValue
	@Column(name="position_id")
	private int PositionId;
	
	@Column(name="position_name")
	private String PositionName;
	
	public JobPosition() {
		super();
	}

	public JobPosition(int positionId, String positionName) {
		super();
		PositionId = positionId;
		PositionName = positionName;
	}

	public int getPositionId() {
		return PositionId;
	}

	public void setPositionId(int positionId) {
		PositionId = positionId;
	}

	public String getPositionName() {
		return PositionName;
	}

	public void setPositionName(String positionName) {
		PositionName = positionName;
	}
	

}
