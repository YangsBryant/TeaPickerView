# TeaPickerView

![这是一张图片](https://github.com/YangsBryant/TeaPickerView/blob/master/image/hn2u5-ukvzr.gif)

## 引入module
```java
allprojects {
    repositories {
        google()
        jcenter()
        maven { url 'https://www.jitpack.io' }
    }
}
```
```java
implementation 'com.github.YangsBryant:TeaPickerView:1.0.2'
```

## 主要代码

```java
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

        TeaPickerView teaPickerView =new TeaPickerView(this,data);
        teaPickerView.setScreenH(3)
                .setDiscolourHook(true)
                .setRadius(25)
                .setContentLine(true)
                .setRadius(25)
                .build();

        button.setOnClickListener(v -> {
            //显示选择器
            teaPickerView.show(button);
        });

        //选择器点击事件
        teaPickerView.setOnPickerClickListener(pickerData -> {
            Toast.makeText(MainActivity.this,pickerData.getFirstText()+","+pickerData.getSecondText()+","+pickerData.getThirdText(),Toast.LENGTH_SHORT).show();
            teaPickerView.dismiss();//关闭选择器
        });
    }
}
```

## TeaPickerView属性大全
方法名 | 属性
--------- | -------------
setHeights(int mHeight) | 显示具体的高度(dp),设置0是自适应(高度没有默认值，需要主动设置)
setScreenH(int num) | 显示的高度占屏幕的百分比
setBackground(int color) | 设置整体的背景颜色 默认是#ffffff
setRadius(int mRadius) | 设置圆角，默认0
setInitSelectText | 初始化文字
setContentBackground(int color) | 内容栏的背景颜色 默认是#ffffff
setContentHeight(int mHeight) | 内容栏的高度(dp) 默认是50dp
setContentText(int size,int color) | 内容栏字体的大小和颜色, 默认是16sp,#0aa666，用此方法会固定颜色
setContentText(ColorStateList drawable) | 自定义内容栏字体颜色变换器 在res目录下创建color文件夹用selector 默认颜色#555 选中颜色#0aa666
setContentLine(boolean bl) | 内容栏选中是否有下划线 默认不开启
setContentLineColor(Drawable drawable) | 自定义内容栏下划线用layer-list 默认是下边框描边 颜色#0fbc72 高度1dp
setLine(int mHeight,int color) | 分割线的高度和颜色 默认是0.5dp #e5e5e5
setitemHeight(int mHeight) | 设置list的item的高度(dp) 默认是40dp
setListText(int size,int color) | 设置list的字体大小和颜色 默认是15 #555
setScrollBal(boolean bl) | 设置list是否显示滚动条,默认false
setAlpha(float mFloat) | 设置阴影层的透明度 默认是0.5f
setDiscolour(boolean bl) | 设置选中项是否加色，默认true
setDiscolourColor(int color) | 设置选中项加色的颜色值，默认#0aa666
setDiscolourHook(boolean bl) | 设置选中项是否有√图标，默认false
setCustomHook(Drawable drawable) | 自定义√图标
build() | 参数设置完毕，一定要build一下

方法名 | 属性
--------- | -------------
setFirstDatas(List<String> mFirstDatas) | 设置一级数据
setSecondDatas(Map<String, List<String>> mSecondDatas) | 设置二级数据
setThirdDatas(Map<String, List<String>> mThirdDatas) | 设置三级数据
setFourthDatas(Map<String, List<String>> mFourthDatas) | 设置四级数据
	
## 给出参考bean地址
[一级ProvinceBean](https://github.com/YangsBryant/TeaPickerView/blob/master/pickerviewlibrary/src/main/java/com/example/pickerviewlibrary/picker/entity/ProvinceBean.java)  [二级SecondBean](https://github.com/YangsBryant/TeaPickerView/blob/master/pickerviewlibrary/src/main/java/com/example/pickerviewlibrary/picker/entity/SecondBean.java)  [三级ThirdBean](https://github.com/YangsBryant/TeaPickerView/blob/master/pickerviewlibrary/src/main/java/com/example/pickerviewlibrary/picker/entity/ThirdBean.java)

## 默认内容栏字体颜色变换器
```java
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
	<item android:state_selected="true" android:color="@color/picker_select_text_color"/>
	<item android:state_pressed="true" android:color="@color/picker_select_text_color"/>
	<item android:state_checked="true" android:color="@color/picker_select_text_color"/>
	<item android:state_focused="true" android:color="@color/picker_select_text_color"/>
	<item android:color="@color/picker_text_color"/>
</selector> 
```
## 默认内容栏下划线
```java
<?xml version="1.0" encoding="UTF-8"?>
<layer-list xmlns:android="http://schemas.android.com/apk/res/android" >
    <!-- 边框颜色值 -->
    <item>
        <shape>
            <solid android:color="@color/station_average" />
        </shape>
    </item>
    <item android:bottom="1dp"> <!--设置只有底部有边框-->
        <shape>
            <solid android:color="#ffffff" />
        </shape>
    </item>
</layer-list>
```

