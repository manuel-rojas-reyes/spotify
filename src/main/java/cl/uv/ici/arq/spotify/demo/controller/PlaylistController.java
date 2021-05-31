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

import cl.uv.ici.arq.spotify.demo.controller.dto.PlaylistDTO;
import cl.uv.ici.arq.spotify.demo.controller.service.impl.PlaylistServiceImpl;


@RestController
@RequestMapping("api/playlists")
public class PlaylistController {
	@Autowired
	PlaylistServiceImpl service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<PlaylistDTO>> getProperties(@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "10") Integer limit){
		return new ResponseEntity<List<PlaylistDTO>>(service.getPlaylists(offset, limit),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PlaylistDTO> save(@RequestBody PlaylistDTO playlist) {
		return new ResponseEntity<>(service.createPlaylist(playlist), HttpStatus.CREATED);
	}
	@GetMapping("/{playlistId}")
	public ResponseEntity<PlaylistDTO> findById(@PathVariable Integer playlistId) {
		return new ResponseEntity<PlaylistDTO>(service.getById(playlistId), HttpStatus.OK);
	}
	
	@DeleteMapping("/{playlistId}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer playlistId) {
		return new ResponseEntity<Boolean>(service.delete(playlistId), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{playlistId}")
	public ResponseEntity<PlaylistDTO> update(@PathVariable Integer playlistId, @RequestBody PlaylistDTO playlistDTO) {
		playlistDTO.setId(playlistId);
		return new ResponseEntity<PlaylistDTO>(service.update(playlistDTO), HttpStatus.OK);
	}
	
}
