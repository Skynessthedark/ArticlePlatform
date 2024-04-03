package com.dev.articleplatform.populator;

public interface Populator<S, T>{

    void populate(S source, T target);
}
