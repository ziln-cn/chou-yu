package com.hubstc.lottery;

public abstract class Person {
    protected String no2;
    protected String name2;
    protected int type;

    public static final int TYPE_DEFAULT=0;
    public static final int TYPE_STUDENT=1;
    public static final int TYPE_TEACHER=2;
    //������Ա����

    public Person(String no2, String name2, int typeStudent) {
        // TODO Auto-generated constructor stub
    }
    public String getNo2() {
        return no2;
    }
    public void setNo(String no2) {
        this.no2 = no2;
    }
    public String getName2() {
        return name2;
    }
    public void setName(String name2) {
        this.name2 = name2;
    }
    public int getType() {
        return type;
    }
    public void setType(int type) {
        this.type = type;
    }
    //��װ
    public abstract String getTiTle();
    public abstract String getPicPath();
    
}
//Person����
