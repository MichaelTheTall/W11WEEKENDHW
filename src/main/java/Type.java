public enum Type {
    B747(400),
    B757(200),
    B777(300),
    A330(250),
    A340(350),
    A380(600),
    TEST10(10);

    private final int capacity;

    Type(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
