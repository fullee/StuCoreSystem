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
					//重选角色
					if(option.equals("back")) break;					
					//功能
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
					
						default:System.out.println("!警告\t你的想法非常好，开发者正在玩命开发中，试试其他功能吧！");
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
					//重选角色
					if(option.equals("back")) break;
					
					//功能
					Option item = new Option();
					switch(option){
					case "exit":Option.exit();break;
					
					case "help":Option.help();break;
					
					case "1":item.findStu();break;
					
					case "2":item.getAAO();break;
				
					default:System.out.println("!警告\t你的想法非常好，开发者正在玩命开发中，试试其他功能吧！");
					try{
						Thread.sleep(2000);
					}catch(Exception e){
						e.printStackTrace();
					}
					}
				}
				
				if(!role.equals("1") && !role.equals("2")){
					System.out.println("!警告\t请确定身份后再次输入");
					System.out.print(Front.role());
					role = in.next();
				}				
			}
		}
	}
}