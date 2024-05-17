package br.com.ccm.dynamoapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;

import java.net.URI;

@Configuration
public class DynamoDBConfig {

    @Bean
    public DynamoDbClient dynamoDBClient() {
        return DynamoDbClient.builder()
                //.endpointOverride(URI.create("http://"))
                .endpointOverride(URI.create("http://localhost:8080"))
                .region(Region.SA_EAST_1)
                .build();
    }

}
