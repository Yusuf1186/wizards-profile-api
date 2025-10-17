//package com.example.profileapi;

//public class User {
//}
package com.example.profileapi;

public class User {
    private String email;
    private String name;
    private String stack;

    // Constructor
    public User(String email, String name, String stack) {
        this.email = email;
        this.name = name;
        this.stack = stack;
    }

    // Getters (Spring will use these for JSON serialization)
    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getStack() {
        return stack;
    }
}