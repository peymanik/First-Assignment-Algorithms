import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Collections.swap;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public int[] twoSum(int[] nums, int target) {
        // TODO
        int[] ans = new int[2];
        int n = nums.length;
        for (int i=0 ; i<n ; i++) {
            for (int j = i+1; j < n; j++) {
                if (nums[i] + nums[j] == target) {
                    ans[0]=i;
                    ans[1]=j;
                }
            }
        }
        return ans;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public int romanToInt(String s) {
        // TODO
        int max=s.length();
        int counter =0;
        int number=0;

        if(s.charAt(counter)=='M' && counter<max){
            number += 1000;
            counter += 1;
            if(counter<max && s.charAt(counter)=='M'){
                number += 1000;
                counter += 1;
                if(counter<max && s.charAt(counter)=='M'){
                    number += 1000;
                    counter += 1;
                }
            }
        }

        if(counter<max && s.charAt(counter)=='D'){
            number += 500;
            counter += 1;
            if(counter<max && s.charAt(counter)=='C'){
                number += 100;
                counter += 1;
                if(counter<max && s.charAt(counter)=='C'){
                    number += 100;
                    counter += 1;
                    if(counter<max && s.charAt(counter)=='C'){
                        number += 100;
                        counter += 1;
                    }
                }
            }
        }

        if(counter<max && s.charAt(counter)=='C'){
            number += 100;
            counter += 1;
            if(counter<max && s.charAt(counter)=='M'){
                number += 800;
                counter += 1;
            }
            if(counter<max && s.charAt(counter)=='D'){
                number += 300;
                counter += 1;
            }
            if(counter<max && s.charAt(counter)=='C'){
                number += 100;
                counter += 1;
                if(counter<max && s.charAt(counter)=='C'){
                    number += 100;
                    counter += 1;
                }
            }
        }

        if(counter<max && s.charAt(counter)=='L'){
            number += 50;
            counter += 1;
            if(counter<max && s.charAt(counter)=='X'){
                number += 10;
                counter += 1;
                if(counter<max && s.charAt(counter)=='X'){
                    number += 10;
                    counter += 1;
                    if(counter<max && s.charAt(counter)=='X'){
                        number += 10;
                        counter += 1;
                    }
                }
            }
        }

        if(counter<max && s.charAt(counter)=='X'){
            number += 10;
            counter += 1;
            if(counter<max && s.charAt(counter)=='L'){
                number += 30;
                counter += 1;
            }
            if(counter<max && s.charAt(counter)=='C'){
                number += 80;
                counter += 1;
            }
            if(counter<max && s.charAt(counter)=='X'){
                number += 10;
                counter += 1;
                if(counter<max && s.charAt(counter)=='X'){
                    number += 10;
                    counter += 1;
                }
            }

        }

        if(counter<max && s.charAt(counter)=='V'){
            number += 5;
            counter += 1;
            if(counter<max && s.charAt(counter)=='I'){
                number += 1;
                counter += 1;
                if(counter<max && s.charAt(counter)=='I'){
                    number += 1;
                    counter += 1;
                    if(counter<max && s.charAt(counter)=='I'){
                        number += 1;
                        counter += 1;
                    }
                }
            }
        }

        if(counter<max && s.charAt(counter)=='I'){
            number += 1;
            counter += 1;
            if(counter<max && s.charAt(counter)=='V'){
                number += 3;
                counter += 1;
            }
            if(counter<max && s.charAt(counter)=='X'){
                number += 8;
                counter += 1;
            }
            if(counter<max && s.charAt(counter)=='I'){
                number += 1;
                counter += 1;
                if(counter<max && s.charAt(counter)=='I'){
                    number += 1;
                    counter += 1;
                }
            }

        }

        return number;
    }

    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> mylist = new ArrayList<>();
        int size = nums.length;
        int start = 0;
        int helper;

        if (start == size - 1) {
            List<Integer> list1 = new ArrayList<>();
            for (int i=0; i <= size - 1 ; i++) {
                list1.add(i);
            }
            mylist.add(list1);
        }
        else {
            for (int i = start; i <= size - 1; i++) {
                helper = nums[i];
                nums[i] = nums[start];
                nums[start] = helper;

                int[] subnums = new int[size-1];
                for (int j = 1 ; j <= size ; j++){
                    subnums[j-1] = nums[j];
                }
                permute(subnums);

                helper = nums[i];
                nums[i] = nums[start];
                nums[start] = helper;
            }
        }
        return mylist;
    }

    public static void main(String[] args) {
        // test your code here!
    }
}