package com.practice.interview150.medium;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node head = new Node(-1, -1);
    Node tail = new Node(-1, -1);
    Map<Integer, Node> map;

    int cap;

    public LRUCache(int capacity) {
        cap = capacity;
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }

    private void addNode(Node newnode) {
        Node temp = head.next;

        newnode.next = temp;
        newnode.prev = head;

        head.next = newnode;
        temp.prev = newnode;
    }

    private void removeNode(Node delnode){
        Node next = delnode.next;
        Node prev = delnode.prev;

        prev.next =next;
        next.prev =prev;
    }


    public int get(int key) {
        if(map.containsKey(key)){
            Node resNode = map.get(key);
            int ans = resNode.val;
            map.remove(key);

            removeNode(resNode);
            addNode(resNode);

            map.put(key,resNode);
            return ans;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node cur = map.get(key);
            map.remove(key);
            removeNode(cur);
        }

        if(map.size()==cap){
            map.remove(tail.prev.key);
            removeNode(tail.prev);
        }

        addNode(new Node(key,value));
        map.put(key,head.next);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */