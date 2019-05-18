package com.example.pickerviewlibrary.picker.entity;

import java.util.ArrayList;
import java.util.List;

public class ProvinceBean {

    private String code = "200";
    private String msg = "服务器返回成功";
    private RepData repData;

    public static class RepData {
        private List<String> province;

        public List<String> getProvince() {
            List<String> list = new ArrayList<>();
            list.add("广东");
            list.add("江西");
            return list;
        }

        public void setProvince(List<String> province) {
            this.province = province;
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
