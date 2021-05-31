package cl.uv.ici.arq.spotify.demo.controller.dto;

public class PlaylistDTO {

	private Integer id;
	private String name;
	private Integer id_user;
	private Integer id_author;
	private Integer[] id_tracks;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getId_user() {
		return id_user;
	}
	public void setId_user(Integer id_user) {
		this.id_user = id_user;
	}
	public Integer getId_author() {
		return id_author;
	}
	public void setId_author(Integer id_author) {
		this.id_author = id_author;
	}
	public Integer[] getId_tracks() {
		return id_tracks;
	}
	public void setId_tracks(Integer[] id_tracks) {
		this.id_tracks = id_tracks;
	}
	
}
