package com.example.lab6_jt;

import jakarta.interceptor.InterceptorBinding;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@InterceptorBinding // This makes LogExecutionTime an interceptor binding
@Retention(RetentionPolicy.RUNTIME) // Makes the annotation available at runtime
public @interface LogExecutionTime {
    // No fields are necessary for this annotation
}
