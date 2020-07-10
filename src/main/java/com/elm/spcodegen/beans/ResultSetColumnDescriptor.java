package com.elm.spcodegen.beans;


import java.io.Serializable;

public class ResultSetColumnDescriptor implements Serializable {
private static final long serialVersionUID = 1L;
private NameTypeBean resultSetColumn;
private String setterMethodName;
private String converterMethodName;

public NameTypeBean getResultSetColumn() {
	return resultSetColumn;
}
public void setResultSetColumn(NameTypeBean resultSetColumn) {
	this.resultSetColumn = resultSetColumn;
}
public String getSetterMethodName() {
	return setterMethodName;
}
public void setSetterMethodName(String setterMethodName) {
	this.setterMethodName = setterMethodName;
}
public String getConverterMethodName() {
	return converterMethodName;
}
public void setConverterMethodName(String converterMethodName) {
	if(converterMethodName != null && !converterMethodName.isEmpty()){
		this.converterMethodName = converterMethodName;
	}
}



}
