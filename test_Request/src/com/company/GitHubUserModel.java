package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;
import java.util.ArrayList;


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
    public URL avatarUrl;

    @JsonProperty("url")
    public URL  url;

    @JsonProperty("html_url")
    public URL htmlUrl;

    @JsonProperty("followers_url")
    public URL followersUrl;

    @JsonProperty("type")
    public String type;

    @JsonProperty("created_at")
    public String createdAt;

    public ArrayList<GitHubRepositoryModel> repositories;

    //endregion Fields

    //region Public

    @Override
    public String toString(){

        StringBuilder userInfo = (new StringBuilder())
                .append("\n Login = ").append(login)
                .append("\n Id = " ).append(id)
                .append("\n NodeId = ").append(nodeId )
                .append("\n AvatarUrl = ").append(avatarUrl)
                .append("\n Url = ").append(url )
                .append("\n HtmlUrl = ").append(htmlUrl )
                .append("\n FollowersUrl = ").append(followersUrl)
                .append("\n Type = " ).append(type )
                .append("\n CreatedAt = " ).append(createdAt);
        userInfo.append("\n");
        userInfo.append("\n Repositories: " );

        if(repositories == null || repositories.isEmpty()) {
            userInfo.append("\n none\n");
            return userInfo.toString();
        }

        for(GitHubRepositoryModel repositoryModel :repositories){
            userInfo.append("\n Name:      " + repositoryModel.name)
                    .append("\n Full Name: " + repositoryModel.fullName)
                    .append("\n Id:        " + repositoryModel.id)
                    .append("\n HtmlURL:   " + repositoryModel.htmlUrl)
                    .append("\n");
        }

        return userInfo.toString();

    }



    //endregion Public

    // region private

    // endregion private

}
