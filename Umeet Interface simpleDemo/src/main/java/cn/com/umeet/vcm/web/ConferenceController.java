package cn.com.umeet.vcm.web;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;









import java.util.Properties;
import java.util.UUID;

import org.apache.http.client.ClientProtocolException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.umeet.vcm.common.HttpLogin;
import cn.com.umeet.vcm.domain.Meeting;
import cn.com.umeet.vcm.domain.Participant;
import cn.com.umeet.vcm.realm.UserRealm;
import cn.com.umeet.vcm.session.SessionFactory;


@Controller
@RequestMapping("/conference")
public class ConferenceController extends HttpLogin {
		
		@RequestMapping("/createConference")
		public @ResponseBody String createConference(@RequestBody Meeting meet) throws InvalidSessionException, ClientProtocolException, IOException{
			System.out.println(meet.getName()+" "+meet.getStreamUrl());
			String s = UUID.randomUUID().toString();
			String random=(s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24)).substring(7, 17);
			Properties prop = new Properties();
			InputStream resourceAsStream = getClass().getResourceAsStream("/domain.properties");
			prop.load(resourceAsStream);
			String property = prop.getProperty("rtmp");
			String rtmp=property+random;
			meet.setStreamUrl(rtmp);
			String uuid = loginSuccess().createConference(meet);
//			String uuid = UserRealm.session.createConference(meet);
			if (uuid == null || "".equals(uuid)) {
				return "false";
			}
			return "success";
			
		}
		
		@RequestMapping("/ConferenceList/{status}")
		public @ResponseBody List<Meeting> ConferenceList(@PathVariable String status) throws InvalidSessionException, ClientProtocolException, IOException{
			System.out.println(status);
			List<Meeting> queryConferenceList = loginSuccess().queryConferenceList(status);
//			List<Meeting> queryConferenceList = UserRealm.session.queryConferenceList(status);
			return queryConferenceList;
			
		}
		
		@RequestMapping("/removeConference/{uuid}")
		public @ResponseBody boolean removeConference(@PathVariable String uuid) throws InvalidSessionException, ClientProtocolException, IOException{
			boolean removeConference = loginSuccess().removeConference(uuid);
//			boolean removeConference = UserRealm.session.removeConference(uuid);
			return removeConference;
			
		}
		
		@RequestMapping("/queryConferenceForOne/{uuid}")
		public @ResponseBody Meeting  queryConferenceForOne(@PathVariable String uuid) throws InvalidSessionException, ClientProtocolException, IOException{
			Meeting queryConferenceForOne = loginSuccess().queryConferenceForOne(uuid);
			System.out.println(queryConferenceForOne.getName()+","+queryConferenceForOne.getStreamStatus());
//			Meeting queryConferenceForOne = UserRealm.session.queryConferenceForOne(uuid);
			return queryConferenceForOne;
			
		}
		@RequestMapping("/queryParticipants/{uuid}")
		public @ResponseBody List<Participant>  queryParticipants(@PathVariable String uuid) throws InvalidSessionException, ClientProtocolException, IOException{
			List<Participant> queryParticipants = loginSuccess().queryParticipants(uuid);
//			 List<Participant> queryParticipants = UserRealm.session.queryParticipants(uuid);
			 return queryParticipants;
			
			
		}
		
}
