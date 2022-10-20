package hu.petrik.versenyeredmenyek;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    private static Map<String, List<Eredmenyek>> sportagEredmenyek = new HashMap<>();

    public static void main(String[] args) {
	String fajlNev = "eredmenyek.txt";
    try {
        beolvas(fajlNev);
        kiiras();
    }catch (FileNotFoundException e){
        System.out.printf("A (z) fájl nem található", fajlNev);
        }
    }

    private static void kiiras(){
        for (Map.Entry<String, List<Eredmenyek>> entry: sportagEredmenyek.entrySet()){
            String sportag = entry.getKey();
            List<Eredmenyek> eredmenyek = entry.getValue();
            System.out.println(sportag);
            for (Eredmenyek e: eredmenyek){
                System.out.println("\t" + e);
            }
        }
    }

    public static void beolvas(String fajlNev) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(fajlNev));
        while (sc.hasNext()){
            String[] sor = sc.nextLine().split(" ");
            String sportag = sor[0];
            String reszIdo = sor[1];
            String nev = sor[2]+ " " + sor[3];
            Eredmenyek e = new Eredmenyek(reszIdo, nev);
            sportagEredmenyek.putIfAbsent(sportag, new ArrayList<>());
            sportagEredmenyek.get(sportag).add(e);
        }
        sc.close();
    }
}
