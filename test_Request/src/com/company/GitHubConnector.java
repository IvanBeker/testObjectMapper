package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class GitHubConnector {

    //region Constants

    public final static String GITHUB_API = "https://api.github.com/";
    public final static String GITHUB_USER_API = "https://api.github.com/users/";

    //endregion Constants

    //endregion Public

    public static GitHubUserModel getUserModelByName(String userName) throws IOException {
        StringBuilder userJson = new StringBuilder();

        URL gitHubUserUrl = new URL(GITHUB_USER_API + userName);

        URLConnection yc = gitHubUserUrl.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(yc.getInputStream()));

        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null)
            userJson.append(inputLine);
        bufferedReader.close();

        return parseUserModel(userJson.toString());
    }

    //endregion Public

    //region Private

    public static GitHubUserModel parseUserModel(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, GitHubUserModel.class);
    }

    //endregion Private
}
