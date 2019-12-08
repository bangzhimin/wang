package main;
import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class MyButton1 extends Button{
	public MyButton1() {
		setLabel("Choose couse");
		setBounds(10,100,100,150);
 		setBackground(Color.orange);
	}
}
class MyButton2 extends Button{
	public MyButton2() {
        setLabel("Back course");	
		setBounds(10,200,100,250);
 		setBackground(Color.green);
		
	}
}

class MyTextField extends TextField{
	public MyTextField() {
		setBounds(110, 100,350,300);//左边距,上边距,右边距,下边距
 	    setBackground(Color.white);
	}
}
class MyTextField1 extends TextField{
	public MyTextField1() {
		setBounds(100, 50, 80, 40);
 	    setBackground(Color.yellow);	
	}
}
class MyTextField2 extends TextField{
	public MyTextField2() {
		setBounds(300, 50, 80, 40);
 	    setBackground(Color.yellow);	
	}
}
class MyFrame extends Frame{
	public MyFrame() {
		 setTitle("Frame");
    	 FlowLayout fl = new FlowLayout();  
         setLayout(fl);
         setSize(500, 400);
         setLocation(300, 200);
         setVisible(true); 
	}
}
class MyWinddow extends WindowAdapter{
	public void windowClosing(WindowEvent e){
		Window window=(Window)e.getComponent();
		window.dispose();
		
	}
}
public class TestGUI implements ActionListener   {
	
     public TestGUI() throws IOException {	
		f = new MyFrame();
     	lab1 = new Label("S-NAME:");
     	lab1.setBounds(20, 50, 80, 40);
     	lab2 = new Label("S-COURSE:");
     	lab2.setBounds(200, 50, 80, 40);
     	tf = new MyTextField();
     	tf1 = new MyTextField1();
     	tf2 = new MyTextField2();
     	b1= new MyButton1();
  		b2= new MyButton2();		
		b1.addActionListener(this);
	    b2.addActionListener(new  ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String namet=tf1.getText();
				    String courset=tf2.getText();
					tf.setText(namet+" Already withdraw this course: " +courset);				
					sb = new StringBuffer(4096);
					temp = null;
					br = new BufferedReader(new FileReader(f1)); 
					while((temp = br.readLine())!= null){ 
					       if ((temp.indexOf(namet))==-1) {
					    	   sb.append(temp).append("\r\n");
						}       
					} 
					br.close(); 
					bw = new BufferedWriter((new FileWriter(f1))); 
					bw.write(sb.toString()); 
					bw.close();
				} catch (IOException e) {
					System.out.println("文件传输错误");
				}
			}
		});     
	     f.add(tf); 
	     f.add(lab1);
	     f.add(tf1);
	     f.add(lab2);
	     f.add(tf2);
	     f.add(b1);
 		 f.add(b2);
         f.setLayout(null);//清空布局
         f.addWindowListener(new MyWinddow());
         
	}
	public void actionPerformed(ActionEvent arg0) {
		String name = tf1.getText();
		String scourse = tf2.getText();
		course=new Course(1, scourse, "综合楼",3,3);
		teacher=new Teacher(1, "张世博", "男",course);
		stu=new Student(1,name, "男",course,teacher);
		if (name.length()==0&& scourse.length()==0) {
			tf.setText("请输入选课信息");	
		} else if (name.length()==0) {
			tf.setText("请输入姓名");
		}else if (scourse.length()==0) {
				tf.setText("请输入课程");
		}else {	   	   
      	    tf.setText(" " +stu+ " ");
      	    try {
      	    	out=new FileWriter(f1,true);
      	    	out.write("\\"+stu.getName()+"\\"+stu.getCourse()+"\\"+stu.getTeather()+"\n");
      	    	out.flush();
      	    	out.close();
			} catch (IOException e) {
				System.out.println("文件传输错误");
			}
		}	
	}
    public static void main(String[] args) throws IOException {
	    TestGUI test = new TestGUI();	   
	   }
    //声明组件变量
    MyFrame f;
	MyTextField tf;
	MyTextField1 tf1;
	MyTextField2 tf2;
	MyButton1 b1;
	MyButton2 b2;
	Label lab1 ;
	Label lab2 ;
	Course course;
	Teacher teacher;
	Student stu;
	//声明文件流的读写变量
	File f1= new File(".."+File.separator+"选课.txt"); 
	FileWriter out;
	BufferedReader br;
	BufferedWriter bw ;
	String temp; //声明取出的一行字符串,通过while循环存入缓存中
	StringBuffer sb ;//声明字符串缓存区,对取出的数据进行缓存
}



