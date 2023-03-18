
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class Person {
    private static final String[] nombres = {"Andy", "Woody", "Buzz", "Motorolo", "Sandalio", "Masiosare", "Lupe", "Aylen Tejas", "Miguel Hidalgo y Costilla", "Agripino"};
    private static final List<String> nombresAleatorios = new ArrayList<String>();

    static {
        for (String nombre : nombres) {
            nombresAleatorios.add(nombre);
        }
        Collections.shuffle(nombresAleatorios, new Random());
    }

    private String nombre;
    protected static boolean bizco;
	protected static boolean pelon;
	protected static boolean brazos;
	protected static boolean fuerte;
	protected static boolean Feo;
	protected boolean estaCansado;
    protected boolean estaEnfermo;
    protected boolean estaTriste;
    protected boolean estaFeliz;

    public Person() {
        this.nombre = nombresAleatorios.remove(0);
        this.bizco = new Random().nextBoolean();
        this.pelon = new Random().nextBoolean();
        this.brazos = new Random().nextBoolean();
        this.fuerte = new Random().nextBoolean();
        this.Feo = new Random().nextBoolean();
        this.estaCansado = new Random().nextBoolean();
        this.estaEnfermo = new Random().nextBoolean();
        this.estaTriste = new Random().nextBoolean();
    }
    
    public String getNombre() {
        return nombre;
    }

    public boolean getbizco() {
        return bizco;
    }

    public boolean getpelon() {
        return pelon;
    }
    public boolean getbrazos() {
        return brazos;
    }
    public boolean getEstaFeo() {
        return Feo;
    }

    public boolean getfuerte() {
        return fuerte;
    }

    public boolean getEstaEnfermo() {
        return estaEnfermo;
    }

    public boolean getEstaTriste() {
        return estaTriste;
    }

    public boolean getEstaFeliz() {
        return estaFeliz;
    }
    
    public boolean getEstaCansado() {
        return estaCansado;
    }


}