package com.sscottie.avaj.aircraft;

public enum AircraftType {
    BALLOON ("Baloon", "994736b4f0aec72f6e5ae580051d012f"),
    HELICOPTER ("Helicopter", "2ab8b43468e8b92b0fc5c81e70e35a2d"),
    JETPLANE ("JetPlane", "554cd647d6b135f7e36ab1214c5e816a");

    private final String type;
    public final String md5;

    AircraftType(String type, String md5) {
        this.type = type;
        this.md5 = md5;
    }

    public static AircraftType from(String type) {
        for (AircraftType aircraftType : values()) {
            if (aircraftType.type.equals(type) || aircraftType.md5.equals(type)) {
                return  aircraftType;
            }
        }
        return null;
    }
}
