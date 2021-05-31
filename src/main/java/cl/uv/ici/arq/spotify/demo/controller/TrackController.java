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

import cl.uv.ici.arq.spotify.demo.controller.dto.TrackDTO;
import cl.uv.ici.arq.spotify.demo.controller.service.impl.TrackServiceImpl;


@RestController
@RequestMapping("api/tracks")
public class TrackController {
	@Autowired
	TrackServiceImpl service;
	
	@GetMapping
	@ResponseBody
	public ResponseEntity<List<TrackDTO>> getProperties(@RequestParam(defaultValue = "0") Integer offset, @RequestParam(defaultValue = "10") Integer limit){
		return new ResponseEntity<List<TrackDTO>>(service.getTracks(offset, limit),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<TrackDTO> save(@RequestBody TrackDTO track) {
		return new ResponseEntity<>(service.createTrack(track), HttpStatus.CREATED);
	}
	@GetMapping("/{trackId}")
	public ResponseEntity<TrackDTO> findById(@PathVariable Integer trackId) {
		return new ResponseEntity<TrackDTO>(service.getById(trackId), HttpStatus.OK);
	}
	
	@DeleteMapping("/{trackId}")
	public ResponseEntity<Boolean> delete(@PathVariable Integer trackId) {
		return new ResponseEntity<Boolean>(service.delete(trackId), HttpStatus.ACCEPTED);
	}
	
	@PutMapping("/{trackId}")
	public ResponseEntity<TrackDTO> update(@PathVariable Integer trackId, @RequestBody TrackDTO trackDTO) {
		trackDTO.setId(trackId);
		return new ResponseEntity<TrackDTO>(service.update(trackDTO), HttpStatus.OK);
	}
	
}
