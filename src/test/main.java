package test;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;

class Student extends Person{

    public Student(String no,String name) {
        super(no,name,Person.TYPE_STUDENT);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getTiTle() {
        // TODO Auto-generated method stub
        String title="学号"+no2+"姓名:"+name2;
        return null;
    }
    //构造方法

}
//学生信息


class Teacher extends Person {
    public Teacher(String no2,String name2) {
        super(no2,name2,Person.TYPE_TEACHER);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getTiTle() {
        // TODO Auto-generated method stub
        String title="工号"+no2+"姓名:"+name2;
        return null;
    }
    //构造方法

}
//老师信息


class DefaultPerson extends Person{

    public DefaultPerson() {
        super("", "",Person.TYPE_DEFAULT);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getTiTle() {
        // TODO Auto-generated method stub
        return "湖北科技职业学院";
    }
    //构造方法

}
//派生类



class PersonFactory{

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



abstract class Person {


    protected String no2;
    protected String name2;
    protected int type;

    public static final int TYPE_DEFAULT=0;
    public static final int TYPE_STUDENT=1;
    public static final int TYPE_TEACHER=2;
    //创建成员变量

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
    //封装
    public abstract String getTiTle();

}
//Person父类


public class main extends JFrame {

    private ButtonGroup group=new ButtonGroup();
    private JRadioButton rbStu=new JRadioButton("学生");
    private JRadioButton rbTeacher=new JRadioButton("教师");

    private JButton btnStart=new JButton("开始抽奖");
    private JButton btnReset=new JButton("重置抽奖结果");

    private JLabel picLabel=new JLabel("图片",JLabel.CENTER);
    private JLabel titleLabel=new JLabel("湖北科技职业学院",JLabel.CENTER);
    //创建组件


    public main(){
        this.setTitle("随机抽奖系统");
        this.setBounds(650, 200, 450, 600);
        this.setResizable(false);
        BackgroundPanel bp=new BackgroundPanel(Toolkit.getDefaultToolkit().
                getImage(main.class.getResource("/imgs/main.png"))); //获取图片 反射机制
        this.setContentPane(bp);
        
        
        Image image = Toolkit.getDefaultToolkit().getImage(main.class.getResource("/imgs/logo.jpg"));
        ImageIcon icon = new ImageIcon(image);
        picLabel.setIcon(icon);
        picLabel.setHorizontalAlignment(JLabel.CENTER); //把校徽放在界面中
 
        
        btnStart.setBounds(40, 20, 120, 40);
        btnReset.setBounds(180, 20, 120, 40);
        bp.add(btnStart);bp.add(btnReset);
        btnStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("开始抽奖");
				btnStart.setEnabled(false);
				btnReset.setEnabled(false);
				rbStu.setSelected(false);
				rbTeacher.setSelected(false);
			}
        	
        });
    
        
        btnReset.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("重置抽奖结果");
				rbStu.setSelected(true);
			}
        	
        });
        
        


        group.add(rbStu);group.add(rbTeacher);
        rbStu.setBounds(320, 10, 100, 20);
        rbTeacher.setBounds(320, 35, 100, 20);
        bp.add(rbStu);bp.add(rbTeacher);
        rbStu.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("学生类别抽奖");
			}
        	
        });
        
        rbTeacher.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("教师类别抽奖");
			}
        	
        });
        

        picLabel.setBounds(90, 85, 250, 300);
        titleLabel.setBounds(60, 380, 300, 50);
        Font font=new Font("微软雅黑",Font.BOLD,24);
        titleLabel.setFont(font);
        titleLabel.setForeground(Color.RED);
        bp.add(titleLabel);bp.add(picLabel);
    }
    //构造方法

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	try{
    		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}//水晶风格
    	
    	
        main frame=new main();
        frame.setVisible(true);
    }

}
//主方法
