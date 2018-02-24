package com.flashhold.tomcat;
import java.util.*;
public class ServletMappingConfig {
	public static List<ServletMapping>servletMappingList=new ArrayList<>();
	static{
		servletMappingList.add(new ServletMapping("testServlet", "/test", "com.flashhold.tomcat.TestServlet"));
	}
}
