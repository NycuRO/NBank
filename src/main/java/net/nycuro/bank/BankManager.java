package net.nycuro.bank;

import lombok.Getter;
import lombok.Setter;

public class BankManager {

    @Getter
    @Setter
    private int idCard;

    @Getter
    @Setter
    private double money;

    public BankManager(int idCard, double money) {
        this.idCard = idCard;
        this.money = money;
    }
}