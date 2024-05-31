package IoEnumsAnnotationsAssigment;

public class BiathlonResult {
    private String athleteNumber;
    private String athleteName;
    private String countryCode;
    private String skiTimeResult;
    private ShotStatus[] firstShootingRange;
    private ShotStatus[] secondShootingRange;
    private ShotStatus[] thirdShootingRange;

    public BiathlonResult(String athleteNumber, String athleteName, String countryCode, String skiTimeResult,
                          ShotStatus[] firstShootingRange, ShotStatus[] secondShootingRange, ShotStatus[] thirdShootingRange) {
        this.athleteNumber = athleteNumber;
        this.athleteName = athleteName;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.firstShootingRange = firstShootingRange;
        this.secondShootingRange = secondShootingRange;
        this.thirdShootingRange = thirdShootingRange;
    }

    public String getAthleteNumber() {
        return athleteNumber;
    }

    public String getAthleteName() {
        return athleteName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public ShotStatus[] getFirstShootingRange() {
        return firstShootingRange;
    }

    public ShotStatus[] getSecondShootingRange() {
        return secondShootingRange;
    }

    public ShotStatus[] getThirdShootingRange() {
        return thirdShootingRange;
    }


    public String calculateFinalTime() {
        int penalty = calculatePenalty(firstShootingRange) + calculatePenalty(secondShootingRange) + calculatePenalty(thirdShootingRange);
        String[] timeParts = skiTimeResult.split(":");
        int minutes = Integer.parseInt(timeParts[0]);
        int seconds = Integer.parseInt(timeParts[1]);
        seconds += penalty;
        minutes += seconds / 60;
        seconds %= 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    private int calculatePenalty(ShotStatus[] shootingRange) {
        int penalty = 0;
        for (ShotStatus status : shootingRange) {
            if (status == ShotStatus.MISS) {
                penalty += 10;
            }
        }
        return penalty;
    }
}
