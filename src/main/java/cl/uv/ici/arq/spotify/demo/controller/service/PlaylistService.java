package cl.uv.ici.arq.spotify.demo.controller.service;

import java.util.List;

import cl.uv.ici.arq.spotify.demo.controller.dto.PlaylistDTO;

public interface PlaylistService {

	public List<PlaylistDTO> getPlaylists(Integer offset, Integer limit);
	public PlaylistDTO createPlaylist(PlaylistDTO playlist);
	public PlaylistDTO getById(Integer id);
	public boolean delete(Integer id);
	public PlaylistDTO update(PlaylistDTO playlist);
}
