package org.apache.camel.component.fxcm;

import java.util.Map;

import org.apache.camel.Consumer;
import org.apache.camel.Processor;
import org.apache.camel.Producer;
import org.apache.camel.spi.Metadata;
import org.apache.camel.spi.UriEndpoint;
import org.apache.camel.spi.UriPath;
import org.apache.camel.util.component.AbstractApiEndpoint;
import org.apache.camel.util.component.ApiMethod;
import org.apache.camel.util.component.ApiMethodPropertiesHelper;

import org.apache.camel.component.fxcm.api.FxcmFileHello;
import org.apache.camel.component.fxcm.api.FxcmJavadocHello;
import org.apache.camel.component.fxcm.internal.FxcmApiCollection;
import org.apache.camel.component.fxcm.internal.FxcmApiName;
import org.apache.camel.component.fxcm.internal.FxcmConstants;
import org.apache.camel.component.fxcm.internal.FxcmPropertiesHelper;

/**
 * Represents a Fxcm endpoint.
 */
@UriEndpoint(firstVersion = "1.0-SNAPSHOT", scheme = "fxcm", title = "Fxcm", syntax="fxcm:name", 
             consumerClass = FxcmConsumer.class, label = "custom")
public class FxcmEndpoint extends AbstractApiEndpoint<FxcmApiName, FxcmConfiguration> {

    @UriPath @Metadata(required = "true")
    private String name;

    // TODO create and manage API proxy
    private Object apiProxy;

    public FxcmEndpoint(String uri, FxcmComponent component,
                         FxcmApiName apiName, String methodName, FxcmConfiguration endpointConfiguration) {
        super(uri, component, apiName, methodName, FxcmApiCollection.getCollection().getHelper(apiName), endpointConfiguration);

    }

    public Producer createProducer() throws Exception {
        return new FxcmProducer(this);
    }

    public Consumer createConsumer(Processor processor) throws Exception {
        // make sure inBody is not set for consumers
        if (inBody != null) {
            throw new IllegalArgumentException("Option inBody is not supported for consumer endpoint");
        }
        final FxcmConsumer consumer = new FxcmConsumer(this, processor);
        // also set consumer.* properties
        configureConsumer(consumer);
        return consumer;
    }

    @Override
    protected ApiMethodPropertiesHelper<FxcmConfiguration> getPropertiesHelper() {
        return FxcmPropertiesHelper.getHelper();
    }

    protected String getThreadProfileName() {
        return FxcmConstants.THREAD_PROFILE_NAME;
    }

    @Override
    protected void afterConfigureProperties() {
        // TODO create API proxy, set connection properties, etc.
        switch (apiName) {
            case HELLO_FILE:
                apiProxy = new FxcmFileHello();
                break;
            case HELLO_JAVADOC:
                apiProxy = new FxcmJavadocHello();
                break;
            default:
                throw new IllegalArgumentException("Invalid API name " + apiName);
        }
    }

    @Override
    public Object getApiProxy(ApiMethod method, Map<String, Object> args) {
        return apiProxy;
    }

    /**
     * Some description of this option, and what it does
     */
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
