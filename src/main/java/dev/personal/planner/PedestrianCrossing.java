package dev.personal.planner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PedestrianCrossing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Reading input
        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = a + b;

        long xp = 2L; // Sirina pasu [m]
        long vp = (5L * 1000) / (60 * 60); // Hitrost pesca [m/s]
        long va = (20L * 1000) / (60 * 60); // Hitrost avta [m/s]
        long l = 5L; // Dolzina avta [m]

        List<Event> events = new ArrayList<>();

        for (int p = 0; p < n; p++) {
            int k = sc.nextInt();
            long[] line = new long[k];
            for (int i = 0; i < k; i++) {
                line[i] = sc.nextLong(); // Use nextLong() for large input
            }

            for (int j = 0; j < k; j++) {
                long d = line[j]; // Nanometri

                // Skupen imenovalec vseh ulomkov [1/(20000*10^9)]
                // Pred avtom
                long tp = (p + 1) * xp * 3600 * (4L * (long) Math.pow(10, 9)); // (p+1)*xp/vp = Cas pesca, da pobegne cez pas pred avtom
                long ta = d * 3600; // d/va = Cas avta, da pripelje do pesca
                events.add(new Event(ta - tp, 1)); // Cakalni cas

                // Za avtom
                tp = p * xp * 3600 * (4L * (long) Math.pow(10, 9)); // p*xp/vp = Cas pesca, da ravno zamudi avto na zacetku pasu
                ta = (d + l * (long) Math.pow(10, 9)) * 3600; // (d+l)/va = Cas avta, da pripelje mimo pesca
                events.add(new Event(ta - tp, -1)); // Cakalni cas
            }
        }

        events.add(new Event(0, 0)); // Zacni takoj?
        events.sort((e1, e2) -> Long.compare(e1.time, e2.time)); // Sort events based on time

        int st = 0;
        for (Event event : events) {
            st += event.delta;
            if (st == 0 && event.time >= 0) {
                System.out.println((event.time + n * xp * 3600 * 4L * (long) Math.pow(10, 9) + 19) / 20); // Cakanje + Preckanje = t + n*xp/vp
                break;
            }
        }
        sc.close();
    }
}

class Event {
    long time;
    int delta;

    Event(long time, int delta) {
        this.time = time;
        this.delta = delta;
    }
}
