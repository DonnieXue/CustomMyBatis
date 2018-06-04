package com.donnie.utils;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by BRL on 2018/6/1.
 * propertis文件工具类
 */
public class PropertiesUtils {
    //项目根路径
    private static final String ROOT_PATH = PropertiesUtils.class.getResource("/").getPath();

    private static final String JDBC_FILE_NAME = "jdbc.properties";

    /**
     * 读取jdbc配置文件信息
     *
     * @param param jdbc.properties变量名称
     * @return String 返回properties值
     */
    public static String getJdbcValue(String param) {
        Map<String, String> hashMap = readValue(JDBC_FILE_NAME);
        return hashMap.get(param);
    }

    /**
     * properties文件读取
     *
     * @param filepath 被读取文件名称
     * @return
     */
    private static Map<String, String> readValue(String filepath) {
        Map<String, String> map = null;
        InputStream is = null;
        Properties prop = new Properties();

        try {
            is = new BufferedInputStream(new FileInputStream(ROOT_PATH + filepath));
            prop.load(is);
            map = new HashMap<>();
            for (Object key : prop.keySet()
                    ) {
                String value = prop.getProperty((String) key);
                map.put((String) key, value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                if (null != is) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        return map;
    }
//  public static void main (String[] args){
//      String username = PropertiesUtils.getJdbcValue("username");
//      System.out.println(username);
//  }

}
