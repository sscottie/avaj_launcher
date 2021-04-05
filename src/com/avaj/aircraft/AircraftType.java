package com.avaj.aircraft;

public enum AircraftType {
    BALLOON ("Baloon", "994736b4f0aec72f6e5ae580051d012f"),
    HELICOPTER ("Helicopter", "e999487829c0fe97e0dea0d03a1417e9"),
    JETPLANE ("JetPlane", "554cd647d6b135f7e36ab1214c5e816a");

    private final String type;
    public final String md5;

    AircraftType(String type, String md5) {
        this.type = type;
        this.md5 = md5;
    }

    public String getType() {
        return type;
    }

    public String getMd5() { return md5; }

}
