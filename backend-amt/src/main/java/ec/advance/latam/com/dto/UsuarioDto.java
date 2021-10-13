package ec.advance.latam.com.dto;

import java.io.Serializable;

public class UsuarioDto implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long usuarioId;

	private String password;

	private Boolean enabled;

	private String username;

	public UsuarioDto() {
	}

	public Long getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(Long usuarioId) {
		this.usuarioId = usuarioId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}