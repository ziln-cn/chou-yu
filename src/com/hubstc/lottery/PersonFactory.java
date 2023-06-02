package com.hubstc.lottery;

public class PersonFactory{

    public static Person getPerson(int type,String no2,String name2){
        Person person=null;
        if(no2==null||no2.isEmpty()||name2==null||name2.isEmpty()){
            person=null;
        }else{
            if(type==Person.TYPE_STUDENT){
                person=new Student(no2,name2);
            }else if(type==Person.TYPE_TEACHER){
                person=new Teacher(no2,name2);
            }
        }

        if(person==null){
            person=new DefaultPerson();
        }
        return person;
    }

}
//判断以及工厂化创建实例对象

