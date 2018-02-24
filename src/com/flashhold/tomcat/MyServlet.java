package com.flashhold.tomcat;

public abstract class MyServlet {
	public abstract void doGet(MyRequest request,MyResponse response);
	public abstract void doPost(MyRequest request,MyResponse response);
	public void service(MyRequest request,MyResponse response){
		if(request.getMethod().equalsIgnoreCase("POST")){
			doPost(request, response);
		}else if(request.getMethod().equalsIgnoreCase("GET")){
			doGet(request, response);
		}
	}
}
