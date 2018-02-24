package com.flashhold.tomcat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class MyTomcat {
	private int port=8080;
	private Map<String,String>urlServletMap=new HashMap<>();
	public MyTomcat(int port){
		this.port=port;
	}
	public void start(){
		initServletMapping();
		try {
			ServerSocket serverSocket=new ServerSocket(port);
			System.out.println("tomcat start ...");
			while(true){
				Socket socket = serverSocket.accept();
				InputStream inputStream = socket.getInputStream();
				OutputStream outputStream = socket.getOutputStream();
				MyRequest myRequest=new MyRequest(inputStream);
				MyResponse myResponse=new MyResponse(outputStream);
				dispacher(myRequest,myResponse);
				socket.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void dispacher(MyRequest myRequest, MyResponse myResponse) {
		// TODO Auto-generated method stub
		String clazz=urlServletMap.get(myRequest.getUrl());
		try {
			Class<MyServlet>mClass=(Class<MyServlet>) Class.forName(clazz);
			MyServlet myServlet=mClass.newInstance();
			myServlet.service(myRequest, myResponse);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	private void initServletMapping() {
		// TODO Auto-generated method stub
		for (ServletMapping servletMapping : ServletMappingConfig.servletMappingList) {
			urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
		}
	}
	public static void main(String[] args) {
		new MyTomcat(8080).start();
	}
}
