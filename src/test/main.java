package test;

import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

class Student extends Person{

    public Student(String no,String name) {
        super(no,name,Person.TYPE_STUDENT);
        // TODO Auto-generated constructor stub
    }

    @Override
    public String getTiTle() {
        // TODO Auto-generated method stub
        String title="ѧ��"+no2+"����:"+name2;
        return null;
    }
    //���췽��

}
//ѧ����Ϣ


class Teacher extends Person {
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

}
//��ʦ��Ϣ


class DefaultPerson extends Person{

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

}
//������



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
//�ж��Լ�����������ʵ������



abstract class Person {


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

}
//Person����


public class main extends JFrame {

    private ButtonGroup group=new ButtonGroup();
    private JRadioButton rbStu=new JRadioButton("ѧ��");
    private JRadioButton rbTracher=new JRadioButton("��ʦ");

    private JButton btnStart=new JButton("��ʼ�齱");
    private JButton btnReset=new JButton("���ó齱���");

    private JLabel picLabel=new JLabel("ͼƬ",JLabel.CENTER);
    private JLabel titleLabel=new JLabel("�����Ƽ�ְҵѧԺ",JLabel.CENTER);
    //�������



    public main(){
        this.setTitle("����齱ϵͳ");
        this.setBounds(650, 200, 450, 600);
        this.setResizable(false);
        BackgroundPanel bp=new BackgroundPanel(Toolkit.getDefaultToolkit().
                getImage(main.class.getResource("/imgs/main.png"))); //��ȡͼƬ �������
        this.setContentPane(bp);


        btnStart.setBounds(40, 20, 120, 40);
        btnReset.setBounds(180, 20, 120, 40);
        bp.add(btnStart);bp.add(btnReset);


        group.add(rbStu);group.add(rbTracher);
        rbStu.setBounds(320, 10, 100, 20);
        rbTracher.setBounds(320, 35, 100, 20);
        bp.add(rbStu);bp.add(rbTracher);

        picLabel.setBounds(90, 85, 250, 300);
        titleLabel.setBounds(60, 380, 300, 50);
        Font font=new Font("����",Font.BOLD,24);
        titleLabel.setFont(font);
        bp.add(titleLabel);bp.add(picLabel);
    }
    //���췽��

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        main frame=new main();
        frame.setVisible(true);
    }

}
//������