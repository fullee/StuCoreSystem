package student;

import java.util.Scanner;
//����ѡ����
class Option{
	static Scanner inO = new Scanner(System.in);
	
	//�˳�ϵͳ
	public static void exit(){
		System.out.println("��л����ʹ�ã���ϵͳ��[�ܶ�-������-�ĳ�ͤ]���");
		System.exit(0);
	}
	//����ϵͳ
	public static int help(){
		System.out.println("==============HELP SYSTEM==============");
		System.out.println("[�÷�����]");
		System.out.println("0.��ʾ����Ϊʱ����ʾ�Ͳ�����ʾ��");
		System.out.println("1.����ʾ��Ҫ�����룬�磺<back> [10:37:33]#:	back");
		System.out.println("2.ѡ���ɫ�˵�������ִ��1,2�������ֱ�Ϊѧ����ʦ��ͬ��ݣ���������ѡ�ͬ��");
		System.out.println("3.��ʦ�˿���ִ�б�ϵͳ��ȫ���ܣ���ʦ���Ȩ�޽ϴ������������");
		System.out.println("4.ѧ����ֻ��ִ�б�ϵͳ�Ĳ��ֹ���");
		System.out.println("\n[���С��]");
		System.out.println("������\t�ܶ� ������ �ĳ�ͤ");
		System.out.println("�ֹ���\t���ڴ������룬�����ĵ���������ԣ����ݱ�¼�룬����������");
		System.out.println("\n[��ԴЭ��]\tMIT");
		System.out.println("\n[���˼·]\t��Linux�ն˽���");
		//�˳�����
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
	//����ѧ����Ϣϵͳ
	public int insertOption(){
		System.out.println("======================����ѧ����Ϣϵͳ======================");
		System.out.print("<����><back> "+Front.time());
		String count = inO.next();
		if(count.equals("back")){
			return 0;
		}
		int countx = Integer.parseInt(count);
		for(int i = 1; i <= countx; i++){
			System.out.println("��ǰ"+i+">>>>>>>>>�����������������������������������������������������������������ܼƣ�"+countx+"\n");
			System.out.print("<2014 0414 0001>��ѧ��>>>");
			long id = inO.nextLong();
			
			System.out.print("<Xen>����������������������������>>>");
			String name = inO.next();
			
			System.out.print("<100>������������������������Ӣ��>>>");
			int eng = inO.nextInt();
			
			System.out.print("<100>����������������������������>>>");
			int chn = inO.nextInt();
			
			System.out.print("<100>��������������������������ѧ>>>");
			int math = inO.nextInt();
			//���ݿ��������
			if(Jdbc.getId(id)){
				System.out.println("������\t�����Ѵ��ڣ������ظ����룡");
			}
			if(Jdbc.insertMethod(id, name, chn, eng, math)){
				System.out.println("�ɹ�����"+i+">>>>>>>>����������������������������������������������������������������ʣ�ࣺ"+(countx-i));
			}else{
				System.out.println("����ʧ��,�����Ϣ��������²��� ,"+i+">>>>>>>>������������������������������ʣ�ࣺ"+(countx-i));
			}
		}
		//inO.close();
		System.out.println("\n3s�󷵻�MENU��������������������������������������������������������������������������<<<<<<<<<<����\n\n");
		try{
			Thread.sleep(2000);
		}catch(Exception e){
			e.printStackTrace();
		}		
		return 0;
	}
	//��ȡѧ��ȫ����Ϣ
	public void getAll(){
		System.out.println(">>>>>>>>>>������������������������������Ϊ���г�����ѧ���ĳɼ���Ϣ��������������������������\n");
		
		//���ݿ⺯��
		Jdbc.getAllMethod();
		System.out.println("\n3s�󷵻�MENU��������������������������������������������������������������������<<<<<<<<<<<<<\n\n");
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	//avgAllOrder
	public void getAAO(){
		System.out.println(">>>>>>>>>>����������������������������������������������������Ϊ���г�����ѧ���ĳɼ���Ϣ������������������������������������������������\n");
		
		//���ݿ⺯��
		Jdbc.avgOrderMethod();
		System.out.println("\n3s�󷵻�MENU����������������������������������������������������������������������������������������������������������������<<<<<<<<<<<<<\n\n");
		try{
			Thread.sleep(5000);
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	//���Ҽ�¼
	public int findStu(){
		System.out.println("====================�ɼ���ѯϵͳ====================");
		
		System.out.print("<ID><back>"+Front.time());
		String id = inO.next();
		while(!(id.equals("back"))){
			//��ѯ���ݿ�
			if(Jdbc.findIdMethod(Long.parseLong(id))){
				System.out.print("<ID><back>"+Front.time());
				id = inO.next();
			}else{
				System.out.println("�޴�ѧ��");
				System.out.print("<ID><back>"+Front.time());
				id = inO.next();
			}
		}
		return 0;
	}

	//delete
	public int deleteId(){
		System.out.println("\n====================��Ϣɾ��ϵͳ====================");
		
			System.out.print("<ID><back><all> "+Front.time());
			String id = inO.next();
			while(!(id.equals("back"))){
				
				if(id.equals("all")){
					System.out.print("������\tִ�д˲���������ݿ�,���ɻָ���Y/N?��");
					String bool = inO.next();
					if(bool.toLowerCase().equals("y")){
						if(Jdbc.deleteAllMethod()){
							System.out.println("@��ʾ\t���ݿ�����գ�");
							try{
								Thread.sleep(2000);
							}catch(Exception e){
								e.printStackTrace();
							}	
							return 0;
						}else{
							System.out.println("������\t���ʧ�ܣ�");
							System.out.print("<ID><back><all> "+Front.time());
							id = inO.next();
						}
					}
				}
				if(!(id.equals("all"))){
					//���ݿ��ѯ
					if(Jdbc.getId(Long.parseLong(id))){
						//���ݿ�ɾ������
						if(Jdbc.deleteIdMethod(Long.parseLong(id))){
							System.out.println(":)");
							System.out.print("<ID><back><all> "+Front.time());
							id = inO.next();
						}else{
							System.out.println("!����\tɾ��ʧ�ܣ����������ʽ��");
							System.out.print("<ID><back><all> "+Front.time());
							id = inO.next();
						}
					}else{
						System.out.println("@��ʾ\tѧ�����������ԣ�");
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
		System.out.println("======================�ɹ��˳�ɾ��ϵͳ======================\n\n");
		//inO.close();
		return 0;
	}

	//�ֶβ�ѯ
	public void subQuery(){
		int max = 0;
		int min = 0;
		int M[];
		M = new int[2];
		M = Jdbc.getM(max, min);
		min = M[0];
		max = M[1];
		if(min == max || min == -1){
			System.out.println("�����޲����������ݣ�");
		}else{
			System.out.print("����ֶ����ݣ�<"+min+"~"+max+">"+Front.time());
			int input = inO.nextInt();
			Jdbc.subMethod(min, max, input);
		}
		
	}
}