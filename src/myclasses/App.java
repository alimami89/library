/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package myclasses;

import entity.Author;
import entity.Book;
import entity.History;
import entity.UserData;
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
*
* @author user
*/
public class App {
private Book[] books = new Book[10];
private UserData[] readers = new UserData[10];
private History[] histories = new History[10];
public void run(){
   String repeat = "yes";
   Scanner scanner = new Scanner(System.in);
   do{
       System.out.println("Выберите номер задачи: ");
       System.out.println("0: Закрыть программу");
       System.out.println("1: Добавить читателя");
       System.out.println("2: Добавить книгу");
       System.out.println("3: Список книг");
       System.out.println("4: Выдать книгу читателю");
       System.out.println("5: Возврат книги");
       int task = scanner.nextInt(); scanner.nextLine();
       switch (task) {
           case 0:
               repeat = "no";
               break;
           case 1:
               UserData reader = new UserData();
               System.out.print("Введите имя читателя: ");
               reader.setFirstName(scanner.nextLine());
               System.out.print("Введите фамилию читателя: ");
               reader.setLastName(scanner.nextLine());
               System.out.print("Введите телефон читателя: ");
               reader.setTelNumber(scanner.nextInt());
               System.out.println("Читатель инициирован: "+reader.toString());
               for (int i = 0; i < readers.length; i++) {
                   if(readers[i] == null){
                       readers[i] = reader;
                       break;
                   }
               }
               break;
           case 2:
               Book book = new Book();
               System.out.print("Введите название книги: ");
               book.setBookName(scanner.nextLine());
               System.out.print("Введите количество авторов книги: ");
               int countAuthors = (scanner.nextInt());scanner.nextLine();
               Author[] authors = new Author[countAuthors];
               for (int i = 0; i < countAuthors; i++) {
                   Author author = new Author();
                   System.out.print("Введите имя автора "+(i+1)+": ");
                   author.setFirstName(scanner.nextLine());
                   System.out.print("Введите фамилию автора: ");
                   author.setLastName(scanner.nextLine());
                   System.out.print("Введите год рождения автора: ");
                   author.setBirthYear(scanner.nextInt());scanner.nextLine();
                   authors[i] = author;
               }
               book.setAuthors(authors);
               for (int i = 0; i < books.length; i++) {
                   if(books[i] == null){
                       books[i] = book;
                       break;
                   }
               }
               System.out.print("Введите год издания книги: ");
               book.setReleaseYear(scanner.nextInt());scanner.nextLine();
               System.out.println("Книга инициирована: "+book.toString());
               break;
           case 3:
               System.out.println("Список книг: ");
               for (int i = 0; i < books.length; i++) {
                   if(books[i] != null){
                       System.out.printf("%d. %s. %s. %d.%n"
                               ,i+1
                               ,books[i].getBookName()
                               ,Arrays.toString(books[i].getAuthors())
                               ,books[i].getReleaseYear()
                       );
                   }

               }
               break;
           case 4:
               System.out.println("---- Выдать книгу ----");
               System.out.println("Список книг: ");
               for (int i = 0; i < books.length; i++) {
                  if(books[i] != null){
                       System.out.printf("%d. %s. %s. %d.%n"
                               ,i+1
                               ,books[i].getBookName()
                               ,Arrays.toString(books[i].getAuthors())
                               ,books[i].getReleaseYear()
                       );
                  }
               }
               System.out.println("Выберите номер книги: ");
               int numberBook = scanner.nextInt(); scanner.nextLine();

               System.out.println("Список читателей: ");
               for (int i = 0; i < readers.length; i++) {
                  if(readers[i] != null){
                       System.out.printf("%d. %s. %s. Телефон: %s.%n"
                               ,i+1
                               ,readers[i].getFirstName()
                               ,readers[i].getLastName()
                               ,readers[i].getTelNumber()
                       );
                  }
               }
               System.out.println("Выберите номер читателя: ");
               int numberReader = scanner.nextInt(); scanner.nextLine();

               History history = new History();
               history.setBook(books[numberBook - 1]);
               history.setUserData(readers[numberReader - 1]);
               Calendar c = new GregorianCalendar();
               history.setGivenBook(c.getTime());
               for (int i = 0; i < histories.length; i++) {
                   if(histories[i] == null){
                       histories[i] = history;
                       break;
                   }
               }
               System.out.println("--------------------");
               break;
           case 5:
               System.out.println("---- Возврат книги ----");
               System.out.println("Список выданных книг:  ");
               for (int i = 0; i < histories.length; i++) {
                   if(histories[i] != null){
                       System.out.printf("%d. Книгу \"%s\" читает %s %s%n"
                               ,i+1
                               ,histories[i].getBook().getBookName()
                               ,histories[i].getUserData().getFirstName()
                               ,histories[i].getUserData().getLastName()
                       );
                   }
               }
               System.out.println("Выберите номер возвращаемой книги");
               int numberHistory = scanner.nextInt(); scanner.nextLine();
               c = new GregorianCalendar();
               histories[numberHistory - 1].setReturnBook(c.getTime());
               break;
           case 6:
               System.out.println("---- Читаемые книиги ---- ");
               for (int i = 0; i < histories.length; i++) {
                   if(histories[i] == null){
                       System.out.println("Нет читаемых книг...");
                       break;
                   }
               }
               for (int i = 0; i < histories.length; i++) {
                   if(histories[i] != null){
                       System.out.printf("%d. Книгу \"%s\" читает %s %s%n"
                               ,i+1
                               ,histories[i].getBook().getBookName()
                               ,histories[i].getUserData().getFirstName()
                               ,histories[i].getUserData().getLastName()
                       );
                   }
                   
               }
                    
               break;
           default:
               System.out.println("Выберите номер из списка!");

       }

   }while("yes".equals(repeat));
   System.out.println("Пока! :)");
}
}
