import { CarService } from '../shared/car/car.service';
import { Component, OnInit } from '@angular/core';
import { GiphyService } from '../shared/giphy/giphy.service';

@Component({
  selector: 'app-car-list',
  templateUrl: './car-list.component.html',
  styleUrls: ['./car-list.component.css']
})
export class CarListComponent implements OnInit {
  cars: Array<any>;
  constructor(private carService: CarService, private giphyService: GiphyService) { }

  ngOnInit() {
    this.carService.getAll().subscribe(data => {
      this.cars = data;

      for (const car of this.cars) {
        this.giphyService.get(car.name + ' car').subscribe(url => car.giphyUrl = url);
      }
    });
  }
}