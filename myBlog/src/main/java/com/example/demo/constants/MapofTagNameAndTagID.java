package com.example.demo.constants;

import org.springframework.data.relational.core.sql.In;

import java.util.HashMap;

public class MapofTagNameAndTagID {
    private HashMap<String,Integer> map1;
    private HashMap<Integer,String> map2;

    public MapofTagNameAndTagID(){

        this.map1 = new HashMap<String,Integer>();
        map1.put("Other",0);
        map1.put("TensorFlow",1);
        map1.put("NumPy",2);
        map1.put("IDEA",3);
        map1.put("Tomcat",4);
        map1.put("PyTorch",5);
        map1.put("JavaEE",6);
        map1.put("Django",7);
        map1.put("Git",8);
        map1.put("Python",9);
        map1.put("Java",10);
        map1.put("C",11);
        map1.put("html",12);

        this.map2 = new HashMap<Integer,String>();
        map2.put(0, "Other");
        map2.put(1, "TensorFlow");
        map2.put(2, "NumPy");
        map2.put(3, "IDEA");
        map2.put(4, "Tomcat");
        map2.put(5, "PyTorch");
        map2.put(6, "JavaEE");
        map2.put(7, "Django");
        map2.put(8, "Git");
        map2.put(9, "Python");
        map2.put(10, "Java");
        map2.put(11, "C");
        map2.put(12, "html");
    }

    public int getTagID(String tagName){
        Integer id = map1.get(tagName);
        return id;
    }

    public String getTagName(int tagId){
        return map2.get(tagId);
    }

}
