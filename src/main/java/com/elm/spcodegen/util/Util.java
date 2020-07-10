package com.elm.spcodegen.util;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Util {
    public Util() {
    }

    public static String getType(String init) {
        if(init.equals("INT"))
            return  "INTEGER";
        else if(init.equals("XML"))
            return  "CLOB";
        else {
            return  init;
        }
    }

    public static String getSmallCase(String text) {

        if (text == null || text.isEmpty()) {
            return text;
        }
        text = text.replaceAll("_","");
        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            ch = Character.toLowerCase(ch);
            converted.append(ch);
        }

        return converted.toString();
    }

    public static String getTitleCase(String text) {

        if (text == null || text.isEmpty()) {
            return text;
        }
        text = text.replaceAll("_"," ");
        StringBuilder converted = new StringBuilder();

        boolean convertNext = true;
        for (char ch : text.toCharArray()) {
            if (Character.isSpaceChar(ch)) {
                convertNext = true;
            } else if (convertNext) {
                ch = Character.toTitleCase(ch);
                convertNext = false;
            } else {
                ch = Character.toLowerCase(ch);
            }
            converted.append(ch);
        }
        return converted.toString().replaceAll(" ","");
    }


    public static String toCamelCaseForAccessors(String init) {
        if (init == null) {
            return null;
        } else {
            StringBuilder ret = new StringBuilder(init.length());
            String[] var5;
            int var4 = (var5 = init.split("_")).length;

            for(int var3 = 0; var3 < var4; ++var3) {
                String word = var5[var3];
                if (!word.isEmpty()) {
                    ret.append(word.substring(0, 1).toUpperCase());
                    ret.append(word.substring(1).toLowerCase());
                }
            }

            return ret.toString();
        }
    }

    public boolean isNullOrEmptyString(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static String getGetterName(String setterName) {
        if (setterName == null) {
            return null;
        } else {
            int endIndex = setterName.length();
            String str = "get" + setterName.substring(3, endIndex);
            StringBuilder ret = new StringBuilder(str);
            return ret.toString();
        }
    }

    public static String toCamelCaseForVariable(String init) {
        if (init == null) {
            return null;
        } else {
            StringBuilder ret = new StringBuilder();
            String word = toCamelCaseForAccessors(init);
            ret.append(word.substring(0, 1).toLowerCase());
            ret.append(word.substring(1));
            return ret.toString();
        }
    }

    public static String toSameString(String init) {
        return init;
    }

    public static String toInputParam(String init) {
        return init + "_IP";
    }

    public static String toOutputParam(String init) {
        return init + "_OP";
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("C:" + getListOfSetters("com.elm.pms.vo.UserVO"));
        System.out.println("C:" + getListOfConverters("com.elm.pms.vo.UserVO"));
    }

    public static String getClassName(String fullyQualifiedName) {
        String result = "";
        if (fullyQualifiedName != null && !fullyQualifiedName.isEmpty()) {
            String[] arr = fullyQualifiedName.split("\\.");
            if (arr.length > 0) {
                result = arr[arr.length - 1];
            }
        }

        return result;
    }

    public static String getPackageName(String fullyQualifiedName) {
        String result = "";
        if (fullyQualifiedName != null && !fullyQualifiedName.isEmpty()) {
            String[] arr = fullyQualifiedName.split("\\.");
            if (arr.length > 1) {
                StringBuffer sb = new StringBuffer(result);

                for(int i = 0; i <= arr.length - 2; ++i) {
                    sb.append(arr[i]);
                    sb.append('.');
                }

                if (sb.length() > 0) {
                    result = sb.substring(0, sb.length() - 1);
                }
            }
        }

        return result;
    }

    public static List<String> getListOfSetters(String fullyQualifiedName) throws ClassNotFoundException {
        List<String> result = new ArrayList();
        searchClassMethods(fullyQualifiedName, result, "set");
        return result;
    }

    public static List<String> getListOfConverters(String fullyQualifiedName) throws ClassNotFoundException {
        List<String> result = new ArrayList();
        searchClassMethods(fullyQualifiedName, result, "convert");
        return result;
    }

    private static void searchClassMethods(String fullyQualifiedName, List<String> result, String methodStartPattern) throws ClassNotFoundException {
        Class c = Class.forName(fullyQualifiedName);
        if (c != null) {
            Method[] var7;
            int var6 = (var7 = c.getMethods()).length;

            for(int var5 = 0; var5 < var6; ++var5) {
                Method method = var7[var5];
                if (method.getName().startsWith(methodStartPattern)) {
                    result.add(method.getName());
                }
            }
        }

    }

    public static List<String> getListOfSqlTypeMethods(String fullyQualifiedName) throws ClassNotFoundException {
        List<String> result = new ArrayList();
        searchClassMethods(fullyQualifiedName, result, "getSqlTypeFor");
        return result;
    }
}

