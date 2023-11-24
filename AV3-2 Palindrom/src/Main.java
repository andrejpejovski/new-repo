import com.sun.security.auth.UnixNumericGroupPrincipal;

public class Main {

    public static class DLLNode<E>{
        protected E element;
        protected DLLNode<E> pred, succ;
        public DLLNode(E element, DLLNode<E> pred, DLLNode<E> succ)
        {
            this.element=element;
            this.pred=pred;
            this.succ=succ;
        }
    }
    public static class DLL<E>
    {
        private DLLNode<E> first, last;
        public DLL()
        {
            this.first=null;
            this.last=null;
        }

        //FN 0 - Printanje na listata
        public void print()
        {
            if(first==null && last==null)
            {
                System.out.println("Listata e prazna");
            }
            else if(first==null || last==null)
            {
                System.out.println("First / Last error");
            }
            else
            {
                DLLNode<E> temp = new DLLNode(0, null, first);
                for(temp=first;temp!=null;temp=temp.succ)
                {
                    System.out.print(temp.element + " ");
                }
            }
        }
        //FN 1 - Vmetnuvanje element
        public void insertFirst(E o)
        {
            DLLNode<E> ins = new DLLNode(o,null,first);
            if(first==null)
            {
                last=ins;
                ins.succ=null;
            }
            else first.pred=ins;
            first=ins;
        }

        //FN 2 - vmetnuvanje posleden
        public void insertLast(E o)
        {
            DLLNode<E> ins = new DLLNode(o,last,null);
            if(first==null)
                insertFirst(o);
            else
            {
                last.succ=ins;
                last=ins;
            }
        }

        //FN 3 - vmetni posle X
        public void insertAfter(E o, DLLNode<E> after)
        {
            if(after==last)
            {
                insertLast(o);
            }
            else
            {
                DLLNode<E> ins = new DLLNode(o,after,after.succ);
                after.succ.pred=ins;
                after.succ=ins;
            }
        }

        //FN 4 - Insert before function
        public void insertBefore (E o, DLLNode<E> before)
        {
            if(before==first)
                insertFirst(o);
            else {
                DLLNode<E> ins = new DLLNode(o,before.pred,before);
                before.pred.succ=ins;
                before.pred=ins;
            }
        }

        //FN 5 - Deleting first element
        public void deleteFirst()
        {
            if(first!=null) {
                first = first.succ;
                if (first != null) {
                    first.pred = null;
                } else last = null;
            }
            else {
                System.out.println("Error: --> FN-5 No elements to delete.");
            }
        }

        //FN 6 - Deleting last element
        public void deleteLast()
        {
            if(first!=null)
            {
                if(first.succ==null)
                {
                    deleteFirst();
                }
                else
                {
                    last=last.pred;
                    last.succ=null;
                }
            }
            else
            {
                System.out.println("Error: --> FN-6 No elements to delete.");
            }
        }

        //FN 7 - Delete specific node
        public void delete(DLLNode<E> node)
        {
            if(node==first)
                deleteFirst();
            else if(node==last)
                deleteLast();
            else
            {
                node.pred.succ=node.succ;
                node.succ.pred=node.pred;
            }
        }

        //FN 8 - Finding a node
        public int find(E o)
        {
            if(first!=null)
            {
                DLLNode<E> temp=first;
                for(int i=1;temp!=null;i++)
                {
                    //System.out.println("VRTENJE");
                    if(temp.element.equals(o))
                    {
                        return i;
                    }
                    temp=temp.succ;
                }
                System.out.println("Elementot ne e pronajden :/");
            }
            else
            {
                System.out.println("Error -->: FN-8 Listata e prazna");
                return -2;
            }
            return -3;
        }

        //FN 9 - Delete whole list
        public void deleteList()
        {
            first=null;
            last=null;
        }

        //FN 10 - Get number of elements
        public int getSize()
        {
            int size=0;
            DLLNode<E> temp = first;
            for(;temp!=null;temp=temp.succ)
            {
                size++;
            }
            return size;
        }

        //isPalindrom
        public void isPalindrom()
        {
            DLLNode<E> poceten, kraen;
            poceten=first;
            kraen=last;
            boolean isPalindrome=true;
            for(int i=0;i<getSize();i++)
            {
                //test comm for git
                System.out.println("\n");
                System.out.println(poceten.element);
                System.out.println(kraen.element);

                if(!poceten.element.equals(kraen.element))
                {
                    isPalindrome=false;
                    System.out.println("ne e");
                }
                poceten=poceten.succ;
                kraen=kraen.pred;
            }
            if(isPalindrome==true)
                System.out.println("Listata e palindrom");
            else System.out.println("Listata ne e palindrom");
        }
    }

    public static void main(String[] args)
    {
        DLL<Integer> lista = new DLL<>();
        lista.insertAfter(1,lista.first);
        lista.insertFirst(2);
        lista.insertFirst(3);
        lista.insertFirst(2);
        lista.insertFirst(1);

        lista.print();

        lista.isPalindrom();
    }
}