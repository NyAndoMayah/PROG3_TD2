package com.example.prog3_td2.models;

import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class player {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private int id;
  @Column(name = "\"name\"")
  private String name;
  private int number;
  @ManyToOne
  @JoinColumn(name = "id_team")
  private team team;
}
