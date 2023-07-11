public class Jeep implements Product {
    private String code;
    private String description;
    private double points;

    public Jeep(String code, String description, double points) {
        this.code = code;
        this.description = description;
        this.points = points;
    }

    public Jeep(OldJeep oldJeep) {
        this.code = oldJeep.code();
        this.description = oldJeep.description();
        this.points = oldJeep.points();
    }

    public String code() {
        return code;
    }

    public String description() {
        return description;
    }

    public double points() {
        return points;
    }

    @Override
    public String toString() {
        return "Jeep \t" + code + "\t" + description + "\t" + points;
    }
}
