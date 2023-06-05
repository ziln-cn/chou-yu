package com.hubstc.lottery;

public class Student extends Person{

    public Student(String no,String name) {
        super(no,name,Person.TYPE_STUDENT);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getTiTle() {
        // TODO Auto-generated method stub
        String title="学号"+no2+"姓名:"+name2;
        return title;
    }
    //构造方法

	@Override
	public String getPicPath() {
		// TODO Auto-generated method stub
		String path="/imgs/student/"+no2+".jpg";
		return path;
	}

}
//学生信息
