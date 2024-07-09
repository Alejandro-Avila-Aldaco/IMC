package util;

public class ImcResultadoUtil {
    public static double calcularIMC(double weight, double height) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Peso inválido: El peso debe ser mayor que 0.");
        }
        if (height <= 0 || height < 1 || height > 2.5) {
            throw new IllegalArgumentException("Estatura inválida");
        }
        return weight / (height * height);
    }
}
