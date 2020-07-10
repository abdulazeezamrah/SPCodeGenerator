package com.elm.spcodegen.beans;

public class BaseBackingBean {
    private String pageName;

    public BaseBackingBean(String pageName) {
        super();
        this.pageName = pageName;
    }

    public BaseBackingBean() {
        super();
    }

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }


}
