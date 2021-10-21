package ec.advance.latam.com.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class UsuarioServiceTest {
	@Autowired
	private IUsuarioService usuariosService;

	@Test
	@DisplayName("findAll")
	void findAll() {
		// Arrange

		// Act

		// Assert
		assertNotNull(usuariosService);
	}

	@Test
	@DisplayName("save")
	void save() throws Exception {
		// Arrange

		// Act

		// Assert
		assertNotNull(usuariosService);
	}

	@Test
	@DisplayName("delete")
	void delete() throws Exception {
		// Arrange

		// Act

		// Assert
		assertNotNull(usuariosService);
	}

	@Test
	@DisplayName("deleteById")
	void deleteById() throws Exception {
		// Arrange

		// Act

		// Assert
		assertNotNull(usuariosService);
	}

	@Test
	@DisplayName("update")
	void update() throws Exception {
		// Arrange

		// Act

		// Assert
		assertNotNull(usuariosService);
	}

	@Test
	@DisplayName("findById")
	void findById() throws Exception {
		// Arrange

		// Act

		// Assert
		assertNotNull(usuariosService);
	}

	@Test
	@DisplayName("count")
	void count() throws Exception {
		// Arrange

		// Act

		// Assert
		assertNotNull(usuariosService);
	}
}
