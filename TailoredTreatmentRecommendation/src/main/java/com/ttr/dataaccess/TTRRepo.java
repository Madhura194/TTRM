package com.ttr.dataaccess;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

import com.opencsv.CSVReader;
import com.ttr.dto.DiseaseDrug;

@Configuration
public class TTRRepo {
	
	@Autowired
	ResourceLoader resourceLoader;
	
	public static List<DiseaseDrug> data=new ArrayList<>();
	
	@EventListener(ApplicationReadyEvent.class)
	public void load_data() {
		DiseaseDrug datainst=new DiseaseDrug();
		try {
			File file=new File("../drug-disease-mapping.csv");
			System.out.println(file.getAbsolutePath());
			
	        FileReader filereader=new FileReader(file);
	        CSVReader csvReader = new CSVReader(filereader);
	        String[] nextRecord;
	      int   count=0;
	        while ((nextRecord = csvReader.readNext()) != null) {
	        	if(!(count==0)) {
	        	
	        	
	        	datainst.setId(count);
	        	datainst.setDrug(nextRecord[1]);
	        	datainst.setDisease(nextRecord[0]);
	        	datainst.setSpeciality(nextRecord[2]);
	            data.add(datainst);
	            datainst=new DiseaseDrug();
	            
	            
	            }
	        	count++;
	        }
	        
	      csvReader.close();  
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
		
		System.out.println(data.size());
		
	}

}