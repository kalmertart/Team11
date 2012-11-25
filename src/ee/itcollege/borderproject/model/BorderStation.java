package ee.itcollege.borderproject.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@NamedQueries({ 
	@NamedQuery(name = "BorderStation.findAll", 
				query = "SELECT f FROM BorderStation f")  })

@Entity
public class BorderStation implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotNull
	@Size(min = 3, max = 30)
	private String name;
	
	@NotNull
	@Size(min = 5, max = 50)
	private String address;
	
	@Min(value = 1)
	private int guardCount;
	
	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getGuardCount() {
		return guardCount;
	}
	
	public void setGuardCount(int guardCount) {
		this.guardCount = guardCount;
	}	
}
