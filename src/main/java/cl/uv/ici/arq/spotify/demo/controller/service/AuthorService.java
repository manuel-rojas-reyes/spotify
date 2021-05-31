package cl.uv.ici.arq.spotify.demo.controller.service;

import java.util.List;

import cl.uv.ici.arq.spotify.demo.controller.dto.AuthorDTO;

public interface AuthorService {

	public List<AuthorDTO> getAuthors(Integer offset, Integer limit);
	public AuthorDTO createAuthor(AuthorDTO author);
	public AuthorDTO getById(String id);
	public boolean delete(String id);
	public AuthorDTO update(AuthorDTO author);
}
