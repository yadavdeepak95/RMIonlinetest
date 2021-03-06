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
 * Solution generated by hbm2java
 */
@Entity
@Table(name = "solution", catalog = "rmi")
public class Solution implements java.io.Serializable {

	private SolutionId id;
	private String quesid;
	private int sid;
	private String solution;
	private boolean status;
	private Date starttime;
	private Date lastsubmit;

	public Solution() {
	}

	public Solution(SolutionId id, String quesid, int sid, boolean status) {
		this.id = id;
		this.quesid = quesid;
		this.sid = sid;
		this.status = status;
	}

	public Solution(SolutionId id, String quesid, int sid, String solution, boolean status, Date starttime,
			Date lastsubmit) {
		this.id = id;
		this.quesid = quesid;
		this.sid = sid;
		this.solution = solution;
		this.status = status;
		this.starttime = starttime;
		this.lastsubmit = lastsubmit;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "pid", column = @Column(name = "pid", nullable = false)),
			@AttributeOverride(name = "uid", column = @Column(name = "uid", nullable = false)) })
	public SolutionId getId() {
		return this.id;
	}

	public void setId(SolutionId id) {
		this.id = id;
	}

	@Column(name = "quesid", nullable = false, length = 10000)
	public String getQuesid() {
		return this.quesid;
	}

	public void setQuesid(String quesid) {
		this.quesid = quesid;
	}

	@Column(name = "sid", nullable = false)
	public int getSid() {
		return this.sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	@Column(name = "solution", length = 20000)
	public String getSolution() {
		return this.solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	@Column(name = "status", nullable = false)
	public boolean isStatus() {
		return this.status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "starttime", length = 19)
	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastsubmit", length = 19)
	public Date getLastsubmit() {
		return this.lastsubmit;
	}

	public void setLastsubmit(Date lastsubmit) {
		this.lastsubmit = lastsubmit;
	}

}
