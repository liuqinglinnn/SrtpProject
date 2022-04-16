package com.Lql.SRTP.util;

import java.io.File;

public class Upload {
    // 项目根路径下的目录
    public final static String IMG_PATH_PREFIX = "static/image";

    public static File getImgDirFile() {
        // 构建上传文件的存放 "文件夹" 路径
        String fileDirPath = new String("src/main/resources/" + IMG_PATH_PREFIX);
        File fileDir = new File(fileDirPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        return fileDir;
    }
}
