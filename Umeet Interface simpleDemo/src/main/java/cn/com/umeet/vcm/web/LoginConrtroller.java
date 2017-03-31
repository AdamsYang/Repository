package cn.com.umeet.vcm.web;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.umeet.vcm.common.HttpLogin;
import cn.com.umeet.vcm.realm.UserRealm;
import cn.com.umeet.vcm.session.SessionFactory;


@Controller
public class LoginConrtroller extends HttpLogin{
	
	
	@RequestMapping("/index")
	public String home(){
		return "login";
	}
	
	@RequestMapping("/login")
	public @ResponseBody String login(@RequestBody HashMap<String, String> map) throws ClientProtocolException, IOException{
		
		UsernamePasswordToken token = new UsernamePasswordToken(map.get("username"), map.get("password"));  
	    token.setRememberMe(Boolean.getBoolean(map.get("remember")));  
	    Subject subject = SecurityUtils.getSubject();  
	    try {

	        subject.login(token);  
	        if (subject.isAuthenticated()) {  
	        	Session session = subject.getSession();
	        	session.setAttribute("username", map.get("username"));
	        	session.setAttribute("password", map.get("password"));
	        	
	            return "success";  
	        } else {  
	            return "false";  
	        }   
	    }
	    catch (UnknownAccountException e) {
	    	 return "false";
	    	}
	  }
	
	
	@RequestMapping("/createConference")
	public String createConference(){
		
		return "createConference";
	}
	
	@RequestMapping("/ConferenceList")
	public String ConferenceList(){
		
		return "ConferenceList";
	}
	
	@RequestMapping("/removeConference")
	public String removeConference(){
		
		return "removeConference";
	}
	
	@RequestMapping("/addTerminal")
	public String addTerminal(){
	
		return "addTerminal";
	}
	
	@RequestMapping("/updateTerminal")
	public String updateTerminal(){
	
		return "updateTerminal";
	}
	
	@RequestMapping("/queryTerminal")
	public String queryTerminal(){
		
		return "queryTerminal";
	}
	
	@RequestMapping("/deleteTerminal")
	public String deleteTerminal(){
		
		return "deleteTerminal";
	}
	
	@RequestMapping("/callTerminal")
	public String callTerminal(){
		
		return "callTerminal";
	}
	
	@RequestMapping("/recordingStart")
	public String recordingStart(){
		
		return "recordingStart";
	}
	
	@RequestMapping("/recordingStop")
	public String recordingStop(){
		
		return "recordingStop";
	}
	
	@RequestMapping("/queryRecordVideoURL")
	public String queryRecordVideoURL(){
		
		return "queryRecordVideoURL";
	}
	
	@RequestMapping("/startLive")
	public String startLive(){
	
		return "startLive";
	}
	
	@RequestMapping("/viewLive")
	public String viewLive(){
		
		return "viewLive";
	}
	
	@RequestMapping("/stopLive")
	public String stopLive(){
		
		return "stopLive";
	}
	
	@RequestMapping("/monitor")
	public String monitor(){
		
		return "monitor";
	}
	
	@RequestMapping("/logout")
	public @ResponseBody String logout() throws InvalidSessionException, ClientProtocolException, IOException{
		 Subject subject = SecurityUtils.getSubject();
		 boolean logout = loginSuccess().logout();
		 if (logout == true) {
			 subject.logout();
			 return "success";
		}
		 else {
			return "false";
		}

	}


}
