package student;

import student.Jdbc;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Index {

	public static void main(String[] args) {
		
		while(true){
			Scanner in = new Scanner(System.in);
			Front front = new Front();
			
			String role = in.next();
			while(true){
				
				if(role.equals("1")){

					front.subFront();

					System.out.print("Welcome,TeA! "+Front.time());
					String option = in.next();
					//��ѡ��ɫ
					if(option.equals("back")) break;					
					//����
					Option item = new Option();
					switch(option){
						case "exit":Option.exit();break;
						
						case "help":Option.help();break;
						
						case "1":item.insertOption();break;
						
						case "2":item.getAll();break;
						
						case "3":item.getAAO();break;
						
						case "4":item.findStu();break;
						
						case "5":item.subQuery();break;
						
						case "6":item.deleteId();break;
					
						default:System.out.println("!����\t����뷨�ǳ��ã��������������������У������������ܰɣ�");
						try{
							Thread.sleep(2000);
						}catch(Exception e){
							e.printStackTrace();
						}
					}
				}
				if(role.equals("2")){
					Front.stuFront();
					System.out.print("Welcome,Stu! "+Front.time());
					String option = in.next();
					//��ѡ��ɫ
					if(option.equals("back")) break;
					
					//����
					Option item = new Option();
					switch(option){
					case "exit":Option.exit();break;
					
					case "help":Option.help();break;
					
					case "1":item.findStu();break;
					
					case "2":item.getAAO();break;
				
					default:System.out.println("!����\t����뷨�ǳ��ã��������������������У������������ܰɣ�");
					try{
						Thread.sleep(2000);
					}catch(Exception e){
						e.printStackTrace();
					}
					}
				}
				
				if(!role.equals("1") && !role.equals("2")){
					System.out.println("!����\t��ȷ����ݺ��ٴ�����");
					System.out.print(Front.role());
					role = in.next();
				}				
			}
		}
	}
}