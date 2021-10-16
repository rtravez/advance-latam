/**************************************************************************
				(c) Copyright ADVANCE-LATAM 2021
                             www.advance.latam.com
                             info@advance.latam.com

 Este programa de computador es propiedad de ADVANCE-LATAM y esta 
 protegido por las leyes y tratados internacionales de derechos de 
 autor. El uso, reproducción o distribución no autorizada de este programa, 
 o cualquier porción de él, puede dar lugar a sanciones criminales y 
 civiles severas, y serán procesadas con el grado máximo contemplado 
 por la ley.
 
 ************************************************************************* 
 PROYECTO:	  backend-amt  
 ARCHIVO:     IEmpleadoMapper.java 
 DESCRIPCION: Descripcion de la clase, interface o enumeracion.
 *************************************************************************
                             	MODIFICACIONES

 FECHA         		AUTOR          					COMENTARIOS
 Oct 9, 2021 	    renetravez					   	 Emisión Inicial
 ***************************************************************************/
package ec.advance.latam.com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import ec.advance.latam.com.dto.ModeloDto;
import ec.advance.latam.com.entity.Modelo;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@Mapper(implementationName = "ModeloMapper", implementationPackage = "<PACKAGE_NAME>.impl", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IModeloMapper {

	IModeloMapper INSTANCE = Mappers.getMapper(IModeloMapper.class);

	@Mapping(target = "marcaDto.tipoDto", source = "marca.tipo")
	@Mapping(target = "marcaDto", source = "marca")
	public ModeloDto modeloToModeloDto(Modelo modelo);

	@Mapping(target = "marca.tipo", source = "marcaDto.tipoDto")
	@Mapping(target = "marca", source = "marcaDto")
	public Modelo modeloDtoToModelo(ModeloDto modeloDto);

	public List<ModeloDto> listModeloToListModeloDto(List<Modelo> modelos);

	public List<Modelo> listModeloDtoToListModelo(List<ModeloDto> modeloDtos);

}
