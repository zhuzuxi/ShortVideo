package com.backend.util;

import org.apache.tika.Tika;
import org.modelmapper.internal.bytebuddy.implementation.bytecode.collection.ArrayLength;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class fileUtils {

    public static List<String> getAllFileAbsolutePathFromDirectory(String dir,String type) {
        File file = new File(dir);

        //目录不存在返回null
        if (!file.exists()) {
            System.out.println("该目录不存在");
            return null;
        }

        ArrayList<String> files = new ArrayList<>();
//        判断是否为目录 不是则直接返回该文件
        if (!file.isDirectory()) {
            files.add(file.getAbsolutePath());
            return files;
        }
        for (File listFile : file.listFiles()) {
            if ((!listFile.isDirectory() && type.equals(getFileType(listFile))) ) {
                files.add(listFile.getAbsolutePath());
            }else {
                files.addAll(getAllFileAbsolutePathFromDirectory(listFile.getAbsolutePath(),type));
            }

        }
        return files;


    }

    public static String getFileType(File file){
        String file_type = null;
        Tika tika = new Tika();
        try {
            file_type=tika.detect(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return file_type;
    }
}
