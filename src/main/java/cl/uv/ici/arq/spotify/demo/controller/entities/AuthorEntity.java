package cl.uv.ici.arq.spotify.demo.controller.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name= "Author")

public class AuthorEntity {

	@Id
    @Column(name = "ID", nullable = false)
    @GeneratedValue
    private UUID trackId;
	
	private String name;
	private Integer followers;
	private Integer id_playlist;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getFollowers() {
		return followers;
	}
	public void setFollowers(Integer followers) {
		this.followers = followers;
	}
	public Integer getId_playlist() {
		return id_playlist;
	}
	public void setId_playlist(Integer id_playlist) {
		this.id_playlist = id_playlist;
	}
	public void setAuthorId(UUID fromString) {
		trackId = fromString;
		
	}
	
	
}
