/***************************************************************************************
 *
 *    Codewars question Created By:
 *    Author: dcieslak
 *    Title: Alphabet war - airstrike - letters massacre
 *    Availability: https://www.codewars.com/kata/5938f5b606c3033f4700015a
 *
 ***************************************************************************************/

/***************************************************************************************
 * Introduction
 * There is a war and nobody knows - the alphabet war!
 * There are two groups of hostile letters. The tension between left side letters and right side letters was too high and the war began. The letters called airstrike to help them in war - dashes and dots are spreaded everywhere on the battlefield.
 *
 * Task
 * Write a function that accepts fight string consists of only small letters and * which means a bomb drop place. Return who wins the fight after bombs are exploded. When the left side wins return Left side wins!, when the right side wins return Right side wins!, in other case return Let's fight again!.
 *
 * The left side letters and their power:
 *  w - 4
 *  p - 3
 *  b - 2
 *  s - 1
 *
 * The right side letters and their power:
 *  m - 4
 *  q - 3
 *  d - 2
 *  z - 1
 *
 * The other letters don't have power and are only victims.
 * The * bombs kills the adjacent letters ( i.e. aa*aa => a___a, **aa** => ______ );
 *
 * Example
 * AlphabetWar("s*zz");           //=> Right side wins!
 * AlphabetWar("*zd*qm*wp*bs*"); //=> Let's fight again!
 * AlphabetWar("zzzz*s*");       //=> Right side wins!
 * AlphabetWar("www*www****z");  //=> Left side wins!
 *
 ***************************************************************************************/

import java.util.HashMap;

public class AlphabetWarAirstrike {

    public static String alphabetWar(String fight) {
        int powerLevel = 0;
        String survivors = doMassacre(fight);
        char[] survivorsCharArr = survivors.toCharArray();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>() {{
            put('w', 4);
            put('p', 3);
            put('b', 2);
            put('s', 1);
            put('m', -4);
            put('q', -3);
            put('d', -2);
            put('z', -1);
        }};

        for (int i = 0; i < survivorsCharArr.length; i++) {
            if (map.containsKey(survivorsCharArr[i]))
                powerLevel += map.get(survivorsCharArr[i]);
        }
        if (powerLevel == 0)
            return "Let's fight again!";
        return powerLevel > 0
                ? "Left side wins!"
                : "Right side wins!";
    }

    public static String doMassacre(String fight) {
        return fight.replaceAll("[a-z]?\\*[a-z]?", "");
    }
}