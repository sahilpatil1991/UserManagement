package com.db.database.entity;

public class Change {
	private String del;
	private String udp;
	public String getDel() {
		return del;
	}
	public void setDel(String del) {
		this.del = del;
	}
	public String getUdp() {
		return udp;
	}
	public void setUdp(String udp) {
		this.udp = udp;
	}
	@Override
	public String toString() {
		return "Change [del=" + del + ", udp=" + udp + "]";
	}

}
