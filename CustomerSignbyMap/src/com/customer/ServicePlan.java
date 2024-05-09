package com.customer;

public enum ServicePlan {
	SILVER(1000),GOLD(2000),PLATINUM(10000),DIAMOND(5000);
	private double plancost;
	ServicePlan(double plancost) {
		this.plancost=plancost;
	}
	public double getPlancost() {
		return plancost;
	}
	

}
