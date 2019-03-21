package com.company;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;

import java.net.*;
import java.io.*;
import java.lang.*;


import java.net.URL;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("start");
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");
        String userName = scanner.next();
        String json = null;
        try {
             json = GitHubConnector.getUserStringJSON(userName);
        }catch (IOException e){
            System.out.print(e.toString());
            return;
        }
        GitHubUser gitHub = null;
        try {
             gitHub = GitHubUser.getMap(json);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        System.out.print(gitHub.toString());

    }




}
