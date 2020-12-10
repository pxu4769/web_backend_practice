package listener;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.dbcp.BasicDataSource;

public class ApplicationHandler implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContextListener.super.contextInitialized(sce);
		ServletContext application=sce.getServletContext();
		
		String realPath=application.getRealPath("/")+"WEB-INF\\dbconfig.properties";
		
		try {
			InputStream is = new FileInputStream(realPath);
			Properties properties=new Properties();
			
			properties.load(is);
			String driverClassName=properties.getProperty("driverClassName");
			String url=properties.getProperty("url");
			String username=properties.getProperty("username");
			String password=properties.getProperty("password");
			is.close();
			
			BasicDataSource dataSource= new BasicDataSource();
			dataSource.setDriverClassName(driverClassName);
			dataSource.setUrl(url);
			dataSource.setUsername(username);
			dataSource.setPassword(password);
			
			application.setAttribute("dataSource",dataSource);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
