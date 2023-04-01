*Project Description:*

This project is a Java implementation of the HashMap and Queue data structures. The project requires the creation of a custom data structure library that is generic, which means it can work with different data types. The library provides classes for data structures, method calls expected with those data structures, and the definition for an iterator so that clients of the library can iterate through the lists and maps in the same way as most generic data structures in Java.

The Queue data structure will be a singly linked list, FIFO (first in first out), and the HashMap will use the Queue data structure to handle collisions. The project implements the Iterator design pattern, allowing users access to multiple custom Iterators for the data structures.

The project requires the creation of an abstract class called GenericList<T>, which implements the Java Iterable<T> interface. The class has two private data fields, Node<T> head, and int length. The class includes public methods for adding and deleting items from the list, printing the items of the list, getting and setting elements at a specific index, and returning an iterator over the elements of the list in reverse order.

The project also requires the creation of a GenericQueue<T> class that inherits from GenericList<T>. The class adds a tail data member, and the constructor initializes the linked list head, with the value passed in by the constructor, and sets the head and tail data members. The class implements the method add(T data) and delete(), which adds to the back of the list and returns the value of and deletes the last node in the list. The class also overloads the add method to include an optional code data member.

Overall, this project aims to provide a custom data structure library that can be used by others and is generic, with the capability to handle collisions and iterate over elements in reverse order.
