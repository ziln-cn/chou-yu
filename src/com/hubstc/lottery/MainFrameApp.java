package com.hubstc.lottery;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.List;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;


public class MainFrameApp extends JFrame {

    private ButtonGroup group=new ButtonGroup();
    private JRadioButton rbStu=new JRadioButton("学生");
    private JRadioButton rbTeacher=new JRadioButton("教师");
    //多选按钮

    private JButton btnStart=new JButton("开始抽奖");
    private JButton btnReset=new JButton("重置抽奖结果");
    //普通按钮

    private JLabel picLabel=new JLabel("图片",JLabel.CENTER);
    private JLabel titleLabel=new JLabel("湖科职",JLabel.CENTER);
    //图片和文字
    
    private int type=Person.TYPE_STUDENT;//获取选择类型
    private List<Person> persons;

    public MainFrameApp(){
        this.setTitle("随机抽奖系统");
        this.setBounds(650, 200, 450, 600);
        this.setResizable(false);
        BackgroundPanel bp=new BackgroundPanel(Toolkit.getDefaultToolkit().
                getImage(MainFrameApp.class.getResource("/imgs/main.png"))); //获取图片 反射机制
        this.setContentPane(bp);
        
        
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
				rbStu.setSelected(true);
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
				type=Person.TYPE_STUDENT;
				initialData();
			}
        	
        });
        
        rbTeacher.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("教师类别抽奖");
				type=Person.TYPE_TEACHER;
				initialData();
			}
        	
        });
        

        picLabel.setBounds(90, 85, 250, 300);
        titleLabel.setBounds(60, 380, 300, 50);
        Font font=new Font("微软雅黑",Font.BOLD,24);
        titleLabel.setFont(font);
        titleLabel.setForeground(Color.RED);
        bp.add(titleLabel);bp.add(picLabel);
        
          initialUI(); //初始化界面getTitle picLablel
          initialData(); //初始化数据
    }
    //构造方法
    
    private void initialUI(){
    	rbStu.setSelected(true);
    	Person person = PersonFactory.getPerson(Person.TYPE_DEFAULT, "", "");
    	displayUI(person);
    }
    private void displayUI(Person person){
    	titleLabel.setText(person.getTiTle());
    	ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().
    			getImage(MainFrameApp.class.getResource("/imgs/logo.jpg")));
    	picLabel.setIcon(icon);
    }
    
    private void initialData(){
    	try{
    		persons=FileinfoUtils.getFileInfo(type);
            }
    			catch (IOException e) {
                e.printStackTrace();
    	}
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
    	try{
    		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
    	}catch(Exception e)
    	{
    		e.printStackTrace();
    	}//水晶风格
    	
    	
        MainFrameApp frame=new MainFrameApp();
        frame.setVisible(true);
    }

}
//主方法