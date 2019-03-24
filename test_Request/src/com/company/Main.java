package com.company;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String userName = getUserName();

        GitHubUserModel userModel;
        try {
            userModel = GitHubConnector.getUserModelByName(userName);
        }catch (IOException e){
            if(e.hashCode() == 173099767)
            System.out.println("This user does not exist");
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
