package IoEnumsAnnotationsAssigment;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
public class BiathlonStandingsTest {

    @Test
    void testCSVParser() {
        // ex de linie CSV
        String csvLine = "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo";

        // Apelarea metodei de parsare și verificarea rezultatului
        BiathlonResult result = BiathlonStandings.parseCSVLine(csvLine);
        assertNotNull(result);
        assertEquals("11", result.getAthleteNumber());
        assertEquals("Umar Jorgson", result.getAthleteName());
        assertEquals("SK", result.getCountryCode());
        assertEquals("30:27", result.getSkiTimeResult());
        assertArrayEquals(new ShotStatus[]{ShotStatus.HIT, ShotStatus.HIT, ShotStatus.HIT, ShotStatus.MISS, ShotStatus.HIT}, result.getFirstShootingRange());
        assertArrayEquals(new ShotStatus[]{ShotStatus.HIT, ShotStatus.HIT, ShotStatus.HIT, ShotStatus.HIT, ShotStatus.HIT}, result.getSecondShootingRange());
        assertArrayEquals(new ShotStatus[]{ShotStatus.HIT, ShotStatus.HIT, ShotStatus.MISS, ShotStatus.HIT, ShotStatus.MISS}, result.getThirdShootingRange());
    }

    @Test
    void testStandingsCalculation() {
        // Definirea unui set de obiecte BiathlonResult pentru a testa calculul clasamentului
        List<String> csvLines = Arrays.asList(
                "11,Umar Jorgson,SK,30:27,xxxox,xxxxx,xxoxo",
                "1,Jimmy Smiles,UK,29:15,xxoox,xooxo,xxxxo",
                "27,Piotr Smitzer,CZ,30:10,xxxxx,xxxxx,xxxxx"
        );

        List<BiathlonResult> results = csvLines.stream()
                .map(BiathlonStandings::parseCSVLine)
                .collect(Collectors.toList());

        results.sort(new BiathlonResultComparator());

        assertNotNull(results);
        assertEquals("Piotr Smitzer", results.get(0).getAthleteName());
        assertEquals("30:10", results.get(0).calculateFinalTime());
        assertEquals("Jimmy Smiles", results.get(1).getAthleteName());
        assertEquals("30:15", results.get(1).calculateFinalTime());
        assertEquals("Umar Jorgson", results.get(2).getAthleteName());
        assertEquals("30:57", results.get(2).calculateFinalTime());  // 30:27 + 30s penalizare
    }


}
