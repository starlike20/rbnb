package MVC.model.reservation;

public interface CalculFacture {
    public float TotalFacture = 0;

    public static float getTotalFacture(){
        return TotalFacture;
    }

}
