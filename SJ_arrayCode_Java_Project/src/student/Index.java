package student;
import java.lang.*;
import java.util.Scanner;
import java.io.*;
//程序说明，本程序数据储存为数组实现
//改自同学代码
	public class Index{
		
		static Scanner in = new Scanner(System.in);
		public static void main(String[] args){
	//		StudentSet.newstatic();
			while(true){
				Menu.paint();
				int ctrlTag = in.nextInt();
				switch(ctrlTag){
					case 1:Menu.action1();break;
					case 2:Menu.action2();break;
					case 3:Menu.action3();break;
					case 4:Menu.action4();break;
					case 5:Menu.action5();break;
					case 6:Menu.action6();break;
					case 0:System.exit(0);break;
				}
			}
		}
	}


class Student{
	private int number;
	private String name;
	private int english;
	private int math;
	private int computer;
	private int average;
	private int total;

	public Student(int number, String name, int english, int math, int computer){		    
		this.number = number;
		this.name = name;
		this.english = english;
		this.math = math;
		this.computer = computer;
		this.total = english + math + computer;
		this.average = total/3;
	}
	
	public int getNumber(){
		return number;
	}
	public String getName(){
		return name;
	}
	public int getEnglish(){
		return english;
	}
	public int getMath(){
		return math;
	}
	public int getComputer(){
		return computer;
	}
	public int getAverage(){
		return average;
	}
	public int getTotal(){
		return total;
	}
}

