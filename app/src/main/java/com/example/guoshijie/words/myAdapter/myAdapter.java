package com.example.guoshijie.words.myAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guoshijie.words.Dialog.WordDialog;
import com.example.guoshijie.words.R;
import com.example.guoshijie.words.Word.word;
import com.example.guoshijie.words.Word.wordrecord;
import com.example.guoshijie.words.getwordsFromMysql.getwordrecordFromMysql;

import java.util.ArrayList;

public class myAdapter extends ArrayAdapter {
    private ArrayList<word> arrayList;
    private getwordrecordFromMysql getwordrecordFromMysql;
    private Context context;

    public myAdapter(Context context, int textViewResourceId, ArrayList<word> objects) {
        super(context, textViewResourceId, objects);
        this.context=context;
        this.arrayList = objects;
        this.getwordrecordFromMysql=new getwordrecordFromMysql(context);
    }
    @Override
    public int getCount() {
        return super.getCount();
    }
    @Override
    public View getView(final int position, final View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.item, null);
        ListView.LayoutParams params = new ListView.LayoutParams(ListView.LayoutParams.MATCH_PARENT,120);//设置宽度和高度
        v.setLayoutParams(params);
        v.setLongClickable(true);
        v.setOnLongClickListener(new View.OnLongClickListener() {
            public boolean onLongClick(View view) {

                return true;
            }
        });
        v.setClickable(true);
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wordrecord wordrecord;
                wordrecord=getwordrecordFromMysql.getwordrecords(arrayList.get(position).getWord());
                WordDialog wordDialog=new WordDialog(getContext(),arrayList.get(position),new wordrecord(wordrecord.getWord(),wordrecord.getExample(),wordrecord.getExampletranslation()),0.6,0.75);
                wordDialog.setCancelable(true);
                wordDialog.show();

            }
        });
        TextView textView=(TextView) v.findViewById(R.id.textview);
        textView.setText(arrayList.get(position).getWord()+" "+arrayList.get(position).getTranslation());

        return v;
    }

    public ArrayList getArraryList()
    {
        return arrayList;
    }

}
