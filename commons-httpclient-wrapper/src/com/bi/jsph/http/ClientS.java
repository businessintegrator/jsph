/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bi.jsph.http;

import java.io.IOException;
import java.net.InetAddress;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HostConfiguration;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 *
 * @author rafaralahitsimba tiaray
 */
public class ClientS {

    public ClientS() {
    }
    
    public boolean doservice(HttpClient client, String domain,
			String mail, String password, PostMethod method, String emailkey,
			String passwordkey, String queryString, String realm) {
		client.getState().setCredentials(realm, domain,
				new UsernamePasswordCredentials(mail, password));

		method.addParameter(emailkey, mail);
		method.addParameter(passwordkey, password);
		//method.setFollowRedirects(true);
		// method.setDoAuthentication(true);
		// method.addParameter("route", "account/login");
		try {
			HostConfiguration hostConfiguration = new HostConfiguration();
			hostConfiguration.setHost(domain);
			hostConfiguration.setLocalAddress(InetAddress.getLocalHost());

			// HttpConnection cnx = new HttpConnection(hostConfiguration);

			method.setQueryString(queryString);
			method.setHostConfiguration(hostConfiguration);
			int respone = client.executeMethod(method);
			System.err.println("CheckOC.main() " + respone);
			System.err.println("CheckOC.main() " + client.getState());
			Header[] headers = method.getResponseHeaders();
			for (int i = 0; i < headers.length; i++) {
				Header header = headers[i];
				System.err.println(header.getName() + " "
						+ header.getValue());

			}
			
			System.err.println(method.getResponseBodyAsString());
			
			if (respone == 302) {
				Header newUrl = method.getResponseHeader("Location");
				PostMethod methodRedirect = new PostMethod(newUrl.getValue());
				for (int i = 0; i < headers.length; i++) {
					Header header = headers[i];
					methodRedirect.addRequestHeader(header);
				}
				method.releaseConnection();
				method = null;
                                return true;
				//doservice(client, domain, mail, password, methodRedirect,
				//		emailkey, passwordkey, queryString, realm);
			}
                        

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			method.releaseConnection();
		}
                return false;
    }

}
