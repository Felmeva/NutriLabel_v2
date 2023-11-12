package cl.ipvg.nutrilabel_v2;

public class receta {
    private int idreceta;
    private String nombreR;

    public receta() {
    }

    public receta(int idreceta, String nombreR) {
        this.idreceta = idreceta;
        this.nombreR = nombreR;
    }

    public int getIdreceta() {
        return idreceta;
    }

    public void setIdreceta(int idreceta) {
        this.idreceta = idreceta;
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
                "idreceta=" + idreceta +
                ", nombreR='" + nombreR + '\'' +
                '}';
    }
}
