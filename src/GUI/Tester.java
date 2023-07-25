   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import DTO.Author;
import DTO.Book;
import Manager.Manager;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Tester 
{
    public static void main(String[] args) 
    {
        int choice =0;
        boolean connhap = false;
        Scanner sc = new Scanner (System.in);
        Manager obj = new Manager();
        System.out.println("Welcome to HKT Store -@ 2021 by <SE151132-Tran Duy Hieu Trung>");
        obj.readFile();
        obj.writeFile();
        obj.writeFile1();
       do
        {
            System.out.println("_________-Main menu-_________");
            System.out.println("1.Show Book List");
            System.out.println("2.Add new Book");
            System.out.println("3.Update Book's information");
            System.out.println("4.Remove a Book by ISBN");
            System.out.println("5.Search a Book ");
            System.out.println("6.Store data to file");
            System.out.println("7.Delete Author");
            System.out.println("8.Real time update processing");
            System.out.println("9.Exit!!");
            
            do
            {
                try
                {
                    sc = new Scanner (System.in);
                    System.out.println("Chose your option: ");
                    choice = sc.nextInt();
                    if(choice < 0 || choice > 9 )
                        throw new Exception();
                    connhap = false;
                }
                catch(Exception e)
                {
                    System.err.println("Choice must be from 1 to 9. Try again!!");
                    connhap = true;
                }
            }while(connhap);
            
            switch(choice)
            {
                //--------------case 1-----------------
                case 1:
                    obj.readFile();
                    obj.writeFile();
                    break;
                    
                //--------------------------------------
                    
                    
                //--------------Case 2----------------------
                case 2:
                    String authorID="";
                    int choiceC2 = 0;
                    boolean connhapC2 = false;
                    Book tm = new Book();
                    Author tm2 = new Author();
                    do
                    {
                        try
                        {
                    
                            System.out.println("Input authorID: ");
                            sc=new Scanner(System.in);
                            authorID=sc.nextLine();
                            if(authorID.isEmpty())
                                throw new Exception();
                            connhapC2 = false;
                        }
                        catch(Exception e)
                        {
                            System.out.println("Try Again!!");
                            connhapC2 = true;
                        }
                    }while(connhapC2);
                    
                    tm2 = obj.searchAuthor(authorID);
                    if(tm2 == null)
                    {
                        System.err.println("AuthorID is not EXIST in AuthorList");
                    }
                    else
                    {
                        tm.setAuthorID(tm2);
                        tm.input();
                        if(obj.addBook(tm) == true)
                        {
                            System.out.println("Add new Book successfully!!");
                            obj.writeFile();
                        }
                        else
                        {
                            System.err.println("Add new Book FAILED!!!");
                        }
                    }
                    
                    
                    //------tiep tuc add------------
                    
                      
                    do
                    {
                            System.out.println("Do you want to continue add new Book??");
                            System.out.println("1.Yes");
                            System.out.println("2.No");

                        do
                        {
                            try
                            {
                                sc = new Scanner(System.in);
                                System.out.println("Select your choice: ");
                                choiceC2 = sc.nextInt();
                                if(choiceC2 < 0 || choiceC2 > 2)
                                    throw new Exception();
                                connhapC2 = false;

                            }
                            catch(Exception e)
                            {
                                System.err.println("Choice must be  1 or 2. Try again, please!!");
                                connhapC2 = true;
                            }
                        }while(connhapC2);

                        switch(choiceC2)
                        {
                            case 1:
                                Book tm3 = new Book();
                                Author tm4 = new Author();
                                String authorID1 = "";
                                
                                do
                                {
                                    try
                                    {
                                        sc = new Scanner(System.in);
                                        System.out.println("Input AuthorID: ");
                                        authorID1 = sc.nextLine();
                                        if(authorID1.isEmpty())
                                            throw new Exception();
                                        connhapC2 = false;
                                    }
                                    catch(Exception e)
                                    {
                                        System.out.println("Try Again!!!");
                                        connhapC2 = true;
                                    }
                                }while(connhapC2);
                                
                                tm4 = obj.searchAuthor(authorID1);
                                if(tm4 == null)
                                {
                                    System.err.println("AuthorID is not exist in AuthorList!!");
                                }
                                else
                                {
                                    tm3.setAuthorID(tm4);
                                    tm3.input();
                                    if(obj.addBook(tm3) == true)
                                    {
                                        System.out.println("Add new Book successfully!!");
                                        obj.writeFile();
                                    }
                                    else
                                    {
                                        System.err.println("Add new  Book FAILED!!!");
                                    }
                                }
                                
                            case 2:
                                System.out.println("Back to main menu!!!");
                                break;
                        }
                    }while(choiceC2 < 2);
                    break;
                    //--------------end case 2---------------------------
                    
                 
                //----------------------Case 3-----------------------------    
                case 3:
                    String bookidUp ="";
                    sc = new Scanner(System.in);
                    System.out.println("Input BookID you want to update: ");
                    bookidUp = sc.nextLine();
                    obj.updateInf(bookidUp);
                    obj.writeFile();
                    break;
                    
                //--------------------End case 3-------------------------------
                    
                    
                //---------------------Case 4---------------------------------    
                case 4:
                    String idcanxoa = "";
                    sc = new Scanner(System.in);
                    System.out.println("Input BookID you want to remove: ");
                    idcanxoa =sc.nextLine();
                    obj.removeBook(idcanxoa);
                    obj.writeFile();
                    break;
                //-------------------End case 4---------------------------------
                    
                
                //--------------------------Case 5--------------------------
              case 5:
                    int choiceC5 = 0;
                    boolean connhapC5 =false ;
                    sc = new Scanner(System.in);
                    
                    do
                    {
                        System.out.println("Chose the way you want to search a Book");
                        System.out.println("1.Search by book name");
                        System.out.println("2.Search by author name");
                        System.out.println("3.Back to main menu!");
                        
                        do
                        {
                            try 
                            {
                                sc = new Scanner(System.in);
                                System.out.println("Input your choice: ");
                                choiceC5 = sc.nextInt();
                                if(choiceC5 < 0 || choiceC5 > 3)
                                    throw new Exception();
                                connhapC5 = false;
                            } 
                            catch (Exception e) 
                            {
                                System.out.println("Try Again,please!!");
                                connhapC5 = true;
                            }
                            
                        }while(connhapC5);
                        
                        switch(choiceC5)
                        {
                            case 1:
                                String booktitle= "";
                                sc = new Scanner(System.in);
                                System.out.println("Input Book's Title you want to find: ");
                                booktitle = sc.nextLine();
                                obj.searchNormal(booktitle);
                                break;
                                
                            case 2:
                                String authorname = "";
                                sc = new Scanner(System.in);
                                System.out.println("Input Author's name of Book you want to search: ");
                                authorname = sc.nextLine();
                                obj.searchByAuthorName(authorname);
                                break;
                                
                            case 3:
                                System.out.println("Back to main menu!!");
                                break;
                        }
                    
                    }while(choiceC5 < 3);
                    break;
                    
                //--------------------------End case 5------------------------------    
                    
                //------------------CASE 6----------------------------------------    
                case 6:
                    System.out.println("Stored data successfully");
                    obj.writeFile();
                    obj.writeFile1();
                    break;       
                    
                //----------------End case 6 ---------------------------------  
                    
                //-------------------Case 7 -------------------------------
                case 7:
                    String authorIdDelete = "";
                    boolean connhapC7 = false;
                    do
                    {
                        try
                        {
                            sc = new Scanner (System.in);
                            System.out.println("Input AuthorID of Author you want to delete: ");
                            authorIdDelete = sc.nextLine();
                            if(authorIdDelete.isEmpty())
                                throw new Exception();
                            connhapC7 = false;
                        }
                        catch(Exception e)
                        {
                            System.err.println("AuthorID is not available!!");
                            connhapC7 = true;
                        }
                    }while(connhapC7);
                    obj.deleteAuthor(authorIdDelete);
                    obj.writeFile();
                    obj.writeFile1();
                    break;
                    
                case 8:
                    obj.readFile();
                    obj.readFile1();
                    java.util.Date date = new java.util.Date();  
                    System.out.println("This program updated succesfully at : " + date);
                    break;
                    
                case 9:
                   
                    break;
            }
            
        }while(choice < 9);
       
    }
}
