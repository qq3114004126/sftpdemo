package com.example.sftp.sftpservice.connectionpool;

import com.sun.xml.internal.ws.util.xml.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class XmlTranslate {
	private InputStreamReader in;
	public static Logger logger = LoggerFactory.getLogger(XmlTranslate.class);
	public static ExecutorService ex = Executors.newFixedThreadPool(20);
	
	public InputStreamReader getIn() {
		return in;
	}
	
	public void setIn(InputStreamReader in) {
		this.in = in;
	}
	
	public XmlTranslate(InputStreamReader in) {
		super();
		this.in = in;
	}
	
	public boolean checkXml(){
        BufferedReader bufferedReader = new BufferedReader(this.in);
        

        try {
			/*while((lsStr = bufferedReader.readLine())!=null){
			    //追加到字符串缓冲区存放
				xmlStr.append(lsStr);
			}*/
			// 先读取8位长度
			char[] cha = new char[8];
			bufferedReader.read(cha, 0, 8);
			String xmlLength = String.valueOf(cha);
			// 正则去除字符串中的0
		    xmlLength = xmlLength.replaceAll("^(0+)", "");
		    logger.debug("需要截取的长度为："+xmlLength+"字节");
			// 截取指定长度的报文
			char[] xmlBodyChar = new char[Integer.parseInt(xmlLength)];
			bufferedReader.read(xmlBodyChar, 0, Integer.parseInt(xmlLength));
			String xmlBody = String.valueOf(xmlBodyChar);
			logger.debug("截取的报文为："+xmlBody);
			SftpInfo sftpInfo  = XmlUtil.xmlTranslate(xmlBody);
			//创建sftp操作对象
			SftpService sftpUtils = new SftpService();
			return sftpUtils.SFTPOper(sftpInfo);
			 
		} catch (Exception e) {
			logger.info(e.getMessage());
			return false;
		}
	}
}