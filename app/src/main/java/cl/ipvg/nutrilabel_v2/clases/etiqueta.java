package cl.ipvg.nutrilabel_v2.clases;

public class etiqueta {

    private int idEtiqueta;
    private String nombreEt;

    private double energiaEt, protEt, GrasEt, hdcEt, sodEt;

    public etiqueta() {
    }

    public etiqueta(int idEtiqueta, String nombreEt, double energiaEt, double protEt, double grasEt, double hdcEt, double sodEt) {
        this.idEtiqueta = idEtiqueta;
        this.nombreEt = nombreEt;
        this.energiaEt = energiaEt;
        this.protEt = protEt;
        GrasEt = grasEt;
        this.hdcEt = hdcEt;
        this.sodEt = sodEt;
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

    public double getEnergiaEt() {
        return energiaEt;
    }

    public void setEnergiaEt(double energiaEt) {
        this.energiaEt = energiaEt;
    }

    public double getProtEt() {
        return protEt;
    }

    public void setProtEt(double protEt) {
        this.protEt = protEt;
    }

    public double getGrasEt() {
        return GrasEt;
    }

    public void setGrasEt(double grasEt) {
        GrasEt = grasEt;
    }

    public double getHdcEt() {
        return hdcEt;
    }

    public void setHdcEt(double hdcEt) {
        this.hdcEt = hdcEt;
    }

    public double getSodEt() {
        return sodEt;
    }

    public void setSodEt(double sodEt) {
        this.sodEt = sodEt;
    }

    @Override
    public String toString() {
        return "etiqueta{" +
                "idEtiqueta=" + idEtiqueta +
                ", nombreEt='" + nombreEt + '\'' +
                ", energiaEt=" + energiaEt +
                ", protEt=" + protEt +
                ", GrasEt=" + GrasEt +
                ", hdcEt=" + hdcEt +
                ", sodEt=" + sodEt +
                '}';
    }
}
