package com.example.prog3_td2.models;

import static jakarta.persistence.GenerationType.IDENTITY;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "play_against")
public class match {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private int id;
  @OneToOne
  @JoinColumn(name = "id_home")
  private team home;
  @OneToOne
  @JoinColumn(name = "id_opponent")
  private team opponent;
  private LocalDateTime datetime;
  private String stadium;
}
