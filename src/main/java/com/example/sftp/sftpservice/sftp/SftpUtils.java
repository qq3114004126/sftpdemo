//package com.example.sftp.sftpservice.sftp;
//
//import com.jcraft.jsch.Channel;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.Session;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import sun.security.pkcs11.wrapper.CK_SESSION_INFO;
//
//@Configuration
//public class SftpUtils {
//    // 日志引入
//    private static final Logger log = LoggerFactory.getLogger(SftpUtils.class);
//
//    @Value("${sftp.username}")
//    private String username;
//
//    @Value("${sftp.password}")
//    private String password;
//
//    @Value("${sftp.host}")
//    private String host;
//
//    @Value("${sftp.port}")
//    private int port;
//
//    public Session sftpConnect() {
//        Session sshSession = null;
//        Channel channel = null;
//        JSch jSch = new JSch();
//        try {
//            sshSession = jSch.getSession(username,host,port);
//            sshSession.setPassword(password);
//            // sshSession.setConfig();
//            channel = sshSession.openChannel("sftp");
//            sshSession.connect();
//        } catch (JSchException e) {
//            log.error("登录失败!");
//            e.printStackTrace();
//        }
//    }
//
//
//}
