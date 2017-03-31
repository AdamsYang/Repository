package cn.com.umeet.vcm.web;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.shiro.session.InvalidSessionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.umeet.vcm.common.HttpLogin;
import cn.com.umeet.vcm.domain.Video;
import cn.com.umeet.vcm.realm.UserRealm;


@Controller
@RequestMapping("/recording")
public class RecordingController extends HttpLogin{

	@RequestMapping("/recordingStart/{uuid}")
	public @ResponseBody String recordingStart(@PathVariable String uuid) throws InvalidSessionException, ClientProtocolException, IOException{
		boolean recordingStart = loginSuccess().recordingStart(uuid);
//		boolean recordingStart = UserRealm.session.recordingStart(uuid);
		if (recordingStart == false) {
			return "false";
		}
		return "success";	
	}
	
	@RequestMapping("/recordingStop/{uuid}")
	public @ResponseBody String recordingStop(@PathVariable String uuid) throws InvalidSessionException, ClientProtocolException, IOException{
		boolean recordingStop = loginSuccess().recordingStop(uuid);
//		boolean recordingStop = UserRealm.session.recordingStop(uuid);
		if (recordingStop == false) {
			return "false";
		}
		return "success";	
	}
	
	@RequestMapping("/queryRecordVideoURL")
	public @ResponseBody List<Video> queryRecordVideoURL() throws InvalidSessionException, ClientProtocolException, IOException{
		List<Video> queryRecordVideoURL = loginSuccess().queryRecordVideoURL("");
//		List<Video> queryRecordVideoURL = UserRealm.session.queryRecordVideoURL("");
		for (int i = 0; i < queryRecordVideoURL.size(); i++) {
		}
		return queryRecordVideoURL;	
	}
}
