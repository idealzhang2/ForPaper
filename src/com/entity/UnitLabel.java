package com.entity;

import java.util.ArrayList;
import java.util.List;

public class UnitLabel {
     private List<String> types = new ArrayList<String>();
     private List<String> methods = new ArrayList<>();
	public List<String> getTypes() {
		return types;
	}
	public void setTypes(List<String> types) {
		this.types = types;
	}
	public List<String> getMethods() {
		return methods;
	}
	public void setMethods(List<String> methods) {
		this.methods = methods;
	}
     
     
}
