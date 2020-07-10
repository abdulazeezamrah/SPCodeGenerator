package com.elm.spcodegen.beans;





import com.elm.spcodegen.util.Util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Properties;

public class NameTypeBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private String type;
    private static Properties sqlJavaTypeMap = new Properties();
    private static Properties javaTypeResultSetMethodMap;

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        javaTypeResultSetMethodMap = new Properties();

        try {
            InputStream input = classLoader.getResourceAsStream("Types.properties");
            sqlJavaTypeMap.load(input);
            input = classLoader.getResourceAsStream("ResultSetMethods.properties");
            javaTypeResultSetMethodMap.load(input);
        } catch (IOException var2) {
            var2.printStackTrace();
        }

    }

    public static Properties getSqlJavaTypeMap() {
        return sqlJavaTypeMap;
    }

    public String getName() {
        return this.name;
    }

    public String getType() {
        return this.type;
    }

    public String getJavaType() {
        //System.out.println(type);
        String reustl= sqlJavaTypeMap.getProperty(Util.getType(this.type));
        //System.out.println(reustl);
        return reustl;

    }

    public String getResultSetMethod() {
         //  System.out.println(this.getJavaType());
        return javaTypeResultSetMethodMap.getProperty(this.getJavaType());
    }

    public NameTypeBean(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

