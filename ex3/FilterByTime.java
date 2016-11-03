package No3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * 题目要求：
 * 0. 在个人仓库下，创建分支yourname_ex3
 * 1. 编写代码完成以下功能：
 * 		a. 从access.log中读入数据，获取IP和Time
 * 		b. 输出在时间区间[beginTime, endTime]内的IP和Time，以tab分割
 * 2. 提交代码到分支下，创建pull request，与主仓库的master分支对比
 */
public class FilterByTime {
	
	public static void main(String[] args) throws ParseException, FileNotFoundException{
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = regularFormat.parse("2015-12-31 18:00:00");
		Date endDate = regularFormat.parse("2015-12-31 19:00:00");
		//String filePath = "./access.log";
		String filePath = "e://data.txt";
		FileInputStream inputStream = new FileInputStream(filePath);
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(inputStream, "UTF-8");
		while (scanner.hasNext()){
			// 对每行进行处理
			String line = scanner.nextLine();
			Pattern pattern=Pattern.compile("(\\d+.\\d+.\\d+.\\d+).*(\\[.*\\])");//正则提取ip和时间
			Matcher matcher=pattern.matcher(line);
			if(matcher.find()){				
				String strIp = null;
				String strTime = null;
				
				strIp=matcher.group(1);
				
				String t1[]=matcher.group(2).split(" ");//对提取到的时间进一步优化
				strTime=t1[0].substring(1, t1[0].length());
				Date date=new Date();
				DateFormat df=new SimpleDateFormat("dd/MMM/yyyy:HH:mm:SS",Locale.ENGLISH);
				date=df.parse(strTime);//将字符串解析成时间
				

				if(date.after(beginDate) && date.before(endDate)){//时间判断
					System.out.println(strIp+"\t"+date);
				}

			}

		}
	}
	
}
