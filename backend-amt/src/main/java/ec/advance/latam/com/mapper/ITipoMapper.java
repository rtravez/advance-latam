package ec.advance.latam.com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import ec.advance.latam.com.dto.TipoDto;
import ec.advance.latam.com.entity.Tipo;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@Mapper(implementationName = "TipoMapper", implementationPackage = "<PACKAGE_NAME>.impl", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ITipoMapper {

	ITipoMapper INSTANCE = Mappers.getMapper(ITipoMapper.class);

	@Mapping(target = "marcaDtos", source = "marcas")
	public TipoDto tipoToTipoDto(Tipo tipo);

	@Mapping(target = "marcas", source = "marcaDtos")
	public Tipo tipoDtoToTipo(TipoDto tipoDto);

	public List<TipoDto> listTipoToListTipoDto(List<Tipo> tipos);

	public List<Tipo> listTipoDtoToListTipo(List<TipoDto> tipoDtos);

}
