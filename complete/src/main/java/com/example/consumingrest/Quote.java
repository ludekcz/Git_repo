package com.example.consumingrest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.web.bind.annotation.GetMapping;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Quote(String type, Value value) {
    public Quote {
    }

    @Override
    public String type() {
        return type;
    }

    @Override
    public Value value() {
        return value;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
