package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String userName = getUserName();

        GitHubUserModel userModel = null;
        try {
            userModel = GitHubConnector.getUserModelByName(userName);
        }catch (IOException e){
            System.out.print(e.toString());
            return;
        }

        System.out.print(userModel.toString());
    }

    private static String getUserName() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Name: ");

        return scanner.next();
    }

}
