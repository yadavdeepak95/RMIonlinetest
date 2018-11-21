package pojo;
// Generated 11 Nov, 2018 9:22:47 PM by Hibernate Tools 5.1.7.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Substudent generated by hbm2java
 */
@Entity
@Table(name = "substudent", catalog = "rmi")
public class Substudent implements java.io.Serializable {

	private SubstudentId id;
	private Date substudentcreationdate;

	public Substudent() {
	}

	public Substudent(SubstudentId id, Date substudentcreationdate) {
		this.id = id;
		this.substudentcreationdate = substudentcreationdate;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "sid", column = @Column(name = "sid", nullable = false)),
			@AttributeOverride(name = "subid", column = @Column(name = "subid", nullable = false)) })
	public SubstudentId getId() {
		return this.id;
	}

	public void setId(SubstudentId id) {
		this.id = id;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "substudentcreationdate", nullable = false, length = 19)
	public Date getSubstudentcreationdate() {
		return this.substudentcreationdate;
	}

	public void setSubstudentcreationdate(Date substudentcreationdate) {
		this.substudentcreationdate = substudentcreationdate;
	}

}