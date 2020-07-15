package net.nycuro.bank;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public final class App {

    public static Map<String, BankManager> accounts = new HashMap<>();

    static {
        accounts.put("NycuRO", new BankManager(492, 10053.00));
    }

    public static void main(String[] args) {
        System.out.println("Hello! Welcome to NBank! Please input your name: ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello " + name + "! Please input your personal id of your card");
        int idCard = scanner.nextInt();
        BankManager bankManager = accounts.get(name);
        if (bankManager.getIdCard() == idCard) {
            System.out.println("Your idCard it's correct. Please input the options you want to do:");
            System.out.println("1. Get money from your account.");
            System.out.println("2. Input money to your account.");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Please insert the sum you want to withdraw:");
                    double sum = scanner.nextDouble();
                    double pMoney = bankManager.getMoney();
                    if (pMoney < sum) {
                        System.out.println("I'm sorry but you don't have enough money to withdraw. You only have: " + pMoney);
                    } else {
                        bankManager.setMoney(pMoney - sum);
                        System.out.println("You succesfully withdrawed " + sum + ". Now you have " + (pMoney - sum) + " in your account.");
                    }
                    break;
                case 2:
                    System.out.println("Please input the sum you want to deploy:");
                    double sumW = scanner.nextDouble();
                    double pMoneyW = bankManager.getMoney();
                    bankManager.setMoney(sumW + pMoneyW);
                    System.out.println("You succesfully deployed the sum " + sumW + " and now you have " + (pMoneyW + sumW) + " in your account.");
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("I'm sorry but your idCard it's not correct. Please try again.");
        }
    }
}
