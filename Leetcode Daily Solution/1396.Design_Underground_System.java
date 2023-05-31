
class UndergroundSystem {
    private Map<Integer, CheckInInfo> checkIns;
    private Map<String, TravelInfo> travelTimes;

    public UndergroundSystem() {
        checkIns = new HashMap<>();
        travelTimes = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new CheckInInfo(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        CheckInInfo checkInInfo = checkIns.remove(id);
        String travel = checkInInfo.stationName + "," + stationName;
        int travelTime = t - checkInInfo.checkInTime;

        if (travelTimes.containsKey(travel)) {
            TravelInfo travelInfo = travelTimes.get(travel);
            travelInfo.totalTime += travelTime;
            travelInfo.count++;
        } else {
            travelTimes.put(travel, new TravelInfo(travelTime, 1));
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        String travel = startStation + "," + endStation;
        TravelInfo travelInfo = travelTimes.get(travel);
        return (double) travelInfo.totalTime / travelInfo.count;
    }

    private class CheckInInfo {
        String stationName;
        int checkInTime;

        public CheckInInfo(String stationName, int checkInTime) {
            this.stationName = stationName;
            this.checkInTime = checkInTime;
        }
    }

    private class TravelInfo {
        int totalTime;
        int count;

        public TravelInfo(int totalTime, int count) {
            this.totalTime = totalTime;
            this.count = count;
        }
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */
