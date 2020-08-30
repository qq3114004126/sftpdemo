package com.example.sftp.sftpservice.connectionpool;

import com.sun.xml.internal.ws.util.xml.XmlUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class XmlRecv extends Thread {
	private BufferedOutputStream out;
	private InputStreamReader in;
	private Socket socket;
	private boolean result = false;

	public static Logger logger = LoggerFactory.getLogger(XmlRecv.class);

	@Override
	public void run() {
		String charSet = ReadProperties.getCharSet();
		try {
			// 保存输入流
			in = new InputStreamReader(socket.getInputStream(), charSet);
			// 准备输出流
			out = new BufferedOutputStream(socket.getOutputStream());
			// 翻译接收到的报文，并执行SFTP操作
			XmlTranslate xmlTranslate = new XmlTranslate(in);
			logger.info("开始进行报文检查");
			result = xmlTranslate.checkXml();
			// 输出应答报文

			out.write(XmlUtil.retrunXml(charSet, result, "0000", "文件传输成功！")
					.getBytes(charSet));

			out.flush();
			socket.close();

		} catch (UnsupportedEncodingException e) {
			logger.info(Log.getTrace(e));
			e.printStackTrace();
		} catch (IOException e) {
			logger.info(Log.getTrace(e));
			e.printStackTrace();
		}
	}

	public XmlRecv(Socket clientSocket) {
		this.socket = clientSocket;
	}
}