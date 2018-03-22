package org.apache.camel.component.fxcm;

import org.apache.camel.component.fxcm.internal.FxcmApiName;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;
import org.apache.camel.spi.UriPath;
import org.apache.camel.util.jsse.SSLContextParameters;

import java.util.Map;

/**
 * Component configuration for Fxcm component.
 */
@UriParams
public class FxcmConfiguration {

	@UriPath
	@Metadata(required = "true")
	private FxcmApiName apiName;

	@UriPath
	@Metadata(required = "true")
	private String methodName;

	@UriParam(label = "security", secret = true)
	private String apiKey;

	@UriParam(label = "advanced")
	private Map<String, Object> httpParams;

	@UriParam(label = "security")
	private SSLContextParameters sslContextParameters;

	/**
	 * What kind of operation to perform
	 *
	 * @return the API Name
	 */
	public FxcmApiName getApiName() {
		return apiName;
	}

	/**
	 * What kind of operation to perform
	 *
	 * @param apiName the API Name to set
	 */
	public void setApiName(FxcmApiName apiName) {
		this.apiName = apiName;
	}

	/**
	 * What sub operation to use for the selected operation
	 *
	 * @return the methodName
	 */
	public String getMethodName() {
		return methodName;
	}

	/**
	 * What sub operation to use for the selected operation
	 *
	 * @param methodName the methodName to set
	 */
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	/**
	 * Custom HTTP params for settings like proxy host
	 *
	 * @return the httpParams
	 */
	public Map<String, Object> getHttpParams() {
		return httpParams;
	}

	/**
	 * Custom HTTP params for settings like proxy host
	 *
	 * @param httpParams the httpParams to set
	 */
	public void setHttpParams(Map<String, Object> httpParams) {
		this.httpParams = httpParams;
	}

	/**
	 * To configure security using SSLContextParameters.
	 *
	 * @return the sslContextParameters
	 */
	public SSLContextParameters getSslContextParameters() {
		return sslContextParameters;
	}

	/**
	 * To configure security using SSLContextParameters.
	 *
	 * @param sslContextParameters
	 *            the sslContextParameters to set
	 */
	public void setSslContextParameters(SSLContextParameters sslContextParameters) {
		this.sslContextParameters = sslContextParameters;
	}
}
