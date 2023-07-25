/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import Manager.Manager;
import java.io.Serializable;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Book implements Comparable<Book>, Serializable
{
    private String isbn;
    private String title;
    private int price;
    private Author authorID;

    public Book()
    {
        isbn = "";
        title ="";
        price =0;
        authorID = new Author();
    }
    

    public Book(String isbn, String title, int price, Author authorID) 
    {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.authorID = authorID;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthorID() {
        return authorID;
    }

    public void setAuthorID(Author authorID) {
        this.authorID = authorID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    

   
    public void input()
    {
        Scanner sc = new Scanner (System.in);
        boolean connhap = false;
        
        do
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Input ISBN: ");
                isbn = sc.nextLine();
                if(isbn.isEmpty())
                    throw new Exception();
                connhap = false;
            }
            catch(Exception e)
            {
                System.out.println("ISBN is not available!!!");
                connhap =true;
            }
        }while(connhap);
        
        do
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Input title: ");
                title = sc.nextLine();
                if(title.isEmpty())
                    throw new Exception();
                connhap = false;
            }
            catch(Exception e)
            {
                System.out.println("Title is not available!!!");
                connhap =true;
            }
        }while(connhap);
        
        do
        {
            try
            {
                sc = new Scanner(System.in);
                System.out.println("Input Price: ");
                price= sc.nextInt();
                if(price < 0)
                    throw new Exception();
                connhap = false;
                            
            }
            catch(Exception e)
            {
                System.out.println("Price is not available");
                connhap = true;
            }
        }while(connhap);
        
    }
    
   
    
    @Override
    public String toString()
    {
        return isbn + ", " + title + ", "+ price + ", "+ authorID.toString() ;
    }
    
    @Override
    public int compareTo(Book b)
    {
        if(isbn.compareTo(b.getIsbn()) > 0)
        {
            return -1;
        }
        if(isbn.compareTo(b.getIsbn()) < 0)
        {
            return 1;
        }
        return 0;
    }
}
