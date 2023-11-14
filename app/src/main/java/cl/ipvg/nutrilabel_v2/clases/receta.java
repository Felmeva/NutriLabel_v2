package cl.ipvg.nutrilabel_v2.clases;

public class receta {
    private String idReceta;
    private String nombreR;

    public receta() {
        this.idReceta = "";
        this.nombreR = "";
    }

    public receta(String idreceta, String nombreR) {
        this.idReceta = idreceta;
        this.nombreR = nombreR;
    }

    public String getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(String idReceta) {
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
