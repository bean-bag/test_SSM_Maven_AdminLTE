package com.fang.domain;

public class dataTable {
	private Long userID;
	private String colcumnTable;
	private String sort;
	private int start;
	private int length;

	public dataTable() {
		super();
	}

	public dataTable(Long userID, String colcumnTable, String sort, int start, int length) {
		super();
		this.userID = userID;
		this.colcumnTable = colcumnTable;
		this.sort = sort;
		this.start = start;
		this.length = length;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public String getColcumnTable() {
		return colcumnTable;
	}

	public void setColcumnTable(String colcumnTable) {
		this.colcumnTable = colcumnTable;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "userID:" + userID + "*colcumnTable:" + colcumnTable + "*start:" + start + "*sort:" + sort + "*length:"
				+ length;
	}
}
