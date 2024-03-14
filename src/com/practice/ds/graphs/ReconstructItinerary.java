package com.practice.ds.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

class ReconstructItinerary {

	List<String> result = new LinkedList<>();
	Map<String, ArrayList<String>> ds = new HashMap<>();
	Map<String, boolean[]> mapper = new HashMap<>();

	public List<String> findItinerary(List<List<String>> tickets) {
		this.contructDS(tickets);
		result.add("JFK");
		this.dfs("JFK");
		return result;
	}

	private boolean dfs(String element) {

		if (baseCase()) {
			return true;
		} else {
			boolean[] outGoing = mapper.get(element);
			List<String> destination = ds.get(element);
			for (int i = 0; !Objects.isNull(destination) && i < destination.size(); i++) {
				if (!outGoing[i]) {
					result.add(destination.get(i));
					outGoing[i] = true;
					if (dfs(destination.get(i)))
						return true;
					result.remove(result.size() - 1);
					outGoing[i] = false;
				}
			}
		}
		return false;
	}

	private boolean baseCase() {
		for (String flight : mapper.keySet()) {
			for (boolean x : mapper.get(flight)) {
				if (!x)
					return false;
			}
		}
		return true;
	}

	private void contructDS(List<List<String>> tickets) {

		for (List<String> ls : tickets) {
			if (ds.containsKey(ls.get(0)))
				ds.get(ls.get(0)).add(ls.get(1));
			else
				ds.put(ls.get(0), new ArrayList<String>(Arrays.asList(ls.get(1))));
		}

		for (String key : ds.keySet()) {
			Collections.sort(ds.get(key));
			mapper.put(key, new boolean[ds.get(key).size()]);
		}
	}

	public static void main(String[] args) {
		ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
		System.out.println(reconstructItinerary
				.findItinerary(Arrays.asList(Arrays.asList("JFK", "SFO"), Arrays.asList("JFK", "ATL"),
						Arrays.asList("SFO", "ATL"), Arrays.asList("ATL", "JFK"), Arrays.asList("ATL", "SFO"))));
	}
}