package org.wso2.as.ee.sample5;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Log
public class LogImpl {

    @AroundInvoke
    public Object log(InvocationContext context) throws Exception {
        System.out.println("Before greeting");
        context.proceed();
        System.out.println("After greeting");
        return null;
    }
}
