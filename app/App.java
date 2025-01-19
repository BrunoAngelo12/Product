package app;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class App{
    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Product> list = new ArrayList<>();
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");//Para formatar como queremos a data

        System.out.print("Enter the number of products: ");
        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 1; i <= n; i++){
            System.out.println("Product #" + i + " data:");
            System.out.print("Common, used or imported (c/u/i)? ");
            char ch = sc.next().charAt(0);
            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = sc.nextDouble();
            sc.nextLine();
            if(ch == 'i'){
                System.out.print("Customs fee: ");
                Double customsFee = sc.nextDouble();
                list.add(new ImportedProduct(name, price, customsFee));
            }else if(ch == 'u'){
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String manufactureDateString = sc.nextLine();//Le a data no formato String que o usuario digita
                LocalDate manufactureDate = LocalDate.parse(manufactureDateString, dateFormat);//Pega a formatação que queremos e converte o String que o usuario forneceu e joga dentro da variavel Date criada
                list.add(new UsedProduct(name, price, manufactureDate));
            }else{
                list.add(new Product(name, price));
            }
        }

        System.out.println("PRICE TAGS:");
        for(Product prod : list){
            System.out.println(prod.priceTag());
        }

    }
    
}