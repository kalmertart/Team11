package ee.itcollege.borderproject.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ee.itcollege.borderproject.common.BaseEntity;

@Entity
@Table(name = "Amet")
@NamedQueries({
	@NamedQuery(name = "Occupation.findAll", query = "SELECT o FROM Occupation o WHERE o.removed IS null")
})
public class Occupation extends BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Column(name = "IscoKood")
	@NotNull
	@Size(min = 2, max = 10)
	private String iscoCode;
	
	@Column(name = "Nimetus")
	@NotNull
	@Size(min = 5, max = 50)
	private String name;
	
	@OneToMany(mappedBy = "occupation")
	private List<OccupationInBorderStation> occupationInBorderStation;

	public String getIscoCode() {
		return iscoCode;
	}

	public String getName() {
		return name;
	}
	
	public List<OccupationInBorderStation> getOccupationInBorderStation() {
		return occupationInBorderStation;
	}

	public void setIscoCode(String iscoCode) {
		this.iscoCode = iscoCode;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setOccupationInBorderStation(
			List<OccupationInBorderStation> occupationInBorderStation) {
		this.occupationInBorderStation = occupationInBorderStation;
	}
}
