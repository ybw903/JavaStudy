import chaptor.BasicExample;

import chaptor.ioBasednetwork.tcp.ClientExample;
import chaptor.ioBasednetwork.tcp.ServerExample;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.stream.Collectors;


public class Main {
    static Map<String,Integer> nameDict = new HashMap<>();
    public static String solution(String S, String C) {

        StringBuilder answer = new StringBuilder();
        // write your code in Java SE 8
        String[] names = C.split("; ");
        S = S.toLowerCase();
        for(String name: names) {
            String[] firstNameAndLastName = name.split(" ");
            String firstName = firstNameAndLastName[0].toLowerCase();
            String lastName = firstNameAndLastName[firstNameAndLastName.length-1].toLowerCase();
            int hyphensIndex = lastName.indexOf('-');
            if(hyphensIndex != -1) {
                lastName = lastName.substring(0,hyphensIndex) + lastName.substring(hyphensIndex+1);;
            }
            if(lastName.length()>8) {
                lastName = lastName.substring(0,8);
            }

            String emailNameFormat = firstName + "." + lastName;

            if(nameDict.containsKey(emailNameFormat)) {
                int order = nameDict.get(emailNameFormat);
                nameDict.put(emailNameFormat,order+1);
                emailNameFormat += order;
            } else {
                nameDict.put(emailNameFormat,2);
            }

            String emailFormat = emailNameFormat + "@" + S +".com";
            answer.append(emailFormat + "; ");
        }
        return answer.toString();
    }

    public String solution2(String S) {
        Integer count = 0;
        // write your code in Java SE 8

        return count.toString();
    }
    public static int solution3(int N) {
        // write your code in Java SE 8
        String number = Integer.toString(N+1);

        while(isContainTwoIdenticalConsecutiveDigits(number)) {
            int indexOfTwoIdenticalConsecutiveDigits = findIndexOfTwoIdenticalConsecutiveDigits(number);

            if(indexOfTwoIdenticalConsecutiveDigits == -1)
                break;
            if(indexOfTwoIdenticalConsecutiveDigits == number.length()-1) {
                int temp = Integer.parseInt(number);
                temp+=1;
                number = Integer.toString(temp);
            } else {
                number = transeNumber(number, indexOfTwoIdenticalConsecutiveDigits);
            }
        }


        return Integer.parseInt(number);
    }

    public static boolean isContainTwoIdenticalConsecutiveDigits(String number) {
        for(int i =1; i<number.length(); i++) {
            if(number.charAt(i-1) == number.charAt(i))
                return true;
        }
        return false;
    }

    public static int findIndexOfTwoIdenticalConsecutiveDigits(String number) {
        for(int i = 1; i<number.length(); i++) {
            if(number.charAt(i-1) == number.charAt(i))
                return i;
        }
        return -1; // Not Founded
    }

    public static String transeNumber(String number, int index) {

        int temp = Integer.parseInt(number);
        int addVal = 1;
        for(int i = 1; i< number.length()-index; i++) {
            addVal *= 10;
        }

        String changedNumber = Integer.toString((temp+addVal)/addVal);
        boolean isZeroTurn = true;

        for(int i = addVal; i!=1; i/=10) {
            if(isZeroTurn)
                changedNumber += "0";
            else
                changedNumber += "1";
            isZeroTurn = !isZeroTurn;
        }
        return changedNumber;
    }

    public static void writeFileTest() {

    }

    public static void main(String[] args) {
        writeFileTest();
    }
}
