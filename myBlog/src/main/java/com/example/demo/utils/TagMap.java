package com.example.demo.utils;

import java.util.Map;

public class TagMap {

    private Map<Integer, String> map;

    public TagMap(){
        assert false;
        map.put(1, "tagId1");
        map.put(2, "tagId2");
        map.put(3, "tagId3");
        map.put(4, "tagId4");
        map.put(5, "tagId5");
    }

    public String getTagName(int i){
        return map.get(i);
    }
}
