package pojo;
// Generated 11 Nov, 2018 9:22:47 PM by Hibernate Tools 5.1.7.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

/**
 * Studentreg generated by hbm2java
 */
@Entity
@Table(name = "studentreg", catalog = "rmi", uniqueConstraints = @UniqueConstraint(columnNames = "semail"))
public class Studentreg implements java.io.Serializable {

	private Integer sid;
	private String sname;
	private String semail;
	private String spassword;
	private Date screationdate;

	public Studentreg() {
	}

	public Studentreg(String sname, String semail, String spassword, Date screationdate) {
		this.sname = sname;
		this.semail = semail;
		this.spassword = spassword;
		this.screationdate = screationdate;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "sid", unique = true, nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	@Column(name = "sname", nullable = false, length = 100)
	public String getSname() {
		return this.sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	@Column(name = "semail", unique = true, nullable = false, length = 200)
	public String getSemail() {
		return this.semail;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	@Column(name = "spassword", nullable = false, length = 100)
	public String getSpassword() {
		return this.spassword;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "screationdate", nullable = false, length = 19)
	public Date getScreationdate() {
		return this.screationdate;
	}

	public void setScreationdate(Date screationdate) {
		this.screationdate = screationdate;
	}

}