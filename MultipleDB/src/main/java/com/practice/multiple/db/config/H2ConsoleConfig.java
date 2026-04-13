package com.practice.multiple.db.config;



import org.springframework.boot.autoconfigure.h2.H2ConsoleProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class H2ConsoleConfig {

    //@Bean
    public org.springframework.boot.autoconfigure.h2.H2ConsoleProperties h2ConsoleProperties() {
        H2ConsoleProperties props = new H2ConsoleProperties();
        props.setEnabled(true);
        props.setPath("/h2-console");
        return props;
    }
}
