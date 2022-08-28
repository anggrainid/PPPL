package org.example;

//Sebuah kelas Wallet memiliki :
//attribut owner yang akan diset jika ada yang membeli dompet tersebut atribut berupa list kartu-kartu atrribut untuk menyimpan list uang lembaran dan koin.
//
//Fungsionalitas untuk : Set data owner, menambahkan kartu, mengambil kartu, menambahkan uang rupiah, mengambil uang, menampilkan jumlah uang yang ada di dompet.
//
// Implementasikan kelas tersebut dan buatlah unit testing yang sesuai dengan fungsionalitas di atas.  Method yang diimplementasikan juga bisa ditambahkan sesuai dengan kebutuhan
//
//Manfaatkanlah berbagai macam annotation assert yang sudah dipelajari.
//
//Submission berupa screenshot code, test code dan penjelasan.  Terdapat pengurangan nilai apabila solusi sama persis dengan teman, ataupun terlambat.

import java.util.ArrayList;
import java.util.List;

public class Wallet {

    private String owner;
    private ArrayList<String> cards;
    private ArrayList<Double> moneys;

    public Wallet() {
        //this.owner = owner;
        this.cards = new ArrayList<String>();
        this.moneys = new ArrayList<Double>();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String status, String owner) {
        if (status == "paid"){
            this.owner = owner;
        }
        this.owner = null;

    }

    public void addCard(String card){
        this.cards.add(card);
    }

    public void takeCard(String card){
        this.cards.remove(card);
    }

    public ArrayList<String> getCards() {
        return cards;
    }

    public ArrayList<Double> getMoneys() {
        return moneys;
    }

    public void addMoney(Double money){
        this.moneys.add(money);
    }

    public void takeMoney(Double money){
        this.moneys.remove(money);
    }

    public double getMoney(){

        double total = 0;

        for (int i = 0;i <this.moneys.size(); i++){
            total += this.moneys.get(i);
        }

        return total;

    }


}
