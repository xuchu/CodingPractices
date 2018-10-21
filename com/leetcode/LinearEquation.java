package com.leetcode;

import java.util.ArrayList;

/**
 * Created by appleuser on 9/8/16.
 */
public class LinearEquation {
    public ArrayList<ArrayList<Integer>> getSolution(ArrayList<Integer> coeffList, int rhs ){
        ArrayList<ArrayList<Integer>> solutions = new ArrayList<>();
        ArrayList<Integer> currentSolution = new ArrayList<>(coeffList.size());
        recurGetSolution(solutions, currentSolution, coeffList, rhs);
        return solutions;
    }

    private void recurGetSolution( ArrayList<ArrayList<Integer>> solutions, ArrayList<Integer> currentSolution, ArrayList<Integer> coeffList, int rhs ){
        if( coeffList.size() == 1 ){
            int coeff = coeffList.get(0);
            if( rhs % coeff == 0 ){
                int result = rhs / coeff;
                currentSolution.add(result);
                solutions.add(currentSolution);
            }
            return;
        }
        for( int i = 0; i < coeffList.size(); i++ ){
            int coeff = coeffList.get(i);
            coeffList.remove(i);
            for( int j = 0; j <= (rhs/coeff); j++ ){
                currentSolution.add(j);
                recurGetSolution(solutions, currentSolution, coeffList, rhs-coeff*j);
                currentSolution.remove( currentSolution.size()-1 );
            }
        }
    }
}
