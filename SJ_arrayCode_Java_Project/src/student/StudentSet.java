package student;

public class StudentSet {
	//最多存放50个学生
	private static final int maxLen = 50;
	private static int len = 0;
	private static Student[] data = new Student[maxLen];

	public static int getMaxLen(){
		return maxLen;
	}
	public static int getLen(){
		return len;
	}
	//获取数据
	public static Student getData(int index){
		return data[index];
	}
	//添加数据
	public static int addData(Student newData){
		if (len < maxLen) {
			data[len] = newData;
			len++;
			return 0;
		} else{
			return -1;
		}
	}
	//排序
	public static void sortData(){
		for (int i = 0; i < len -1; i++){
			int minIndex = i;
			for (int j = i+1; j < len; j++){
				if (data[minIndex].getAverage() > data[j].getAverage()){
					minIndex = j;
				}
			}
			if (minIndex != i){
				Student temp = data[i];
				data[i] = data[minIndex];
				data[minIndex] = temp;
			}
		}
	}
	//搜索
	public static int search(int number){
		for(int i = 0; i < len; i++){
			if (data[i].getNumber() == number){
				return i;
			}
		}
		return -1;
	}
	//删除
	public static int delete(int number){
		for (int i = 0; i < len; i++){
			if (data[i].getNumber() == number){
				for (int j = i + 1; j < len; j++){
					data[j-1] = data[j];
				}
				len--;
				return 0;
			}
		}
		return -1;
	}
	
	//data预设
	public static int newstatic(){
		for(int i = 1; i <= 10; i++){
			int number = i*20;
			String name = "黄晓明"+i;
			int english = 0;
			int math = 0;
			int computer = (i*10-2)*3;
			
			Student newData = new Student(number, name, english, math, computer);
			
			if (StudentSet.addData(newData) == -1){
				System.out.println("@提示\t数据溢出！");
				return -2;
			}
		}
		return 0;
	}
	//分段
	public static int stat(int min, int max){
		int sum =0;
	
		for (int i = 0; i < len; i++){
			if ((data[i].getAverage() >= min) && (data[i].getAverage() <= max)){
			sum++;
			}
		}
		return sum;
	}
}
