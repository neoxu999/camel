package org.apache.camel.component.fxcm;

import org.apache.camel.CamelContext;
import org.apache.camel.Endpoint;
import org.apache.camel.spi.Metadata;
import org.apache.camel.util.component.AbstractApiComponent;

import org.apache.camel.component.fxcm.internal.FxcmApiCollection;
import org.apache.camel.component.fxcm.internal.FxcmApiName;

/**
 * Represents the component that manages {@link FxcmEndpoint}.
 */
public class FxcmComponent extends AbstractApiComponent<FxcmApiName, FxcmConfiguration, FxcmApiCollection> {

    @Metadata
    private String accessKey;

    public FxcmComponent() {
        super(FxcmEndpoint.class, FxcmApiName.class, FxcmApiCollection.getCollection());
    }

    public FxcmComponent(CamelContext context) {
        super(context, FxcmEndpoint.class, FxcmApiName.class, FxcmApiCollection.getCollection());
    }

    @Override
    protected FxcmApiName getApiName(String apiNameStr) throws IllegalArgumentException {
        return FxcmApiName.fromValue(apiNameStr);
    }

    @Override
    protected Endpoint createEndpoint(String uri, String methodName, FxcmApiName apiName,
                                      FxcmConfiguration endpointConfiguration) {
        FxcmEndpoint endpoint = new FxcmEndpoint(uri, this, apiName, methodName, endpointConfiguration);
        endpoint.setName(methodName);
        return endpoint;
    }

    /**
     * To use the shared configuration
     */
    @Override
    public void setConfiguration(FxcmConfiguration configuration) {
        super.setConfiguration(configuration);
    }

}
