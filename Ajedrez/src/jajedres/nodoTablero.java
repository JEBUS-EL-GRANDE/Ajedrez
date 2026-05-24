package jajedres;
import java.util.LinkedList;
public class nodoTablero {
   public int[][] posicionPiezas = new int[8][8];
    public nodoTablero padre;
    public nodoTablero[] movimientos;
    public LinkedList<nodoTablero> hijos;
    private int funcionUtilidad;
    public boolean turno;
    public heuristica heu;
    public boolean esTerminal;//true si es hoja

    public nodoTablero(){
        heu = heuristica.getHeuristica();//new heuristica();
        hijos = new LinkedList<nodoTablero>();
        inicializarTablero();
        padre = null;
        esTerminal = false;
        turno = false;
    }

    public int[][] getPosicionPiezas() {
        return posicionPiezas;
    }

    public void setPosicionPiezas(int[][] posicionPiezas) {
        this.posicionPiezas = posicionPiezas;
    }

    public void setTurno(boolean turno){
        this.turno = turno;
    }

    public boolean getTurno(){
        return turno;
    }

    public void setFuncionUtilidad(int func){
        funcionUtilidad = func;
    }
    public int getFuncionUtilidad(){
        int negras = heu.funcionEvaluacion(this, turno);
        if(turno == true)
            turno = false;
        else
            turno = true;
        int blancas = heu.funcionEvaluacion(this, turno);
        if(turno == true)
            turno = false;
        else
            turno = true;
        funcionUtilidad = negras - blancas;
        return funcionUtilidad;
    }

    public nodoTablero[] getMovimientos(){
        return movimientos;
    }

    public void setEstadoTerminal(boolean estado){
        esTerminal = estado;
    }

    public boolean getEstadoTerminal(){
        return esTerminal;
    }

