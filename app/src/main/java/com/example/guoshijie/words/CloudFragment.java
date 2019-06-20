package com.example.guoshijie.words;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.guoshijie.words.FindFiles.FindFiles;

import java.util.ArrayList;
import java.util.List;

public class CloudFragment extends android.support.v4.app.Fragment {
    private View view=null;
    private List<String> lstFile = new ArrayList<String>();
    private TextView textView;
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        if(view==null) {
            view = inflater.inflate(R.layout.fragment_cloud, container, false);
            textView=view.findViewById(R.id.text);
            lstFile=new FindFiles().getLstFile();
            setView();
        }
        return view;
    }

    private void setView() {
        String translation= lstFile.get(0);
        for(int i=1;i<lstFile.size();i++)
        {
            translation=translation+"\n"+lstFile.get(i);
        }
        textView.setText(translation);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



    }

    public void onResume()
    {
        super.onResume();
    }

}
