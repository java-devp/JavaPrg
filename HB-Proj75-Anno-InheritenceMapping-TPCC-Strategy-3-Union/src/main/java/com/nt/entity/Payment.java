package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import lombok.Data;

@Entity
//@Table(name="INH_PAYMENT_TPSC_DISC")
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Data
//@DiscriminatorColumn(name="PAYMENT_MODE",length=15,discriminatorType=DiscriminatorType.STRING)
//@Polymorphism(type=PolymorphismType.EXPLICIT)  //no effect will be in the o/p
public abstract class Payment { 
	 @Id
	 @GenericGenerator(name="gen1",strategy="increment")
	 @GeneratedValue(generator="gen1")
	 @Column(length=15)
	 @Type(type="long")
     private long txid;
	 @Column(length=15)
	 @Type(type="string")
	 private String name;
	 @Column(length=15)
	 @Type(type="float")
     private float amount;
}
