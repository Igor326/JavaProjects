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

    public static class MyArrayList {
        private Object[] installArr = {};

        private Object[] elementData = null;

        private int size = 0; // Скільки елементів зберігається в записі

        private int installSize = 10;

        public MyArrayList() {
            this.elementData = new Object[installSize];
        }

        public MyArrayList(int sizeParam) throws Exception {
            if (this.size <= 0) {
                System.out.println("Поза межами");
            }
            this.elementData = new Object[sizeParam];
        }

        public void add(Object obj) {
            grow(); // Якщо необхідно збільшити ємність масива
            elementData[size] = obj;
            size++;
        }

        public void remove(Object obj) {

            for (int i = 0; i < elementData.length; i++) {
                Object ob = elementData[i];
                if (ob.equals(obj)) {
                    int numMoved = size - i - 1;
                    if (numMoved > 0) {
                        // Сенс цієї функції
                        // Першим elementData є початковий масив
                        // Другий elementData - це новий масив, який тут особливий. Щоб не створювати новый масив, він використовува себе сам.
                        // Другий параметр означає початковий індекс  елемента, який копіюється
                        // передається четвертый параметр для покриття початкового індекса нового масива
                        // П'ятий параметр - це довжина, скопійована з початкового масива
                        System.arraycopy(elementData, i + 1, elementData, i,
                                numMoved);
                        // Розмір повинен бути зменшений на 1
                        size--;
                        //Ми повнні залишити останній елемент пустим
                        // оскільки в середині відсутній один елемент, значення останнього елемента все ще не перезаписується
                        System.out.println("Розмір дорівнює: " + size);
                        elementData[size] = null;

                    }
                    break;
                }
            }
        }

        //Розширення
        public void grow() {
            if (size == elementData.length) {
                Object[] elementDataNew = new Object[size * 2 + 10]; // Правило определяет себя
                System.arraycopy(elementData, 0, elementDataNew, 0, size);
                elementData = elementDataNew;
                System.out.println("Розширення відбулося успішно, поточний розмір масива: " + elementData.length);
            }
        }

        // Обход списка
        public void whileMyArrayList() {

            for (Object obj : elementData) {
                if (obj != null) {
                    System.out.println(obj);
                } else {
                    System.out.println("null");
                }
            }
        }

        public boolean contains(Object o) {

            if (o == null) {
                for (int i = 0; i < elementData.length; i++) {
                    if (elementData[i] == o) {
                        return true;
                    }
                }
            } else {
                for (int i = 0; i < elementData.length; i++) {
                    if (elementData[i] == o) {
                        return true;
                    }
                }
            }
            return false;
        }

        public int size() {
            return size;
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

            list.whileMyArrayList();
            System.out.println ("Вирізати елемент");
            list.remove(7);
            System.out.println ("Довжина масива, після видалення елемента" + list.elementData.length);
            list.whileMyArrayList();
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
