package com.nt.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import lombok.Getter;
import lombok.Setter;

@Entity
//@DiscriminatorValue(value="CHEQUE")
@Table(name="INH_CHEQUEPAYMENT_TPCC")
//@PrimaryKeyJoinColumn(name="tx_id",referencedColumnName="txid")
@Setter
@Getter
public class ChequePayment extends Payment {
	@Column(length=15)
	@Type(type="int")
    private int chequeNo;
	@Column(length=15)
	@Type(type="string")
    private String chequeType;
	@Column(length=15)
	@Type(type="string")
    private String bankName;
	@Override
	public String toString() {
		return "ChequePayment [chequeNo=" + chequeNo + ", chequeType=" + chequeType + ", bankName=" + bankName
				+ ", Payment=" + super.toString() + "]";
	}
	
	
	

    
}
