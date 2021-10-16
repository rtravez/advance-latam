import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { auto } from '@popperjs/core';
import { Auto } from 'src/app/models/auto';
import { Marca } from 'src/app/models/marca';
import { Modelo } from 'src/app/models/modelo';
import { Tipo } from 'src/app/models/tipo';
import { AutoService } from 'src/app/services/auto.service';
import { MarcaService } from 'src/app/services/marca.service';
import { ModeloService } from 'src/app/services/modelo.service';
import { TipoService } from 'src/app/services/tipo.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-auto-form',
  templateUrl: './auto-form.component.html',
  styleUrls: ['./auto-form.component.css'],
})
export class AutoFormComponent implements OnInit {
  tipos: Tipo[] = [];
  tipo: Tipo = new Tipo();
  marcas: Marca[] = [];
  marca: Marca = new Marca();
  modelos: Modelo[] = [];
  modelo: Modelo = new Modelo();
  auto: Auto = new Auto();
  errores: string[];

  constructor(
    private router: Router,
    private activatedRoute: ActivatedRoute,
    private tipoService: TipoService,
    private marcaService: MarcaService,
    private modeloService: ModeloService,
    private autoService: AutoService
  ) {}

  ngOnInit(): void {
    this.cargarTipos();
  }

  public cargarTipos(): void {
    this.tipoService.getTipos().subscribe((tipos) => {
      this.tipos = tipos;
    });
  }

  public cargarMarcas(): void {
    if (this.tipo != null) {
      this.marca.tipoDto = this.tipo;
      this.marcaService.getMarcas(this.tipo.tipoId).subscribe((marcas) => {
        this.marcas = marcas;
      });
    }
  }

  public cargarModelos(): void {
    if (this.marca != null) {
      this.modelo.marcaDto = this.marca;
      this.modeloService.getModelos(this.marca.marcaId).subscribe((modelos) => {
        this.modelos = modelos;
      });
    }
  }

  public create(): void {
    if (this.modelo != null) {
      this.auto.modeloDto = this.modelo;
      console.log(this.auto);
      this.autoService.create(this.auto).subscribe(
        (auto) => {
          Swal.fire(
            'Nuevo:',
            `Auto ${this.auto.placa} creado con éxito`,
            'success'
          );

          this.router.navigate(['/dashboard/auto']);
        },
        (err) => {
          if (err.status === 400) {
            this.errores = err.error.errors as string[];
            console.error(err.status);
            console.error(err.error.errors);
          }
        }
      );
    }
  }
}
