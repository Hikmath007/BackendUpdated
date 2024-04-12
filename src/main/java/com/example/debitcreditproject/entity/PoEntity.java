
package com.example.debitcreditproject.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class PoEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "po_id", length = 12)
	private String poNumber;

	@JsonManagedReference
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "vendor_code")
	private VendorEntity vendor;

	@JsonIgnore
	@OneToMany(mappedBy = "poid",cascade = CascadeType.ALL)
	private List<PoItem> poitems;

	@Override
	public String toString() {
		return "PoEntity [id=" + id + ", poNumber=" + poNumber + "]";
	}

}