    private void inicializarTablero()
    {
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                posicionPiezas[i][j] = 0;
            }
        }
    }

    public void setPieza(int posX, int posY, int pieza){
        posicionPiezas[posX][posY] = pieza;
    }

    public int getPieza(int posX, int posY){
        return posicionPiezas[posX][posY];
    }

    public int getFreeSpaces() {

        int free_spaces = 0;
        int tablero[][] = this.posicionPiezas;

        for(int x = 0; x < 8; x++)
        {
            for(int y = 0; y < 8; y++)
            {
                if(tablero[x][y] == 0)
                {
                    free_spaces++;
                }
            }
        }

        return free_spaces;
    }

    private void establecerTurno(nodoTablero nodo){
        if(turno == true)//humano
            nodo.setTurno(false);
        else//pc
            nodo.setTurno(true);
    }

    public void generarHijos(){
        if(turno == true){
            for(int i = 0; i < 8;i++){
                for(int j = 0; j < 8; j++){
                    switch(posicionPiezas[i][j]){
                        case 1:
                            calcularMovPeon(i, j, 1);
                            break;
                        case 2:
                            calcularMovCaballo(i, j, 2);
                            break;
                        case 3:
                            calcularMovAlfil(i, j, 3);
                            break;
                        case 4:
                            calcularMovTorre(i, j, 4);
                            break;
                        case 5:
                            calcularMovReina(i, j, 5);
                            break;
                        case 6:
                            calcularMovRey(i, j, 6);
                    }
                }
            }
        }
        else{
            for(int i = 0; i < 8;i++){
                for(int j = 0; j < 8; j++){
                    switch(posicionPiezas[i][j]){
                        case -1:
                            calcularMovPeon(i, j, -1);
                            break;
                        case -2:
                            calcularMovCaballo(i, j, -2);
                            break;
                        case -3:
                            calcularMovAlfil(i, j, -3);
                            break;
                        case -4:
                            calcularMovTorre(i, j, -4);
                            break;
                        case -5:
                            calcularMovReina(i, j, -5);
                            break;
                        case -6:
                            calcularMovRey(i, j, -6);
                    }
                }
            }
        }
    }

    private void calcularMovPeon(int i, int j, int pieza){
        if(((i + 1) < 8) && ((j + 1) < 8))
        {
            //movimiento abajo derecha
            if(heu.getValidacionPieza(i, j, i + 1, j + 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i][j] = 10;
                Ttablero[i + 1][j + 1] = pieza;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        if(((i + 1) < 8) && ((j - 1) >= 0))
        {
            //movimiento abajo izquierda
            if(heu.getValidacionPieza(i, j, i + 1, j - 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i][j] = 10;
                Ttablero[i + 1][j - 1] = pieza;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        if(((i + 1) < 8))
        {
            //movimiento abajo
            if(heu.getValidacionPieza(i, j, i + 1, j, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i][j] = 10;
                Ttablero[i + 1][j] = pieza;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        if(((i - 1) >= 0) && ((j - 1) >= 0))
        {
            //movimiento arriba izquierda
            if(heu.getValidacionPieza(i, j, i - 1, j - 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i][j] = 10;
                Ttablero[i - 1][j - 1] = pieza;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        if(((i - 1) >= 0) && ((j + 1) < 8))
        {
            //movimiento arriba derecha
            if(heu.getValidacionPieza(i, j, i - 1, j + 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i][j] = 10;
                Ttablero[i - 1][j + 1] = pieza;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        if(((i - 1) >= 0))
        {
            //movimiento arriba
            if(heu.getValidacionPieza(i, j, i - 1, j, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i][j] = 10;
                Ttablero[i - 1][j] = pieza;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
    }

    private void calcularMovTorre(int i, int j, int pieza){
        for(int x = (i + 1); x < 8; x++)
        {
            if(heu.getValidacionPieza(i, j, x, j, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[x][j] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        for(int x = (i - 1); x >= 0; x--)
        {
            if(heu.getValidacionPieza(i, j, x, j, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[x][j] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        for(int y = (j + 1); y < 8; y++)
        {
            if(heu.getValidacionPieza(i, j, i, y, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i][y] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        for(int y = (j - 1); y >= 0; y--)
        {
            if(heu.getValidacionPieza(i, j, i, y, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i][y] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
    }

    private void calcularMovAlfil(int i, int j, int pieza){
        for(int x = (i + 1), y = (j + 1); x < 8 && y < 8; x++, y++)
        {
            if(heu.getValidacionPieza(i, j, x, y, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[x][y] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        for(int x = (i - 1), y = (j - 1); x >= 0 && y >= 0; x--, y--)
        {
            if(heu.getValidacionPieza(i, j, x, y, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[x][y] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        for(int x = (i + 1), y = (j - 1); x < 8 && y >= 0; x++, y--)
        {
            if(heu.getValidacionPieza(i, j, x, y, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[x][y] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        for(int x = (i - 1), y = (j + 1); x >= 0 && y < 8; x--, y++)
        {
            if(heu.getValidacionPieza(i, j, x, y, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[x][y] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
    }

    private void calcularMovCaballo(int i, int j, int pieza){
        if(((j + 2) < 8) &&((i + 1) < 8))
        {
            if(heu.getValidacionPieza(i, j, i + 1, j + 2, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i + 1][j + 2] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        if(((j + 2) < 8) &&((i - 1) >= 0))
        {
            if(heu.getValidacionPieza(i, j, i - 1, j + 2, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i - 1][j + 2] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        if(((i + 2) < 8) && ((j + 1) < 8))
        {
            if(heu.getValidacionPieza(i, j, i + 2, j + 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i + 2][j + 1] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        if(((i - 2) >= 0) && ((j + 1) < 8))
        {
            if(heu.getValidacionPieza(i, j, i - 2, j + 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i - 2][j + 1] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        if(((i - 2) >= 0) && ((j - 1) >= 0))
        {
            if(heu.getValidacionPieza(i, j, i - 2, j - 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i - 2][j - 1] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        if(((i + 1) < 8) && ((j - 2) >= 0))
        {
            if(heu.getValidacionPieza(i, j, i + 1, j - 2, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i + 1][j - 2] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        if(((i + 2) < 8) && ((j - 1) >= 0))
        {
            if(heu.getValidacionPieza(i, j, i + 2, j - 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i + 2][j - 1] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        if(((i - 1) >= 0) && ((j - 2) >= 0))
        {
            if(heu.getValidacionPieza(i, j, i - 1, j - 2, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i - 1][j - 2] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
    }

    private void calcularMovReina(int i, int j, int pieza){
        for(int x = (i + 1); x < 8; x++)
        {
            if(heu.getValidacionPieza(i, j, x, j, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[x][j] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        for(int x = (i - 1); x >= 0; x--)
        {
            if(heu.getValidacionPieza(i, j, x, j, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[x][j] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        for(int y = (j + 1); y < 8; y++)
        {
            if(heu.getValidacionPieza(i, j, i, y, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i][y] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        for(int y = (j - 1); y >= 0; y--)
        {
            if(heu.getValidacionPieza(i, j, i, y, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i][y] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        for(int x = (i + 1), y = (j + 1); x < 8 && y < 8; x++, y++)
        {
            if(heu.getValidacionPieza(i, j, x, y, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[x][y] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        for(int x = (i - 1), y = (j - 1); x >= 0 && y >= 0; x--, y--)
        {
            if(heu.getValidacionPieza(i, j, x, y, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[x][y] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        for(int x = (i + 1), y = (j - 1); x < 8 && y >= 0; x++, y--)
        {
            if(heu.getValidacionPieza(i, j, x, y, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[x][y] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        for(int x = (i - 1), y = (j + 1); x >= 0 && y < 8; x--, y++)
        {
            if(heu.getValidacionPieza(i, j, x, y, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[x][y] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
    }

    private void calcularMovRey(int i, int j, int pieza){
        //abajo
        if((i + 1) < 8)
        {
            if(heu.getValidacionPieza(i, j, i + 1, j, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i + 1][j] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        //abajo izquierda
        if(((i + 1) < 8) && ((j - 1) >= 0))
        {
            if(heu.getValidacionPieza(i, j, i + 1, j - 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i + 1][j - 1] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        //izquierda
        if((j - 1) >= 0)
        {
            if(heu.getValidacionPieza(i, j, i, j - 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i][j - 1] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        //arriba izquierda
        if(((i - 1) >= 0) && ((j - 1) >= 0))
        {
            if(heu.getValidacionPieza(i, j, i - 1, j - 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i - 1][j - 1] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        //arriba
        if((i - 1) >= 0)
        {
            if(heu.getValidacionPieza(i, j, i - 1, j, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i - 1][j] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        //arriba derecha
        if(((i - 1) >= 0) && ((j + 1) < 8))
        {
            if(heu.getValidacionPieza(i, j, i - 1, j + 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i - 1][j + 1] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        //derecha
        if((j + 1) < 8)
        {
            if(heu.getValidacionPieza(i, j, i, j + 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i][j + 1] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
        //abajo derecha
        if(((i + 1) < 8) && ((j + 1) < 8))
        {
            if(heu.getValidacionPieza(i, j, i + 1, j + 1, posicionPiezas, pieza))
            {
                int Ttablero[][] = new int[8][8];
                copy_data(posicionPiezas,Ttablero);
                Ttablero[i + 1][j + 1] = pieza;
                Ttablero[i][j] = 10;
                nodoTablero nodo = new nodoTablero();
                establecerTurno(nodo);
                nodo.posicionPiezas = Ttablero;
                hijos.add(nodo);
            }
        }
    }
    public void copy_data(int[][] source, int[][] destiny)
    {
        for(int i = 0; i < source.length; i++)
        {
            for(int j = 0; j < source.length; j++)
            {
                destiny[i][j] = source[i][j];
            }
        }
    }
    public int getEvaluacion() {
        return getFuncionUtilidad();
    }   
}