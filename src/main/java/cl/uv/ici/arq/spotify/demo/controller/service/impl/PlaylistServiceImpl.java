package cl.uv.ici.arq.spotify.demo.controller.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;


import cl.uv.ici.arq.spotify.demo.controller.dto.PlaylistDTO;
import cl.uv.ici.arq.spotify.demo.controller.service.PlaylistService;

@Service("playlistService")
public class PlaylistServiceImpl implements PlaylistService {
	
	private int index = 0; 
	private List<PlaylistDTO> playlists = new ArrayList<PlaylistDTO>();

	@Override
	public List<PlaylistDTO> getPlaylists(Integer offset, Integer limit) {
		
		List<PlaylistDTO> playlists_filtered = new ArrayList<PlaylistDTO>();
		
		for (int index = 0; index < this.playlists.size(); index++) {
			if(playlists_filtered.size() != limit & index >= offset) {
				playlists_filtered.add(this.playlists.get(index));
			}
		}
		
		return playlists_filtered;
	}
	
	
	@Override
	public PlaylistDTO createPlaylist(PlaylistDTO playlist) {
		playlist.setId(index);
		index++;
		this.playlists.add(playlist);
		// TODO Auto-generated method stub
		return playlist;
	}
	@Override
	public PlaylistDTO getById(Integer id) {
		// TODO Auto-generated method stub
		return this.playlists.get(id);
	}
	@Override
	public boolean delete(Integer playlist_id) {
		// TODO Auto-generated method stub
		boolean delete=false;
		
		PlaylistDTO playlistDelete=this.playlists.stream().filter(playlist -> playlist_id.equals(playlist.getId())).findAny().orElse(null);
		
		if(playlistDelete!=null) {
			this.playlists.remove(playlistDelete);
			delete=true;
		}	
		return delete;
	}
	@Override
	public PlaylistDTO update(PlaylistDTO playlist) {
		int currentindex;
		for (currentindex = 0; currentindex < this.playlists.size(); currentindex++) {
			if (playlist.getId() == this.playlists.get(currentindex).getId()) {
				this.playlists.get(currentindex).setName(playlist.getName());
				//Agregar más cosas
				break;
			}
		}
		return this.playlists.get(currentindex);
	}
}
