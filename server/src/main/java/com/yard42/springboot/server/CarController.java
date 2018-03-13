package com.yard42.springboot.server;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
class CarController
{
   private CarRepository repository;

   public CarController(CarRepository repository)
   {
      this.repository = repository;
   }

   @GetMapping("/cool-cars")
   @CrossOrigin(origins = "http://localhost:4200")
   public Collection<Car> coolCars()
   {
      return repository.findAll().stream()
         .filter(this::isCool)
         .collect(Collectors.toList());
   }

   private boolean isCool(Car car)
   {
      return !car.getName().equals("AMC Gremlin") &&
         !car.getName().equals("Triumph Stag") &&
         !car.getName().equals("Ford Pinto") &&
         !car.getName().equals("Yugo GV");
   }
}