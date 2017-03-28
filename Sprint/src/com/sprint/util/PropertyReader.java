package com.sprint.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;

public class PropertyReader {
	private static PropertyReader propertyReader = null;
	private PropertyReader(){
		
	}
	static Properties prop=null;
  public void loadproperties(final String fName) {

	prop=new Properties();
	InputStream is = null;

	try {

		is = new FileInputStream(fName);
		prop.load(is);
	
	} catch (IOException io) {
		io.printStackTrace();
	} finally {
		if (is != null) {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
  }
  public String getProperty(final String key){
	  if(prop!=null)
	  {
		  return prop.getProperty(key);
	  }
	return null;
	  
  }
  void printProperties()
  {
	  if(prop!=null)
	  {
		  for (Map.Entry<Object, Object> p:prop.entrySet()) {
			  System.out.println(p.getKey()+"=="+p.getValue());
		  }
	  }
  }
    
  public static void main(String[] args){
	  final String fName="Sprint.properties";
	  PropertyReader reader=null;//PropertyReader.getPropertyReader();
	  reader.loadproperties(fName);
	  reader.printProperties();
	  
  }
}