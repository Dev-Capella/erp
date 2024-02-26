package com.capella.facade.policy;

public interface PolicyEvaluate<T> {
    default T invoke() {
        return null;
    }
}
