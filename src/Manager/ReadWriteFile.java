/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manager;

import DTO.Author;
import DTO.Book;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class ReadWriteFile 
{
     public static TreeSet<Book> readFile(String filename)
     {
               ArrayList<Author> authorlist = readFile1("author.dat");
               TreeSet<Book> bk = new TreeSet<>();
        try 
        {
            FileReader fr = new FileReader("book.dat");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true)
            {
                line = br.readLine();
                if(line == null)
                {
                    break;
                }
                String txt[] = line.split(",");
                if(txt.length == 4)
                {
                    String isbn = txt[0].trim();
                    String title = txt[1].trim();
                    int price = Integer.parseInt(txt[2].trim());
                    String authorID = txt[3].trim();
                    for (Author author : authorlist) 
                    {
                        if(author.getAuthorID().equalsIgnoreCase(authorID))
                        {
                            Author tm = author;
                            bk.add(new Book(isbn,title,price,tm));
                        }
                    }
                }
            }
            
        } 
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        return bk;
}
    
    public static void writeFile(TreeSet<Book> t, String filename)
    {
               try 
                    {
                        FileWriter fw  = new FileWriter("book.dat");
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (Book book : t) 
                        {
                            bw.write(book.toString());
                            bw.newLine();
                        }
                        bw.close();
                        fw.close();
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e.getMessage());
                    }
    }
    //---------------------------------------------------------------
    
     public static ArrayList<Author> readFile1(String filename)
     {
                ArrayList<Author> au = new ArrayList<>();
        try 
        {
            FileReader fr = new FileReader("author.dat");
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            while(true)
            {
                line = br.readLine();
                if(line == null)
                {
                    break;
                }
                String txt[] = line.split(",");
                if(txt.length == 2)
                {
                    String authorID = txt[0].trim();
                    String authorName = txt[1].trim();
                    au.add(new Author(authorID, authorName));
                }
            }
            
        } 
        catch (Exception e) 
        {
            
        }
        return au;
}
     public static void writeFile1(ArrayList<Author> auth, String filename)
     {
                try 
                    {
                        FileWriter fw  = new FileWriter("author.dat");
                        BufferedWriter bw = new BufferedWriter(fw);
                        for (Author au : auth) 
                        {
                            bw.write(au.output());
                            bw.newLine();
                        }
                        bw.close();
                        fw.close();
                    } 
                    catch (Exception e) 
                    {
                        System.out.println(e.getMessage());
                    }
    }
}
