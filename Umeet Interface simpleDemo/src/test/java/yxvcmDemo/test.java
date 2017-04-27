package yxvcmDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;

import cn.com.umeet.vcm.domain.Meeting;
import cn.com.umeet.vcm.domain.Terminal;
import cn.com.umeet.vcm.domain.Video;
import cn.com.umeet.vcm.session.Session;
import cn.com.umeet.vcm.session.SessionFactory;

public class test {
	public static void main(String[] args) throws ClientProtocolException, IOException{
			Session session = new SessionFactory().createSession("admin", "admin", "192.168.30.129:8080");
//			List<Meeting> queryConferenceList = session.queryConferenceList("online");
//			System.out.println(queryConferenceList.get(0).getName());
			
//			List<Terminal> queryTerminal = session.queryTerminal("");
//			for (Terminal terminal : queryTerminal) {
//				System.out.println(terminal.getName()+"----->"+terminal.getStatus());
//			}

	}
}
