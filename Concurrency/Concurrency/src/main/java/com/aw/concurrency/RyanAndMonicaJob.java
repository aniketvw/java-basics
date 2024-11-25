package com.aw.concurrency;

public class RyanAndMonicaJob implements Runnable{
   //Ryan and Monica do the same thing check and withdraw. So only one instance.

    BankAccount bankAccount=new BankAccount();

    @Override
    public void run() {

       for (int x=0;x<10;x++){
           withdraw(10);
           if (bankAccount.getBalance()<0){
               System.out.println("OverDrawn!!!!");
           }
       }


    }

    public synchronized void withdraw(int amount){

        if(bankAccount.getBalance()>=amount){
            System.out.println(Thread.currentThread().getName()+"is about to make withdraw");
            try {
                System.out.println(Thread.currentThread().getName()+"is going to sleep");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"woke up!");
            bankAccount.withdraw(amount);
            System.out.println(Thread.currentThread().getName()+"completes withdrawal");

        }else {
            System.out.println("Sorry, not enough amount for"+ Thread.currentThread().getName());
        }

    }

    public static void main(String[] args) {

        RyanAndMonicaJob theJob= new RyanAndMonicaJob();

        Thread ryan =new Thread(theJob);
        Thread monica = new Thread(theJob);
        ryan.setName("Ryan");
        monica.setName("Monica");
        ryan.start();
        monica.start();

    }
}
