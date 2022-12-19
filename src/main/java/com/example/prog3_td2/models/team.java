package com.example.prog3_td2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class team {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private int id;
  @Column(name = "\"name\"")
  private String name;

  @JsonIgnoreProperties("teams")
  @ManyToMany
  @JoinTable(
      name = "have_sponsor",
      joinColumns = @JoinColumn(name = "id_team", referencedColumnName = "id"),
      inverseJoinColumns = @JoinColumn(name = "id_sponsor", referencedColumnName = "id")
  )
  private List<sponsor> sponsors;
  @OneToOne
  @JoinTable(
      name = "play_against",
      joinColumns = {
          @JoinColumn(name = "id_home", referencedColumnName = "id"),
      },
      inverseJoinColumns = {
          @JoinColumn(name = "id_opponent", referencedColumnName = "id"),
      }
  )
  private team opponent;
}