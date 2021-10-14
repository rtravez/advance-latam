package ec.advance.latam.com.controller;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.advance.latam.com.mapper.IAutoMapper;
import ec.advance.latam.com.service.IAutoService;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author rene.travez
 * @version $1.0$
 */
@RestController()
@RequestMapping("/api")
public class AutoController {

	private static final Logger LOG = LoggerFactory.getLogger(AutoController.class);

	@Autowired
	private IAutoService autoService;
	@Autowired
	private IAutoMapper autoMapper;
	private Map<String, Object> response;

	public AutoController() {
		response = new HashMap<>();
	}

}
