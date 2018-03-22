package org.apache.camel.component.fxcm.api;


/**
 * write some description
 *
 * @author Neo Xu - 2018-03-22
 */
public enum FxcmApiMethodType {
	
	GET_HISTORICALDATA_CANDLES("", "");

	private final String name;
	private final String path;
	
	FxcmApiMethodType(String name, String path) {
		this.name = name;
		this.path = path;
	}
}
