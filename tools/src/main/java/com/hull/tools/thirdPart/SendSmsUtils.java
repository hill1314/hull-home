package com.hull.tools.thirdPart;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendSmsUtils {
	private static Logger logger = LoggerFactory.getLogger(SendSmsUtils.class);

	private static String URL = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	private static String ACCOUNT = "C99331063";
	private static String PASSWORD = "6196454cb9b79f2328dc4152be68d9c2";

	/**
	 * 发送短信
	 * @param phoneNum
	 * @param content
	 */
	public static boolean sendMsg(String phoneNum,String content){
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(URL);

		client.getParams().setContentCharset("GBK");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=GBK");

		NameValuePair[] data = {//提交短信
				new NameValuePair("account", ACCOUNT),
				new NameValuePair("password", PASSWORD),
				new NameValuePair("mobile", phoneNum),
				new NameValuePair("content", content),
		};
		method.setRequestBody(data);

		try {
			client.executeMethod(method);
			String submitResult =method.getResponseBodyAsString();
			logger.info(submitResult);

			Document doc = DocumentHelper.parseText(submitResult);
			Element root = doc.getRootElement();

			if(StringUtils.equals(root.elementText("code"),"2")){
				logger.info("短信提交成功");
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error("发送短信异常:"+e.getMessage());
		}
		return false;
	}

	public static void main(String [] args) {
		int mobile_code = (int)((Math.random()*9+1)*100000);
		String content = new String("您的验证码是：" + mobile_code + "。请不要把验证码泄露给其他人。");
		sendMsg("18813119640",content);
	}

}