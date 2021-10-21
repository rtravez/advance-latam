
package ec.advance.latam.com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import ec.advance.latam.com.dto.AutoDto;
import ec.advance.latam.com.entity.Auto;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@Mapper(implementationName = "AutoMapper", implementationPackage = "<PACKAGE_NAME>.impl", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IAutoMapper {

	IAutoMapper INSTANCE = Mappers.getMapper(IAutoMapper.class);

	@Mapping(target = "modeloDto.marcaDto.tipoDto", source = "modelo.marca.tipo")
	@Mapping(target = "modeloDto.marcaDto", source = "modelo.marca")
	@Mapping(target = "modeloDto", source = "modelo")
	@Mapping(target = "movilizacionDtos", source = "movilizaciones")
	public AutoDto autoToAutoDto(Auto auto);

	@Mapping(target = "modelo.marca.tipo", source = "modeloDto.marcaDto.tipoDto")
	@Mapping(target = "modelo.marca", source = "modeloDto.marcaDto")
	@Mapping(target = "modelo", source = "modeloDto")
	@Mapping(target = "movilizaciones", source = "movilizacionDtos")
	public Auto autoDtoToAuto(AutoDto autoDto);

	@Mapping(target = "modeloDto.marcaDto", source = "modelo.marca")
	@Mapping(target = "modeloDto", source = "modelo")
	@Mapping(target = "tipoDto", source = "tipo")
	public List<AutoDto> listAutoToListAutoDto(List<Auto> autos);

	@Mapping(target = "modelo.marca", source = "modeloDto.marcaDto")
	@Mapping(target = "modelo", source = "modeloDto")
	@Mapping(target = "tipo", source = "tipoDto")
	@Mapping(target = "movilizaciones", source = "movilizacionDtos")
	public List<Auto> listAutoDtoToListAuto(List<AutoDto> autoDtos);

}
