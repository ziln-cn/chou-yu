package com.hubstc.lottery;

public class DefaultPerson extends Person{

    public DefaultPerson() {
        super("", "",Person.TYPE_DEFAULT);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getTiTle() {
        // TODO Auto-generated method stub
        return "�����Ƽ�ְҵѧԺ";
    }
    //���췽��

	@Override
	public String getPicPath() {
		// TODO Auto-generated method stub
		String path="/imgs/"+"logo.jpg";
		return path;
	}

	

}
//������