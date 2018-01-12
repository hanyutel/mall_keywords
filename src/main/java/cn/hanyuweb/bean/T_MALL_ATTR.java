package cn.hanyuweb.bean;

import java.util.Date;
import java.util.List;

import org.apache.solr.client.solrj.beans.Field;

public class T_MALL_ATTR {
	@Field("id")
	private int id;
	@Field("shxm_mch")
	private String shxm_mch;
	@Field("shfqy")
	private String shfqy;
	@Field("flbh2")
	private int flbh2;
	@Field("chjshj")
	private Date chjshj;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getShxm_mch() {
		return shxm_mch;
	}

	public void setShxm_mch(String shxm_mch) {
		this.shxm_mch = shxm_mch;
	}

	public String getShfqy() {
		return shfqy;
	}

	public void setShfqy(String shfqy) {
		this.shfqy = shfqy;
	}

	public int getFlbh2() {
		return flbh2;
	}

	public void setFlbh2(int flbh2) {
		this.flbh2 = flbh2;
	}

	public Date getChjshj() {
		return chjshj;
	}

	public void setChjshj(Date chjshj) {
		this.chjshj = chjshj;
	}

}
