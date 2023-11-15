package cl.ipvg.nutrilabel_v2.clases;

public class receta {
    private String idReceta;
    private String nombreR;



    private double eneR, proR, graR, hdcR, sodR, gramos;

    public receta() {

    }

    public receta(String idReceta, String nombreR, double eneR, double proR, double graR, double hdcR, double sodR, double gramos) {
        this.idReceta = idReceta;
        this.nombreR = nombreR;
        this.eneR = eneR;
        this.proR = proR;
        this.graR = graR;
        this.hdcR = hdcR;
        this.sodR = sodR;
        this.gramos = gramos;
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

    public double getEneR() {
        return eneR;
    }

    public void setEneR(double eneR) {
        this.eneR = eneR;
    }

    public double getProR() {
        return proR;
    }

    public void setProR(double proR) {
        this.proR = proR;
    }

    public double getGraR() {
        return graR;
    }

    public void setGraR(double graR) {
        this.graR = graR;
    }

    public double getHdcR() {
        return hdcR;
    }

    public void setHdcR(double hdcR) {
        this.hdcR = hdcR;
    }

    public double getSodR() {
        return sodR;
    }

    public void setSodR(double sodR) {
        this.sodR = sodR;
    }

    public double getGramos() {
        return gramos;
    }

    public void setGramos(double gramos) {
        this.gramos = gramos;
    }

    @Override
    public String toString() {
        return "receta{" +
                "idReceta='" + idReceta + '\'' +
                ", nombreR='" + nombreR + '\'' +
                ", eneR=" + eneR +
                ", proR=" + proR +
                ", graR=" + graR +
                ", hdcR=" + hdcR +
                ", sodR=" + sodR +
                ", gramos=" + gramos +
                '}';
    }
}
