package org.MIFI;

import org.MIFI.model.*;
import org.MIFI.storage.Factory;
import org.MIFI.storage.FileUserStorage;


public class Main {
    public static void main(String[] args) {
        Storage<String, User> userStorage = new FileUserStorage();
        userStorage.add(new User("Vasia", "123"));
        userStorage.add(new User("Petia", "123"));
        userStorage.add(new User("Kilia", "123"));
        userStorage.flush();
        User user = userStorage.get("Petia").get();

        Wallet wallet = new Wallet.DefaultWallet(user, new Factory.FileFactory());


        Wallet.Result o = wallet.operation("Зарплата", new Amount(100));
        System.out.println(o.message());
        double balance = wallet.balance();
        System.out.println(balance);

    }
}