package com.hussain.pink.triangle.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Hussain
 *
 */
public class PropsGetters {
	private static final Logger LOG = LoggerFactory.getLogger(PropsGetters.class);
	private static volatile PropsGetters instance = null;
	
	private static final String PROPERTIES_FILE_NAME = "fileChooser.properties";
	
	private String vlcPath;
	
	private PropsGetters(){
		ClassLoader loader = PropsGetters.class.getClassLoader();
		InputStream inputStream = loader.getResourceAsStream(PROPERTIES_FILE_NAME);
		try{
			if(inputStream == null)
			{
				throw new FileNotFoundException("The properties file was not found");
			}
			Properties properties = new Properties();
			properties.load(inputStream);
			
			vlcPath = properties.getProperty("vlc.path");
		}
		catch(FileNotFoundException fnfException){
			LOG.error("There was an error when trying to find the properties file at the path /config/fileChooser.properties", fnfException);
		}
		catch(IOException ioException){
			LOG.error("There was an error when trying to read the properties file", ioException);
		}
		finally{
			IOUtils.closeQuietly(inputStream);
		}
	}
	
	public static PropsGetters getInstance(){
		if(instance == null)
		{
			synchronized (PropsGetters.class) {
				instance = new PropsGetters();
			}
		}
		return instance;
	}
	
	public String getVlcPath(){
		return this.vlcPath;
	}

}
