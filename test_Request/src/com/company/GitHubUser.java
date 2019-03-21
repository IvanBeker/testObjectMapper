package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUser {
    @JsonProperty("login")
    public String login;

    @JsonProperty("id")
    public String id;

    @JsonProperty("node_id")
    public String nodeId;

    @JsonProperty("avatar_url")
    public String avatarUrl;

    @JsonProperty("url")
    public String url;

    @JsonProperty("html_url")
    public String htmlUrl;

    @JsonProperty("followers_url")
    public String followersUrl;

    @JsonProperty("type")
    public String type;

    @JsonProperty("created_at")
    public String createdAt;

    @Override
    public String toString(){
        return
        "\ngitHub Login = "+         login+
        "\ngitHub id = " +           id+
        "\ngitHub nodeId = " +       nodeId +
        "\ngitHub avatarUrl = " +    avatarUrl+
        "\ngitHub url = " +          url +
        "\ngitHub htmlUrl = " +      htmlUrl +
        "\ngitHub followersUrl = " + followersUrl +
        "\ngitHub type = " +         type +
        "\ngitHub createdAt = " +    createdAt;

    }

    public static GitHubUser getMap(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, GitHubUser.class);
    }

}
