package cl.uv.ici.arq.spotify.demo.controller.dto;

public class TrackDTO {
	
	private Integer id;
	private String title;
	private Integer id_playlist;
	private Integer duration;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getId_playlist() {
		return id_playlist;
	}
	public void setId_playlist(Integer id_playlist) {
		this.id_playlist = id_playlist;
	}
	public Integer getDuration() {
		return duration;
	}
	public void setDuration(Integer duration) {
		this.duration = duration;
	}

}
