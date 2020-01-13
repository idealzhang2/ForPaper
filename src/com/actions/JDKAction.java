package com.actions;

import java.util.ArrayList;
import java.util.List;

public class JDKAction {
	private List<String> classes = new ArrayList<String>();
	private List<String> methods = new ArrayList<>();
	public List<String> getClasses() {
		return classes;
	}
	public void setClasses(List<String> classes) {
		this.classes = classes;
	}
	public List<String> getMethods() {
		return methods;
	}
	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

}
