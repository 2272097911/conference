package com.youkeda.web.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.*;

/**
 * JSON 解析数据工具类
 * @author Juniors
 */
public class HandleData {


    /**
     * 读取json文件
     *
     * @param fileName
     * @return
     */
    public static String readJsonFile(String fileName){

        String jsonStr;

        try {
            File jsonFile = new File("src/main/resources/"+fileName);
            FileReader fileReader = new FileReader(jsonFile);

            Reader reader = new InputStreamReader(new FileInputStream(jsonFile), "utf-8");
            int ch;
            StringBuffer sb = new StringBuffer();
            while ((ch = reader.read()) != -1) {
                sb.append((char)ch);
            }
            fileReader.close();
            reader.close();
            jsonStr = sb.toString();
            return jsonStr;
        }catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析json数据
     *
     * @param code
     * @return
     */
    public static int handle(String code){

        String jsonData = readJsonFile("data.json");
        JSONArray jsonArray = JSON.parseArray(jsonData);
        Map<String,Map> maps = new HashMap<>();

        for (Object o:jsonArray){
            JSONObject object = (JSONObject) o;
            Map jsomMap = object;
            maps.put(((JSONObject) jsomMap).getString("code"),jsomMap);

        }
        int des = (int) maps.get(code).get("capacity");

        return des;
    }

    /**
     * 由会议室号查找会议室名字
     *
     * @param code
     * @return
     */
    public static String skr(String code){

        String jsonData = readJsonFile("data.json");
        JSONArray jsonArray = JSON.parseArray(jsonData);
        Map<String,Map> maps = new HashMap<>();

        for (Object o:jsonArray){
            JSONObject object = (JSONObject) o;
            Map jsomMap = object;
            maps.put(((JSONObject) jsomMap).getString("code"),jsomMap);

        }
        System.out.println(code);
        String des = (String) maps.get(code).get("name");

        return des;
    }



    public static void main(String[] args) {

        String jsonData = readJsonFile("data.json");
        JSONArray jsonArray = JSON.parseArray(jsonData);
        //System.out.println(jsonArray);
        Map<String,Map> maps = new HashMap<>();

        for (Object o:jsonArray){
            JSONObject object = (JSONObject) o;
            Map jsomMap = object;
            maps.put(((JSONObject) jsomMap).getString("code"),jsomMap);


//            System.out.println(jsomMap.get("capacity"));
//            System.out.println(jsomMap.get("code"));
//            System.out.println(jsomMap.get("name"));
//
            System.out.println("会议室容量:"+object.getInteger("capacity")+
                                "  会议室号:"+object.getString("code")+
                                "  会议室名称:"+object.getString("name"));

        }
         //System.out.println(maps.get("4-9-2").get("capacity"));
    }
}
