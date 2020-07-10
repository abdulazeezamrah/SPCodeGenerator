package com.elm.spcodegen.beans;


import java.io.Serializable;

public class TableColumnDescriptor implements Serializable {
    private static final long serialVersionUID = 1L;
    private NameTypeBean column = new NameTypeBean("", "");
    private String setterMethodName = "";
    private String converterMethodName = "";
    private String getSqlMethodName = "";

    public TableColumnDescriptor() {
    }

    public String getGetSqlMethodName() {
        return this.getSqlMethodName;
    }

    public void setGetSqlMethodName(String getSqlMethodName) {
        this.getSqlMethodName = getSqlMethodName;
    }

    public NameTypeBean getColumn() {
        return this.column;
    }

    public void setColumn(NameTypeBean column) {
        this.column = column;
    }

    public String getSetterMethodName() {
        return this.setterMethodName;
    }

    public void setSetterMethodName(String setterMethodName) {
        this.setterMethodName = setterMethodName;
    }

    public String getConverterMethodName() {
        return this.converterMethodName;
    }

    public void setConverterMethodName(String converterMethodName) {
        if (converterMethodName != null && !converterMethodName.isEmpty()) {
            this.converterMethodName = converterMethodName;
        }

    }
}

