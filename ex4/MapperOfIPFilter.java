package No4;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MapperOfIPFilter {
	public static void main(String[] args) throws ParseException{
		Scanner scanner = new Scanner(System.in);
		SimpleDateFormat regularFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date beginDate = regularFormat.parse(args[0]);
		Date endDate = regularFormat.parse(args[1]);
		while (scanner.hasNext()){
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
				DateFormat df=new SimpleDateFormat("dd/MMM/yyyy:HH:mm:ss",Locale.ENGLISH);
				date=df.parse(strTime);//将字符串解析成时间
				

				if(date.after(beginDate) && date.before(endDate)){//时间判断
					System.out.println(strIp+"\t"+date);
				}

			}
		}
	}
}
