package org.apache.camel.component.fxcm;

import org.apache.camel.Processor;
import org.apache.camel.util.component.AbstractApiConsumer;

import org.apache.camel.component.fxcm.internal.FxcmApiName;

/**
 * The Fxcm consumer.
 */
public class FxcmConsumer extends AbstractApiConsumer<FxcmApiName, FxcmConfiguration> {

    public FxcmConsumer(FxcmEndpoint endpoint, Processor processor) {
        super(endpoint, processor);
    }

}
