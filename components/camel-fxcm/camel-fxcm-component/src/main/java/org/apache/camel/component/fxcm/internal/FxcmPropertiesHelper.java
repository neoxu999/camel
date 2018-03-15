package org.apache.camel.component.fxcm.internal;

import org.apache.camel.util.component.ApiMethodPropertiesHelper;

import org.apache.camel.component.fxcm.FxcmConfiguration;

/**
 * Singleton {@link ApiMethodPropertiesHelper} for Fxcm component.
 */
public final class FxcmPropertiesHelper extends ApiMethodPropertiesHelper<FxcmConfiguration> {

    private static FxcmPropertiesHelper helper;

    private FxcmPropertiesHelper() {
        super(FxcmConfiguration.class, FxcmConstants.PROPERTY_PREFIX);
    }

    public static synchronized FxcmPropertiesHelper getHelper() {
        if (helper == null) {
            helper = new FxcmPropertiesHelper();
        }
        return helper;
    }
}
