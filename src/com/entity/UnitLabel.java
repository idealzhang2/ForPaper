package com.entity;

import java.util.ArrayList;
import java.util.List;

public class UnitLabel {
	private String name;
	private String type;
	private String role;
	private double tf;
	private double idf;
	private double complexity;
	private double couple;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public double getTf() {
		return tf;
	}
	public void setTf(double tf) {
		this.tf = tf;
	}
	public double getIdf() {
		return idf;
	}
	public void setIdf(double idf) {
		this.idf = idf;
	}
	public double getComplexity() {
		return complexity;
	}
	public void setComplexity(double complexity) {
		this.complexity = complexity;
	}
	public double getCouple() {
		return couple;
	}
	public void setCouple(double couple) {
		this.couple = couple;
	}
	
}
