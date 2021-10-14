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

import ec.advance.latam.com.dto.AutoDto;
import ec.advance.latam.com.entity.Auto;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@Mapper
public interface IAutoMapper {

	@Mapping(target = "marcaDto", source = "marca")
	@Mapping(target = "tipoDto", source = "tipo")
	@Mapping(target = "movilizacionDtos", source = "movilizaciones")
	public AutoDto autoToAutoDto(Auto auto);

	public Auto autoDtoToAuto(AutoDto autoDto);

	public List<AutoDto> listAutoToListAutoDto(List<Auto> autos);

	public List<Auto> listAutoDtoToListAuto(List<AutoDto> autoDtos);

}
