package com.example.exerciciofixacaotrycatch;

import com.example.exerciciofixacaotrycatch.model.entities.Account;
import com.example.exerciciofixacaotrycatch.model.exception.DomainException;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication
public class ExercicioFixacaoTryCatchApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        try {
            System.out.println("Conta bancaria");
            System.out.print("Number: ");
            int number = sc.nextInt();
            System.out.print("Holder: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Initial balance: ");
            double saldo = sc.nextDouble();
            System.out.print("Witdhdraw limit: ");
            double limite = sc.nextDouble();

            //instaciando classe
            Account account = new Account(number, name, saldo, limite);

            System.out.println(account);
            System.out.println("You want deposit or withdraw:\nd - Deposit,\ns - withdraw");
            char opc = sc.next().charAt(0);
            //quala ação tomar
            if (opc == 'd') {
                System.out.println("Enter number for deposit:");
                double amount = sc.nextDouble();
                account.Deposit(amount);
                System.out.print("New balance: " + account.getBalance());
            } else {
                System.out.println("Enter number for withdraw:");
                double amount = sc.nextDouble();
                account.withdraw(amount);
                System.out.print("New balance " + account.getBalance());
            }
        }//tratamento de exceção.
        catch(DomainException e){
            System.out.println("Withdraw error: " + e.getMessage());
        }
    }

}
