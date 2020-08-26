/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankfacade;

import bankcustomers.BankAccount;
import bankcustomers.BankCustomer;
import gencustaccount.AccountIf;
import gencustaccount.CustomerIf;
import java.util.ArrayList;

/**
 *
 * @author sarun
 */
public class BankFacade {

    /**
     * @param args the command line arguments
     */
    static ArrayList<AccountIf> cust1Accounts = new ArrayList();//create customer1
    static ArrayList<AccountIf> cust2Accounts = new ArrayList();//create customer2
    static CustomerIf cust1 = new BankCustomer("Earth", cust1Accounts);
    static CustomerIf cust2 = new BankCustomer("Xiang", cust2Accounts);
    
    
      public BankFacade () {
       AccountIf acc = new BankAccount(0001);
       cust1Accounts.add(acc);
       acc = new BankAccount(0002);
       cust1Accounts.add(acc);
       acc = new BankAccount(0003);
       cust2Accounts.add(acc);
       acc = new BankAccount(0004);
       cust2Accounts.add(acc);
    }
    
    public static void main(String[] args) {
      BankFacade obj = new BankFacade();
      obj.doDeposit(2000,cust1,0001);
      obj.getBankAccount(cust1,0001);
      obj.getBanCustomer("Earth");
      obj.doDeposit(1000,cust2,0003);
      obj.getBankAccount(cust2,0004);
      obj.getBanCustomer("Xiang");
    }
    
     public void doDeposit (double amt, CustomerIf cust, int accNo){
        AccountIf acc = cust.getAccount(accNo);
        acc.deposit(amt);
        System.out.println("Success");
    }
    
    public void getBankAccount(CustomerIf cust, int accNo){
        AccountIf acc = cust.getAccount(accNo);
        System.out.println("Account Number: " + acc.getAccountNumber() + " has " + acc.getBalance());
    }
    
    public void getBanCustomer(String custName) {
    if (cust1.getCustomerName().equals(custName)) {
        ArrayList<AccountIf> accounts = cust1.getllAccounts();
        System.out.println("Customer and account information");
        System.out.println("Name = " + cust1.getCustomerName());
        System.out.println("Has " + cust1.getNumAccounts() + " accounts");
        for(AccountIf account : accounts) {
            System.out.println("Account number " + account.getAccountNumber() + " has " + account.getBalance());
        }
    } else if (cust2.getCustomerName().equals(custName)) {
        ArrayList<AccountIf> accounts = cust2.getllAccounts();
        System.out.println("Customer and account information");
        System.out.println("Name = " + cust2.getCustomerName());
        System.out.println("Has " + cust2.getNumAccounts() + " accounts");
        for(AccountIf account : accounts) {
            System.out.println("Account number " + account.getAccountNumber() + " has " + account.getBalance());
        }
    }
    }
}
