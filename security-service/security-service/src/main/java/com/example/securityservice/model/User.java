package com.example.securityservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String username;

  private String password;

  private String mail;
  @ManyToMany(fetch = FetchType.EAGER)
  private Collection<Role> roles = new ArrayList<>();
}