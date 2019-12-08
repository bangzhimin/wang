综合性实验  学生选课系统设计
===
一、实验目的
---
分析学生选课系统
使用GUI窗体及其组件设计窗体界面
完成学生选课过程业务逻辑编程
基于文件保存并读取数据
处理异常

二、实验要求
----
一、系统角色分析及类设计
学校有“人员”，分为“教师”和“学生”，教师教授“课程”，学生选择课程。
定义每种角色人员的属性，及其操作方法。
二、要求:
1、	设计GUI窗体，支持课程新加、学生选课、学生退课、打印学生选课列表等操作。
2、	基于事件模型对业务逻辑编程，实现在界面上支持上述操作。
3、	针对操作过程中可能会出现的各种异常，做异常处理
4、	基于输入/输出编程，支持学生数据在文本文件中的读取和写入(选课和退课)。


三、实验流程
----
1.	了解模型构架,构思用户需求
2.	新建Java项目并创建相应的类包
3.	设计角色类(人员\学生\老师\课程),界面UI类.
4.	完成各类的基本方法逻辑,和属性变量定义
5.	运行程序并观察实验结果,测试程序健壮性.
6.	进行实验总结

关键代码：
```java
退课操作
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
```java
选课操作
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
```
三 流程图
![image](https://github.com/bangzhimin/wang/blob/master/%E6%B5%81%E7%A8%8B%E5%9B%BE.png)

四 运行结果
![image](https://github.com/bangzhimin/wang/blob/master/%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C.png)
![image](https://github.com/bangzhimin/wang/blob/master/%E8%BF%90%E8%A1%8C%E7%BB%93%E6%9E%9C1.png)

六 实验感想
本次实验需要面型对象的基本编程思想以及类的继承,构造函数的使用,各类之间的调用,GUI组件的使用,监听器的运用,和对文件流的操作基本知识,虽然没有数据库的参与,但是通过文件流的运用,可通过文本文件暂时代替数据库实现对数据的存取功能,
本次实验基本上囊括了Java编程基础,但是要熟练编程还需在下一个项目(可以编写一个简单游戏,如推箱子)进行实际训练,在实践中加强请对基础知识的了解及扩展

