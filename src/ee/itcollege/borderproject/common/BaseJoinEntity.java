package ee.itcollege.borderproject.common;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public class BaseJoinEntity extends BaseEntity {
	
	@Column(name = "Alates")
	@NotNull
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date start;
	
	@Column(name = "Kuni")
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date end;

	public Date getStart() {
		return start;
	}

	public Date getEnd() {
		return end;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public void setEnd(Date end) {
		this.end = end;
	}
	
}
