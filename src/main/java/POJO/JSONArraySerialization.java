package POJO;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONArraySerialization {
	
	public String completeJSON;
	
	@Test
	public void createJSONArrayFromPOJO() throws JsonProcessingException {
		
		samplePOJO alik = new samplePOJO();
		alik.setName("Alik");
		alik.setAge(24);
		alik.setSalary(30000.50);
		alik.setBilability(false);
		
		samplePOJO arpan = new samplePOJO();
		arpan.setName("Arpan");
		arpan.setAge(23);
		arpan.setSalary(30000.50);
		arpan.setBilability(true);
		
		samplePOJO abhi = new samplePOJO();
		abhi.setName("Abhinandan");
		abhi.setAge(23);
		abhi.setSalary(32000.50);
		abhi.setBilability(true);
		
		ArrayList<samplePOJO> emp = new ArrayList<samplePOJO>();
		emp.add(alik);
		emp.add(abhi);
		emp.add(arpan);
		
		ObjectMapper objMap = new ObjectMapper();
		completeJSON = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		System.out.println(completeJSON);
	}
	
	@Test
	public void getPOJOfromObject() throws JsonProcessingException {
		ObjectMapper objMap = new ObjectMapper();
		List<samplePOJO> allemp = objMap.readValue(completeJSON, new TypeReference<List<samplePOJO>>() {});
		
		for(samplePOJO emp: allemp) {
			System.out.println("====================================");
			System.out.println("Name: "+emp.getName());
			System.out.println("Age: "+emp.getAge());
			System.out.println("Salary: "+emp.getSalary());
			System.out.println("Billability Role: "+emp.getBilability());
			System.out.println("====================================");
		}
	}

}
