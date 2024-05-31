package IoEnumsAnnotationsAssigment;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BiathlonStandings {

    public static void main(String[] args) {
        List<String> csvLines = Arrays.asList(
                "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo",
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo",
                "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx"
        );

        List<BiathlonResult> results = csvLines.stream()
                .map(BiathlonStandings::parseCSVLine)
                .collect(Collectors.toList());

        results.sort(new BiathlonResultComparator());

        System.out.println("Clasamentul Biatlonului la Schi:");
        System.out.println("Castigator - " + results.get(0).getAthleteName() + " " + results.get(0).calculateFinalTime());
        System.out.println("Locul doi - " + results.get(1).getAthleteName() + " " + results.get(1).calculateFinalTime());
        System.out.println("Locul trei - " + results.get(2).getAthleteName() + " " + results.get(2).calculateFinalTime());
    }

    public static BiathlonResult parseCSVLine(String line) {
        String[] parts = line.split(",");
        System.out.println(Arrays.toString(parts));
        String athleteNumber = parts[0];
        String athleteName = parts[1];
        String countryCode = parts[2];
        String skiTimeResult = parts[3];
        ShotStatus[] firstShootingRange = parseShootingRange(parts[4]);
        ShotStatus[] secondShootingRange = parseShootingRange(parts[5]);
        ShotStatus[] thirdShootingRange = parseShootingRange(parts[6]);

        return new BiathlonResult(athleteNumber, athleteName, countryCode, skiTimeResult,
                firstShootingRange, secondShootingRange, thirdShootingRange);
    }

    private static ShotStatus[] parseShootingRange(String range) {
        ShotStatus[] statuses = new ShotStatus[5];
        for (int i = 0; i < range.length(); i++) {
            statuses[i] = range.charAt(i) == 'x' ? ShotStatus.HIT : ShotStatus.MISS;
        }
        System.out.println(Arrays.toString(statuses));
        return statuses;
    }

}
