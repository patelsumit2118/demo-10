package com.rays.proj;




import java.util.List;

import javax.transaction.Transactional;
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Service;

  @Service
  @Transactional
  public class UserService< d extends UserDao >{
 	
	@Autowired UserDao dao;
	
	public long add(UserDto dto) {
		return dao.add(dto);
		
	}
	
	public UserDto findById(long id) {
	return	dao.findById(id);
	}
	
	
	
	public UserDto update (UserDto dto) {
		return dao.update(dto);
	}
	
	public List search (UserDto dto) {
		return dao.search(dto);
	}
	

 }


