package com.leetcode.tests;

import com.leetcode.ExclusiveTimeOfFunctions;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ExclusiveTimeOfFunctionsTest {
    @Test
    public void test1() {
        List<String> logs = Stream.of("0:start:0", "1:start:2", "1:end:5", "0:end:6").collect(Collectors.toList());
        ExclusiveTimeOfFunctions exclusiveTimeOfFunctions = new ExclusiveTimeOfFunctions();
        int[] exclusiveTime = exclusiveTimeOfFunctions.exclusiveTime(2, logs);
        assertThat(exclusiveTime[0], is(3));
        assertThat(exclusiveTime[1], is(4));
    }

    @Test
    public void test2(){
        List<String> logs = Stream.of("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7").collect(Collectors.toList());
        ExclusiveTimeOfFunctions exclusiveTimeOfFunctions = new ExclusiveTimeOfFunctions();
        int[] exclusiveTime = exclusiveTimeOfFunctions.exclusiveTime(1, logs);
        assertThat(exclusiveTime[0], is(8));
    }

}