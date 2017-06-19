package com.wuxianedu.controller;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import java.io.IOException;  
import java.util.Date;  
import java.util.Iterator;  
  
import javax.servlet.http.HttpServletRequest;  
import javax.servlet.http.HttpServletResponse;  
  
import org.springframework.stereotype.Controller;  
import org.springframework.web.bind.annotation.RequestMapping;  
import org.springframework.web.bind.annotation.RequestParam;  
import org.springframework.web.multipart.MultipartFile;  
import org.springframework.web.multipart.MultipartHttpServletRequest;  
import org.springframework.web.multipart.commons.CommonsMultipartFile;  
import org.springframework.web.multipart.commons.CommonsMultipartResolver;  
  
  

  
@Controller  
@RequestMapping("/file")  
public class TestPhoto {   
      
      
    @RequestMapping("/upload"   )  
    public String addUser(@RequestParam("file") CommonsMultipartFile[] files,HttpServletRequest request){  
          
        for(int i = 0;i<files.length;i++){  
            System.out.println("fileName---------->" + files[i].getOriginalFilename());  
          
            if(!files[i].isEmpty()){  
                int pre = (int) System.currentTimeMillis();  
                try {  
                    //�õ��������ͬʱ�������ϴ����ļ�  
                    FileOutputStream os = new FileOutputStream("H:/" + new Date().getTime() + files[i].getOriginalFilename());  
                    //�õ��ϴ��ļ���������  
                    FileInputStream in = (FileInputStream) files[i].getInputStream();  
                      
                    //��д�ֽڵķ�ʽд�ļ�  
                    int b = 0;  
                    while((b=in.read()) != -1){  
                        os.write(b);  
                    }  
                    os.flush();  
                    os.close();  
                    in.close();  
                    int finaltime = (int) System.currentTimeMillis();  
                    System.out.println(finaltime - pre);  
                      
                } catch (Exception e) {  
                    e.printStackTrace();  
                    System.out.println("�ϴ�����");  
                }  
        }  
        }  
        return "/success";  
    }  
      
      
    @RequestMapping("/upload2"  )  
    public String upload2(HttpServletRequest request,HttpServletResponse response) throws IllegalStateException, IOException {  
        //����һ��ͨ�õĶಿ�ֽ�����  
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());  
        //�ж� request �Ƿ����ļ��ϴ�,���ಿ������  
        if(multipartResolver.isMultipart(request)){  
            //ת���ɶಿ��request    
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest)request;  
            //ȡ��request�е������ļ���  
            Iterator<String> iter = multiRequest.getFileNames();  
            while(iter.hasNext()){  
                //��¼�ϴ�������ʼʱ��ʱ�䣬���������ϴ�ʱ��  
                int pre = (int) System.currentTimeMillis();  
                //ȡ���ϴ��ļ�  
                MultipartFile file = multiRequest.getFile(iter.next());  
                if(file != null){  
                    //ȡ�õ�ǰ�ϴ��ļ����ļ�����  
                    String myFileName = file.getOriginalFilename();  
                    //������Ʋ�Ϊ����,˵�����ļ����ڣ�����˵�����ļ�������  
                    if(myFileName.trim() !=""){  
                        System.out.println(myFileName);  
                        //�������ϴ�����ļ���  
                        String fileName = "demoUpload" + file.getOriginalFilename();  
                        //�����ϴ�·��  
                        String path = "H:/" + fileName;  
                        File localFile = new File(path);  
                        file.transferTo(localFile);  
                    }  
                }  
                //��¼�ϴ����ļ����ʱ��  
                int finaltime = (int) System.currentTimeMillis();  
                System.out.println(finaltime - pre);  
            }  
              
        }  
        return "/success";  
    }  
      
    @RequestMapping("/toUpload" )   
    public String toUpload() {  
          
        return "/upload";  
    }  
      
}  