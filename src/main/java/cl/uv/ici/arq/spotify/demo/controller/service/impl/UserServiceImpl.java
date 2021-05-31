package cl.uv.ici.arq.spotify.demo.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import cl.uv.ici.arq.spotify.demo.controller.dto.UserDTO;
import cl.uv.ici.arq.spotify.demo.controller.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	private int index = 0; 
	private List<UserDTO> users = new ArrayList<UserDTO>();

	@Override
	public List<UserDTO> getUsers(Integer offset, Integer limit) {
		
		List<UserDTO> users_filtered = new ArrayList<UserDTO>();
		
		for (int index = 0; index < this.users.size(); index++) {
			if(users_filtered.size() != limit & index >= offset) {
				users_filtered.add(this.users.get(index));
			}
		}
		
		return users_filtered;
	}
	
	
	@Override
	public UserDTO createUser(UserDTO user) {
		user.setId(index);
		index++;
		this.users.add(user);
		// TODO Auto-generated method stub
		return user;
	}
	@Override
	public UserDTO getById(Integer id) {
		// TODO Auto-generated method stub
		return this.users.get(id);
	}
	@Override
	public boolean delete(Integer user_id) {
		// TODO Auto-generated method stub
		boolean delete=false;
		
		UserDTO userDelete=this.users.stream().filter(user -> user_id.equals(user.getId())).findAny().orElse(null);
		
		if(userDelete!=null) {
			this.users.remove(userDelete);
			delete=true;
		}	
		return delete;
	}
	@Override
	public UserDTO update(UserDTO user) {
		int currentindex;
		for (currentindex = 0; currentindex < this.users.size(); currentindex++) {
			if (user.getId() == this.users.get(currentindex).getId()) {
				this.users.get(currentindex).setName(user.getName());
				//Agregar más cosas
				break;
			}
		}
		return this.users.get(currentindex);
	}
}
