package student;

import java.util.Scanner;

class Menu{
	//显示
	public static void paint(){
		clrscr();
		System.out.println(">>>——————————————————学生成绩管理系统———————————————————<<<");
		System.out.println();
		System.out.println("               1 输入记录\t\t2 输出所有记录");
		System.out.println("               3 按平均成绩排序并输出\t4 查找记录");
		System.out.println("               5 统计各分数段人数\t6 删除记录");
		System.out.println("               0 退出");
		System.out.println();
		System.out.println(">>>————————————————————————————————————————————————<<<");
		System.out.println();
		System.out.print("请输入命令：");
	}
	
	//数据录入
	static Scanner in = new Scanner(System.in);
	public static int action1(){
		while(true){
			clrscr();
			System.out.print("待输入记录的学号[-1 退出]：");
			int number = in.nextInt();
			if (number != -1){
				
				System.out.print("姓名：");
				String name = in.next();
				System.out.print("英语：");
				int english = in.nextInt();
				System.out.print("数学：");
				int math = in.nextInt();
				System.out.print("计算机：");
				int computer = in.nextInt();
				Student newData = new Student(number, name, english, math, computer);
				
				if (StudentSet.addData(newData) == -1){
					System.out.println("@提示\t数据溢出！");
					return -2;
				}
			} else{
				return -1;
			}
		}
	}
  //输出所有记录
	public static void action2(){
		clrscr();
		if (StudentSet.getLen() == 0){
			System.out.println("@提示\t没有记录！");
		} else{
			System.out.println("学号\t|姓名\t|数学\t|英语\t|计算机\t|平均\t|总计");
			for (int i = 0; i < StudentSet.getLen(); i++){				
				System.out.println(StudentSet.getData(i).getNumber()+"\t|"+StudentSet.getData(i).getName()+"\t|"+StudentSet.getData(i).getMath()+"\t|"+StudentSet.getData(i).getEnglish()+"\t|"+StudentSet.getData(i).getComputer()+"\t|"+StudentSet.getData(i).getAverage()+"\t|"+StudentSet.getData(i).getTotal());
			}
		}
	}
  //排序
	public static void action3(){
		StudentSet.sortData();
		action2();
	}
  //查找
	public static void action4(){
		clrscr();
		System.out.print("请输入学号：");
		int number = in.nextInt();
		int i;
		if((i = StudentSet.search(number)) != -1){
			clrscr();
			System.out.println("学号\t|姓名\t|数学\t|英语\t|计算机\t|平均\t|总计");			
			System.out.println(StudentSet.getData(i).getNumber()+"\t|"+StudentSet.getData(i).getName()+"\t|"+StudentSet.getData(i).getMath()+"\t|"+StudentSet.getData(i).getEnglish()+"\t|"+StudentSet.getData(i).getComputer()+"\t|"+StudentSet.getData(i).getAverage()+"\t|"+StudentSet.getData(i).getTotal());
		}else{
			System.out.println("@提示\t没有找到相应的记录！");
		}
	}
  //分段
	public static void action5(){
		clrscr();
		System.out.println("按平均分分段输出：");
		System.out.println("90-100: "+StudentSet.stat(90, 100)+"人");
		System.out.println("80-89: "+StudentSet.stat(80, 89)+"人");
		System.out.println("70-79: "+StudentSet.stat(70, 79)+"人");
		System.out.println("60-69: "+StudentSet.stat(60, 69)+"人");
		System.out.println("0-59: "+StudentSet.stat(0, 59)+"人");
	}

  //删除
	public static void action6(){
		while(true){
			clrscr();
			System.out.print("请输入要删除记录的学号[-1 退出]：");
			int number = in.nextInt();
			if (number != -1){
				if(StudentSet.delete(number) == -1){
					System.out.println("@提示\t没有找到相应的记录！");
					return;
				}else{
					System.out.println("@提示\t删除记录成功！");
				}
			} else{
				return;
			}
		}
	}
	//空格
	public static void clrscr(){ //temp function
		System.out.println();
		System.out.println();
	}
}