package com.example.pickerviewlibrary.picker.adapter;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.example.pickerviewlibrary.R;
import com.example.pickerviewlibrary.picker.PickerView;

import java.util.List;

public class DataAdapter extends BaseAdapter {
    private List<String> mDatas;
    private Context context;
    private String checkStr="";
    public DataAdapter(Context context, List<String> mDatas) {
        this.context=context;
        this.mDatas = mDatas;
    }

    @Override
    public int getCount() {
        return mDatas==null ? 0 :mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("ViewHolder")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView= LayoutInflater.from(context).inflate(R.layout.data_textview, parent, false);
            viewHolder.data_layout = convertView.findViewById(R.id.data_layout);
            viewHolder.textView = convertView.findViewById(R.id.data_text);
            viewHolder.data_img = convertView.findViewById(R.id.data_img);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.textView.setTextSize(PickerView.dataSize);
        viewHolder.textView.setTextColor(PickerView.dataColor);
        viewHolder.textView.setText(mDatas.get(position));
        if(checkStr.equals(mDatas.get(position))&&PickerView.discolour){
            viewHolder.textView.setTextColor(PickerView.discolourColor);
        }
        if(checkStr.equals(mDatas.get(position))&&PickerView.discolourHook){
            viewHolder.data_img.setVisibility(View.VISIBLE);
        }else{
            viewHolder.data_img.setVisibility(View.GONE);
        }
        if(PickerView.customHook!=null){
            viewHolder.data_img.setImageDrawable(PickerView.customHook);
        }
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(AbsListView.LayoutParams.WRAP_CONTENT,PickerView.dataHeight);
        viewHolder.textView.setLayoutParams(params);
        return convertView;
    }
    public void setList(List<String> datas,String toString) {
        if (datas != null && datas.size()>0) {
            mDatas=datas;
        }
        checkStr=toString;
        notifyDataSetChanged();
    }

    class ViewHolder {
        TextView textView;
        LinearLayout data_layout;
        ImageView data_img;
    }
}
