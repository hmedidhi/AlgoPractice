package com.practice.algo.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CriticalConnections {

	private List<List<Integer>> result = new LinkedList<List<Integer>>();
	private List<List<Integer>> dataStructure;

	public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
		dataStructure = new ArrayList<>();
		dataStructure = prepareDataStructure(n, connections);
		getCriticalConnection(connections,n);
		return result;

	}

	private void getCriticalConnection(List<List<Integer>> connections, int n) {
		
		
	
	}

	private List<List<Integer>> prepareDataStructure(int n, List<List<Integer>> connections) {
		List<List<Integer>> alist = new ArrayList<>(n);
		for (int i = 0; i < n; i++)
			 alist.add(new ArrayList<>());
		
		for(List<Integer> element: connections) {
			alist.get(element.get(0)).add(element.get(1));
			alist.get(element.get(1)).add(element.get(0));
		}
		return alist;
	}



	public static void main(String[] args) {
		CriticalConnections cc = new CriticalConnections();
		List<List<Integer>> input = Arrays.asList(
				Arrays.asList(0,1),
                Arrays.asList(1,2),
                Arrays.asList(2,0),
                Arrays.asList(1,3)
              );
		cc.criticalConnections(4, input);
	}

}
