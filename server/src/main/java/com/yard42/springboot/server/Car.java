package com.yard42.springboot.server;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter
@NoArgsConstructor @ToString
@EqualsAndHashCode
public class Car
{
   @Id @GeneratedValue
   private Long id;

   private @NonNull String name;
}
