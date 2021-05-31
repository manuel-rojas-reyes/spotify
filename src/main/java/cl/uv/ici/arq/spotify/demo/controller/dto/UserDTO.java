package cl.uv.ici.arq.spotify.demo.controller.dto;

public class UserDTO {
	private Integer id;
	private String username;
	private Integer[] id_playlist;
	private String name;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Integer[] getId_playlist() {
		return id_playlist;
	}
	public void setId_playlist(Integer[] id_playlist) {
		this.id_playlist = id_playlist;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
