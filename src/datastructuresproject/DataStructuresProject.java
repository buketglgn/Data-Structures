package datastructuresproject;
import java.util.*;
public class DataStructuresProject
{
    public static void main(String[] args)
    {
        BinarySearch binarysearch=new BinarySearch();
        linkedlListt lst=new linkedlListt();
        HashMap<Integer,String> hashmap=new HashMap<>();
        showMenu();
        Scanner scanner=new Scanner(System.in);
        System.out.print("Enter a number for choose : ");
        int input = scanner.nextInt();
        while (true)
        {
            if(input==0)
            {
                System.out.println("Are you sure you want to quit?");
                System.out.println("for exit 0, for continue 1 click");
                input = scanner.nextInt();
                if(input==0)
                {
                    System.out.println("you are out..");
                    System.exit(0);
                }
                else
                    {
                    System.out.println("continues..");
                    showMenu();
                    System.out.print("Enter a number for choose : ");
                    input = scanner.nextInt();
                }
            }
            else if(input==1)
            {
                System.out.println("İnsert  idNumber, name and surname:");
                System.out.println("------");
                System.out.println("ENTER  ID : ");
                int id=scanner.nextInt();
                System.out.println("ENTER  NAME : ");
                String names=scanner.next();
                System.out.println("ENTER  SURNAME : ");
                String surnames=scanner.next();
                binarysearch.insertRecursively(id,names,surnames); //bst ye göre ekleme
                lst.add(id, names, surnames); //linkedliste göre ekleme
                if(hashmap.containsKey(id)){
                    System.out.println("There is a student at the same idNumber, you cant insert");
                }
                hashmap.put(id, names+" "+ surnames); //hashmap e göre ekleme 
                
                System.out.println("İNSERTED..");
                showMenu();
                System.out.print("Enter a number for choose : ");
                input = scanner.nextInt();
            }
            else if(input==2)
            {
                System.out.println("ENTER İD NUMBER FOR DELETİNG A STUDENT: ");
                int id1=scanner.nextInt();
                if(hashmap.containsKey(id1)){
                    hashmap.remove(id1); //hashmap e göre silme
                }
                else{
                    System.out.println("KEY NOT FOUND ACCORDİNg TO HASHMAP");
                }
                if(lst.printstudent2(id1)){
                    
                     lst.deleteNode(id1);//linkedliste göre silme
                }
                else{
                    System.out.println("KEY NOT FOUND ACCORDİNg TO LİNKEDLİST");
                }
                
                binarysearch.delete(id1); //bst ye göre silme
                
                System.out.println("DELETED");
                showMenu();
                System.out.print("Enter a number for choose : ");
                input = scanner.nextInt();
            }
            else if(input==3)
            {
                System.out.println("ENTER İD NUMBER FOR FINDING A STUDENT");
                int id2=scanner.nextInt();
               // binarysearch.search(binarysearch.root,id2,null); //bst ye find islemi
                lst.printStudent(id2); //linkedliste göre find islemi
               // hashmap.get(id2); //hashmap e göre find islemi
                System.out.println("--------");
                showMenu();
                System.out.print("Enter a number for choose : ");
                input = scanner.nextInt();
            }
            else if(input==4)
            {
                System.out.println("Which data structure do you want to use to list all students:..");
                System.out.println("For LinkedList :0 ");
                System.out.println("For BinarySearchTree :1 ");
                System.out.println("For HashMap :2 ");
                input=scanner.nextInt();
                if(input==0)
                {
                    lst.print();
                }
                else if(input==1)
                {
                    binarysearch.printInorder();
                }
                else
                {
                    for(Map.Entry<Integer,String> entry: hashmap.entrySet()){
                        System.out.println(entry.getKey()+" "+ entry.getValue());
                    }
                }
                showMenu();
                System.out.println("------------");
                System.out.print("Enter a number for choose : ");
                input = scanner.nextInt();
            }
            else if(input==5)
            {
                System.out.println("Displaying distinct names..");
                String[] dizi=new String[lst.size()];
                 for(int i=0; i<lst.size(); i++)
                 {
                     String name= lst.getName(i).toLowerCase();
                     dizi[i]=name;
                 }
                  List<String> list = Arrays.asList(dizi);
                  HashSet<String> set = new HashSet<>(list);
                 System.out.println("***No duplicates : "  + set);	
                 
                
                
                showMenu();
                System.out.print("Enter a number for choose : ");
                input = scanner.nextInt();
            }
            else if(input==6)
            {
                System.out.println("Displaying names count..");
                HashMap<String,Integer> namecounts=new HashMap<>();
                for(int i=0; i<lst.size(); i++)
                {
                    String name= lst.getName(i).toLowerCase();
                    if(!namecounts.containsKey(name))
                    {
                        namecounts.put(name, 1);
                    }
                    else{
                        namecounts.replace(name,namecounts.get(name)+1);
                    }
                }
                for(Map.Entry<String,Integer>name: namecounts.entrySet())
                {
                    System.out.println(name.getKey()+" :"+name.getValue());
                }
                System.out.println("*******");
                showMenu();
                System.out.print("Enter a number for choose : ");
                input = scanner.nextInt();
            }
            else if(input==7)
            {
                System.out.println("My information: ");
                showInformation();
                showMenu();
                System.out.println("--------");
                System.out.print("Enter a number for choose : ");
                input = scanner.nextInt();
            }
            else
            {
                System.out.println("Choose between 0 and 7..");
                showMenu();
                System.out.println("---------");
                System.out.print("Enter a number for choose : ");
                input = scanner.nextInt();
            }
        }
    }
    public static void showMenu()
    {
        System.out.println("0. Exit");
        System.out.println("1. Add Student");
        System.out.println("2. Delete Student");
        System.out.println("3. Find Student");
        System.out.println("4. List All Student");
        System.out.println("5. List Distinct Names");
        System.out.println("6. List name counts");
        System.out.println("7. About");
    }
    public  static void showInformation()
    {
        System.out.println("My IdNumber: 180315071");
        System.out.println("My name and surname: BUKET GÜLGÜN");
    }
    
    
    
    
     
}
