import { Component, OnInit } from '@angular/core';
import { Empleado } from 'src/app/models/tipo';
import { AuthService } from 'src/app/services/auth.service';
import { EmpleadoService } from 'src/app/services/empleado.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-empleado',
  templateUrl: './empleado.component.html',
  styleUrls: ['./empleado.component.css'],
})
export class EmpleadoComponent implements OnInit {
  empleados: Empleado[];

  constructor(
    private empleadoService: EmpleadoService,
    public authService: AuthService
  ) {}

  ngOnInit(): void {
    this.empleadoService
      .getEmpleados()
      .subscribe((empleados) => (this.empleados = empleados));
  }

  public delete(empleado: Empleado): void {
    Swal.fire({
      title: 'Cuidado:',
      text: `¿Seguro que desea eliminar a ${empleado.nombres} ?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!',
    }).then((result) => {
      if (result.value) {
        this.empleadoService
          .delete(empleado.empleadoId)
          .subscribe((response) => {
            this.empleados = this.empleados.filter((emp) => emp !== empleado);
            Swal.fire(
              'Eliminado:',
              `Empleado ${empleado.nombres} eliminado con éxito.`,
              'success'
            );
          });
      }
    });
  }
}
