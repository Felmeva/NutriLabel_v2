package cl.ipvg.nutrilabel_v2;

public class receta {
    private int idReceta;
    private String nombreR;

    public receta() {
        this.idReceta = 0;
        this.nombreR = "";
    }

    public receta(int idreceta, String nombreR) {
        this.idReceta = idreceta;
        this.nombreR = nombreR;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public String getNombreR() {
        return nombreR;
    }

    public void setNombreR(String nombreR) {
        this.nombreR = nombreR;
    }

    @Override
    public String toString() {
        return "receta{" +
                "idreceta=" + idReceta +
                ", nombreR='" + nombreR + '\'' +
                '}';
    }
}
