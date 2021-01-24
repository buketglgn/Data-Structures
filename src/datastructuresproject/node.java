/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresproject;

public class node 
{
    private node left;
    private node right;
    private int idNumber;
    private String name;
    private String surname;
    
     public node(node left, node right, int idNumber,String name, String surname){
        this.left=left;
        this.right=right;
        this.idNumber=idNumber;
        this.name=name;
        this.surname=surname;
    }
     
      public node getLeft(){
        return left;
    }
    public node getRight(){
        return right;
    }
    public int getIdNumber(){
        return idNumber;
    }
    public void setLeft(node newLeft){
        left=newLeft;
    }
    public void setRight(node newRight){
        right=newRight;
    }

    public void setData(int newIdNumber){
        idNumber=newIdNumber;
    }
    public void setNameSurname(String name, String surname){
        this.name=name;
        this.surname=surname;
    }
    public String getname(){
        return name;
    }
    public String getsurname(){
        return surname;
    }
    
    
    
    
}
