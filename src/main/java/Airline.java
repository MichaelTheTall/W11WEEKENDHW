public enum Airline {
    BA("British Airways"),
    VA("Virgin Atlantic"),
    EJ("EasyJet"),
    RA("RyanAir");

    private final String name;

    Airline(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
