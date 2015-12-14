package com.rhc.aggregates;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.rhc.entities.Address;
import com.rhc.entities.Discount;
import com.rhc.entities.Purchase;

public class Customer implements AggregateRoot {

	private Long id;

	private List<Purchase> purchases;

	private Address address;

	private Discount currentDiscount;

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public List<Purchase> getPurchases() {
		return purchases;
	}

	public void setPurchases(List<Purchase> purchases) {
		this.purchases = purchases;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Discount getCurrentDiscount() {
		return currentDiscount;
	}

	public void setCurrentDiscount(Discount currentDiscount) {
		this.currentDiscount = currentDiscount;
	}

	@Override
	public Collection<Object> asCollectionOfFacts() {
		Collection<Object> facts = new ArrayList<>();
		if (address != null) {
			facts.add(address);
		}
		if (purchases != null & !purchases.isEmpty()) {
			facts.addAll(purchases);
		}
		if (address != null) {
			facts.add(address);
		}
		return facts;
	}

}
