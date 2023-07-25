/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.io.Serializable;
import java.util.Scanner;



/**
 *
 * @author Admin
 */
public class Author implements Comparable<Author>, Serializable
{
    private String authorID;
    private String name;
    
    public Author()
    {
        authorID = "";
        name = "";
    }
    
    public Author(String authorID)
    {
        this.authorID = authorID;
    }
    
    

    public Author(String authorID, String name) {
        this.authorID = authorID;
        this.name = name;
    }

    public String getAuthorID() {
        return authorID;
    }

    public void setAuthorID(String authorID) {
        this.authorID = authorID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String output()
    {
        return authorID + ", " + name;
    }
    
    @Override
    public String toString() {
        return authorID ;
    }

    @Override
    public int compareTo(Author au)
    {
        if(authorID.compareTo(au.getAuthorID()) > 0)
        {
            return -1;
        }
        if(authorID.compareTo(au.getAuthorID()) < 0)
        {
            return 1;
        }
        return 0;
    }
    
    
}
