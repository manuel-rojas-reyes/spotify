package cl.uv.ici.arq.spotify.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cl.uv.ici.arq.spotify.demo.controller.dto.UserDTO;
import cl.uv.ici.arq.spotify.demo.controller.service.impl.UserServiceImpl;


@RestController
@RequestMapping("api/users")
public class UserController {
	@Autowired
	UserServiceImpl service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<UserDTO>> getProperties(@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "10") Integer limit){
		return new ResponseEntity<List<UserDTO>>(service.getUsers(offset, limit),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> save(@RequestBody UserDTO user) {
		return new ResponseEntity<>(service.createUser(user), HttpStatus.CREATED);
	}
	@GetMapping("/{userId}")
	public ResponseEntity<UserDTO> findById(@PathVariable Integer userId) {
		return new ResponseEntity<UserDTO>(service.getById(userId), HttpStatus.OK);
	}
	
	@DeleteMapping("/{userId}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer userId) {
		return new ResponseEntity<Boolean>(service.delete(userId), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{userId}")
	public ResponseEntity<UserDTO> update(@PathVariable Integer userId, @RequestBody UserDTO userDTO) {
		userDTO.setId(userId);
		return new ResponseEntity<UserDTO>(service.update(userDTO), HttpStatus.OK);
	}
	
}
