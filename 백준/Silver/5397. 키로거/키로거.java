import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Main {
    static class Node{
        char data;
        Node prev, next;

        Node(char data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;
        Node tail;
        Node cursor;

        LinkedList(){
            head = new Node('H');
            tail = new Node('T');
            head.next = tail;
            tail.prev = head;
            cursor = tail;
        }

        void insert(char data){
            Node newNode = new Node(data);
            newNode.prev = cursor.prev;
            newNode.next = cursor;
            cursor.prev.next = newNode;
            cursor.prev = newNode;
        }

        void delete(){
            if(cursor.prev != head){
                cursor.prev.prev.next = cursor;
                cursor.prev = cursor.prev.prev;
            }
        }

        void moveLeft(){
            if(cursor.prev != head){
                cursor = cursor.prev;
            }
        }

        void moveRight(){
            if(cursor != tail){
                cursor = cursor.next;
            }
        }

        String getPassword(){
            StringBuilder sb = new StringBuilder();
            Node current = head.next;
            while(current != tail){
                sb.append(current.data);
                current = current.next;
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t  = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            String input = br.readLine();
            LinkedList list = new LinkedList();

            for(char c : input.toCharArray()){
                switch(c) {
                    case '<':
                        list.moveLeft();
                        break;
                    case '>':
                        list.moveRight();
                        break;
                    case '-':
                        list.delete();
                        break;
                    default:
                        list.insert(c);
                }
            }
            System.out.println(list.getPassword());
        }
    }
}