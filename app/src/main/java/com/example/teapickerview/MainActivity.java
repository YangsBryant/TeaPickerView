package com.example.teapickerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import com.example.pickerviewlibrary.picker.PickerView;
import com.example.pickerviewlibrary.picker.entity.PickerData;
import com.example.pickerviewlibrary.picker.entity.ProvinceBean;
import com.example.pickerviewlibrary.picker.entity.SecondBean;
import com.example.pickerviewlibrary.picker.entity.ThirdBean;
import com.example.pickerviewlibrary.picker.util.JsonArrayUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.mButton)
    Button button;

    List<String> mProvinceDatas=new ArrayList<>();
    Map<String, List<String>> mSecondDatas= new HashMap<>();
    Map<String, List<String>> mThirdDatas= new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind( this );
        intiPickerView();
    }

    private  void intiPickerView(){
        //一级列表
        ProvinceBean provinceBean = new ProvinceBean();
        mProvinceDatas.addAll(provinceBean.getRepData().getProvince());

        //二级列表
        SecondBean secondBean = new SecondBean();
        mSecondDatas.putAll(secondBean.getRepData().getSecond());

        //三级列表
        ThirdBean thirdBean = new ThirdBean();
        mThirdDatas.putAll(thirdBean.getRepData().getThird());

        Log.i("json", JsonArrayUtil.toJson(mProvinceDatas));
        Log.i("json",JsonArrayUtil.toJson(mSecondDatas));
        Log.i("json",JsonArrayUtil.toJson(mThirdDatas));

        //设置数据有多少层级
        PickerData data=new PickerData();
        data.setFirstDatas(mProvinceDatas);//json: ["广东","江西"]
        data.setSecondDatas(mSecondDatas);//json: {"江西":["南昌","赣州"],"广东":["广州","深圳","佛山","东莞"]}
        data.setThirdDatas(mThirdDatas);//json: {"广州":["天河区","白云区","番禹区","花都区"],"赣州":["章贡区","黄金开发区"],"东莞":["东城","南城"],"深圳":["南山区","宝安区","龙华区"],"佛山":["禅城区","顺德区"],"南昌":["东湖区","青云谱区","青山湖区"]}

        data.setInitSelectText("请选择");

        PickerView pickerView=new PickerView(this,data);
        pickerView.setScreenH(3)
                .setDiscolourHook(true)
                .setRadius(25)
                .setContentLine(true)
                .setRadius(25)
                .build();

        button.setOnClickListener(v -> {
            //显示选择器
            pickerView.show(button);
        });

        //选择器点击事件
        pickerView.setOnPickerClickListener(pickerData -> {
            Toast.makeText(MainActivity.this,pickerData.getFirstText()+","+pickerData.getSecondText()+","+pickerData.getThirdText(),Toast.LENGTH_SHORT).show();
            pickerView.dismiss();//关闭选择器
        });
    }
}
