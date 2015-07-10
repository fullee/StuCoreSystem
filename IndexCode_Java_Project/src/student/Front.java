package student;

import java.text.SimpleDateFormat;
import java.util.Date;
//显示界面类
class Front{
	public Front(){
		System.out.print("<1老师><2学生>\t请选择用户角色>>>");
	}
	public static String role(){
		String role = "<1 老师><2 学生>  请选择用户角色>>>";
		return role;
	}
	//提示符格式时间
	public static String time(){
		SimpleDateFormat time = new SimpleDateFormat("hh:mm:ss");
		String tips = "["+time.format(new Date())+"]#:";
		return tips;
	}
	//教师系统界面
	public static void subFront(){
		System.out.println("======================================================");
		System.out.println("\t\t欢迎使用学生成绩管理系统");
		System.out.println("\t1 输入学生信息\t 2 输出所有记录");
		System.out.println("\t3 按平均成绩排序并输出\t 4 查找记录");
		System.out.println("\t5 统计各分数段人数\t 6 删除记录");
		System.out.println("\n\t重选角色 <back>\t 帮助<help>\t 退出 <exit>");
		System.out.println("======================================================");
	}
	//学生客户端查询界面
	public static void stuFront(){
		System.out.println("======================================================");
		System.out.println("\t\t成绩管理系统学生端");
		System.out.println("\t\t  1 查寻成绩");
		System.out.println("\t\t  2按名次输出");
		System.out.println("\t[back][exit][help][1|2]");
		System.out.println("======================================================");
		
	}
}