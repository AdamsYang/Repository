package cn.com.umeet.vcm.web;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.shiro.session.InvalidSessionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;









import cn.com.umeet.vcm.common.HttpLogin;
import cn.com.umeet.vcm.domain.Call;
import cn.com.umeet.vcm.domain.Terminal;
import cn.com.umeet.vcm.realm.UserRealm;



@Controller
@RequestMapping("/terminal")
public class TerminalController extends HttpLogin{
	
	@RequestMapping("/addTerminal")
	public @ResponseBody String addTerminal(@RequestBody Terminal terminal) throws InvalidSessionException, ClientProtocolException, IOException{
		System.out.println(terminal.getName()+","+terminal.getBandWidth()+","+terminal.getStatus()+","+terminal.getTerminalCallAddress()+","+terminal.getTerminalModel());
		boolean addTerminal = loginSuccess().addTerminal(terminal);
//		boolean addTerminal = UserRealm.session.addTerminal(terminal);
		if (addTerminal == false) {
			return "false";
		}
		return "success";
		
	}
	
	@RequestMapping("/queryTerminal")
	public @ResponseBody List<Terminal> queryTerminal() throws InvalidSessionException, ClientProtocolException, IOException{
		List<Terminal> queryTerminal =loginSuccess().queryTerminal("");
//		List<Terminal> queryTerminal = UserRealm.session.queryTerminal("");
		return queryTerminal;
		
	}
	
	@RequestMapping("/deleteTerminal/{id}")
	public @ResponseBody boolean removeConference(@PathVariable String id) throws InvalidSessionException, ClientProtocolException, IOException{
		boolean deleteTerminal = loginSuccess().deleteTerminal(id);
//		boolean deleteTerminal = UserRealm.session.deleteTerminal(id);
		return deleteTerminal;
		
	}
	
	@RequestMapping("/callTerminal")
	public @ResponseBody String callTerminal(@RequestBody Call terminal) throws InvalidSessionException, ClientProtocolException, IOException{
		System.out.println(terminal.getIsAudioMute());
		boolean callTerminal = loginSuccess().callTerminal(terminal);
//		boolean callTerminal = UserRealm.session.callTerminal(terminal);
		if (callTerminal == false) {
			return "false";
		}
		return "success";
	}
	
	@RequestMapping("/updateTerminal")
	public @ResponseBody String updateTerminal(@RequestBody Terminal terminal) throws InvalidSessionException, ClientProtocolException, IOException{
		boolean updateTerminal = loginSuccess().updateTerminal(terminal);
//		boolean updateTerminal = UserRealm.session.updateTerminal(terminal);
		if (updateTerminal == false) {
			return "false";
		}
		return "success";
	}
	
	@RequestMapping("/queryTerminalForOne")
	public @ResponseBody List<Terminal> queryTerminalForOne(@RequestBody HashMap<String, String> id) throws InvalidSessionException, ClientProtocolException, IOException{
		List<Terminal> queryTerminal = loginSuccess().queryTerminal(id.get("id"));
//		List<Terminal> queryTerminal = UserRealm.session.queryTerminal(id.get("id"));
		return queryTerminal;
		
	}
		
}

