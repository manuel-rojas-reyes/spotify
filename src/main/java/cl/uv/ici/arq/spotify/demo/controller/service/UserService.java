package cl.uv.ici.arq.spotify.demo.controller.service;

import java.util.List;

import cl.uv.ici.arq.spotify.demo.controller.dto.UserDTO;

public interface UserService {

	public List<UserDTO> getUsers(Integer offset, Integer limit);
	public UserDTO createUser(UserDTO user);
	public UserDTO getById(Integer id);
	public boolean delete(Integer id);
	public UserDTO update(UserDTO user);
}
