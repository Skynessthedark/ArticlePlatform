package com.dev.articlePlatform.populator;

public interface Populator<S, T>{

    void populate(S source, T target);
}
