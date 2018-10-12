public enum AirportCode {
    EDI("Edinburgh"),
    HKG("Hong Kong"),
    LDN("London"),
    NYC("New York City"),
    BER("Berlin"),
    PAR("Paris"),
    WAR("Warsaw");

    private final String name;

    AirportCode(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
