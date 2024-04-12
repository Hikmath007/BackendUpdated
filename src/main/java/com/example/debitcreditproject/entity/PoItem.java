package com.example.debitcreditproject.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "PoItems")
public class PoItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "po_Itemid")
	private Long id;

	@Column(name = "gst")
	private int gst;


	@ManyToOne(cascade = CascadeType.ALL) // Apply cascade to PoEntity
	@JoinColumn(name = "Po_id")
	private PoEntity poid;

	@ManyToOne(cascade = CascadeType.ALL) // Apply cascade to MaterialEntity
	@JoinColumn(name = "material_code")
	private MaterialEntity poItemMaterial;

	@JoinColumn(name = "item_price")
	private String price;

	@Column(name = "Quantity")
	private Long quantity;

	@OneToMany(mappedBy = "poitem", cascade = CascadeType.ALL) // Apply cascade to GrnItem
	private List<GrnItem> grn_items;

	@OneToOne(mappedBy = "poitems", cascade = CascadeType.ALL) // Apply cascade to RateEntity
	private RateEntity poItem;

	@Override
	public String toString() {
		return "PoItem [id=" + id + ", gst=" + gst + ", poid=" + poid + ", price=" + price + ", quantity=" + quantity
				+ "]";
	}
}
