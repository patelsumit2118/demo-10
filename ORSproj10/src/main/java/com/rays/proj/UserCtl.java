package com.rays.proj;



 import java.util.List;

  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.web.bind.annotation.GetMapping;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.PostMapping;
  import org.springframework.web.bind.annotation.RequestBody;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RestController;

import antlr.collections.impl.LList;

  @RestController
  @RequestMapping(value = "user")
  public class UserCtl <f extends UserForm, t extends UserDto, s extends UserService> {
	
	
	@Autowired UserService service;
	
	@PostMapping("signUp")
	public String signUp(@RequestBody UserForm f) {
		
		UserDto dto=new UserDto();
		dto.setFirstName(f.getFirstName());
		
		dto.setLastName(f.getLastName());
		dto.setLoginId(f.getLoginId());
		dto.setPassword(f.getPassword());
		dto.setDOB(f.getDOB());
		
		service.add(dto);
		return "useradded";
	}
	
	
	
	@PostMapping("update/{id}")
	public String update (@RequestBody UserForm f,@PathVariable long id) {
		UserDto dto = service.findById(id);
		dto.setFirstName(f.getFirstName());
		dto.setLastName(f.getLastName());
		dto.setLoginId(f.getLoginId());
		dto.setPassword(f.getPassword());
		
		service.update(dto);
		
		return "userupdated";
		
	}
	
	
	  @GetMapping("/search") public List search () { UserDto dto = new UserDto();
	  return service.search(dto);
	  
	  }
	 
		@GetMapping("get/{id}")
	public UserDto  search(@PathVariable long id) {
	UserDto dto =	service.findById(id);
	return  dto;
		
	}
	
	@PostMapping("search")
	public List search(@RequestBody UserForm f) {
		UserDto dto = new UserDto();
		dto.setFirstName(f.getFirstName());
		List list = service.search(dto);
		return list;
	}
	
	
	
	
				
				
	}	
	
  
	



