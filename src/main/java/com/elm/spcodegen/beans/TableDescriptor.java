package com.elm.spcodegen.beans;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class TableDescriptor implements Serializable {
    private static final long serialVersionUID = 1L;
    private String tableName = "";
    private String tableDaoClassName = "";
    private String mappedBeanClassName = "";
    private String tableDaoPackageName = "";
    private String mappedBeanPackageName = "";
    private List<TableColumnDescriptor> columnDescriptors = new ArrayList();
    private boolean isGenerateMappedBean = false;

    public TableDescriptor() {
    }

    public String getTableName() {
        return this.tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getTableDaoClassName() {
        return this.tableDaoClassName;
    }

    public void setTableDaoClassName(String tableDaoClassName) {
        this.tableDaoClassName = tableDaoClassName;
    }

    public String getMappedBeanClassName() {
        return this.mappedBeanClassName;
    }

    public void setMappedBeanClassName(String mappedBeanClassName) {
        this.mappedBeanClassName = mappedBeanClassName;
    }

    public String getTableDaoPackageName() {
        return this.tableDaoPackageName;
    }

    public void setTableDaoPackageName(String tableDaoPackageName) {
        this.tableDaoPackageName = tableDaoPackageName;
    }

    public String getMappedBeanPackageName() {
        return this.mappedBeanPackageName;
    }

    public void setMappedBeanPackageName(String mappedBeanPackageName) {
        this.mappedBeanPackageName = mappedBeanPackageName;
    }

    public List<TableColumnDescriptor> getColumnDescriptors() {
        return this.columnDescriptors;
    }

    public void setColumnDescriptors(List<TableColumnDescriptor> columnDescriptors) {
        this.columnDescriptors = columnDescriptors;
    }

    public boolean isGenerateMappedBean() {
        return this.isGenerateMappedBean;
    }

    public void setGenerateMappedBean(boolean isGenerateMappedBean) {
        this.isGenerateMappedBean = isGenerateMappedBean;
    }

    public static long getSerialversionuid() {
        return 1L;
    }
}
