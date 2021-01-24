/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresproject;


public class BinarySearch {
    
    public node root;
    
    
  public void insertRecursively(int newValue,String newname,String newsurname){
        root= insertRecursively(newValue,root, newname, newsurname);
    }
    private node insertRecursively(int newValue,node tempNode,String newname, String newsurname){
        if(tempNode==null)
            return new node(null,null,newValue,newname,newsurname); //root bos ise yeni node olustur.
        
        if(newValue<tempNode.getIdNumber())
            tempNode.setLeft(insertRecursively(newValue, tempNode.getLeft(),newname,newsurname));
        else //newValue getData dan büyükse;
            tempNode.setRight(insertRecursively(newValue, tempNode.getRight(),newname,newsurname));
            
        return tempNode;
       
    }
   
     public static void search(node root, int key, node parent)
    {      
        if (root == null)
        {
            System.out.print("Key Not found");
            return;
        }
 
        if (root.getIdNumber() == key)
        {
            if (parent == null) {
                System.out.print(""+ root.getIdNumber()+" "+root.getname()+" "+root.getsurname());
            }
 
            else if (key < parent.getIdNumber()) {
                System.out.print("" + root.getIdNumber()+" "+root.getname()+" "+root.getsurname());
            }
            else {
                System.out.print(" "+ root.getIdNumber()+" "+root.getname()+" "+root.getsurname());
            }
 
            return;
        }
 
        if (key < root.getIdNumber()) {
            search(root.getLeft(), key, root);
        }
        else {
            search(root.getRight(), key, root);
        }
    }
     public void printInorder()
    {
        printInorder(root);
    }
    
    private void printInorder(node tempNode)
    {
        if(tempNode == null)
            return;
           
        printInorder(tempNode.getLeft());
        System.out.print(tempNode.getIdNumber()+ " "+tempNode.getname()+" "+tempNode.getsurname());
        printInorder(tempNode.getRight());     
    }
    
     

     public boolean isEmpty(){
        return root==null;
    }
    
     public void delete(Integer data) {
 
        deleteNode(this.root, data);
    }
 
    private node deleteNode(node root, Integer data) {
 
        if(root == null) return root;
 
        if(data < root.getIdNumber()) {
            root.setLeft(deleteNode(root.getLeft(), data));
        } else if(data > root.getIdNumber()) {
            root.setRight(deleteNode(root.getRight(), data));
        } else {
            
            if(root.getLeft() == null && root.getRight() == null) {
                System.out.println(data+" "+root.getname()+" "+root.getsurname()+" -deleting ");
                return null;
            } else if(root.getLeft() == null) {
               
                System.out.println(data+" "+root.getname()+" "+root.getsurname()+" -deleting ");
                return root.getRight();
            } else if(root.getRight() == null) {
                
                System.out.println(data+" "+root.getname()+" "+root.getsurname()+" -deleting ");
                return root.getLeft();
            } else {
                
                Integer minValue = minValue(root.getRight());
                root.setData(minValue);
                root.setRight(deleteNode(root.getRight(), minValue));
                System.out.println(data+" "+root.getname()+" "+root.getsurname()+" -deleting ");
            }
        }
 
        return root;
    }
 
    private Integer minValue(node nodex) {
 
        if(nodex.getLeft() != null) {
            return minValue(nodex.getLeft());
        }
        return nodex.getIdNumber();
    }
    

   
}
