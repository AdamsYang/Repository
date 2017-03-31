package cn.com.umeet.vcm.web;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.shiro.session.InvalidSessionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.umeet.vcm.common.HttpLogin;
import cn.com.umeet.vcm.realm.UserRealm;


@Controller
@RequestMapping("/live")
public class LiveController extends HttpLogin{

	@RequestMapping("/startLive/{uuid}")
	public @ResponseBody String startLive(@PathVariable String uuid) throws InvalidSessionException, ClientProtocolException, IOException{
		System.out.println(uuid);
		boolean startLive = loginSuccess().startLive(uuid);
//		boolean startLive = UserRealm.session.startLive(uuid);
		if (startLive == false) {
			return "false";
		}
		return "success";	
	}
	
	@RequestMapping("/stopLive/{uuid}")
	public @ResponseBody String stopLive(@PathVariable String uuid) throws InvalidSessionException, ClientProtocolException, IOException{
		System.out.println(uuid);
		boolean startLive =  loginSuccess().stopLive(uuid);
//		boolean startLive = UserRealm.session.stopLive(uuid);
		if (startLive == false) {
			return "false";
		}
		return "success";	
	}
}
