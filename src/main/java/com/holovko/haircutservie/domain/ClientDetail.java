package com.holovko.haircutservie.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Table;

@Table(name = "client_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientDetail extends BaseEntity{
}
