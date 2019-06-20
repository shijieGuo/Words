package com.example.guoshijie.words.getwordsFromMysql;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.guoshijie.words.Word.word;
import com.example.guoshijie.words.WordsDatabaseHelper.WordsDatabaseHelper;

import java.util.ArrayList;

public class getwordsFromMysql {
    private ArrayList<word> arrayList=new ArrayList();
    private ArrayList<word> allwords=new ArrayList();
    private WordsDatabaseHelper wordsDatabaseHelper;
    private SQLiteDatabase db;
    private Cursor cursor;
    public getwordsFromMysql(Context context){
        wordsDatabaseHelper=new WordsDatabaseHelper(context,"Words.db",null,2);
        db=wordsDatabaseHelper.getWritableDatabase();

    }
    public ArrayList<word> getwords(String string){
        cursor=db.query("word_table",null,null,null,null,null,null);
        arrayList.clear();
        if(string.isEmpty())
            return arrayList;
        if(cursor.moveToFirst()){
            do{
                double partchapter=cursor.getDouble(cursor.getColumnIndex("partchapter"));
                String word=cursor.getString(cursor.getColumnIndex("word"));
                String translation=cursor.getString(cursor.getColumnIndex("translation"));
                if(word.startsWith(string)){
                    arrayList.add(new word(partchapter,word,translation));
                }
            }while (cursor.moveToNext());
        }
        return arrayList;
    }
    private void get_all_words(){


    }
}
