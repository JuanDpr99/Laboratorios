
/**
 * @author ECI, 2017 v01 2021 v02
 *
 */
public class Vector{

    public static final float MAXERROR = 0.00000000000001f;
    
    private float r;
    private Angulo theta;
    
    /**
     * Constructor del vector, en coordenadas polares
     * @param d longitud del vector
     * @param a angulo del vector
     */
    public Vector (float r, Angulo t) {
    }

    /**
     * Constructor del vector, en coordenadas cartesianas
     * @param x coordenada x del vector
     * @param y coordenada y del vector
     */
    public Vector (float x, float y) {
    }
    
    /**
     * Retorna la coordenada X del vector
     * @return coordenada X del vector
     */
    public float coordenadaX() {
        return 0.0f;
    }

    /**
     * Retorna la coordenada Y del Vector
     * @return coordenada Y del vector
     */
    public float coordenadaY() {
        return 0.0f;
    }


    /**
     * Retorna el angulo del vector
     * @return angulo del vector
     */
    public Angulo angulo () {
        return null;
    }


    /**
     * Retorna la longitud del vector
     * @return 
     */
    public float longitud() {
        return 0.0f;
    }
    
    /**
     * Retorna la distancia entre este vector y otro vector
     * @return 
     */
    public float distancia(Vector otro) {
        return 0.0f;
    }
    
    /**
     * Compara este vector con otro. Serán iguales si la distancia entre ellos es menor que MAXERROR
     * @param v el vector a comparar con este
     */
    private boolean equals (Vector v) {
        return false;
    }

    /** 
     * Compara si este Vector es igual al parametro (debe ser tambien un vector)
     */
    @Override
    public boolean equals (Object o) {
            return this.equals ((Vector) o);
    }
    
    /**
     * Translada el vector, dados los desplazamientos en dx, dy
     *
     * @param dx desplazamiento en el eje x
     * @param dy desplazamiento en el eje Y
     */
    public Vector traslade (float dx, float dy) {
        return null;
    }
    
    /**
     * Calcula el producto escalar
     * @param escalar El factor de multiplicación de la distancia respecto al centro
     * @return 
     */
    public Vector productoEscalar(float escalar) {
        return null;
    }

    /**
     * Rota el vector el angulo dado, con respecto al origen. 
     * Es decir que el angulo resultante, es la suma del angulo dado con el angulo inicial del vector, 
     * y la distancia es la misma.
     */
    public Vector rote(Angulo a) {
        return null;
    }

    public  Vector  sume(Vector v){
        return null;
    }
    
    public Vector reste(Vector v){
        return null;
    }
    
    public Vector multiplique(Vector v){
        return null;
    }
    
    
    /** 
     * Retorna una cadena que describe a este vector (en coordenadas polares)
     * P(r,theta)
     */
    @Override
    public String toString () {
          String s = "";
          return s;
    }

}
