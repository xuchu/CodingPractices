package com.leetcode;

import java.util.*;

class Frequency{
    int number;
    int frequency;
    Frequency(int n, int f){
        this.number = n;
        this.frequency = f;
    }
}

class FixedSizeMinHeap<E> extends PriorityQueue<E> {
    private final int size;
    private final Comparator<E> comparator;
    public FixedSizeMinHeap(int size, Comparator<E> comparator){
        super(size, comparator);
        this.size = size;
        this.comparator = comparator;
    }
    public boolean offer(E element){
        if( size() == size ){
            E root = peek();
            if( comparator.compare(element, root) > 0 ){
                super.poll();
                return super.offer(element);
            }
        }
        else{
            return super.offer(element);
        }
        return false;
    }
}

public class TopKElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for( int i : nums ){
            int frequency = frequencyMap.getOrDefault(i, 0);
            frequencyMap.put(i, frequency+1);
        }
        Comparator<Frequency> frequencyComparator = (x,y) -> x.frequency - y.frequency;
        FixedSizeMinHeap<Frequency> minHeap = new FixedSizeMinHeap<>(k, frequencyComparator);
        List<Integer> results = new ArrayList<>();
        for( Map.Entry<Integer, Integer> entry : frequencyMap.entrySet() ){
            minHeap.add(new Frequency(entry.getKey(), entry.getValue()));
        }
        for( Frequency freq : minHeap ){
            results.add(freq.number);
        }
        return results;
    }
}