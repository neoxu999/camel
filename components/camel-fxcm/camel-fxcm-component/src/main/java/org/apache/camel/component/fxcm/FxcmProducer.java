package org.apache.camel.component.fxcm;

import org.apache.camel.util.component.AbstractApiProducer;

import org.apache.camel.component.fxcm.internal.FxcmApiName;
import org.apache.camel.component.fxcm.internal.FxcmPropertiesHelper;

/**
 * The Fxcm producer.
 */
public class FxcmProducer extends AbstractApiProducer<FxcmApiName, FxcmConfiguration> {

    public FxcmProducer(FxcmEndpoint endpoint) {
        super(endpoint, FxcmPropertiesHelper.getHelper());
    }
}
