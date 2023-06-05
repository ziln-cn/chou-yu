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
    private JRadioButton rbStu=new JRadioButton("ѧ��");
    private JRadioButton rbTeacher=new JRadioButton("��ʦ");
    //��ѡ��ť

    private JButton btnStart=new JButton("��ʼ�齱");
    private JButton btnReset=new JButton("���ó齱���");
    //��ͨ��ť

    private JLabel picLabel=new JLabel("ͼƬ",JLabel.CENTER);
    private JLabel titleLabel=new JLabel("����ְ",JLabel.CENTER);
    //ͼƬ������
    
    private int type=Person.TYPE_STUDENT;//��ȡѡ������
    private List<Person> persons;

    public MainFrameApp(){
        this.setTitle("����齱ϵͳ");
        this.setBounds(650, 200, 450, 600);
        this.setResizable(false);
        BackgroundPanel bp=new BackgroundPanel(Toolkit.getDefaultToolkit().
                getImage(MainFrameApp.class.getResource("/imgs/main.png"))); //��ȡͼƬ �������
        this.setContentPane(bp);
        
        
        btnStart.setBounds(40, 20, 120, 40);
        btnReset.setBounds(180, 20, 120, 40);
        bp.add(btnStart);bp.add(btnReset);
        btnStart.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��ʼ�齱");
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
				System.out.println("���ó齱���");
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
				System.out.println("ѧ�����齱");
				type=Person.TYPE_STUDENT;
				initialData();
			}
        	
        });
        
        rbTeacher.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("��ʦ���齱");
				type=Person.TYPE_TEACHER;
				initialData();
			}
        	
        });
        

        picLabel.setBounds(90, 85, 250, 300);
        titleLabel.setBounds(60, 380, 300, 50);
        Font font=new Font("΢���ź�",Font.BOLD,24);
        titleLabel.setFont(font);
        titleLabel.setForeground(Color.RED);
        bp.add(titleLabel);bp.add(picLabel);
        
          initialUI(); //��ʼ������getTitle picLablel
          initialData(); //��ʼ������
    }
    //���췽��
    
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
    	}//ˮ�����
    	
    	
        MainFrameApp frame=new MainFrameApp();
        frame.setVisible(true);
    }

}
//������