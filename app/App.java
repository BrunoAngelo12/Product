package app;

import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;

public class App{
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        Product emp = new ImportedProduct("Tablet", 260.00, 20.00);
        System.out.println(emp.priceTag());
    }
    
}