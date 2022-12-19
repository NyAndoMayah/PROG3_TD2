package com.example.prog3_td2.models;

import static jakarta.persistence.GenerationType.IDENTITY;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class sponsor {
  @Id
  @GeneratedValue(strategy = IDENTITY)
  private int id;
  @JsonIgnoreProperties("sponsors")
  @ManyToMany(mappedBy = "sponsors")
  private List<team> teams;
  @Column(name = "\"name\"")
  private String name;
}
