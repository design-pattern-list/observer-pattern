package com.michielswaanen.publisher;

import com.michielswaanen.listeners.IEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventManager {

    private Map<String, List<IEventListener>> listeners;

    public EventManager(String... eventTypes) {
        this.listeners = new HashMap<>();
        for (String eventType : eventTypes)
            this.listeners.put(eventType, new ArrayList<>());
    }

    public void subscribe(String eventType, IEventListener listener) {
        List<IEventListener> users =  this.listeners.get(eventType);
        users.add(listener);
    }

    public void unsubscribe(String eventType, IEventListener listener) {
        List<IEventListener> users =  this.listeners.get(eventType);
        users.remove(listener);
    }

    public void notify(String eventType, String displayName, String url) {
        List<IEventListener> users =  this.listeners.get(eventType);
        for (IEventListener listener : users)
            listener.update(eventType, displayName, url);
    }
}
