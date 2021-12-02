package Collection;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "coordinates")
public class Coordinates {

    private Integer x; //Поле не может быть null
    private Double y; //Значение поля должно быть меньше -212, Поле не может быть null

    public Coordinates(Integer x, Double y) {
        this.x = x;
        this.y = y;
    }

    public Coordinates() {
    }

    public Coordinates(Integer x) {
        this.x = x;
    }

    public Coordinates(Double y) {
        this.y = y;
    }

    @XmlElement(name = "coordinateX")
    public void setX(Integer x) {
        this.x = x;
    }

    @XmlElement(name = "coordinateY")
    public void setY(Double y) {
        this.y = y <= -212 ? y : this.y;
    }

    public Integer getX() {
        return x;
    }

    @Override
    public String toString() {
        return "Coordinates{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public Double getY() {
        return y;
    }


}
