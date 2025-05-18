package dev.sathyamolagoda.book_service.configuration;

import org.springframework.context.annotation.Bean;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedClient;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

public class DynamoDbConfig {

    @Bean
    public DynamoDbEnhancedClient enhancedClient() {
        return DynamoDbEnhancedClient.builder()
                .dynamoDbClient(DynamoDbClient.create())
                .build();
    }

}
