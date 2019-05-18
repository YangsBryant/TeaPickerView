package com.example.pickerviewlibrary.picker.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SecondBean {

    private String code = "200";
    private String msg = "服务器返回成功";
    private RepData repData;

    public static class RepData {
        private Map<String,List<String>> second;

        public Map<String,List<String>> getSecond() {
            Map<String,List<String>> map = new HashMap<>();

            List<String> list = new ArrayList<>();
            list.add("广州");
            list.add("深圳");
            list.add("佛山");
            list.add("东莞");

            List<String> list2 = new ArrayList<>();
            list2.add("南昌");
            list2.add("赣州");

            map.put("广东",list);
            map.put("江西",list2);
            return map;
        }

        public void setSecond(Map<String,List<String>> second) {
            this.second = second;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public RepData getRepData() {
        return repData = new RepData();
    }

    public void setRepData(RepData repData) {
        this.repData = repData;
    }
}
