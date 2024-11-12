package com.example.lab6_jt;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@LogExecutionTime
public class LogExecutionInterceptor {

    @AroundInvoke
    public Object logExecutionTime(InvocationContext context) throws Exception {
        long startTime = System.currentTimeMillis();
        Object result = context.proceed();
        long endTime = System.currentTimeMillis();
        System.out.println("Method " + context.getMethod().getName() + " executed in " + (endTime - startTime) + " ms");
        return result;
    }
}

