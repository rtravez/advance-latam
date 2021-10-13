import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Empleado } from 'src/app/models/empleado';
import { EmpleadoService } from 'src/app/services/empleado.service';

@Component({
  selector: 'app-empleado-form',
  templateUrl: './empleado-form.component.html',
  styleUrls: ['./empleado-form.component.css'],
})
export class EmpleadoFormComponent implements OnInit {
  empleado: Empleado;

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private empleadoService: EmpleadoService
  ) {}

  ngOnInit(): void {
    this.cargarEmpleado();
  }

  public cargarEmpleado(): void {
    this.activatedRoute.paramMap.subscribe((params) => {
      const cedula: string = params.get('cedula');
      console.log(cedula);
      if (cedula) {
        this.empleadoService.getEmpleado(cedula).subscribe((e) => {
          this.empleado = e;
          console.log(e);
          // console.log(c.region);
        });
      }
    });

    /*this.regionService
      .getRegiones()
      .subscribe((regiones) => (this.regiones = regiones));*/
  }
}
