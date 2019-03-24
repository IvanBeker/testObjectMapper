package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URL;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GitHubRepositoryModel {
    // region Fields
    @JsonProperty("name")
    public String name ;

    @JsonProperty("full_name")
    public String fullName ;

    @JsonProperty("id")
    public String id;

    @JsonProperty("html_url")
    public URL htmlUrl;
    // endregion Fields

}
