package co.edu.udistrital.controlador;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/phone")
public class PhoneController {
	
	 	@RequestMapping(value="/hello")
	    public String index(){
	        return "Hello World!";
	    }
	    
	    @RequestMapping(value="/getmap")
	    public Map<String,String> getMap(){
	        Map<String,String> phoneMap = new HashMap<String,String>();
	        phoneMap.put("name", "apple phone");
	        phoneMap.put("money", "5000");
	        return phoneMap;
	    }
}
