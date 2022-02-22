/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;
import interfa.LinkedList;
import interfa.LinkedListNode;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanp
 */
public class Lista implements LinkedList{

    Nodo head=null;
    Nodo tail=null;
    int c=0;

    @Override
    public boolean add(Object object) {
        Nodo n = new Nodo(object);
        if (head==null){
            head = n;
            c++;
            return true;
        }
        else if (tail==null){
            tail=n;
            head.setnext(tail);
            c++;
            return true;
        }
        else if (tail!=null){
            tail.setnext(n);
            tail=n;
            c++;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean add(LinkedListNode node, Object object) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if (n==null){return false;}
            if(n==node){
                Nodo o = new Nodo(object);
                o.setnext(n.getnext());
                n.setnext(o);
                c++;
                return true;
            }
            else{
                n=n.getnext();
            }
        }
        return false;
        
    }

    @Override
    public boolean addAll(Object[] objects) {
        try {
            for (Object o : objects){
            Nodo n = new Nodo(o);
            if (head==null){head=n;}
            else if(tail==null){
                head.setnext(n);
            }
            else{
                tail.setnext(n);
                tail=n;
            }
            c++;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean addAll(LinkedListNode node, Object[] objects) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if (n==null){return false;}
            if(n==node){
                try {
                    for (Object o : objects){
                        Nodo e = new Nodo(o);
                        if(n.getnext()!=null){
                            e.setnext(n.getnext());
                            n.setnext(e);
                        }
                        if(n.getnext()==null){
                            n.setnext(e);
                        }
                        n=e;
                        c++;
                    }
                    return true;
                } catch (Exception e) {
                    return false;
                }
            }
            else{
                n=n.getnext();
            }
        }
        return false;
        
    }

    @Override
    public boolean addFirst(Object object) {
        Nodo n = new Nodo(object);
        if (head==null){
            head=n;
            c++;
            return true;
        }
        else if (head!=null){
            n.setnext(head);
            head=n;
            c++;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean addLast(Object object) {
        Nodo n = new Nodo(object);
        if(head==null){
            head=n;
            c++;
            return true;
        }
        else if (tail==null){
            tail=n;
            head.setnext(tail);
            c++;
            return true;
        }
        else if (tail!=null){
            tail.setnext(n);
            tail=n;
            c++;
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public void clear() {
        head=null;
        tail=null;
        c=0;
        System.out.println("borrada con exito");
    }

    @Override
    public LinkedList clone() {
        return this;
    }

    @Override
    public boolean contains(Object object) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if(n.getvalor()==object){
                return true;
            }
            n=n.getnext();
        }
        return false;
    }

    @Override
    public boolean containsAll(Object[] objects) {
        boolean b = false;
        for (Object o : objects) {
            Nodo n = head;
            for (int i = c; i>=1; i--) {
                if(n.getvalor()==o){
                    b=true;
                }
            }
        }
        return b;
    }

    @Override
    public LinkedListNode nodeOf(Object object) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if(n.getvalor()==object){return n;}
            else{n=n.getnext();}
        }
        return null;
    }

    @Override
    public boolean isEquals(Object object) {
        return this==object;
    }

    @Override
    public boolean isEmpty() {
        return head == null & tail == null;
    }

    @Override
    public Object get() {
        return head.getvalor();
    }

    @Override
    public Object get(LinkedListNode node) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if (n==node){return n.getvalor();}
            n=n.getnext();
        
        }
        return null;
    }

    @Override
    public Object getPrevious(LinkedListNode node) { //aaaaaaaaaa
        Nodo n = head;
        if (head == node){
            return null;
        }
        else{
            for (int i = c; i>=1; i--) {
            if (n.getnext()==node){return n;}
            n=n.getnext();
        }
        }
        return null;
    }

    @Override
    public Object getNext(LinkedListNode node) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if (n==node){return n.getnext();}
            n=n.getnext();
        
        }
        return null;
    }

    @Override
    public Object getFirst() {
        return head.getvalor();
    }

    @Override
    public Object getLast() {
        return tail.getvalor();
    }

    @Override
    public boolean remove(Object object) {
        Nodo n = head;
        if (head.getvalor()==object){
            head=head.getnext();
            c--;
            return true;
        }
        for (int i = c; i>=1; i--) {
            if(n.getnext().getvalor()==object){
                n.setnext(n.getnext().getnext());
                c--;
                return true;
            }
            n=n.getnext();
        }
        return false;
    }

    @Override
    public boolean remove(LinkedListNode node) {
        Nodo n = head;
        if (head==node){
            head=head.getnext();
            c--;
            return true;
        }
        for (int i = c; i>=1; i--) {
            if (n.getnext()==node){
                n.setnext(n.getnext().getnext());
                c--;
                return true;
            }
            n=n.getnext();
        }
        return false;
    }

    @Override
    public boolean removeAll(Object[] objects) {
        try {
            for (Object o : objects){
            Nodo n = head;
            if (head.getvalor()==o){
            head=head.getnext();
            c--;
            return true;
        }
            for (int i = c; i>=1; i--) {
                if (n.getvalor()==o){
                    n.setnext(n.getnext().getnext());
                    c--;
                }
                n=n.getnext();
            }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean retainAll(Object[] objects) {
        try {
            Nodo n = head;
            for (int i = c; i>=1; i--) {
                for (Object o : objects){
                    if(head.getvalor()!=o){
                        head=head.getnext();
                        c--;
                    }
                    else if(n.getnext().getvalor()!=o){
                        n.setnext(n.getnext().getnext());
                        c--;
                    }
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    @Override
    public boolean set(LinkedListNode node, Object object) {
        Nodo n = head;
        for (int i = c; i>=1; i--) {
            if (n==node){n.setvalor(object);return true;}
        }
        return false;
    }

    @Override
    public int size() {
        return c;
    }

    @Override
    public LinkedList subList(Nodo from, Nodo to) {
        Lista l = new Lista();
        l.head=from;
        l.tail=to;
        return l;
    }

    @Override
    public Object toArray() {
        List<Object> listaobj = new ArrayList();
        Nodo temp = head;
        while(temp!=null){
            listaobj.add(temp.getvalor());
            temp=temp.getnext();
        }
        return listaobj;
    }

    @Override
    public LinkedList sort() {
        List<Object> listaobj = new ArrayList();
        Nodo temp = head;
        while(temp!=null){
            listaobj.add(temp.getvalor());
            temp=temp.getnext();
        }
        return this;
    }
    @Override
    public String toString() {
        return "List [head=" + head + ", tail=" + tail + "]";
    }
    
}
