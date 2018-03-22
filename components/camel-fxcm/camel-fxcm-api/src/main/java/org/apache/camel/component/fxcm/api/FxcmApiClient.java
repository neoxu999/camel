package org.apache.camel.component.fxcm.api;

import io.socket.client.IO.Options;
import io.socket.client.IO;
import io.socket.client.Socket;
import io.socket.emitter.Emitter;
import okhttp3.OkHttpClient;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.logging.Level;

/**
 * Some Description
 *
 * @author Long Xu, 21/3/18
 */
public class FxcmApiClient {

	private static final Logger LOG = LoggerFactory.getLogger(FxcmApiClient.class);
	

	private static final String DEFAULT_API_URL = "https://api.fxcm.com:443";
	
	public static Socket createApiConnection(Map<String, String> params) {
		
		String apiHost = params.get("apiHost");
		String apiKey = params.get("apiKey");
		String apiName = params.get("apiName");
		String methodName = params.get("methodName");

		if (StringUtils.isBlank(apiKey)) {
			throw new IllegalArgumentException("apiKey cannot be empty.");
		}
		
		if (StringUtils.isBlank(apiHost)) {
			apiHost = DEFAULT_API_URL;
		}

		try {
			Socket socket = IO.socket(apiHost, createOptions(apiKey));
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}

		return null;
	}
	
	private static Options createOptions(String apiKey) {
		Options options = new Options();
		options.forceNew = true;

		final OkHttpClient client = new OkHttpClient();
		options.webSocketFactory = client;
		options.callFactory = client;
		options.query = "access_token="+ apiKey;
		
		return options;
	}

	 
}
