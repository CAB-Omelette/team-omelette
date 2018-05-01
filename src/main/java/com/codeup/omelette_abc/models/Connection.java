package com.codeup.omelette_abc.models;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class Connection {

    @Id
    @GeneratedValue
    private long id;

    private boolean connectionStatus;

    public Connection(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isConnectionStatus() {
        return connectionStatus;
    }

    public void setConnectionStatus(boolean connectionStatus) {
        this.connectionStatus = connectionStatus;
    }
}
