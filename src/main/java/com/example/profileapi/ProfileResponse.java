//package com.example.profileapi;
//
//public class ProfileResponse {
//}
package com.example.profileapi;

import java.time.Instant;

public class ProfileResponse {
    private String status;
    private User user;
    private String timestamp;
    private String fact;

    // Constructor
    public ProfileResponse(String status, User user, String timestamp, String fact) {
        this.status = status;
        this.user = user;
        this.timestamp = timestamp;
        this.fact = fact;
    }

    // Getters
    public String getStatus() {
        return status;
    }

    public User getUser() {
        return user;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getFact() {
        return fact;
    }
}
