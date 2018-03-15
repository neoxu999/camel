package org.apache.camel.component.fxcm.api;

/**
 * Sample API used by Fxcm Component whose method signatures are read from Javadoc.
 */
public class FxcmJavadocHello {

    public String sayHi() {
        return "Hello!";
    }

    public String greetMe(String name) {
        return "Hello " + name;
    }

    public String greetUs(String name1, String name2) {
            return "Hello " + name1 + ", " + name2;
    }
}
