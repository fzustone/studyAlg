package org.chenly.study;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/lru-cache/
 *
 * @author chenly
 * @create 2020-11-22 16:18
 */
public class LRUCache {
	private LinkedList<Integer> valueList;
	private int capacity;
	private Map<Integer, Integer> map = new HashMap<>();

	public LRUCache(int capacity) {
		valueList = new LinkedList<>();
		this.capacity = capacity;
	}

	public int get(int key) {
		Integer newUse = map.getOrDefault(key, -1);
		//把使用到的key捞出来放到第一个
		if (newUse != -1) {
			valueList.removeLastOccurrence(key);
			valueList.offerFirst(key);
		}
		return newUse;

	}

	public void put(int key, int value) {

		//LRU缓存容量是否满了
		if (valueList.size() < capacity) {
			//没有满，如果存在照样，把使用到的key捞出来放到第一个
			if (valueList.contains(key)) {
				map.put(key, value);
				//移除链表的元素，放在第一个，表示最近刚用的
				//这里由于整数的原因无法区分是remove index还是object故而换了一个方法
				valueList.removeLastOccurrence(key);
				valueList.offerFirst(key);
			} else {
				//没有满放第一个
				valueList.offerFirst(key);
				map.put(key, value);
			}
		} else {
			if (valueList.contains(key)) {
				map.put(key, value);
				//移除链表的元素，放在第一个，表示最近刚用的
				valueList.removeLastOccurrence(key);
				valueList.offerFirst(key);
			} else {
				//移除最后一个即最近未使用的节点
				int removeLast = valueList.removeLast();
				map.remove(removeLast);
				//把新节点放在第一个
				valueList.offerFirst(key);
				map.put(key, value);
			}
		}
	}

	public static void main(String[] args) {
		LRUCache lRUCache = new LRUCache(10);
		lRUCache.put(10, 13);
		lRUCache.put(3, 17);
		lRUCache.put(6, 11);
		lRUCache.put(10, 5);
		lRUCache.put(9, 10);

		lRUCache.get(13);
		lRUCache.put(2, 19);
		lRUCache.get(2);
		lRUCache.get(3);
		lRUCache.put(5, 25);

		lRUCache.get(8);
		lRUCache.put(9, 22);
		lRUCache.put(5, 5);
		lRUCache.put(1, 30);
		lRUCache.get(11);

		lRUCache.put(9, 12);
		lRUCache.get(7);
		lRUCache.get(5);
		lRUCache.get(8);
		lRUCache.get(9);

		lRUCache.put(4, 30);
		lRUCache.put(9, 3);
		lRUCache.get(9);
		lRUCache.get(10);
		lRUCache.get(10);

	}
}
