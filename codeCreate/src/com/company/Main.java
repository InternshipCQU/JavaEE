package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String point = "div";
        int imgCount = 0;
        int divCount = 0;

        File file = new File("/Users/lasuerte/Desktop/暑期实习/JavaEE/codeCreate/src/com/company/origin.html");
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                tempString = tempString.trim();
                if(tempString.contains("</div>")){
                    divCount = divCount - 1;
                }else if(tempString.contains("<div")){
                    divCount = divCount + 1;
                    point = "div";
                    System.out.println("var $div" + divCount + " = $(\"<div></div>\");");

                    if(tempString.contains("class")){
                        if(tempString.contains("post")){
                            System.out.println("$div" + divCount + ".attr('class','post');");
                        }
                    }
                    if(tempString.contains("uk-dropdown")){
                        System.out.println("$div" + divCount + ".attr('uk-dropdown','pos: top-right;mode:hover');");
                    }

                    if(divCount != 1){
                        int temp = divCount-1;
                        if(point.equals("div")){
                            temp = divCount-1;
                        }else if(point.equals("img")){
                            temp = imgCount-1;
                        }else{

                        }

                        System.out.println("$div"+ temp +".append($div"+divCount+")");
                    }

                }

                if(tempString.contains("<img")){
                    System.out.println(tempString.indexOf("class"));
                    System.out.println("line " + line + ": " + tempString.trim());
                }
                //System.out.println("line " + line + ": " + tempString.trim());
                line++;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
    }
}
