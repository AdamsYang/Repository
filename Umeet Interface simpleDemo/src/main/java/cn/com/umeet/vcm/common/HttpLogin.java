package cn.com.umeet.vcm.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.http.client.ClientProtocolException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import cn.com.umeet.vcm.session.SessionFactory;

public class HttpLogin {
	public  cn.com.umeet.vcm.session.Session loginSuccess() throws InvalidSessionException, ClientProtocolException, IOException {
		Properties prop = new Properties();
		InputStream resourceAsStream = getClass().getResourceAsStream("/domain.properties");
		prop.load(resourceAsStream);
		String property = prop.getProperty("domain");
		System.out.println(property);
		Subject subject = SecurityUtils.getSubject();  
		Session ShiroSession = subject.getSession();
		cn.com.umeet.vcm.session.Session session = new SessionFactory().createSession(ShiroSession.getAttribute("username").toString(), ShiroSession.getAttribute("password").toString(), property);
		return session;
		}
}
