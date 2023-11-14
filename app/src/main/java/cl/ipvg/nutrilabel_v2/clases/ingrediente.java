package cl.ipvg.nutrilabel_v2.clases;

public class ingrediente {
    private String idIng;
    private String nombre;
    private double energia;
    private double proteinas;
    private double grasasT;
    private double HdC;
    private double sodio;

    public ingrediente() {
        this.idIng = "";
        this.nombre = "";
        this.energia = 0;
        this.proteinas = 0;
        this.grasasT = 0;
        this.HdC = 0;
        this.sodio = 0;

    }

    public ingrediente(String idIng ,String nombre, double energia, double proteinas, double grasasT, double HdC, double sodio) {
        this.nombre = nombre;
        this.energia = energia;
        this.proteinas = proteinas;
        this.grasasT = grasasT;
        this.HdC = HdC;
        this.sodio = sodio;
        this.idIng = idIng;
    }

    public String getIdIng() {
        return idIng;
    }

    public void setIdIng(String idIng) {
        this.idIng = idIng;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getEnergia() {
        return energia;
    }

    public void setEnergia(double energia) {
        this.energia = energia;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getGrasasT() {
        return grasasT;
    }

    public void setGrasasT(double grasasT) {
        this.grasasT = grasasT;
    }

    public double getHdC() {
        return HdC;
    }

    public void setHdC(double hdC) {
        HdC = hdC;
    }

    public double getSodio() {
        return sodio;
    }

    public void setSodio(double sodio) {
        this.sodio = sodio;
    }

    @Override
    public String toString() {
        return "ingrediente{" +
                "idIng=" + idIng +
                ", nombre='" + nombre + '\'' +
                ", energia=" + energia +
                ", proteinas=" + proteinas +
                ", grasasT=" + grasasT +
                ", HdC=" + HdC +
                ", sodio=" + sodio +
                '}';
    }



}
