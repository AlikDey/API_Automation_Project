package POJO;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class dataSerializaAndDeserialize {
	
	@Test
	public void createDataToPOJO() throws JsonProcessingException {
		samplePOJO emp = new samplePOJO();
		emp.setName("Alik");
		emp.setAge(24);
		emp.setSalary(30000.50);
		emp.setBilability(false);
		
		ObjectMapper objMapper = new ObjectMapper();
		String empJSON = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
		System.out.println(empJSON);
		
	}
	
	@Test
	public void getPOJOFromObject() throws JsonProcessingException {
		samplePOJO emp = new samplePOJO();
		emp.setName("Alik");
		emp.setAge(24);
		emp.setSalary(30000.50);
		emp.setBilability(false);
		
		ObjectMapper objMapper = new ObjectMapper();
		String empJSON = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(emp);
		
		samplePOJO empObj = objMapper.readValue(empJSON, samplePOJO.class);
		
		System.out.println("Name: "+empObj.getName());
		System.out.println("Age: "+empObj.getAge());
		System.out.println("Salary: "+empObj.getSalary());
		System.out.println("Bollability Role: "+empObj.getBilability());
		
	}

}
