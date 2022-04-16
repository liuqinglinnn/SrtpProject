package com.Lql.SRTP.controller;

import com.Lql.SRTP.util.Upload;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("Picture")
public class PictureUpload {
    @PostMapping("upload")
    public String upload(MultipartFile imgFile){
        String msg = "111";
        if (imgFile.isEmpty()) {
            msg="文化上传失败!";
        }else {
            // 拿到文件名
            String filename = imgFile.getOriginalFilename();
            System.out.println("0"+filename);//获取图片的文件名
            // 存放上传图片的文件夹
            File fileDir = Upload.getImgDirFile();
            // 输出文件夹绝对路径  -- 这里的绝对路径是相当于当前项目的路径而不是“容器”路径
            //  System.out.println(fileDir.getAbsolutePath());

            try {
                // 构建真实的文件路径
                File newFile = new File(fileDir.getAbsolutePath() + File.separator + filename);
                // 上传图片到“绝对路径”
                imgFile.transferTo(newFile);
                msg = "上传成功!";
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return msg;
    }
}
