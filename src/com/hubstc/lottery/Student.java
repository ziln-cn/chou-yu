package com.hubstc.lottery;

public class Student extends Person{

    public Student(String no2,String name2) {
        super(no2,name2,Person.TYPE_STUDENT);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getTiTle() {
        // TODO Auto-generated method stub
        String title="ѧ��"+no2+"����:"+name2;
        return title;
    }
    //���췽��

	@Override
	public String getPicPath() {
		// TODO Auto-generated method stub
		String path="/imgs/student/"+no2+".jpg";
		return path;
	}

}
//ѧ����Ϣ
