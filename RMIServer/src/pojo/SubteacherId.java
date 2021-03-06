package pojo;
// Generated 11 Nov, 2018 9:22:47 PM by Hibernate Tools 5.1.7.Final

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SubteacherId generated by hbm2java
 */
@Embeddable
public class SubteacherId implements java.io.Serializable {

	private int tid;
	private int subid;

	public SubteacherId() {
	}

	public SubteacherId(int tid, int subid) {
		this.tid = tid;
		this.subid = subid;
	}

	@Column(name = "tid", nullable = false)
	public int getTid() {
		return this.tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	@Column(name = "subid", nullable = false)
	public int getSubid() {
		return this.subid;
	}

	public void setSubid(int subid) {
		this.subid = subid;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SubteacherId))
			return false;
		SubteacherId castOther = (SubteacherId) other;

		return (this.getTid() == castOther.getTid()) && (this.getSubid() == castOther.getSubid());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getTid();
		result = 37 * result + this.getSubid();
		return result;
	}

}
