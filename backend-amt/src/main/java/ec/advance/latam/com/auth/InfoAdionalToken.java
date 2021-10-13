package ec.advance.latam.com.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import ec.advance.latam.com.entity.Usuario;
import ec.advance.latam.com.service.IUsuarioService;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@Component
public class InfoAdionalToken implements TokenEnhancer {

	@Autowired
	private IUsuarioService usuarioService;

	@Override
	public OAuth2AccessToken enhance(OAuth2AccessToken accessToken, OAuth2Authentication authentication) {
		Usuario usuario = usuarioService.findByUsername(authentication.getName()).orElse(null);
		if (usuario != null) {
			Map<String, Object> additionalInformation = new HashMap<>();
			additionalInformation.put("enabled", usuario.getEnabled());
			((DefaultOAuth2AccessToken) accessToken).setAdditionalInformation(additionalInformation);
		}
		return accessToken;
	}
}
