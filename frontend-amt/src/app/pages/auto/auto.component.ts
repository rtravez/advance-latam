import { Component, OnInit } from '@angular/core';
import { Auto } from 'src/app/models/auto';
import { AuthService } from 'src/app/services/auth.service';
import { AutoService } from 'src/app/services/auto.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-auto',
  templateUrl: './auto.component.html',
  styleUrls: ['./auto.component.css'],
})
export class AutoComponent implements OnInit {
  autos: Auto[] = [];
  auto: Auto = new Auto();
  error: string;

  constructor(
    private autoService: AutoService,
    public authService: AuthService
  ) {}

  ngOnInit(): void {}

  public find(): void {
    this.autos = [];
    this.error = null;
    if (this.auto != null && this.auto.placa != null) {
      this.autoService.getAutoByPlaca(this.auto.placa).subscribe(
        (auto) => {
          this.autos.push(auto);
          //this.autos = this.autos.filter((aut) => aut === auto);
        },
        (err) => {
          if (err.status === 404 || err.status === 500) {
            this.error = err.error.error;
            console.log(this.error);
          }
        }
      );
    } else {
    }
  }

  public delete(auto: Auto): void {
    Swal.fire({
      title: 'Cuidado:',
      text: `¿Seguro que desea eliminar el auto ${auto.placa} ?`,
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Si, eliminar!',
    }).then((result) => {
      if (result.value) {
        this.autoService.delete(auto.autoId).subscribe((response) => {
          this.autos = this.autos.filter((aut) => aut !== auto);
          Swal.fire(
            'Eliminado:',
            `Auto ${auto.placa} eliminado con éxito.`,
            'success'
          );
        });
      }
    });
  }
}
