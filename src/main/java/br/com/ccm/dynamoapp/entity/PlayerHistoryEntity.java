package br.com.ccm.dynamoapp.entity;

import br.com.ccm.dynamoapp.controller.ScoreDTO;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbAttribute;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbSortKey;

import java.time.Instant;
import java.util.UUID;


@DynamoDbBean
public class PlayerHistoryEntity {
    private String username;
    private UUID gameId;
    private Double score;
    private Instant createdAt;

    public static PlayerHistoryEntity fromScore(String username, ScoreDTO scoreDTO) {
        var entity = new PlayerHistoryEntity();
        entity.setUsername(username);
        entity.setScore(scoreDTO.score());
        entity.setGameId(UUID.randomUUID());
        entity.setCreatedAt(Instant.now());

        return entity;
    }

    @DynamoDbAttribute("created_at")
    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    @DynamoDbSortKey
    @DynamoDbAttribute("game_id")
    public UUID getGameId() {
        return gameId;
    }

    public void setGameId(UUID gameId) {
        this.gameId = gameId;
    }

    @DynamoDbAttribute("score")
    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @DynamoDbAttribute("username")
    @DynamoDbPartitionKey
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
