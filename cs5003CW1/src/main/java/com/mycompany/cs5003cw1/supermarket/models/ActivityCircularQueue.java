/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs5003cw1.supermarket.models;

/**
 *
 * @author nadiaabdullahi
 */
public class ActivityCircularQueue {
    // Attributes
    private activityTracker[] queue;
    private int front = 0;
    private int rear = -1;
    private int size = 0;
    private int capacity;
    
    // Constructor that takes capacity
    public ActivityCircularQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new activityTracker[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
    }
    
    /**
     * Adds new activity to circular queue
     * If queue is full, oldest activity is overwritten
     * Uses circular indexing to wrap around array
     * @param activity the activity to insert
     */
    public void enqueue(activityTracker activity) {
        if (activity == null) {
            System.out.println("Cannot enqueue a null activity.");
            return;
        }
        
        //Overwrite oldest if full
        if (size == capacity) {
            front = (front + 1) % capacity; 
        } else {
            size++;
        }
        
        //Move rear and insert
        rear = (rear + 1) % capacity;
        queue[rear] = activity;
    }
    
    
    
    
}
