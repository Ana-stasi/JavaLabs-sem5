package lab3.model.entity;

public class Color {
    private int id;
    private String name;

    public Color(int id) {
        this.id = id;
    }

    public Color(String name) {
        this.name = name;
    }

    public Color(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format("%4s |%20s |",
                id,name );
    }
}
