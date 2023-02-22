package com.deverything.candidate.productstore.common.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name ="SUMMARYCHECKOUT")
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class SummaryCheckoutDomain {

	  @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @EqualsAndHashCode.Include
	 private int idcheckoutsummary;
	
	 private double total;
	 
	 private String adress;
	
}
