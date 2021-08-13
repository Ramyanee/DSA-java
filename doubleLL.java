import java.util.*;

class dnode{
    int data;
    dnode prev;
    dnode next;
}
class dll{
    dnode h;
    dnode t;
    public void addtoend(int data){
        dnode dn = new dnode();
        dn.data = data;
        if(h==null){
            h = dn;
            t = dn;
        }
        else{
            dn.prev = t;
            t.next = dn;
            t = dn;
        }
    }

    public void addtobeg(int data){
        dnode dn = new dnode();
        dn.data=data;
        if(h==null){
            h = dn;
            t = dn;
        }
        else{
            dn.next = h;
            h.prev = dn;
            h = dn;
        }

    }

    public void delend(){
        t = t.prev;
        t.next = null;
    }

    public void delbeg(){
        h = h.next;
        h.prev = null;
    }

    public void delmid(int key){
        dnode temp = h;

        if(h.data == key){
            delbeg();
            return;
        }
        else if(t.data==key){
            delend();
            return;
        }

        while(temp!=t){
            if(temp.data == key){
                break;
            }
            temp = temp.next;
        }
        if(temp == t){
            System.out.println("\n Key Not Found!!! \n");
            return;
        }
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
    }

    public void delpos(int p){
        int cur = 1;
        dnode temp = h;
        while(cur<p){
            cur++;
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;

    }
    public void bidirtraverse(){
        dnode htemp = h;
        dnode ttemp = t;
        System.out.println("\nTraversing from head to tail");
        while(htemp!=null){
            System.out.printf("%d ",htemp.data);
            htemp = htemp.next;
        }
        System.out.println("\nTraversing from tail to head");
        while(ttemp!=null){
            System.out.printf("%d ",ttemp.data);
            ttemp = ttemp.prev;
        }
    }
}

public class doubleLL {
    public static void main(String[] args){
        dll x = new dll();
        x.addtobeg(1);
        x.addtobeg(2);
        x.addtobeg(3);
        x.addtobeg(4);
        x.addtoend(5);
        x.addtobeg(7);
        x.addtobeg(8);
        x.addtobeg(9);
        x.addtobeg(10);
        x.addtoend(6);

        x.bidirtraverse();

        x.delbeg();
        x.bidirtraverse();
        x.delend();
        x.bidirtraverse();
        x.delpos(3);
        x.bidirtraverse();
        x.delmid(9);
        x.bidirtraverse();
        x.delmid(100);
        x.bidirtraverse();
        x.delmid(5);
        x.bidirtraverse();
        x.delmid(2);
        x.bidirtraverse();

    }
}
