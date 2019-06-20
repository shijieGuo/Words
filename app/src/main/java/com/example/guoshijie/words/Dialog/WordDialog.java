package com.example.guoshijie.words.Dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Display;
import android.view.Gravity;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.guoshijie.words.R;
import com.example.guoshijie.words.Word.word;
import com.example.guoshijie.words.Word.wordrecord;

public class WordDialog extends AlertDialog {

    private double dialog_width;
    private double dialog_height;
    private Activity activity;
    private TextView Part;
    private TextView Chapter;
    private TextView Word;
    private TextView Translation;
    private TextView Example;
    private TextView Exampletranslation;
    private ImageButton Play;
    private word word;
    private wordrecord wordrecord;
    public WordDialog(@NonNull Context context, word word,wordrecord wordrecord, double dialog_height, double dialog_width) {
        super(context);
        //  setContentView(R.layout.custom_dialog);
        this.activity = (Activity) context;
        this.dialog_height = dialog_height;
        this.dialog_width = dialog_width;
        this.word=word;
        this.wordrecord=wordrecord;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //为了锁定app界面的东西是来自哪个xml文件
        setContentView(R.layout.worddialog);



        //设置弹窗的宽度
        WindowManager m = getWindow().getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int) (size.x * dialog_width);//size.x*0.8是dialog的宽度为app界面的80%
        p.height = (int) (size.y * dialog_height);
        getWindow().setAttributes(p);
        findview();
        setview();
    }

    private void setview() {
        if(word.getPartchapter()>1&&word.getPartchapter()<2)
            Part.setText(R.string.Partⅰ);
        else if(word.getPartchapter()>2&&word.getPartchapter()<3)
            Part.setText(R.string.Partⅱ);
        else if(word.getPartchapter()>3&&word.getPartchapter()<4)
            Part.setText(R.string.Partⅲ);
        else if(word.getPartchapter()>4&&word.getPartchapter()<5)
            Part.setText(R.string.Partⅳ);
        else if(word.getPartchapter()>5&&word.getPartchapter()<6)
            Part.setText(R.string.Partⅴ);

        Word.setText(word.getWord());

        String[] tt=word.getTranslation().split("\\s+");
        String translation=tt[0];
        for(int i=1;i<tt.length;i++)
        {
            translation=translation+"\n"+tt[i];
        }
        Translation.setText(translation);
        Example.setText(wordrecord.getExample());
        Exampletranslation.setText(wordrecord.getExampletranslation());
    }

    @Override
    public void show() {
        super.show();
        getWindow().setWindowAnimations(R.style.dialogWindowAnim1);
        // 设置显示位置为右部
        getWindow().setGravity(Gravity.RIGHT);
    }
    public void findview() {
        Part=(TextView)findViewById(R.id.part);
        Chapter=(TextView)findViewById(R.id.chapter);
        Word=(TextView)findViewById(R.id.word);
        Translation=(TextView)findViewById(R.id.translation);
        Example=(TextView)findViewById(R.id.example);
        Exampletranslation=(TextView)findViewById(R.id.exampletranslation);
        Play=(ImageButton)findViewById(R.id.paly);
    }
}
