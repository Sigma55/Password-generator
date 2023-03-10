import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.File;  // Import the File class
import java.io.IOException;

public class main {

    public static void main(String[] args) {
        //System.out.println(generator().toString());

        // create file

        try {
            File myObj = new File("filename.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        //writte in file
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write( "Voici vos mots de passes : " + generator().toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }





    }

    public static ArrayList<String> generator(){
        System.out.println("Choisir la taille de votre mot de passe : ");
        Scanner scan = new Scanner(System.in);
        int sizePass = scan.nextInt();

        System.out.println("Choisir le nombre de mot de passe : ");
        Scanner scan2 = new Scanner(System.in);
        int nomberPass = scan.nextInt();

        ArrayList<String> passArr = new ArrayList<>();

        char [] minus = tableauAlphabetMinus();
        char [] majus = tableauAlphabetMajus();
        char[] caracteresSpeciaux = {'!', '@', '#', '$', '%', '&', '*', '?'};
        char [] combine = combinerTableaux(minus,majus,caracteresSpeciaux);


        while(nomberPass>0) {
            String finalPass = "";
            for (int i = 0; i < sizePass; i++) {
                Random ran = new Random();
                int nb = ran.nextInt(combine.length);
                finalPass += combine[nb];
            }
            passArr.add(finalPass);
            nomberPass--;
        }
        return passArr;
    }

    public static char[] tableauAlphabetMinus() {
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('a' + i);
        }
        return alphabet;
    }

    public static char[] tableauAlphabetMajus() {
        char[] alphabet = new char[26];
        for (int i = 0; i < 26; i++) {
            alphabet[i] = (char) ('A' + i);
        }
        return alphabet;
    }

    public static char[] combinerTableaux(char[] tableau1, char[] tableau2, char[] tableau3) {
        int longueurTableau1 = tableau1.length;
        int longueurTableau2 = tableau2.length;
        int longueurTableau3 = tableau3.length;
        char[] tableauCombine = new char[longueurTableau1 + longueurTableau2 + longueurTableau3];
        System.arraycopy(tableau1, 0, tableauCombine, 0, longueurTableau1);
        System.arraycopy(tableau2, 0, tableauCombine, longueurTableau1, longueurTableau2);
        System.arraycopy(tableau3, 0, tableauCombine, longueurTableau1 + longueurTableau2, longueurTableau3);
        return tableauCombine;
    }

}
