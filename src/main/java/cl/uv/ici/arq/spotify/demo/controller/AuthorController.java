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

import cl.uv.ici.arq.spotify.demo.controller.dto.AuthorDTO;
import cl.uv.ici.arq.spotify.demo.controller.service.impl.AuthorServiceImpl;


@RestController
@RequestMapping("api/authors")
public class AuthorController {
	@Autowired
	AuthorServiceImpl service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<AuthorDTO>> getProperties(@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "10") Integer limit){
		return new ResponseEntity<List<AuthorDTO>>(service.getAuthors(offset, limit),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<AuthorDTO> save(@RequestBody AuthorDTO author) {
		return new ResponseEntity<>(service.createAuthor(author), HttpStatus.CREATED);
	}
	@GetMapping("/{authorId}")
	public ResponseEntity<AuthorDTO> findById(@PathVariable String authorId) {
		return new ResponseEntity<AuthorDTO>(service.getById(authorId), HttpStatus.OK);
	}
	
	@DeleteMapping("/{authorId}")
	public ResponseEntity<Boolean> delete(@PathVariable String authorId) {
		return new ResponseEntity<Boolean>(service.delete(authorId), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{authorId}")
	public ResponseEntity<AuthorDTO> update(@PathVariable String authorId, @RequestBody AuthorDTO authorDTO) {
		authorDTO.setId(authorId);
		return new ResponseEntity<AuthorDTO>(service.update(authorDTO), HttpStatus.OK);
	}
	
}
