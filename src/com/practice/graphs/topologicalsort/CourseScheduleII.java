package com.practice.graphs.topologicalsort;

import java.util.*;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] incomingNodes = new int[numCourses];
        int[] result = new int[numCourses];
        int index = 0;
        for (int[] edge : prerequisites) {
            int a = edge[1];
            int b = edge[0];
            List<Integer> lst = graph.getOrDefault(a,new ArrayList<>());
            lst.add(b);
            graph.put(a,lst);
            incomingNodes[b]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<incomingNodes.length;i++){
            if(incomingNodes[i]==0) {
                queue.add(i);
                result[index] = i;
                index++;
            }
        }
        while(!queue.isEmpty()){
            int node = queue.poll();
            if(!graph.containsKey(node))
                continue;
            for(int childNode: graph.get(node)){
                incomingNodes[childNode]--;
                if(incomingNodes[childNode]==0){
                    queue.add(childNode);
                    result[index] = childNode;
                    index++;
                }
            }
        }

        for (int incomingNode : incomingNodes) {
            if (incomingNode != 0)
                return new int[numCourses];
        }
        return result;
    }
}
