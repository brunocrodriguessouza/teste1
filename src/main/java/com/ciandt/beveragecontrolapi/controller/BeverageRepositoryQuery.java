package com.ciandt.beveragecontrolapi.controller;

import java.util.List;

import com.ciandt.beveragecontrolapi.filter.BeverageFilter;
import com.ciandt.beveragecontrolapi.model.Beverage;

public interface BeverageRepositoryQuery {
	
	public List<Beverage> filter(BeverageFilter expenseFilter);

}
