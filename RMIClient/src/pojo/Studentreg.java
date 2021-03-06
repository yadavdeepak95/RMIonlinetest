package pojo;
// Generated 31 Oct, 2018 2:21:46 PM by Hibernate Tools 5.1.7.Final

import java.util.Date;

/**
 * Studentreg generated by hbm2java
 */
// Entity
// Table(name = "studentreg", catalog = "rmi", uniqueConstraints =
// //UniqueConstraint(columnNames = "semail"))
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

	// Id
	// GeneratedValue(strategy = IDENTITY)

	// Temporal(TemporalType.TIMESTAMP)
	// Column(name = "screationdate", nullable = false, length = 19)
	public Date getScreationdate() {
		return this.screationdate;
	}

	// Column(name = "semail", unique = true, nullable = false, length = 200)
	public String getSemail() {
		return this.semail;
	}

	// Column(name = "sid", unique = true, nullable = false)
	public Integer getSid() {
		return this.sid;
	}

	// Column(name = "sname", nullable = false, length = 100)
	public String getSname() {
		return this.sname;
	}

	// Column(name = "spassword", nullable = false, length = 100)
	public String getSpassword() {
		return this.spassword;
	}

	public void setScreationdate(Date screationdate) {
		this.screationdate = screationdate;
	}

	public void setSemail(String semail) {
		this.semail = semail;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}

	public void setSpassword(String spassword) {
		this.spassword = spassword;
	}

}
