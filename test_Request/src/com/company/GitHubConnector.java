package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class GitHubConnector {
    public final static String GITHUB_API = "https://api.github.com/";
    public final static String GITHUB_USER_API = "https://api.github.com/users/";
    static String getUserStringJSON(String userName) throws IOException {
        String userJSON = "";

        URL myUrl = new URL(GITHUB_USER_API+userName);
        System.out.print(userName);
        URLConnection yc = myUrl.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(yc.getInputStream()));
        String inputLine = "";
        while ((inputLine = in.readLine()) != null) userJSON += inputLine;

        in.close();

        return userJSON;
    }


}
