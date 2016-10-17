package org.davidd.methodReferencesAndLambdas;

import java.util.function.Function;

/**
 * Created by David on 10/14/2016.
 */
public class FunctionExample {

    public FunctionExample() {
        Function<String, String> f = String::toUpperCase;

        System.out.println(f.apply("szia mit csinalsz"));

    }
}
