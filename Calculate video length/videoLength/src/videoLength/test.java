package videoLength;

import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import java.io.File;

public class test {
	public static void main(String[] args){
		    File source = new File("E:\\������Ƶ\\test.avi");
	        Encoder encoder = new Encoder();
	        try {
	             MultimediaInfo m = encoder.getInfo(source);
	             long ls = m.getDuration();
	             System.out.println("����Ƶʱ��Ϊ:" + ls / (60 * 60 * 1000) + "ʱ" + (ls % (60 * 60 * 1000)) / 60000 + "��"  
	                     + ((ls % (60 * 60 * 1000)) % 60000) / 1000 + "��" + (((ls % (60 * 60 * 1000)) % 60000) % 1000)  
	                     + "���룡");  
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	
	
		
}
