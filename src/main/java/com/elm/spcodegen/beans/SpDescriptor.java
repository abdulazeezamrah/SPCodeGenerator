package com.elm.spcodegen.beans;

import java.io.Serializable;
import java.util.List;

public class SpDescriptor implements Serializable {
	private static final long serialVersionUID = 1L;
	private String spName;
	private String spExecutorClassName;
	private String spInputClassName;
	private String spResultClassName;
	private String spExecutorClassPackageName;
	private String spInputClassPackageName;
	private String spResultClassPackageName;
	private List<NameTypeBean> inputParameters;
	private List<NameTypeBean> outputParameters;
	private List<ResultSetDescriptor> resultSetDescriptors;
	private Boolean logSql;

	public Boolean getLogSql() {
		return logSql;
	}

	public void setLogSql(Boolean logSql) {
		this.logSql = logSql;
	}

	public String getSpName() {
		return spName;
	}
	public void setSpName(String spName) {
		this.spName = spName;
	}
	public String getSpExecutorClassPackageName() {
		return spExecutorClassPackageName;
	}
	public void setSpExecutorClassPackageName(String spExecutorClassPackageName) {
		this.spExecutorClassPackageName = spExecutorClassPackageName;
	}
	public String getSpInputClassPackageName() {
		return spInputClassPackageName;
	}
	public void setSpInputClassPackageName(String spInputClassPackageName) {
		this.spInputClassPackageName = spInputClassPackageName;
	}
	public String getSpResultClassPackageName() {
		return spResultClassPackageName;
	}
	public void setSpResultClassPackageName(String spResultClassPackageName) {
		this.spResultClassPackageName = spResultClassPackageName;
	}
	public String getSpExecutorClassName() {
		return spExecutorClassName;
	}
	public void setSpExecutorClassName(String spExecutorClassName) {
		this.spExecutorClassName = spExecutorClassName;
	}
	public String getSpInputClassName() {
		return spInputClassName;
	}
	public void setSpInputClassName(String spInputClassName) {
		this.spInputClassName = spInputClassName;
	}
	public String getSpResultClassName() {
		return spResultClassName;
	}
	public void setSpResultClassName(String spResultClassName) {
		this.spResultClassName = spResultClassName;
	}
	public List<NameTypeBean> getInputParameters() {
		return inputParameters;
	}
	public void setInputParameters(List<NameTypeBean> inputParameters) {
		this.inputParameters = inputParameters;
	}
	public List<NameTypeBean> getOutputParameters() {
		return outputParameters;
	}
	public void setOutputParameters(List<NameTypeBean> outputParameters) {
		this.outputParameters = outputParameters;
	}
	public List<ResultSetDescriptor> getResultSetDescriptors() {
		return resultSetDescriptors;
	}
	public void setResultSetDescriptors(
			List<ResultSetDescriptor> resultSetDescriptors) {
		this.resultSetDescriptors = resultSetDescriptors;
	}

	
		
}
