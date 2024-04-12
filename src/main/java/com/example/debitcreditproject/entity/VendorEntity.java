
package com.example.debitcreditproject.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class VendorEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "vendor_code", length = 15)
	private String vendorCode;
	
	@JsonBackReference
	@OneToMany(mappedBy = "vendor",cascade=CascadeType.ALL)
	private List<PoEntity> purchaseOrders;
}
