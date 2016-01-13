/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter_1.section_1;

/**
 *
 * @author hkhoi
 */
public class Question {

    public static boolean isUnique(String str) {
        if (str.length() > 26) {
            return false;       // Pigeon-Hole!
        }

        boolean[] visited = new boolean[26];
        for (char c : str.toCharArray()) {
            if (visited[c - 'a']) {
                return false;
            } else {
                visited[c - 'a'] = true;
            }
        }

        return true;
    }

    public static boolean isUnique2(String str) {
        int array = 0;
        for (char c : str.toCharArray()) {
            if (isOn(c - 'a', array)) {
                return false;
            } else {
                array = turnOn(array, c - 'a');
            }
        }

        return true;
    }

    private static boolean isOn(int pos, int num) {
        return ((num & (1 << pos)) != 0);
    }

    private static int turnOn(int num, int pos) {
        return num | (1 << pos);
    }
    
    public static void main(String[] args) {
        System.out.println(isUnique2("khoidk"));
    }
}
