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

import org.hibernate.validator.constraints.Range;

import ee.itcollege.borderproject.common.BaseEntity;

@Entity
@Table(name = "Piiripunkt")
@NamedQueries({
	@NamedQuery(name = "BorderStation.findAll", query = "SELECT b FROM BorderStation b WHERE b.removed IS null"),
	@NamedQuery(name = "BorderStation.findWithDeleted", query = "Select b FROM BorderStation b")
})
public class BorderStation extends BaseEntity implements Serializable{
	
	private static final long serialVersionUID = 1831045952199616355L;

	@Column(name = "GpsLaiuskraad")
	@Range(min = -90, max = 90)
	private double latitude;
	
	@Column(name = "GpsPikkuskraad")
	@Range(min = -180, max = 180)
	private double longitude;
	
	@Column(name = "Korgusmerepinnast")
	@Range(min = -399, max = 8848)
	private double elevation;
	
	@Column(name = "Kood")
	@NotNull
	@Size(min = 4, max = 50)
	private String code;
	
	@Column(name = "Nimetus")
	@NotNull
	@Size(min = 4, max = 100)
	private String name;
	
	@OneToMany(mappedBy = "borderStation")
	private List<OccupationInBorderStation> occupationInBorderStation;

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public double getElevation() {
		return elevation;
	}

	public String getCode() {
		return code;
	}

	public String getName() {
		return name;
	}
	
	public List<OccupationInBorderStation> getOccupationInBorderStation() {
		return occupationInBorderStation;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public void setElevation(double elevation) {
		this.elevation = elevation;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setOccupationInBorderStation(
			List<OccupationInBorderStation> occupationInBorderStation) {
		this.occupationInBorderStation = occupationInBorderStation;
	}
}
