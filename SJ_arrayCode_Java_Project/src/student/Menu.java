package student;

import java.util.Scanner;

class Menu{
	//��ʾ
	public static void paint(){
		clrscr();
		System.out.println(">>>������������������������������������ѧ���ɼ�����ϵͳ��������������������������������������<<<");
		System.out.println();
		System.out.println("               1 �����¼\t\t2 ������м�¼");
		System.out.println("               3 ��ƽ���ɼ��������\t4 ���Ҽ�¼");
		System.out.println("               5 ͳ�Ƹ�����������\t6 ɾ����¼");
		System.out.println("               0 �˳�");
		System.out.println();
		System.out.println(">>>������������������������������������������������������������������������������������������������<<<");
		System.out.println();
		System.out.print("���������");
	}
	
	//����¼��
	static Scanner in = new Scanner(System.in);
	public static int action1(){
		while(true){
			clrscr();
			System.out.print("�������¼��ѧ��[-1 �˳�]��");
			int number = in.nextInt();
			if (number != -1){
				
				System.out.print("������");
				String name = in.next();
				System.out.print("Ӣ�");
				int english = in.nextInt();
				System.out.print("��ѧ��");
				int math = in.nextInt();
				System.out.print("�������");
				int computer = in.nextInt();
				Student newData = new Student(number, name, english, math, computer);
				
				if (StudentSet.addData(newData) == -1){
					System.out.println("@��ʾ\t���������");
					return -2;
				}
			} else{
				return -1;
			}
		}
	}
  //������м�¼
	public static void action2(){
		clrscr();
		if (StudentSet.getLen() == 0){
			System.out.println("@��ʾ\tû�м�¼��");
		} else{
			System.out.println("ѧ��\t|����\t|��ѧ\t|Ӣ��\t|�����\t|ƽ��\t|�ܼ�");
			for (int i = 0; i < StudentSet.getLen(); i++){				
				System.out.println(StudentSet.getData(i).getNumber()+"\t|"+StudentSet.getData(i).getName()+"\t|"+StudentSet.getData(i).getMath()+"\t|"+StudentSet.getData(i).getEnglish()+"\t|"+StudentSet.getData(i).getComputer()+"\t|"+StudentSet.getData(i).getAverage()+"\t|"+StudentSet.getData(i).getTotal());
			}
		}
	}
  //����
	public static void action3(){
		StudentSet.sortData();
		action2();
	}
  //����
	public static void action4(){
		clrscr();
		System.out.print("������ѧ�ţ�");
		int number = in.nextInt();
		int i;
		if((i = StudentSet.search(number)) != -1){
			clrscr();
			System.out.println("ѧ��\t|����\t|��ѧ\t|Ӣ��\t|�����\t|ƽ��\t|�ܼ�");			
			System.out.println(StudentSet.getData(i).getNumber()+"\t|"+StudentSet.getData(i).getName()+"\t|"+StudentSet.getData(i).getMath()+"\t|"+StudentSet.getData(i).getEnglish()+"\t|"+StudentSet.getData(i).getComputer()+"\t|"+StudentSet.getData(i).getAverage()+"\t|"+StudentSet.getData(i).getTotal());
		}else{
			System.out.println("@��ʾ\tû���ҵ���Ӧ�ļ�¼��");
		}
	}
  //�ֶ�
	public static void action5(){
		clrscr();
		System.out.println("��ƽ���ֶַ������");
		System.out.println("90-100: "+StudentSet.stat(90, 100)+"��");
		System.out.println("80-89: "+StudentSet.stat(80, 89)+"��");
		System.out.println("70-79: "+StudentSet.stat(70, 79)+"��");
		System.out.println("60-69: "+StudentSet.stat(60, 69)+"��");
		System.out.println("0-59: "+StudentSet.stat(0, 59)+"��");
	}

  //ɾ��
	public static void action6(){
		while(true){
			clrscr();
			System.out.print("������Ҫɾ����¼��ѧ��[-1 �˳�]��");
			int number = in.nextInt();
			if (number != -1){
				if(StudentSet.delete(number) == -1){
					System.out.println("@��ʾ\tû���ҵ���Ӧ�ļ�¼��");
					return;
				}else{
					System.out.println("@��ʾ\tɾ����¼�ɹ���");
				}
			} else{
				return;
			}
		}
	}
	//�ո�
	public static void clrscr(){ //temp function
		System.out.println();
		System.out.println();
	}
}