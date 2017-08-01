package com.fang.domain;

import java.util.List;

public class historyJson {

	private int draw;
	private int recordsTotal;
	private int recordsFiltered;
	private List<history> data;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public int getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<history> getData() {
		return data;
	}

	public void setData(List<history> data) {
		this.data = data;
	}

}
