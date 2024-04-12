
package com.example.debitcreditproject.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "GrnItems")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class GrnItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "grn_id")
	private GrnEntity grn;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "po_itemid")
	private PoItem poitem;

	@Column(name = "dispatchedquantity")
	private Long dispatchedquantity;

	@Column(name = "AcceptedQuantity")
	private long acceptedquantity;

	@OneToOne(mappedBy = "grnItems", cascade = CascadeType.REMOVE)
	private InvoiceEntity invoice;

	@Override
	public String toString() {
		return "GrnItem [id=" + id + ", grn=" + grn + ", dispatchedquantity=" + dispatchedquantity
				+ ", acceptedquantity=" + acceptedquantity + "]";
	}

}
