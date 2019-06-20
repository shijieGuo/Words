package com.example.guoshijie.words.FindFiles;

import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FindFiles {
    private List<String> lstFile = new ArrayList<String>();  //结果 List

    public FindFiles(){
        GetFiles(Environment.getExternalStorageDirectory().getAbsolutePath(),"words.csv",true);
    }

    public void GetFiles(String Path, String Extension, boolean IsIterative)  //搜索目录，扩展名，是否进入子文件夹
    {
        File[] files = new File(Path).listFiles();

        for (int i = 0; i < files.length; i++)
        {
            File f = files[i];
            if (f.isFile())
            {
                if (f.getName().equals(Extension))  //判断扩展名
                    lstFile.add(f.getPath());

                if (!IsIterative)
                    break;
            }
            else if (f.isDirectory() && f.getPath().indexOf("/.") == -1)  //忽略点文件（隐藏文件/文件夹）
                GetFiles(f.getPath(), Extension, IsIterative);
        }
    }

    public List<String> getLstFile() {
        return lstFile;
    }
}
