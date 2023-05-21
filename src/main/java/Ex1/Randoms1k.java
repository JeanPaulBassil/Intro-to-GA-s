package Ex1;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Randoms1k {
    public static int[] randomNums() {
        int[] rangeCount = new int[4];
        for (int i = 0; i < 1000; i++) {
            double number = Math.random();
            System.out.println("Generated number: " + number);
            if (number <= 0.25) rangeCount[0]++;
            else if (number <= .5) rangeCount[1]++;
            else if (number <= .75) rangeCount[2]++;
            else rangeCount[3]++;
        }
        System.out.println();
        System.out.println("There is:");
        System.out.println("- " + rangeCount[0] + " values between 0 and 0.25");
        System.out.println("- " + rangeCount[1] + " values between 0.25 and 0.5");
        System.out.println("- " + rangeCount[2] + " values between 0.5 and 0.75");
        System.out.println("- " + rangeCount[3] + " values between 0.75 and 1");
        return rangeCount;
    }

    public static int[] rouletteSim() {
        int[] stringsCount = new int[11];
        for (int i = 0; i < 1000; i++) {
            int random = (int) Math.floor(Math.random() * (101));
            System.out.println("Generated number: " + random);
            if (random <= 10) stringsCount[0]++;
            else if (random <= 30) stringsCount[1]++;
            else if (random <= 35) stringsCount[2]++;
            else if (random <= 50) stringsCount[3]++;
            else if (random <= 61) stringsCount[5]++;
            else if (random <= 68) stringsCount[6]++;
            else if (random <= 72) stringsCount[7]++;
            else if (random <= 84) stringsCount[9]++;
            else stringsCount[10]++;
        }
        System.out.println();
        System.out.println("There is:");
        System.out.println("String 1: " + stringsCount[0]);
        System.out.println("String 2: " + stringsCount[1]);
        System.out.println("String 3: " + stringsCount[2]);
        System.out.println("String 4: " + stringsCount[3]);
        System.out.println("String 5: " + stringsCount[4]);
        System.out.println("String 6: " + stringsCount[5]);
        System.out.println("String 7: " + stringsCount[6]);
        System.out.println("String 8: " + stringsCount[7]);
        System.out.println("String 9: " + stringsCount[8]);
        System.out.println("String 10: " + stringsCount[9]);
        System.out.println("String 11: " + stringsCount[10]);
        return stringsCount;
    }

    public static int[] threeAndTwelve() {
        int[] count = new int[10];
        for (int i = 0; i < 1000; i++) {
            int random = (int) Math.floor(Math.random() * 10 + 3);
            System.out.println("Generated number: " + random);
            count[random - 3]++;
        }
        System.out.println();
        for (int i = 0; i < count.length; i++) {
            System.out.println("Value " + (i + 3) + ": " + count[i]);
        }
        return count;
    }

    public static String[] crossOver(String s1, String s2, int crossingSite) {
        System.out.println("Crossing over '" + s1 + "' and '" + s2 + "' on site " + crossingSite);
        if (crossingSite <= 0 || crossingSite > s1.length() - 1) {
//            System.out.println("Parent 1: " + s1);
//            System.out.println("Offspring 1: " + s1);
//            System.out.println("Parent 2: " + s2);
//            System.out.println("Offspring 2: " + s2);
            return new String[]{s1, s2};
        }
        StringBuilder offSpring1 = new StringBuilder();
        StringBuilder offSpring2 = new StringBuilder();

        for (int i = 0; i < s1.length(); i++) {
            if (i < crossingSite) {
                offSpring1.append(s1.charAt(i));
                offSpring2.append(s2.charAt(i));
            } else {
                offSpring1.append(s2.charAt(i));
                offSpring2.append(s1.charAt(i));
            }
        }

//        System.out.println("Parent 1: " + s1);
//        System.out.println("Offspring 1: " + offSpring1);
//        System.out.println("Parent 2: " + s2);
//        System.out.println("Offspring 2: " + offSpring2);
        return new String[]{offSpring1.toString(), offSpring2.toString()};
    }

    public static int[] mutation(double probability){
        int[] mutationOrNot = new int[2];
        for (int i = 0; i < 1000; i++){
            int random = (int) Math.floor(Math.random() * 1001);
            System.out.println("Generated number: " + random);
            if (random <= probability * 1000){
                mutationOrNot[0]++;
                System.out.println("There is mutation.");
            }
            else {
                mutationOrNot[1]++;
                System.out.println("No mutation.");
            }
        }
        System.out.println();
        System.out.println("Mutation happened " + mutationOrNot[0] + " times out of 1000.");
        System.out.println("Mutation didn't happen " + mutationOrNot[1] + " times out of 1000.");
        return mutationOrNot;
    }

    public static String[] fiftyGens(){
        String[] generation = new String[100];
        System.out.println("Initializing the first Generation...");

        for (int i = 0; i < 50; i++){
            generation[i] = "11101";
            generation[i + 50] = "00011";
        }
        System.out.println("First Generation Ready, Starting crossovers...");
        System.out.println();
        for (int i = 0; i < 50; i++){
            System.out.println("Generation " + (i + 1) + ": \n");

            String[] matingPool = new String[100];

            List<String> lst = Arrays.asList(generation);

            Collections.shuffle(lst);

            lst.toArray(matingPool);

            for (int j = 0; j < 50; j++){
                String firstParent = matingPool[j];
                String secondParent = matingPool[j + 50];
                int site = (int) Math.floor(Math.random() * firstParent.length());
                String[] crossOver = crossOver(firstParent, secondParent, site);
                matingPool[j] = crossOver[0];
                matingPool[j + 50] = crossOver[1];
            }
            System.out.println();
            generation = matingPool;

        }
        return generation;
    }

    public static void main(String[] args) {
        String[] output = fiftyGens();
        System.out.println("Final output:\n" + Arrays.toString(output));
    }

}
