package com.example.services;

public class LogEntityWrapper {
    private LogEntity loge_;
    public LogEntityWrapper(LogEntity loge) {
        loge_ = loge;
    }

    @Override
    public String toString() {
        return loge_.toString();
    }
}
