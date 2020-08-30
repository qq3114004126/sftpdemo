package com.example.sftp.sftpservice.connectionpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SocketMain {
    public static Logger logger = LoggerFactory.getLogger(SocketMain.class);
    public static ExecutorService ex = Executors.newFixedThreadPool(ReadProperties.getThreadPoolSize());

    public static void main(String[] args) {
        final int port = ReadProperties.getServerPort();
        ServerSocket socket = null;

        try {
            // 绑定端口号
            socket = new ServerSocket(port);
            while(true){
                Socket clientSocket = socket.accept();
                logger.info("有一个客户端连接");
                ex.execute(new XmlRecv(clientSocket));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            socket.close();
            ex.shutdown();
        }

    }
}
