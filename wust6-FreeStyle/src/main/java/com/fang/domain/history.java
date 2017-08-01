package com.fang.domain;

import java.util.Date;

public class history {
	private Long id;

	private Long customerid;

	private Long deliveryid;

	private Date ordertime;

	private Date reachtime;

	private Long prizeid;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}

	public Long getDeliveryid() {
		return deliveryid;
	}

	public void setDeliveryid(Long deliveryid) {
		this.deliveryid = deliveryid;
	}

	public Date getOrdertime() {
		return ordertime;
	}

	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}

	public Date getReachtime() {
		return reachtime;
	}

	public void setReachtime(Date reachtime) {
		this.reachtime = reachtime;
	}

	public Long getPrizeid() {
		return prizeid;
	}

	public void setPrizeid(Long prizeid) {
		this.prizeid = prizeid;
	}

	public String toString() {
		return "id:" + id + "customerid:" + customerid + "deliveryid:" + deliveryid + "ordertime:" + ordertime
				+ "reachtime:" + reachtime + "prizeid:" + prizeid;
	}
}