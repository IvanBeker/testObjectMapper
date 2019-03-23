package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubUserModel {

    //region Fields

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

    //endregion Fields

    //region Public

    @Override
    public String toString(){
        return
        (new StringBuilder()).append("\nGitHub Login = ").append(login)
                             .append("\nGitHub Id = " ).append(id)
                             .append("\nGitHub NodeId = ").append(nodeId )
                             .append("\nGitHub AvatarUrl = ").append(avatarUrl)
                             .append("\nGitHub Url = ").append(url )
                             .append("\nGitHub HtmlUrl = ").append(htmlUrl )
                             .append("\nGitHub FollowersUrl = ").append(followersUrl)
                             .append("\nGitHub Type = " ).append(type )
                             .append("\nGitHub CreatedAt = " ).append(createdAt).toString();

    }

    //endregion Public

}
