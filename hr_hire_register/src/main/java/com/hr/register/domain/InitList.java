package com.hr.register.domain;

public class InitList {
	
	private String siteName;
	private int siteNumber;
	private String conCheckResult;
	private boolean result;
	
	
	public InitList() {};
	
	public InitList(String siteName, int siteNumber, String conCheckResult, boolean result) {
		this.siteName = siteName;
		this.siteNumber = siteNumber;
		this.conCheckResult = conCheckResult;
		this.result = result;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public int getSiteNumber() {
		return siteNumber;
	}

	public void setSiteNumber(int siteNumber) {
		this.siteNumber = siteNumber;
	}

	public String getConCheckResult() {
		return conCheckResult;
	}

	public void setConCheckResult(String conCheckResult) {
		this.conCheckResult = conCheckResult;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	
	

}
