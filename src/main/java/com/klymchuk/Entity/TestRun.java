package com.klymchuk.Entity;

import java.util.Date;

import com.google.common.base.Objects;

public class TestRun {

	private String testName;
	private String testResult;
	private Date testTime;
	private String testEnvironment;
	
	public TestRun(String testName, Date testTime, String testResult,
			String testEnvironment) {
		super();
		this.testName = testName;
		this.testTime = testTime;
		this.testResult = testResult;
		this.testEnvironment = testEnvironment;
	}
	public String getTestName() {
		return testName;
	}
	public void setTestName(String testName) {
		this.testName = testName;
	}
	public Date getTestTime() {
		return testTime;
	}
	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}
	public String getTestResult() {
		return testResult;
	}
	public void setTestResult(String testResult) {
		this.testResult = testResult;
	}
	public String getTestEnvironment() {
		return testEnvironment;
	}
	public void setTestEnvironment(String testEnvironment) {
		this.testEnvironment = testEnvironment;
	}
	
	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("testName", testName)
				.add("testResult", testResult)
				.toString();
	}
}
