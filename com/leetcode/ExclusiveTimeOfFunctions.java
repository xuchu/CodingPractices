package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ExclusiveTimeOfFunctions {
    class Job{
        int id;
        private boolean start;
        int time;
        Job(int id, boolean start, int time){
            this.id = id;
            this.start = start;
            this.time = time;
        }
        boolean isStart(){
            return start;
        }
        boolean isEnd(){
            return !start;
        }
    }
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] results = new int[n];
        List<Job> jobs = convertLogsToJobs(logs);
        Collections.sort(jobs, Comparator.comparingInt(x -> x.time));
        Job previousJob = jobs.get(0);
        for(  int i = 1; i < jobs.size(); i++ ){
            Job currentJob = jobs.get(i);
            if( previousJob.id == currentJob.id ){
                if( previousJob.isStart() && currentJob.isEnd() ) {
                    results[previousJob.id] += currentJob.time - previousJob.time + 1;
                }
                if( (previousJob.isStart() && currentJob.isStart()) ){
                    results[previousJob.id] += currentJob.time - previousJob.time;
                }
                if( (previousJob.isEnd() && currentJob.isEnd()) ){
                    results[currentJob.id] += currentJob.time - previousJob.time;
                }
            }
            if( previousJob.id != currentJob.id ){
                if( previousJob.isStart() && currentJob.isStart() ){
                    results[previousJob.id] += currentJob.time - previousJob.time;
                }
                if( previousJob.isEnd() && currentJob.isEnd() ){
                    results[currentJob.id] += currentJob.time - previousJob.time;
                }
            }
            previousJob = currentJob;
        }
        return results;
    }

    private List<Job> convertLogsToJobs(List<String> logs){
        List<Job> jobs = new ArrayList<>(logs.size() * 2);
        for( String log : logs ){
            String[] logSplits = log.split(":");
            Job job = new Job(parseStringToInt(logSplits[0]), isStart(logSplits[1]), parseStringToInt(logSplits[2]));
            jobs.add(job);
        }
        return jobs;
    }

    private boolean isStart(String str){
        return str.equals("start");
    }

    private int parseStringToInt(String str){
        int result = Integer.parseInt(str);
        return result;
    }
}
