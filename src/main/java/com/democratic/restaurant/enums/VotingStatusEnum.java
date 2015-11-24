package com.democratic.restaurant.enums;

/**
 * @author ramachado
 *
 */
public enum VotingStatusEnum {
	
	OPENED(1),
	CLOSED(2);
	
	private Integer code;
	
	private VotingStatusEnum(Integer code){
		this.code = code;
	}

	public Integer getCode() {
		return code;
	}
}
