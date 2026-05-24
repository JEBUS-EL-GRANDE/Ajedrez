package jajedres;
public class constantes {
     //tipos que pueden tener una casilla
    public final int CASILLA_VACIA = 10;
    //blancas
    public final int wPEON = 1;
    public final int wCABALLO = 2;
    public final int wALFIL = 3;
    public final int wTORRE = 4;
    public final int wREINA = 5;
    public final int wREY = 6;
    //negras
    public final int bPEON = -1;
    public final int bCABALLO = -2;
    public final int bALFIL = -3;
    public final int bTORRE = -4;
    public final int bREINA = -5;
    public final int bREY = -6;
    //turno de juego
    public final int PC = 11;
    public final int HUMANO = 12;
    public constantes()
    {
    }
    public String getPiezaNombre(int tipo){
        switch(tipo){
            case 1:
                return "Peon Blanco";
            case -1:
                return "Peon Negro";
            case 2:
                return "Caballo Blanco";
            case -2:
                return "Caballo Negro";
            case 3:
                return "Alfil Blanco";
            case -3:
                return "Alfil Negro";
            case 4:
                return "Torre Blanco";
            case -4:
                return "Torre Negro";
            case 5:
                return "Reina Blanco";
            case -5:
                return "Reina Negro";
            case 6:
                return "Rey Blanco";
            case -6:
                return "Rey Negro";
        }
        return "";
    }   
}