package videoLength;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;

public class test {
	public static void main(String[] args){
		    File source = new File("E:\\测试视频\\test.avi");
	        Encoder encoder = new Encoder();
	        try {
	             MultimediaInfo m = encoder.getInfo(source);
	             long ls = m.getDuration();
	             System.out.println("此视频时长为:" + ls / (60 * 60 * 1000) + "时" + (ls % (60 * 60 * 1000)) / 60000 + "分"  
	                     + ((ls % (60 * 60 * 1000)) % 60000) / 1000 + "秒" + (((ls % (60 * 60 * 1000)) % 60000) % 1000)  
	                     + "毫秒！");  
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
	
		
}
