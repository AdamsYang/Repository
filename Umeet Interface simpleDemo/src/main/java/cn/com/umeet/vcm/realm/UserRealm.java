package cn.com.umeet.vcm.realm;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;




import org.apache.http.client.ClientProtocolException;
import org.apache.shiro.authc.AuthenticationException;  
import org.apache.shiro.authc.AuthenticationInfo;  
import org.apache.shiro.authc.AuthenticationToken;  
import org.apache.shiro.authc.SimpleAuthenticationInfo;  
import org.apache.shiro.authc.UnknownAccountException;  
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;  
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;  
import org.apache.shiro.subject.PrincipalCollection;  

import cn.com.umeet.vcm.session.Session;
import cn.com.umeet.vcm.session.SessionFactory;
  


public class UserRealm extends AuthorizingRealm {
//	public static Session session;
    
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(  
            AuthenticationToken authcToken) throws AuthenticationException {  
        // TODO Auto-generated method stub  
    	UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
    	String username = token.getUsername();
    	char[] chr = token.getPassword();
    	String password = new String(chr);
    	System.out.println("username:"+username+" password:"+password);
        AuthenticationInfo authenticationInfo = null;
        Properties prop = new Properties();
		try {
			InputStream resourceAsStream = getClass().getResourceAsStream("/domain.properties");
			prop.load(resourceAsStream);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String property = prop.getProperty("domain");
		System.out.println(property);
        try {
        		
			      Session session = new SessionFactory().createSession(username,password, property);
			  if (session == null ) {  
		            return authenticationInfo; 
		        }  else {
		        	
		        	return authenticationInfo = new SimpleAuthenticationInfo(username, password, getName());
				}
        } catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return authenticationInfo;  
    }

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(
			PrincipalCollection paramPrincipalCollection) {
		// TODO Auto-generated method stub
		
		Set<String> roleNames = new HashSet<String>();  
        Set<String> permissions = new HashSet<String>();  
        roleNames.add("admin");
        roleNames.add("administrator");  
        permissions.add("create"); 
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo(roleNames);  
        info.setStringPermissions(permissions);  
        return info; 
		
	}

}
