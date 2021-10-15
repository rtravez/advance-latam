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
import org.mapstruct.factory.Mappers;

import ec.advance.latam.com.dto.MarcaDto;
import ec.advance.latam.com.entity.Marca;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@Mapper(implementationName = "MarcaMapper", implementationPackage = "<PACKAGE_NAME>.impl")
public interface IMarcaMapper {

	IMarcaMapper INSTANCE = Mappers.getMapper(IMarcaMapper.class);

	@Mapping(target = "modeloDtos", source = "modelos")
	public MarcaDto marcaToMarcaDto(Marca marca);

	@Mapping(target = "modelos", source = "modeloDtos")
	public Marca marcaDtoToMarca(MarcaDto marcaDto);

	public List<MarcaDto> listMarcaToListMarcaDto(List<Marca> marcas);

	public List<Marca> listMarcaDtoToListMarca(List<MarcaDto> marcaDtos);

}
