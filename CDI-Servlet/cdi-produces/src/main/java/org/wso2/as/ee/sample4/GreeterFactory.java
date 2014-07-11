package org.wso2.as.ee.sample4;

import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import java.io.Serializable;

@SessionScoped
public class GreeterFactory implements Serializable {

    private static final long serialVersionUID = 5269302440619391616L;

    private GreetingType greetingType;

    @Produces
    @Greetings(GreetingType.HI)
    public Greeter getGreeterOne() {
        return new GreeterImplOne();
    }

    @Produces
    @Greetings(GreetingType.BYE)
    public Greeter getGreeterTwo() {
        return new GreeterImplTwo();
    }
}
