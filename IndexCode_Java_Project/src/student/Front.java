package student;

import java.text.SimpleDateFormat;
import java.util.Date;
//��ʾ������
class Front{
	public Front(){
		System.out.print("<1��ʦ><2ѧ��>\t��ѡ���û���ɫ>>>");
	}
	public static String role(){
		String role = "<1 ��ʦ><2 ѧ��>  ��ѡ���û���ɫ>>>";
		return role;
	}
	//��ʾ����ʽʱ��
	public static String time(){
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
		String tips = "["+time.format(new Date())+"]#:";
		return tips;
	}
	//��ʦϵͳ����
	public static void subFront(){
		System.out.println("======================================================");
		System.out.println("\t\t��ӭʹ��ѧ���ɼ�����ϵͳ");
		System.out.println("\t1 ����ѧ����Ϣ\t 2 ������м�¼");
		System.out.println("\t3 ��ƽ���ɼ��������\t 4 ���Ҽ�¼");
		System.out.println("\t5 ͳ�Ƹ�����������\t 6 ɾ����¼");
		System.out.println("\n\t��ѡ��ɫ <back>\t ����<help>\t �˳� <exit>");
		System.out.println("======================================================");
	}
	//ѧ���ͻ��˲�ѯ����
	public static void stuFront(){
		System.out.println("======================================================");
		System.out.println("\t\t�ɼ�����ϵͳѧ����");
		System.out.println("\t\t  1 ��Ѱ�ɼ�");
		System.out.println("\t\t  2���������");
		System.out.println("\t[back][exit][help][1|2]");
		System.out.println("======================================================");
		
	}
}