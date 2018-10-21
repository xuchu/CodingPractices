package com.leetcode.tests;

import com.leetcode.TopKElements;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.TopLevelElement;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TopKElementsTest {
    @Test
    public void test1(){
        int[] nums = {1,1,1,2,2,3};
        TopKElements topKElements = new TopKElements();
        List<Integer> integers = topKElements.topKFrequent(nums, 2);
        System.out.println(integers);
    }

}