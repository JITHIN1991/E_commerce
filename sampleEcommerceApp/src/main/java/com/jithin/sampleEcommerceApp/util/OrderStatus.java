package com.jithin.sampleEcommerceApp.util;

public enum OrderStatus {

	NEW((byte)1),
	PAID((byte)2),
	DELIVERED((byte)3);
	
	
	private byte value;
	private OrderStatus(byte value){
		this.value =value;
	}
	
	public byte getValue(){
		return value;
	}
}
