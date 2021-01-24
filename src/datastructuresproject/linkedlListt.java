/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package datastructuresproject;

import java.util.HashMap;
import java.util.Map;

public class linkedlListt { private Node head;
    private Node tail;
    private int theSize; //eklenen gercek eleman sayısını tutuyor toplam indexten 1 fazla
    
    private class Node
    {
        private Node prev;
        private int data;
        private Node next;
        private String name;
        private String surname;
        
        public Node(Node p, int d, Node n,String name, String surname)
        { 
            prev = p;
            data = d;
            next = n;
            this.name=name;
            this.surname=surname;
        }
    }
    public linkedlListt()
    {
        clear();
    }
     
      
    public String getName(int idx){
         if(idx < 0 || idx >= theSize)
            throw new IndexOutOfBoundsException("Index " + idx + "; size " + theSize);
         return  getNode(idx).name;
    }
    
    public int get(int idx)
    {
        if(idx < 0 || idx >= theSize)
            throw new IndexOutOfBoundsException("Index " + idx + "; size " + theSize);
        
        return getNode(idx).data;
    }
        
    public int set(int idx, int newVal)
    {
        if(idx < 0 || idx >= theSize)
            throw new IndexOutOfBoundsException("Index " + idx + "; size " + theSize);
        
        Node p = getNode(idx);
        int oldVal = p.data;     
        p.data = newVal;   
        return oldVal;
    }
    
    public boolean add(int x,String name, String surname)
    {
        add(theSize,x,name, surname);   
        return true;         
    }
    
    public void add(int idx, int x,String name, String surname)
    {
        if(idx < 0 || idx > theSize)
            throw new IndexOutOfBoundsException("Index " + idx + "; size " + theSize);
        
        Node p = getNode(idx);
        Node newNode = new Node( p.prev, x, p, name, surname );
        newNode.prev.next = newNode;
        p.prev = newNode; 
        
       theSize++;
    }
    public void print()
    {
        for(int i = 0; i < theSize; i++)
        {
            Node p=getNode(i);
            System.out.println(p.data+" "+p.name+" "+p.surname);
        }
    }

    
    public boolean printstudent2(int id){
        for(int i = 0; i < theSize; i++)
        {
            if(getNode(i).data == id)
            {
                return true;
            }
            
        }
        return false;
    }
    
    
    public void printStudent(int studentId)
    {
        for(int i = 0; i < theSize; i++)
        {
            if(getNode(i).data == studentId)
            {
                System.out.println(studentId + " " + getNode(i).name + " " + getNode(i).surname );
                break;
            }
        }
    }
   public  void deleteNode(int key) 
    {       
        Node temp = head, prev = null; 
        if (temp != null && temp.data == key) 
        { 
            head = temp.next; 
            return; 
        }  
        while (temp != null && temp.data != key) 
        { 
            prev = temp; 
            temp = temp.next; 
        }     
        if (temp == null) return; 

        prev.next = temp.next; 
    } 
    
    public int size()
    {
        return theSize;
    }
    
    public boolean isEmpty()
    {
        return theSize == 0;
    }
    
    public void clear()
    {
        head = new Node(null, 0, null,null,null);  //head için yeni bir node olustur ve içleri bos olsun, yani sil (bos)
        tail = new Node(head, 0, null,null,null); // yukarıdaki public Node kısmına gidiyor. ilki prev var previ head mıs
        head.next = tail; //head den sonra direkt tail yani baska hiçbir sey yok.
        
       theSize = 0;
    }
      
 
    private Node getNode(int idx)
    {
        Node p;
            
        if( idx <= theSize / 2 )
        {
            p = head.next;
            for( int i = 0; i < idx; i++ )
                p = p.next;            
        }
        else
        {
            p = tail;
            for( int i = theSize; i > idx; i-- )
                p = p.prev;
        } 
        
        return p;
    }
       
      
    
    
}
