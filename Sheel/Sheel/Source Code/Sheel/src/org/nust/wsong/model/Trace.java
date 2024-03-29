package org.nust.wsong.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @author xxx
 * 
 *
 */
public class Trace {
	private List<String> events;

	private Map<String, Integer> eventOccurrences;

	public Trace() {
		events = new ArrayList<>();
		eventOccurrences = new HashMap<>();
	}

	public Trace(List<String> events) {
		this.events = events;
		eventOccurrences = new HashMap<>();
	}

	public List<String> getEvents() {
		return events;
	}

	public void setEvents(List<String> events) {
		this.events = events;
	}

	/**
	 * 判断一个trace中的元素是否包含另一个trace的元素
	 * 
	 * @param trace
	 * @return
	 */
	// public boolean contains(Trace trace) {
	// Set<String> s1 = new HashSet<>();
	// s1.addAll(events);
	// return s1.containsAll(trace.getEvents());
	// }
	//
	// public boolean contains(Set<String> set) {
	// Set<String> s1 = new HashSet<>();
	// s1.addAll(events);
	// return s1.containsAll(set);
	// }

	/**
	 * 判断一个trace中的元素是否包含某个元素
	 * 
	 * @param trace
	 * @return
	 */
	public boolean contains(String s) {
		return events.contains(s);
	}

	/**
	 * trace 包含的事件集
	 * 
	 * @return
	 */
	public Set<String> set() {
		return new HashSet<>(events);
	}

	/**
	 * 从指定下标开始是否存在某事件
	 * 
	 * @param s
	 * @param start
	 * @return
	 */
	public boolean contains(String s, int start) {
		for (int i = start; i < getEvents().size(); i++)
			if (getEvents().get(i).equals(s))
				return true;
		return false;
	}

	public String get(int index) {
		return events.get(index);
	}

	public void append(String s) {
		events.add(s);
	}

	public int size() {
		return events.size();
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Trace))
			return false;
		Trace t = (Trace) obj;
		if (getEvents().size() != t.getEvents().size())
			return false;
		for (int i = 0; i < getEvents().size(); i++) {
			if (!getEvents().get(i).equals(t.getEvents().get(i)))
				return false;
		}
		return true;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		for (String s : getEvents()) {
			hash *= 37 * s.hashCode() + 1;
		}
		return hash;
	}

	public Map<String, Integer> getEventOccurrences() {
		if (eventOccurrences.isEmpty()) {
			for (String s : events) {
				if (!eventOccurrences.containsKey(s)) {
					eventOccurrences.put(s, 1);
				} else {
					eventOccurrences.put(s, eventOccurrences.get(s) + 1);
				}
			}
		}
		return eventOccurrences;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (String s : events)
			sb.append(s + " ");
		sb.append("]");
		return sb.toString();
	}

}
