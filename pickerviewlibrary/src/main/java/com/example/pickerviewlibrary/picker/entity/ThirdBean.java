package com.example.pickerviewlibrary.picker.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThirdBean {

    private String code = "200";
    private String msg = "服务器返回成功";
    private RepData repData;

    public static class RepData {
        private Map<String,List<String>> third;

        public Map<String,List<String>> getThird() {
            Map<String,List<String>> map = new HashMap<>();

            List<String> list = new ArrayList<>();
            list.add("天河区");
            list.add("白云区");
            list.add("番禹区");
            list.add("花都区");

            List<String> list2 = new ArrayList<>();
            list2.add("南山区");
            list2.add("宝安区");
            list2.add("龙华区");

            List<String> list3 = new ArrayList<>();
            list3.add("禅城区");
            list3.add("顺德区");

            List<String> list4 = new ArrayList<>();
            list4.add("东城");
            list4.add("南城");

            List<String> list5 = new ArrayList<>();
            list5.add("东湖区");
            list5.add("青云谱区");
            list5.add("青山湖区");

            List<String> list6 = new ArrayList<>();
            list6.add("章贡区");
            list6.add("黄金开发区");

            map.put("广州",list);
            map.put("深圳",list2);
            map.put("佛山",list3);
            map.put("东莞",list4);
            map.put("南昌",list5);
            map.put("赣州",list6);
            return map;
        }

        public void setThird(Map<String,List<String>> third) {
            this.third = third;
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
