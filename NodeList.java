class SinglyList{
    int val;
    SinglyList next;
    SinglyList(int data){
        this.val=data;
        this.next=null;
    }
}
public class NodeList{
    static SinglyList head;
    public static void main(String[] args) {
        int[] input={2,3,4,5,6};
        for(int num:input){
            insert(num);
        }
        //SinglyList rev=reverseList();
        insertAtFirst(1);
        insertAtMid(4,9);
        display(head);
    }
    public static void insert(int data){
        SinglyList newNode=new SinglyList(data);
        if(head==null){
            head=newNode;
            return;
        }
        SinglyList temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        temp.next=newNode;
    }
    public static void display(SinglyList nodeData){
        SinglyList temp=nodeData;
        while (temp!=null){
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
    public static SinglyList reverseList(){
        SinglyList prev=null;
        SinglyList curr=head;
        while (curr!=null){
            SinglyList next =curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
    public static void insertAtFirst(int data){
        SinglyList newNode= new SinglyList(data);
        SinglyList curr=head;
        newNode.next=curr;
        head=newNode;
    }
    public static void insertAtLast(int data){
        SinglyList newNode= new SinglyList(data);
        SinglyList curr=head;
        if(curr==null){
            head=newNode;
        }
        while (curr.next!=null){
            curr=curr.next;
        }
        curr.next=newNode;
    }
    public static void insertAtMid(int data,int target){
        SinglyList newNode= new SinglyList(data);
        SinglyList curr=head;
        if(curr==null){
            head=newNode;
        }
        while (curr.next!=null) {
            if (curr.val == target) {
                SinglyList next = curr.next;
                curr.next = newNode;
                newNode.next = next;
                return;
            }
            curr = curr.next;
        }
        head=curr;
    }
}