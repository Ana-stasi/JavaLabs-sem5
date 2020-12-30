package application.domain;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Color color = (Color) o;
        return Objects.equals(name, color.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
