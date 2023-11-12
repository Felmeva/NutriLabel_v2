package cl.ipvg.nutrilabel_v2;

public class etiqueta {

    private int idEtiqueta;
    private String nombreEt;

    public etiqueta() {
        this.idEtiqueta = 0;
        this.nombreEt = "";
    }

    public etiqueta(int idEtiqueta, String nombreEt) {
        this.idEtiqueta = idEtiqueta;
        this.nombreEt = nombreEt;
    }

    public int getIdEtiqueta() {
        return idEtiqueta;
    }

    public void setIdEtiqueta(int idEtiqueta) {
        this.idEtiqueta = idEtiqueta;
    }

    public String getNombreEt() {
        return nombreEt;
    }

    public void setNombreEt(String nombreEt) {
        this.nombreEt = nombreEt;
    }

    @Override
    public String toString() {
        return "etiqueta{" +
                "idEtiqueta=" + idEtiqueta +
                ", nombreEt='" + nombreEt + '\'' +
                '}';
    }
}
