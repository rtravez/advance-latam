import { Component, OnInit } from '@angular/core';
import { Auto } from 'src/app/models/auto';
import { AuthService } from 'src/app/services/auth.service';
import { AutoService } from 'src/app/services/auto.service';

@Component({
  selector: 'app-auto',
  templateUrl: './auto.component.html',
  styleUrls: ['./auto.component.css'],
})
export class AutoComponent implements OnInit {
  autos: Auto[] = [];

  constructor(
    private autoService: AutoService,
    public authService: AuthService
  ) {}

  ngOnInit(): void {}
}
