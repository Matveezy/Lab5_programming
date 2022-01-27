package collection;

public enum Color {
    GREEN("green"),
    RED("red"),
    BLUE("blue"),
    ORANGE("orange"),
    BROWN("brown");
    private String color;

    Color(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}
