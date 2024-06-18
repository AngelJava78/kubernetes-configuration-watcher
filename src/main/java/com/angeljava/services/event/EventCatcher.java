package com.angeljava.services.event;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.cloud.context.scope.refresh.RefreshScopeRefreshedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class EventCatcher implements ApplicationListener<RefreshScopeRefreshedEvent> {

    private final AtomicInteger times = new AtomicInteger(0);

    @Override
    public void onApplicationEvent(RefreshScopeRefreshedEvent event) {
        times.incrementAndGet();
        List<String> allLines;
        try {
            allLines = Files.readAllLines(new File("/etc/config/application.yml").toPath());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("caught event : " + event.toString() + " from source : " + event.getSource()
            + " at " + times.get());
        System.out.println("all lines : " + allLines);
    }

    public int getTimes() {
        return times.get();
    }
}
