package com.example.services;

public class LogEntity {
    private static int count = 0;
    private int id_;
    public LogEntity() {
        id_ = count;
        count++;
    }

    @Override
    public String toString() {
        return id_ + "";
    }
}