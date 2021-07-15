package com.example.demo.constants;

import java.util.HashMap;

public class MapofTagNameAndTagID {
    public HashMap<String,Integer> map;

    public MapofTagNameAndTagID(){
        this.map = new HashMap<String,Integer>();
        map.put("TensorFlow",1);
        map.put("NumPy",2);
        map.put("IntelliJ IDEA",3);
        map.put("Tomcat",4);
        map.put("PyTorch",5);
        map.put("Java EE",6);
        map.put("Django",7);
        map.put("Git",8);
        map.put("Python",9);
        map.put("Java",10);
        map.put("C++",11);
        map.put("html",12);

    }

    public int getTagID(String tagName){
        Integer id = map.get(tagName);
        return id;
    }

}
