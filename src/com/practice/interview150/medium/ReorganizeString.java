package com.practice.interview150.medium;

import java.util.PriorityQueue;

public class ReorganizeString {

    class Node {
        char a;
        int b;

        public Node(char i, int i1) {
            this.a = i;
            this.b = i1;
        }
    }

    public String reorganizeString(String s) {
        int size = s.length();
        int[] charArr = new int[26];
        for (char c : s.toCharArray()) {
            charArr[c - 'a']++;
            int check = size / 2 + 1;
            if (size % 2 == 0)
                check = size / 2;
            if (charArr[c - 'a'] > check) {
                return "";
            }
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((ele1, ele2) -> ele2.b - ele1.b);

        for (int i = 0; i < 26; i++) {
            if (charArr[i] > 0) {
                Node node = new Node((char) ('a' + i), charArr[i]);
                System.out.println(node.a + " " + node.b);
                pq.add(node);
            }
        }
        String result = "";

        while (result.length() != size) {
            Node ele1 = pq.remove();
            System.out.println(ele1.a + " " + ele1.b);
            if (ele1.b > 1) {
                while (pq.size() > 0 && ele1.b != 0) {
                    ele1.b--;
                    System.out.println(pq.size());
                    Node ele2 = pq.remove();
                    System.out.println(pq.size());
                    result = result + ele1.a + ele2.a;
                    System.out.println(result);
                    ele2.b--;
                    if (ele2.b > 0)
                        pq.add(ele2);
                }
                if (ele1.b > 0)
                    pq.add(ele1);
            } else {
                result = result + ele1.a;
            }
        }

        return result;
    }
}
