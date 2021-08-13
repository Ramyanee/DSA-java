package djmixing;
import java.util.*;


class xnode {

    int key;
    xnode link;
    
}

class LinkedList{
    xnode head;

    public void addxnodeToEnd(int data){
        xnode n = new xnode();
        n.key = data;

        if(head!=null){

            xnode x = head;

            while(x.link!=null){
                x=x.link;
            }
            x.link = n;

        }
        else head=n;
    }


    public xnode reverseLinkedList(xnode h){

        if(h.link==null){
            
            return h;
        }
            xnode x = h;

        
            xnode currentxnode= reverseLinkedList(x.link);
            x.link.link=x;
            x.link=null;
            return currentxnode;
      


    }

   
}



public class djmixing {

    public static xnode DJmixing(LinkedList l,int n, int t){
        
            
        xnode traverse = new xnode();
        xnode reversehead = new xnode();
        xnode newstart = new  xnode();
        xnode newend = new xnode();
        traverse = l.head;
        


        for(int k = 0; k<n/t; k++){

            //creating a new linked list temp of size t to send it to reverse
            // subsequent t xnodes at a time from the start
            LinkedList temp = new LinkedList();
            for (int q = 0; q<t; q++){
                temp.addxnodeToEnd(traverse.key);
                traverse = traverse.link;
            }
            newstart = temp.reverseLinkedList(temp.head);
            if(k == 0){
                reversehead = newstart;
            }
            else{
                newend.link=newstart;
            }
            newend = newstart;
            while(newend.link!=null) newend = newend.link;

        }
        newend.link = traverse;
        return reversehead;
    }
    

    


    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        xnode[] results = new xnode[T];
        

        //for T test cases
        for(int i = 0; i< T; i++){

            int n = s.nextInt();
            int t = s.nextInt();
            LinkedList l = new LinkedList();
            // getting LinkedListfrom input
            for(int j=0; j<n;j++){
                l.addxnodeToEnd(s.nextInt());
            }
            
            results[i]=DJmixing(l, n, t);
        }

    s.close();
    System.out.print("\n\n");
        for(int i = 0; i<T; i++){
            xnode temp = results[i];
            while(temp!=null){
                System.out.printf("%d ",temp.key);
                //System.out.print("-> ");
                temp=temp.link;
            }
            //System.out.print("null\n");
            System.out.print("\n");
        }

        }

}
    

