package cn.hanyuweb.bean;

import java.util.Date;

import org.apache.solr.client.solrj.beans.Field;

public class OBJECT_T_MALL_ATTR_KEYWORDS extends T_MALL_ATTR{
	@Field("value_id")
	private int value_id;
	@Field("shxzh")
	private String shxzh;
	@Field("value_shfqy")
	private String value_shfqy;
	@Field("shxzh_mch")
	private String shxzh_mch;
	@Field("value_chjshj")
	private Date value_chjshj;
	public int getValue_id() {
		return value_id;
	}
	public void setValue_id(int value_id) {
		this.value_id = value_id;
	}
	public String getShxzh() {
		return shxzh;
	}
	public void setShxzh(String shxzh) {
		this.shxzh = shxzh;
	}
	public String getValue_shfqy() {
		return value_shfqy;
	}
	public void setValue_shfqy(String value_shfqy) {
		this.value_shfqy = value_shfqy;
	}
	public String getShxzh_mch() {
		return shxzh_mch;
	}
	public void setShxzh_mch(String shxzh_mch) {
		this.shxzh_mch = shxzh_mch;
	}
	public Date getValue_chjshj() {
		return value_chjshj;
	}
	public void setValue_chjshj(Date value_chjshj) {
		this.value_chjshj = value_chjshj;
	}
	
}
