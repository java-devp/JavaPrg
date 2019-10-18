package com.example.demo.appproperties;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix="formapps")
public class AppsProps {
	
	private Map<String,String> messages= new HashMap<String,String>();
	  
	  
}
