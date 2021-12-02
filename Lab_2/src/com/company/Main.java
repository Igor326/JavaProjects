package com.company;

import java.util.ArrayList;
import java.util.Collection;
import java.io.*;
import java.util.Arrays;


public class Main {
    public static class Person {
        public static String name;
        public static String age;
    }

    public static class MyArrayList<T> {
        private final int INIT_SIZE = 16;
        private final int CUT_RATE = 4;
        private Object[] array = new Object[INIT_SIZE];
        private int pointer = 0;


        public void add(T item) {
            if(pointer == array.length-1)
                resize(array.length*2);
            array[pointer++] = item;
        }


        public T get(int index) {
            return (T) array[index];
        }


        public void remove(int index) {
            for (int i = index; i<pointer; i++)
                array[i] = array[i+1];
            array[pointer] = null;
            pointer--;
            if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
                resize(array.length/2);

        }

        public int size() {
            return pointer;
        }


        private void resize(int newLength) {
            Object[] newArray = new Object[newLength];
            System.arraycopy(array, 0, newArray, 0, pointer);
            array = newArray;
        }
    }

    public static class MyLinkList<T> {
        private class Node<T> {
            T value;
            Node<T> next;

            Node(T value) {
                this.value = value;
                this.next = null;
            }
        }

        private Node<T> head = null;

        public int size() {
            Node<T> p;
            int size = 0;
            for (p = head; p != null; p = p.next) {
                size++;
            }
            return size;
        }

        public boolean isEmpty() {
            if (size() == 0) {
                return true;
            }
            return false;
        }

        public boolean contains(T o) {
            if (isEmpty()) {
                return false;
            }
            Node<T> p;
            for (p = head; p != null; p = p.next) {
                if (p.value.equals(o)) {
                    return true;
                }
            }
            return false;
        }

        public void add(T o) {
            if (isEmpty()) {
                head = new Node<T>(o);
            } else {
                Node<T> p = head;
                Node<T> node = new Node<T>(o);
                while (p.next != null) {
                    p = p.next;
                }
                p.next = node;
                node.next = null;
            }
        }

        public boolean remove(T o) {
            Node<T> p = head, p1 = null;
            boolean have = false;
            if (isEmpty()) {
                return false;
            }
            while (p != null) {
                if (p.value.equals(o)) {
                    if (p1 == null) {
                        head = head.next;
                    } else {
                        p1.next = p.next;
                    }
                    have = true;
                }
                p1 = p;
                p = p.next;
            }
            return have;
        }

        public T get(int index) {
            int i = -1;
            if (isEmpty()) {
                return null;
            }
            if (index < 0 || index > size()) {
                return null;
            }
            Node<T> p = head;
            while (p != null) {
                i++;
                if (i == index) {
                    return p.value;
                }
                p = p.next;
            }
            return null;
        }

        public void add(int index, T element) {
            int i = -1;
            if (isEmpty()) {
                this.add(element);
                return;
            }
            if (index < 0 || index > size()) {
                return;
            }
            Node<T> p = head, p1 = null;
            while (p != null) {
                i++;
                if (i == index) {
                    Node<T> newNode = new Node<T>(element);
                    if (p1 == null) {
                        newNode.next = head;
                        head = newNode;
                    } else {
                        p1.next = newNode;
                        newNode.next = p;
                    }
                }
                p1 = p;
                p = p.next;
            }
        }


        public T remove(int index) {
            if (isEmpty()) {
                return null;
            }
            if (index < 0 || index > size()) {
                return null;
            }
            Node<T> p = head, p1 = null;
            int i = -1;
            while (p != null) {
                i++;
                if (i == index) {
                    if (p1 == null) {
                        head = head.next;
                    } else {
                        p1.next = p.next;
                    }
                    return p.value;
                }
                p1 = p;
                p = p.next;
            }
            return null;
        }

        public void printLinkList() {
            Node<T> p;
            for (p = head; p != null; p = p.next) {
                System.out.print(p.value + "--->");
            }
            System.out.println();
        }


    }

    public static class SerializationUtil {

        public static void serialize(Person person, String path) {
            String text = person.name + "_" + person.age;
             try (FileOutputStream fos = new FileOutputStream(path)) {

                byte[] buffer = text.getBytes();

                fos.write(buffer, 0, buffer.length);
            } catch (IOException ex) {

                System.out.println(ex.getMessage());
            }
            System.out.println("The file has been written");
        }
        public static void deserialize(String path) {
            try(FileReader reader = new FileReader(path))
            {

                int c;
                while((c=reader.read())!=-1){

                    System.out.print((char)c);
                }
            }
            catch(IOException ex){

                System.out.println(ex.getMessage());
            }
        }
    }




        public static void main(String[] args) {

            /////////////////////////////////////////////////////
            MyArrayList list = new MyArrayList();

            for(int i=0;i<10;i++){
                list.add(i);
            }

            System.out.println ("Довжина масива, до видалення елемента " + list.size());
            System.out.println ("Вирізали елемент");
            list.remove(7);
            System.out.println ("Довжина масива, після видалення елемента " + list.size());

            ///////////////////////////////////////////////////////
            MyLinkList<String> list2 = new MyLinkList<String>();
            //System.out.println(list.isEmpty());
            int [] s=new int[5];
            list2.add("5");
            list2.add("6");
            list2.add("7");
            list2.add("8");
            list2.printLinkList();

            ///////////////////////////////////////////////////////////
            Person Ihor = new Person();
            Ihor.name = "Ihor";
            Ihor.age = "19";
            String path ="I:\\My files\\IntelliJ IDEA Community Edition\\IntelliJ IDEA Community Edition 2021.2.2\\Projects\\Lab_2\\Save.txt";
            SerializationUtil.serialize(Ihor, path);
            Person Ihor2 = new Person();
            SerializationUtil.deserialize(path);

        }

}
