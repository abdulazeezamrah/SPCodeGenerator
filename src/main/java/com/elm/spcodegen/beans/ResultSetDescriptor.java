package com.elm.spcodegen.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResultSetDescriptor implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<ResultSetColumnDescriptor> columnDescriptors = new ArrayList<ResultSetColumnDescriptor>();
	private String mappedEntityPackageName;
	private String mappedEntityClassName;
	private String resultSetName;
	
	public String getResultSetName() {
		return resultSetName;
	}
	public void setResultSetName(String resultSetName) {
		this.resultSetName = resultSetName;
	}
	public List<ResultSetColumnDescriptor> getColumnDescriptors() {
		return columnDescriptors;
	}
	public void setColumnDescriptors(
			List<ResultSetColumnDescriptor> columnDescriptors) {
		this.columnDescriptors = columnDescriptors;
	}
	public String getMappedEntityPackageName() {
		return mappedEntityPackageName;
	}
	public void setMappedEntityPackageName(String mappedEntityPackageName) {
		this.mappedEntityPackageName = mappedEntityPackageName;
	}
	public String getMappedEntityClassName() {
		return mappedEntityClassName;
	}
	public void setMappedEntityClassName(String mappedEntityClassName) {
		this.mappedEntityClassName = mappedEntityClassName;
	}

	
}
