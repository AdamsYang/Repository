package cn.com.umeet.vcm.web;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.shiro.session.InvalidSessionException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.umeet.vcm.common.HttpLogin;
import cn.com.umeet.vcm.domain.RecordAndLivePorts;
import cn.com.umeet.vcm.realm.UserRealm;


@Controller
@RequestMapping("/monitor")
public class Monitor extends HttpLogin {
	@RequestMapping("/queryRecordAndLivePorts")
	public @ResponseBody List<RecordAndLivePorts> queryRecordAndLivePorts() throws InvalidSessionException, ClientProtocolException, IOException{
		List<RecordAndLivePorts> queryRecordAndLivePorts =loginSuccess().queryRecordAndLivePorts();
//		List<RecordAndLivePorts> queryRecordAndLivePorts = UserRealm.session.queryRecordAndLivePorts();
		return queryRecordAndLivePorts;
	}

}
