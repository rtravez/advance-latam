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
 ARCHIVO:     IEmpleadosVacunaMapper.java 
 DESCRIPCION: Descripcion de la clase, interface o enumeracion.
 *************************************************************************
                             	MODIFICACIONES

 FECHA         		AUTOR          					COMENTARIOS
 Oct 10, 2021 	        renetravez					   	 Emisión Inicial
 ***************************************************************************/
package ec.advance.latam.com.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import ec.advance.latam.com.dto.EmpleadosVacunaDto;
import ec.advance.latam.com.entity.EmpleadosVacuna;

/**
 * <b> Descripcion de la clase, interface o enumeracion. </b>
 * 
 * @author renetravez
 * @version $1.0$
 */
@Mapper
public interface IEmpleadosVacunaMapper {

	@Mapping(target = "empleadoDto", source = "empleado")
	@Mapping(target = "vacunaDto", source = "vacuna")
	public EmpleadosVacunaDto empleadosVacunaToEmpleadosVacunaDto(EmpleadosVacuna empleadosVacuna);

	public EmpleadosVacuna empleadosVacunaDtoToEmpleadosVacuna(EmpleadosVacunaDto empleadosVacunaDto);

	public List<EmpleadosVacunaDto> listEmpleadosVacunaToListEmpleadosVacunaDto(List<EmpleadosVacuna> empleadosVacunas);

	public List<EmpleadosVacuna> listEmpleadosVacunaDtoToListEmpleadosVacuna(List<EmpleadosVacunaDto> empleadosVacunaDtos);

}
