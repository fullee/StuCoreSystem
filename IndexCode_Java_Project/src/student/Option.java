package student;

import java.util.Scanner;
//功能选项类
class Option{
	static Scanner inO = new Scanner(System.in);
	
	//退出系统
	public static void exit(){
		System.out.println("感谢您的使用，本系统由[周栋-李文良-夏超亭]设计");
		System.exit(0);
	}
	//帮助系统
	public static int help(){
		System.out.println("==============HELP SYSTEM==============");
		System.out.println("[用法帮助]");
		System.out.println("0.提示符，为时间提示和操作提示！");
		System.out.println("1.按提示符要求输入，如：<back> [10:37:33]#:	back");
		System.out.println("2.选择角色菜单，可以执行1,2操作，分别为学生老师不同身份，进入后操作选项不同！");
		System.out.println("3.教师端可以执行本系统的全功能，教师身份权限较大，请谨慎操作！");
		System.out.println("4.学生端只能执行本系统的部分功能");
		System.out.println("\n[设计小组]");
		System.out.println("姓名：\t周栋 李文良 夏超亭");
		System.out.println("分工：\t后期处理，编码，帮助文档，程序测试，数据表录入，命令界面设计");
		System.out.println("\n[开源协议]\tMIT");
		System.out.println("\n[设计思路]\t仿Linux终端界面");
		//退出帮助
		System.out.println();
		System.out.print("<back> "+Front.time());
		String exit = inO.next();
		while(!(exit.equals("back"))){
			System.out.print("<back> "+Front.time());
			exit = inO.next();			
		}
		//inO.close();
		return 0;
	}
	//插入学生信息系统
	public int insertOption(){
		System.out.println("======================插入学生信息系统======================");
		System.out.print("<条数><back> "+Front.time());
		String count = inO.next();
		if(count.equals("back")){
			return 0;
		}
		int countx = Integer.parseInt(count);
		for(int i = 1; i <= countx; i++){
			System.out.println("当前"+i+">>>>>>>>>————————————————————————————————总计："+countx+"\n");
			System.out.print("<2014 0414 0001>—学号>>>");
			long id = inO.nextLong();
			
			System.out.print("<Xen>————————————姓名>>>");
			String name = inO.next();
			
			System.out.print("<100>————————————英语>>>");
			int eng = inO.nextInt();
			
			System.out.print("<100>————————————语文>>>");
			int chn = inO.nextInt();
			
			System.out.print("<100>————————————数学>>>");
			int math = inO.nextInt();
			//数据库操作函数
			if(Jdbc.getId(id)){
				System.out.println("！警告\t该生已存在，不可重复插入！");
			}
			if(Jdbc.insertMethod(id, name, chn, eng, math)){
				System.out.println("成功插入"+i+">>>>>>>>————————————————————————————————剩余："+(countx-i));
			}else{
				System.out.println("插入失败,检查信息无误后重新插入 ,"+i+">>>>>>>>———————————————剩余："+(countx-i));
			}
		}
		//inO.close();
		System.out.println("\n3s后返回MENU—————————————————————————————————————<<<<<<<<<<结束\n\n");
		try{
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return 0;
	}
	//获取学生全部信息
	public void getAll(){
		System.out.println(">>>>>>>>>>—————————————正在为您列出所有学生的成绩信息—————————————\n");
		
		//数据库函数
		Jdbc.getAllMethod();
		System.out.println("\n3s后返回MENU——————————————————————————————————<<<<<<<<<<<<<\n\n");
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	//avgAllOrder
	public void getAAO(){
		System.out.println(">>>>>>>>>>————————————————————————正在为您列出所有学生的成绩信息————————————————————————\n");
		
		//数据库函数
		Jdbc.avgOrderMethod();
		System.out.println("\n3s后返回MENU————————————————————————————————————————————————————————<<<<<<<<<<<<<\n\n");
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	//查找记录
	public int findStu(){
		System.out.println("====================成绩查询系统====================");
		
		System.out.print("<ID><back>"+Front.time());
		String id = inO.next();
		while(!(id.equals("back"))){
			//查询数据库
			if(Jdbc.findIdMethod(Long.parseLong(id))){
				System.out.print("<ID><back>"+Front.time());
				id = inO.next();
			}else{
				System.out.println("无此学生");
				System.out.print("<ID><back>"+Front.time());
				id = inO.next();
			}
		}
		return 0;
	}

	//delete
	public int deleteId(){
		System.out.println("\n====================信息删除系统====================");
		
			System.out.print("<ID><back><all> "+Front.time());
			String id = inO.next();
			while(!(id.equals("back"))){
				
				if(id.equals("all")){
					System.out.print("！警告\t执行此步将清空数据库,不可恢复（Y/N?）");
					String bool = inO.next();
					if(bool.toLowerCase().equals("y")){
						if(Jdbc.deleteAllMethod()){
							System.out.println("@提示\t数据库已清空！");
							try{
								Thread.sleep(2000);
							}catch(Exception e){
								e.printStackTrace();
							}	
							return 0;
						}else{
							System.out.println("！警告\t清空失败！");
							System.out.print("<ID><back><all> "+Front.time());
							id = inO.next();
						}
					}
				}
				if(!(id.equals("all"))){
					//数据库查询
					if(Jdbc.getId(Long.parseLong(id))){
						//数据库删除函数
						if(Jdbc.deleteIdMethod(Long.parseLong(id))){
							System.out.println(":)");
							System.out.print("<ID><back><all> "+Front.time());
							id = inO.next();
						}else{
							System.out.println("!警告\t删除失败，清查正后再式！");
							System.out.print("<ID><back><all> "+Front.time());
							id = inO.next();
						}
					}else{
						System.out.println("@提示\t学号有误，请重试！");
						System.out.print("<ID><back><all> "+Front.time());
						id = inO.next();
					}
					try{
						Thread.sleep(2000);
					}catch(Exception e){
						e.printStackTrace();
					}	
				}
		}
		System.out.println("======================成功退出删除系统======================\n\n");
		//inO.close();
		return 0;
	}

	//分段查询
	public void subQuery(){
		int max = 0;
		int min = 0;
		int M[];
		M = new int[2];
		M = Jdbc.getM(max, min);
		min = M[0];
		max = M[1];
		if(min == max || min == -1){
			System.out.println("数据无波动或无数据！");
		}else{
			System.out.print("键入分段依据：<"+min+"~"+max+">"+Front.time());
			int input = inO.nextInt();
			Jdbc.subMethod(min, max, input);
		}
		
	}
}