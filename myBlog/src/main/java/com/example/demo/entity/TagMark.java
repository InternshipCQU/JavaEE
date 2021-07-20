package com.example.demo.entity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.lang.Math.max;

public class TagMark {

    private int TensorFlow;
    private int NumPy;
    private int PyTorch;
    private int IDEA;
    private int Tomcat;
    private int JavaEE;
    private int Django;
    private int Git;
    private int Python;
    private int Java;
    private int C;
    private int html;

    public TagMark(int tensorFlow, int numPy, int pyTorch, int IDEA, int tomcat, int javaEE, int django, int git, int python, int java, int c, int html) {
        TensorFlow = tensorFlow;
        NumPy = numPy;
        PyTorch = pyTorch;
        this.IDEA = IDEA;
        Tomcat = tomcat;
        JavaEE = javaEE;
        Django = django;
        Git = git;
        Python = python;
        Java = java;
        C = c;
        this.html = html;
    }

    public int getTensorFlow() {
        return TensorFlow;
    }

    public void setTensorFlow(int tensorFlow) {
        TensorFlow = tensorFlow;
    }

    public int getNumPy() {
        return NumPy;
    }

    public void setNumPy(int numPy) {
        NumPy = numPy;
    }

    public int getPyTorch() {
        return PyTorch;
    }

    public void setPyTorch(int pyTorch) {
        PyTorch = pyTorch;
    }

    public int getIDEA() {
        return IDEA;
    }

    public void setIDEA(int IDEA) {
        this.IDEA = IDEA;
    }

    public int getTomcat() {
        return Tomcat;
    }

    public void setTomcat(int tomcat) {
        Tomcat = tomcat;
    }

    public int getJavaEE() {
        return JavaEE;
    }

    public void setJavaEE(int javaEE) {
        JavaEE = javaEE;
    }

    public int getDjango() {
        return Django;
    }

    public void setDjango(int django) {
        Django = django;
    }

    public int getGit() {
        return Git;
    }

    public void setGit(int git) {
        Git = git;
    }

    public int getPython() {
        return Python;
    }

    public void setPython(int python) {
        Python = python;
    }

    public int getJava() {
        return Java;
    }

    public void setJava(int java) {
        Java = java;
    }

    public int getC() {
        return C;
    }

    public void setC(int c) {
        C = c;
    }

    public int getHtml() {
        return html;
    }

    public void setHtml(int html) {
        this.html = html;
    }

    public int getRecommendTag(){
        ArrayList<Integer> a = new ArrayList<>();
        a.add(TensorFlow);
        a.add(NumPy);
        a.add(PyTorch);
        a.add(IDEA);
        a.add(Tomcat);
        a.add(JavaEE);
        a.add(Django);
        a.add(Git);
        a.add(Python);
        a.add(Java);
        a.add(C);
        a.add(html);
        a.sort((o1, o2) -> o2 - o1);
        return a.get(0);
    }

}
