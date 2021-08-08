package com.eturial.blog.server.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class SavePicture {
    //时间格式化
    private SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd/");
    private String fileSavePath = "F:/images/";

    // 图片保存到指定位置并返回url
    public String pictureToUrl(MultipartFile file) throws IOException {
        //文件后半段目录：  2021/08/08
        String directory = simpleDateFormat.format(new Date());
        //文件保存目录  F:/images/2021/08/08
        File dir = new File(fileSavePath + directory);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        //文件重命名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        String newFileName= UUID.randomUUID().toString().replaceAll("-", "")+suffix;
        //创建文件
        File newFile = new File(fileSavePath + directory + newFileName);
        try {
            file.transferTo(newFile);
            String url = "http" + "://" + "localhost" + ":" + "14000" + "/images/" + directory + newFileName;
            return url;
        } catch (IOException e) {
            return "IO异常";
        }
    }

    // 将更改之前保存的图片删除
    public void deletePicture(String filePathAndName) {
        try {
            String filePath = filePathAndName;
            File myDelFile = new File(filePath.toString());
            myDelFile.delete();
        } catch (Exception e) {
            System.out.println("删除文件操作出错");
            e.printStackTrace();
        }
    }
}
