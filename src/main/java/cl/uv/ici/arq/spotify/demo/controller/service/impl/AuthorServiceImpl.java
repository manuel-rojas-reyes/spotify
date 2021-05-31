package cl.uv.ici.arq.spotify.demo.controller.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.reflect.TypeToken;

import cl.uv.ici.arq.spotify.demo.controller.dto.AuthorDTO;
import cl.uv.ici.arq.spotify.demo.controller.entities.AuthorEntity;
import cl.uv.ici.arq.spotify.demo.controller.service.AuthorService;
import cl.uv.ici.arq.spotify.demo.mapper.MapperUtils;
import cl.uv.ici.arq.spotify.demo.repository.AuthorRepository;
import lombok.*;

@Service("authorService")
public class AuthorServiceImpl implements AuthorService {
	
	@Autowired
	AuthorRepository authorRepository;
	
	private AuthorEntity mapUserEntity(AuthorDTO authorDTO) {
		AuthorEntity author = new AuthorEntity();
		
		author.setName(authorDTO.getName());
		author.setFollowers(authorDTO.getFollowers());
		author.setId_playlist(authorDTO.getId_playlist());
		

		return author;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<AuthorDTO> getAuthors(Integer offset, Integer limit) {
		
		/*List<AuthorDTO> authors_filtered = new ArrayList<AuthorDTO>();
		
		for (int index = 0; index < this.authors.size(); index++) {
			if(authors_filtered.size() != limit & index >= offset) {
				authors_filtered.add(this.authors.get(index));
			}
		}
		
		return authors_filtered;*/
		return (List<AuthorDTO>) MapperUtils.mapAsList(authorRepository.findAll(), new TypeToken<List<AuthorDTO>>() {}.getType());
	}
	
	
	@Override
	public AuthorDTO createAuthor(AuthorDTO authorDTO) {
		AuthorEntity authorEntity = this.mapUserEntity(authorDTO);
		authorEntity = this.authorRepository.save(authorEntity);
		authorDTO = (AuthorDTO) MapperUtils.map(authorEntity, AuthorDTO.class);
		return authorDTO;
	}
	
	@Override
	public AuthorDTO getById(String idAuthor) {
		return (AuthorDTO) MapperUtils.map(this.authorRepository.findById(UUID.fromString(idAuthor)).get(), AuthorDTO.class);
	}
	@Override
	public boolean delete(String authorId) {
		boolean delete=true;		
		this.authorRepository.deleteById(UUID.fromString(authorId));		
		return delete;
	}
	
	@Override
	public AuthorDTO update(AuthorDTO authorDTO) {
		AuthorEntity authorEntity = this.mapUserEntity(authorDTO);
		authorEntity.setAuthorId(UUID.fromString(authorDTO.getId()));
		authorEntity = this.authorRepository.save(authorEntity);
		authorDTO = (AuthorDTO) MapperUtils.map(authorEntity, AuthorDTO.class);
		return authorDTO;
	}
}
