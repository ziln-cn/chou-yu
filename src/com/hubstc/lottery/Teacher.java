package com.hubstc.lottery;

public class Teacher extends Person {
    public Teacher(String no2,String name2) {
        super(no2,name2,Person.TYPE_TEACHER);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getTiTle() {
        // TODO Auto-generated method stub
        String title="����"+no2+"����:"+name2;
        return null;
    }
    //���췽��

	@Override
	public String getPicPath() {
		// TODO Auto-generated method stub
		String path="/imgs/Teacher/"+no2+".jpg";
		return path;
	}

}
//��ʦ��Ϣ
