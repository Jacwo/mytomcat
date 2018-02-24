package com.flashhold.tomcat;

import java.io.IOException;

public class TestServlet extends MyServlet{

	@Override
	public void doGet(MyRequest request, MyResponse response) {
		try {
			response.write("test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void doPost(MyRequest request, MyResponse response) {
		// TODO Auto-generated method stub
		try {
			response.write("test");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
