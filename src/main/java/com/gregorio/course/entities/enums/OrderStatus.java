package com.gregorio.course.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

	private int code;

	// CONSTRUTOR PRIVADO
	private OrderStatus(int code) {
		this.code = code;
	}

	// MÉTODO PÚBLICO PARA OBTER O CODE
	public int getCode() {
		return code;
	}

	public static OrderStatus valueOf(int code) {
		// VARRENDO TODOS OS STATUS:
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}

}
