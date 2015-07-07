package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdbc {
//
	//testMain
//	public static void main(String [] args){
//		subMethod(0, 9, 9);
//		
//	}
	
	static Connection conn = null;
	
	static String url="jdbc:mysql://localhost:3306/student?useUnicode=true&characterEncoding=utf8";
	static String user = "root";
	static String pw = "";
	
	//链接Mysql数据库
	public static Connection connect(){
		try{
			
			Class.forName("com.mysql.jdbc.Driver");
			conn =DriverManager.getConnection(url, user, pw);
			//testIf
//			if(conn != null){
//				System.out.println("数据库链接成功！");
//			}
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return conn;
	}
	
	//insertdata
	public static boolean insertMethod(long id,String name,int chn,int eng,int math){
		
		conn = connect();
		try{
			Statement state = conn.createStatement();
			String sql = "insert into core(id,name,chn,eng,math) values("+id+",'"+name+"',"+chn+","+eng+","+math+")";
			if(state.execute(sql) == false){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	//selectAll
	public static void getAllMethod(){
		conn = connect();
		try{
			Statement state = conn.createStatement();
			
			String sql = "select * from core";		
				ResultSet result = state.executeQuery(sql);
				while(result.next()){
					//记录值付给变量
					long id = result.getLong("id");
					String name = result.getString("name");
					
					int chn = result.getInt("chn");
					int eng = result.getInt("eng");
					int math = result.getInt("math");
					System.out.println("学号："+id+"\t姓名："+name+"\t语文："+chn+"\t数学："+math+"\t英语："+eng);
				}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	//selectOrder
	public static void avgOrderMethod(){
		conn = connect();
		try{
			Statement state = conn.createStatement();
			String sql = "select name,id,chn,eng,math,(chn+eng+math)/3 avg from core order by avg desc";
			ResultSet result = state.executeQuery(sql);
			int i = 1;
			while(result.next()){
				
				String name = result.getString("name");
				long id = result.getLong("id");
				int eng = result.getInt("eng");
				int chn = result.getInt("chn");
				int math = result.getInt("math");
				double avg =(eng+chn+math)/3;
				System.out.println("学号："+id+"\t姓名："+name+"\t平均成绩："+avg+"\t语文："+chn+"\t数学："+math+"\t英语："+eng+"\t排名："+i++);
			}	
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	//findstu
	public static boolean findIdMethod(long id){
		conn = connect();
		try{
			Statement state = conn.createStatement();
			
			String sql = "select * from core where id="+id+"";
			ResultSet result = state.executeQuery(sql);
			if(result.next()){
				ResultSet result2 = state.executeQuery(sql);
				while(result2.next()){
					String name = result2.getString("name");
					int eng = result2.getInt("eng");
					int chn = result2.getInt("chn");
					int math = result2.getInt("math");
					System.out.println("学号："+id+"\t姓名："+name+"\t语文："+chn+"\t数学："+math+"\t英语："+eng);
				}	
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	//deleteId
	public static boolean deleteIdMethod(long id){
		conn = connect();
		try{
			Statement state = conn.createStatement();
			
			String sql = "delete from core where id="+id+"";
			int count = state.executeUpdate(sql);
			if(count != 0){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
		
	}
	//deleteAll
	public static boolean deleteAllMethod(){
		conn = connect();
		try{
			Statement state = conn.createStatement();
			
			String sql = "delete from core";
			if(!state.execute(sql)){
				return true;
			}else{
				return false;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	//查学号
	public static boolean getId(long id){
		conn = connect();
		try{
			Statement state = conn.createStatement();
			
			String sql = "select * from core where id="+id+"";		
			ResultSet result = state.executeQuery(sql);
			if(result.next()){
				long x = result.getLong("id");			
				if(x == id){
					return true;
				}else{
					return false;
				}
			}
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return false;
	}
	//查找max min
	public static int[] getM(int max,int min){
		conn = connect();
		int[] M;
		M = new int[2];
		M[0] = -1;
		M[1] = -1;
		try{
			Statement state = conn.createStatement();
			
			String sql = "select min(chn+eng+math) min,max(eng+chn+math) max from core";
			ResultSet result = state.executeQuery(sql);
			if(result.next()){
				M[0] = result.getInt("min");
				M[1] = result.getInt("max");
				return M;
			}else{
				return M;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return M;
	}
	public static void subMethod(int min,int max,int input){
//		min = 3;
//		max = 100;
//		input = 10;
		for(int i = 0; i < max; i+=input){
			conn = connect();
			try{
				Statement state = conn.createStatement();
				String sql = "select * from core where (chn+eng+math)>="+i+"&&(chn+eng+math)<"+(i+input);
				ResultSet result = state.executeQuery(sql);

				if(result.last()){
					int rowCount = result.getRow(); 
					System.out.println("<"+i+"~"+(i+input)+"> :"+rowCount);
				}				
				
				}catch(SQLException e){
					e.printStackTrace();
				}
		}
	}

}
