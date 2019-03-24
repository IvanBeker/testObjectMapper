package com.company;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;

public class GitHubConnector {

    //region Constants

    public final static String GITHUB_API = "https://api.github.com/";
    public final static String GITHUB_USER_API = "https://api.github.com/users/";
    public final static String GITHUB_API_REPOS = "/repos";

    //endregion Constants

    //endregion Public

    public static GitHubUserModel getUserModelByName(String userName) throws IOException {
        StringBuilder userJson = getResponse(new URL(GITHUB_USER_API+userName));
        StringBuilder userRepositorieJson = getResponse(new URL(GITHUB_USER_API+userName+GITHUB_API_REPOS));
        GitHubUserModel userModel = parseUserModel(userJson.toString());
        userModel.repositories = parseRepositoryModelList(userRepositorieJson.toString());

        return userModel;
    }

    //endregion Public

    //region Private

    private static StringBuilder getResponse(URL url) throws IOException {
        StringBuilder responseJson = new StringBuilder();


        URLConnection yc = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(yc.getInputStream()));
        String inputLine;
        while ((inputLine = bufferedReader.readLine()) != null)
            responseJson.append(inputLine);
        bufferedReader.close();
        return responseJson;
    }

    private static ArrayList<GitHubRepositoryModel> parseRepositoryModelList(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return new ArrayList<GitHubRepositoryModel>(Arrays.asList(objectMapper.readValue(json, GitHubRepositoryModel[].class)));
    }



    private static GitHubUserModel parseUserModel(String json) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, GitHubUserModel.class);
    }

    //endregion Private
}
