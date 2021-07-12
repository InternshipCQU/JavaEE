package com.example.demo.entity;

import static java.lang.Math.max;

public class TagMark {

    private int tagId1;
    private int tagId2;
    private int tagId3;
    private int tagId4;
    private int tagId5;

    public TagMark(int tagId1, int tagId2, int tagId3, int tagId4, int tagId5) {
        this.tagId1 = tagId1;
        this.tagId2 = tagId2;
        this.tagId3 = tagId3;
        this.tagId4 = tagId4;
        this.tagId5 = tagId5;
    }

    public int getRecommendTag(){
        int i = max(tagId1, tagId2);
        int j = max(tagId3, tagId4);
        int k = max(i, j);
        return max(k, tagId5);
    }

    public int getTagId1() {
        return tagId1;
    }

    public void setTagId1(int tagId1) {
        this.tagId1 = tagId1;
    }

    public int getTagId2() {
        return tagId2;
    }

    public void setTagId2(int tagId2) {
        this.tagId2 = tagId2;
    }

    public int getTagId3() {
        return tagId3;
    }

    public void setTagId3(int tagId3) {
        this.tagId3 = tagId3;
    }

    public int getTagId4() {
        return tagId4;
    }

    public void setTagId4(int tagId4) {
        this.tagId4 = tagId4;
    }

    public int getTagId5() {
        return tagId5;
    }

    public void setTagId5(int tagId5) {
        this.tagId5 = tagId5;
    }
}
