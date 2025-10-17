//package com.example.profileapi;
//
//public class ProfileController {
//}
package com.example.profileapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.client.RestClientException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Instant;
import java.util.logging.Logger;

@RestController
public class ProfileController {

    // Inject values from application.properties
    @Value("${custom.user.email}")
    private String email;

    @Value("${custom.user.name}")
    private String name;

    @Value("${custom.user.stack}")
    private String stack;

    private static final Logger logger = Logger.getLogger(ProfileController.class.getName());

    // Create a RestTemplate bean (you can do this in a @Configuration class, but for simplicity, we'll use it here)
    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/me")
    public ResponseEntity<ProfileResponse> getProfile() {
        String timestamp = Instant.now().toString();  // Dynamic UTC timestamp in ISO 8601 format
        String fact = "No cat fact available.";  // Fallback message

        try {
            // Fetch cat fact from external API
            String url = "https://catfact.ninja/fact";
            String response = restTemplate.getForObject(url, String.class);

            // Parse the JSON response
            ObjectMapper mapper = new ObjectMapper();
            JsonNode jsonNode = mapper.readTree(response);
            fact = jsonNode.get("fact").asText();  // Extract the fact field

            logger.info("Successfully fetched cat fact");
        } catch (RestClientException e) {
            // Handle API failures (e.g., network error, timeout)
            logger.warning("Failed to fetch cat fact: " + e.getMessage());
            fact = "Failed to fetch cat fact. Please try again later.";  // Graceful fallback
        } catch (Exception e) {
            logger.severe("Unexpected error: " + e.getMessage());
            fact = "Error occurred while processing.";  // General error handling
        }

        // Build the User object
        User user = new User(email, name, stack);

        // Build and return the response
        ProfileResponse profileResponse = new ProfileResponse("success", user, timestamp, fact);
        return ResponseEntity.ok().header("Content-Type", "application/json").body(profileResponse);
    }
}