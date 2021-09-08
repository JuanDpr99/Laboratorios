/**
 * Esta clase sirve para manejar angulos. 
 * La medida de los ángulos podrá especificarse en grados, radianes, o gradianes 
 * y podrá solicitarse en cualquiera de estas unidades, independientemente de con cual hayan sido creados.
 * Internamente se harán las conversiones que sean necesarias.
 * Lo trabajaremos mediante objetos inmutables, es decir, sin métodos modificadores. 
 * @author ECI, 
 */
public class Angulo {

    /** Constantes para indicar que el argumento está en radianes */
    public static final int RADIANES = 0;
    /** Constantes para indicar que el argumento está en grados */
    public static final int GRADOS = 1;
    /** Constantes para indicar que el argumento está en gradianes */
    public static final int GRADIANES = 2;

    /** Constante para maximo error admitido al comparar dos angulos.  
     *  Recuerde que los cálculos en el computador con variables de plunto flotante
     *  tienen una precisión limitada, y se requiere un margen de tolerancia
     */
    public static final double MAXERROR = 0.00000000000001;
    public static final double PI = Math.PI;
    private double valor ;
    private int tipo;

    /** Crea un angulo a partir del valor dado en grados o en radianes
     * @param valor el valor de medida del angulo
     * @param tipo Tipo de medida del angulo: puede ser GRADOS, RADIANES, GRADIANES
     */
    public Angulo (double _valor, int _tipo)
    {
        this.valor = _valor;
        this.tipo = _tipo;
    }
    
    /**Valor del angulo en grados
     * @return el valor del angulo en grados, 0 <= result < 360
     */
    public  double grados ()
    {
        double ret = 0.0;
        if(this.valor < 0)  // en caso de ser negativo
            this.valor = 360 - (this.valor * -1);
        if( this.tipo == 0) // radianes 
        {              
            double result = this.valor * (180 / Math.PI); // convierte de redianes a grados
            if(0 <= result && result  < 360)
                ret =  result;
        }
        else if(this.tipo == 1) // grados 
        {
            double result = this.valor;
            if(0 <= result && result  < 360)
                ret =  result;
        }
        else if(this.tipo == 2) // gradianes 
        {  // convierte de gradianes a grados
            double result =  this.valor * 0.9;
            if(0 <= result && result  < 360)
                ret =  result;
        }
        return ret ;
    }
    
    /**Valor del angulo en radianes
     * @return el valor del angulo en radianes, 0 <= result < 2*PI
     */
    public double radianes () 
    {
        double ret = 0.0;
        if(this.valor < 0)  // en caso de ser negativo
            this.valor = 360 - (this.valor * -1);
        if (this.tipo == 0)
        {
            // retorna radianes
            double result = this.valor;
            if (0 <= result && result < 2*Math.PI)
               ret = result;
        }
        else if (this.tipo == 1)
        {
            double result = this.valor * (PI/180);
            // Pasar de grados a radianes
            if (0 <= result && result < 2*PI)
                ret = result;
        }
        else if (this.tipo == 2)
        {
            double result = this.valor *(PI/200);
            // Pasar gradianes a radianes
            if (0 <= result && result < 2*PI)
                ret = result;
        }
        return ret;
    }
    
    /**Valor del angulo en gradianes
     * @return el valor del angulo en gradianes, 0 <= result < 400
     */
    public double gradianes () 
    {
        double ret = 0.0;
        if(this.valor < 0)  // en caso de ser negativo
            this.valor = 360 - (this.valor * -1);
        if (this.tipo == 0)
        {
            // Pasar de radianes a gradianes
            double result = this.valor*(200/PI);
            if (0 <= result && result < 400)
               ret = result;
        }
        else if (this.tipo == 1)
        {
            double result = this.valor * (200/180);
            // Pasar de grados a gradianes
            if (0 <= result && result < 400)
                ret = result;                
        }
        else if (this.tipo == 2)
        {
            double result = this.valor;
            // Retorna gradianes
            if (0 <= result && result < 400)
                ret = result;
        }
        return ret;
    }
    
    /**
     * Suma este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a sumar
     * @return this + a
     */
    public Angulo sume (Angulo ang) 
    {
        Angulo newAngulo =  null;
        if (this.tipo == ang.tipo)
        {
           double suma = this.valor + ang.valor;
           newAngulo = new Angulo(suma,this.tipo);
        }
        else
        {
            if (ang.tipo == 0 )// tipo radian
            {                
                double suma = this.valor + ang.grados();
                newAngulo = new Angulo(suma, this.tipo);
            }
        }
        return newAngulo;
    }


    /**
     * Resta este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a sumar
     * @return this - a
     */
    public Angulo reste (Angulo a) 
    {
        Angulo newAngulo;
        if (this.tipo == a.tipo)
        {
           double resta = this.valor - a.valor;
           newAngulo = new Angulo(resta, this.tipo);
        }
        else
        {
            newAngulo = null;
        }
        return newAngulo;
    }

     /**
     * Multiplica este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a multiplicar
     * @return this * a
     */
    public Angulo multiplique (Angulo ang) 
    {
        Angulo newAngulo;
        if (this.tipo == ang.tipo)
        {
           double multiplique = this.valor * ang.valor;
           newAngulo = new Angulo(multiplique, this.tipo);
        }
        else
        {
            newAngulo = null;
        }
        return newAngulo;
    }

    /**
     * Divide este angulo con otro. Retorna un nuevo angulo
     * @param a El angulo a dividir
     * @return this / a
     */
    public Angulo divida (Angulo a) 
    {
        Angulo newAngulo;
        if (this.tipo == a.tipo && a.valor > 0)
        {
           double divide = this.valor / a.valor;
           newAngulo = new Angulo(divide, this.tipo);
        }
        else
        {
            newAngulo = null;
        }
        return newAngulo;
    }
    
    
    /**
     * Multiplica esta angulo por un real
     * @param r real para hacer el producto 
     * @return r * this
     */
    public Angulo multiplique (double r) 
    {
        Angulo newAngulo ;
        double producto = this.valor * r;
        newAngulo = new Angulo(producto,this.tipo);
        return newAngulo;
    }
    
    /**
     * Compara a este angulo con otro, para ver si son iguales, 
     * teniendo en cuenta el margen de error MAXERROR, dado que se trabaja con punto flotante
     * @param a angulo para compararse
     * @return |this - _a| < MAXERROR
     */
    public boolean equals (Angulo _a) 
    {
        if(this == _a && Math.abs(this.valor - _a.valor) < MAXERROR)
            return true;
        return false;        
    }
    
    /** overrides Object.equals()
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals (Object _o)
    {
        Angulo o = (Angulo) _o;
        return equals(o) ;
    }

    /**Calcula el seno
     * @return el seno de este angulo
     */
    public double seno () {
        return 0.0;
    }

    /**Calcula el coseno
     * @return el coseno de este angulo
     */
    public double coseno () {
        return 0.0;
    }

    /**
     * Retorna el valor del angulo en grados
     * @return the information of this object
     */
    public String toString() {
      return "";
    }
}
