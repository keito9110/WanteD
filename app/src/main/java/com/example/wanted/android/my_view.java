package com.example.wanted.android;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.wanted.R;

public class my_view  extends LinearLayout{


    public my_view(Context context, AttributeSet attrs) {
        super(context, attrs);
        // LayoutInflaterでレイアウトxmlの内容でViewを作る
        // LayoutInflater#inflate()の第2引数ではルートとなるViewとして自分自身を指定する
        View layout = LayoutInflater.from(context).inflate(R.layout.myview, this);
    }
}
