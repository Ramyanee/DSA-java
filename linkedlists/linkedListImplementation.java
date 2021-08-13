
// class node {

//     int key;
//     node link;
    
// }

// class linkedlist {
//     node head;

//     public void addNodeToEnd(int data){
//         node n = new node();
//         n.key = data;

//         if(head!=null){

//             node x = head;

//             while(x.link!=null){
//                 x=x.link;
//             }
//             x.link = n;

//         }
//         else head=n;
//     }

//     public void traverseAndprint(node head){

//         node x = head;

//         while(x!=null){
//             System.out.print(x.key);
//             System.out.print(" -> ");
//             x=x.link;
//         }
//         System.out.print("null\n");

//     }

//     public node reverseLinkedList(node h){

//         if(h.link==null){
            
//             return h;
//         }
//             node x = h;

        
//             node currentNode= reverseLinkedList(x.link);
//             x.link.link=x;
//             x.link=null;
//             return currentNode;
      


//     }

//     public void reverseNprint(node j){
//         node x = reverseLinkedList(j);
//         System.out.println("Here's the reversed linkedlist!");
//         traverseAndprint(x);
//     }
// }


// public class linkedListImplementation {

//     public static void main(String[] args){

//         linkedlist l = new linkedlist();
//         l.addNodeToEnd(2);
//         l.addNodeToEnd(3);
//         l.addNodeToEnd(4);
//         l.addNodeToEnd(5);
//         l.traverseAndprint(l.head);
//         l.reverseNprint(l.head);
        

//     }
    
// }
