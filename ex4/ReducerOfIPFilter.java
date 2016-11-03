package No4;

import java.util.HashSet;
import java.util.Scanner;

public class ReducerOfIPFilter {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	HashSet<String>set=new HashSet<String>();//利用hashset去重
	while(sc.hasNext()){
		String line = sc.nextLine();
		String str[]=line.split("\t");
		if(str.length!=2)//判断切分格式是否正确
			continue;
		set.add(str[0]);//切分正确的话，将ip添加进入hashset
	}
	System.out.println(set.size());//因其自动去重，因此，set的size即为去重后的ip总数
}
}
