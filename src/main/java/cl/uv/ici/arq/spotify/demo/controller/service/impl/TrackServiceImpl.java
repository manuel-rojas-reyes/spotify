package cl.uv.ici.arq.spotify.demo.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import cl.uv.ici.arq.spotify.demo.controller.dto.TrackDTO;
import cl.uv.ici.arq.spotify.demo.controller.service.TrackService;

@Service("trackService")
public class TrackServiceImpl implements TrackService {
	
	private int index = 0; 
	private List<TrackDTO> tracks = new ArrayList<TrackDTO>();

	@Override
	public List<TrackDTO> getTracks(Integer offset, Integer limit) {
		
		List<TrackDTO> tracks_filtered = new ArrayList<TrackDTO>();
		
		for (int index = 0; index < this.tracks.size(); index++) {
			if(tracks_filtered.size() != limit & index >= offset) {
				tracks_filtered.add(this.tracks.get(index));
			}
		}
		
		return tracks_filtered;
	}
	
	
	@Override
	public TrackDTO createTrack(TrackDTO track) {
		track.setId(index);
		index++;
		this.tracks.add(track);
		// TODO Auto-generated method stub
		return track;
	}
	@Override
	public TrackDTO getById(Integer id) {
		// TODO Auto-generated method stub
		return this.tracks.get(id);
	}
	@Override
	public boolean delete(Integer track_id) {
		// TODO Auto-generated method stub
		boolean delete=false;
		
		TrackDTO trackDelete=this.tracks.stream().filter(track -> track_id.equals(track.getId())).findAny().orElse(null);
		
		if(trackDelete!=null) {
			this.tracks.remove(trackDelete);
			delete=true;
		}	
		return delete;
	}
	@Override
	public TrackDTO update(TrackDTO track) {
		int currentindex;
		for (currentindex = 0; currentindex < this.tracks.size(); currentindex++) {
			if (track.getId() == this.tracks.get(currentindex).getId()) {
				this.tracks.get(currentindex).setDuration(track.getDuration());
				this.tracks.get(currentindex).setTitle(track.getTitle());
				break;
			}
		}
		return this.tracks.get(currentindex);
	}
}
