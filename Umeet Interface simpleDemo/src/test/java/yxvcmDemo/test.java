package yxvcmDemo;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;

import cn.com.umeet.vcm.domain.Meeting;
import cn.com.umeet.vcm.session.Session;
import cn.com.umeet.vcm.session.SessionFactory;

public class test {
	public static void main(String[] args) throws ClientProtocolException, IOException{
		Meeting meeting = new Meeting();
		
		
		
		Session session = new SessionFactory().createSession("admin", "admin", "192.168.22.209:8080");
		String uuid = session.createConference(meeting);
		

		
	}
}
