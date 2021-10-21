package ec.advance.latam.com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import ec.advance.latam.com.dto.MarcaDto;
import ec.advance.latam.com.entity.Marca;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@Mapper(implementationName = "MarcaMapper", implementationPackage = "<PACKAGE_NAME>.impl", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IMarcaMapper {

	IMarcaMapper INSTANCE = Mappers.getMapper(IMarcaMapper.class);

	@Mapping(target = "modeloDtos", source = "modelos")
	@Mapping(target = "tipoDto", source = "tipo")
	public MarcaDto marcaToMarcaDto(Marca marca);

	@Mapping(target = "modelos", source = "modeloDtos")
	@Mapping(target = "tipo", source = "tipoDto")
	public Marca marcaDtoToMarca(MarcaDto marcaDto);

	public List<MarcaDto> listMarcaToListMarcaDto(List<Marca> marcas);

	public List<Marca> listMarcaDtoToListMarca(List<MarcaDto> marcaDtos);

}
