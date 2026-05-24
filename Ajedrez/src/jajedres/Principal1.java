package jajedres;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class Principal1 extends javax.swing.JFrame implements ActionListener 
{
    private pieza[][] tGui = new pieza[8][8];
    private int tLogico[][] = new int[8][8];
    private constantes c = new constantes();
    private boolean release = false;
    private int oX, oY, dX, dY;
    private int tipoO;
    private int wComidas = 0;
    private int bComidas = 0;
    private int turno = c.HUMANO;
    private heuristica heu = new heuristica();
    /***************************************************************************/
    private int jugadasBlanco = 1;
    private int jugadasNegro = 0;
    private int verificarReyes() {
    boolean reyBlanco = false;
    boolean reyNegro = false;
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
            if (tLogico[i][j] == c.wREY) {
                reyBlanco = true;
            }
            if (tLogico[i][j] == c.bREY) {
                reyNegro = true;
            }
        }
    }

    if (!reyBlanco) return c.bREY;  // Ganan las negras
    if (!reyNegro) return c.wREY;  // Ganan las blancas
    return 0; // Ambos reyes están presentes
}
///////////////////////////////////////
    
    public Principal1() {
        initComponents();
        this.setLocationRelativeTo(null);
        makeTablero();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnl_tablero = new javax.swing.JPanel();
        lbl_turno = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txta_bitacora = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        pnl_tablero.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout pnl_tableroLayout = new javax.swing.GroupLayout(pnl_tablero);
        pnl_tablero.setLayout(pnl_tableroLayout);
        pnl_tableroLayout.setHorizontalGroup(
            pnl_tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 404, Short.MAX_VALUE)
        );
        pnl_tableroLayout.setVerticalGroup(
            pnl_tableroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 399, Short.MAX_VALUE)
        );

        lbl_turno.setText("jLabel1");

        txta_bitacora.setColumns(20);
        txta_bitacora.setRows(5);
        jScrollPane1.setViewportView(txta_bitacora);

        jButton1.setText("Nuevo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnl_tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbl_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(0, 100, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbl_turno, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addComponent(pnl_tablero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnl_tablero.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        IniciarTableros();
        txta_bitacora.setText("");
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
     
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                new Principal1().setVisible(true);
            }
        });
}
     private void makeTablero() {
        pieza temp;
        for (int j = 0; j < 8; j++) {
            for (int i = 0; i < 8; i++) {
                temp = new pieza();
                temp.setXpos(i * 50);
                temp.setYpos(j * 50);
                temp.setXposT(j);
                temp.setYposT(i);
                if ((i + j) % 2 == 0) {
                    temp.setColor(Color.RED);
                } else {
                    temp.setColor(Color.BLACK);
                }
               temp.addActionListener(this);
                temp.setValues();
                tGui[j][i] = temp;
                this.pnl_tablero.add(tGui[j][i]);
            }
        }
      IniciarTableros();
    }
     
    public void IniciarTableros(){
        int j;
        int i;
        /************************************************************************/
        jugadasBlanco = 1;
        jugadasNegro = 0;
        //tablero logico inicial
        //piezas negras
        tLogico[0][0] = c.bTORRE;
        tLogico[0][1] = c.bCABALLO;
        tLogico[0][2] = c.bALFIL;
        tLogico[0][3] = c.bREINA;
        tLogico[0][4] = c.bREY;
        tLogico[0][5] = c.bALFIL;
        tLogico[0][6] = c.bCABALLO;
        tLogico[0][7] = c.bTORRE;
        
         tGui[0][0].setTipo(c.bTORRE);
        tGui[0][1].setTipo(c.bCABALLO);
        tGui[0][2].setTipo(c.bALFIL);
        tGui[0][3].setTipo(c.bREINA);
        tGui[0][4].setTipo(c.bREY);
        tGui[0][5].setTipo(c.bALFIL);
        tGui[0][6].setTipo(c.bCABALLO);
        tGui[0][7].setTipo(c.bTORRE);

        for (i = 0; i < 8; i++) {
            tLogico[1][i] = c.bPEON;
            tGui[1][i].setTipo(c.bPEON);
        }

        //casillas vacias
        for (j = 2; j < 6; j++) {
            for (i = 0; i < 8; i++) {
                tLogico[j][i] = c.CASILLA_VACIA;
                tGui[j][i].setTipo(c.CASILLA_VACIA);
            }
        }
        //piezas balncas
        tLogico[7][0] = c.wTORRE;
        tLogico[7][1] = c.wCABALLO;
        tLogico[7][2] = c.wALFIL;
        tLogico[7][3] = c.wREINA;
        tLogico[7][4] = c.wREY;
        tLogico[7][5] = c.wALFIL;
        tLogico[7][6] = c.wCABALLO;
        tLogico[7][7] = c.wTORRE;

        tGui[7][0].setTipo(c.wTORRE);
        tGui[7][1].setTipo(c.wCABALLO);
        tGui[7][2].setTipo(c.wALFIL);
        tGui[7][3].setTipo(c.wREINA);
        tGui[7][4].setTipo(c.wREY);
        tGui[7][5].setTipo(c.wALFIL);
        tGui[7][6].setTipo(c.wCABALLO);
        tGui[7][7].setTipo(c.wTORRE);

        for (i = 0; i < 8; i++) {
            tLogico[6][i] = c.wPEON;
            tGui[6][i].setTipo(c.wPEON);
        }

        //Coloco el turno al humano
        this.lbl_turno.setText("BLANCAS - Humano: ROJAS - PC");
        this.turno = c.HUMANO;
        setLog("Turno: BLANCAS - Humano(jugadas: 1)");
        
        
        repaintPiezas(tLogico);
    }
       private void paintPieza(int x, int y, int tipo) {

        if (tipo != c.CASILLA_VACIA) {
            ImageIcon icon = null;
           //  System.out.println("TIPO: " + tipo + ", X:" + x + ", Y:" + y);
            icon = new ImageIcon(this.getClass().getResource("/Imagenes/" + tipo + ".gif"));
            tGui[x][y].setBackground(null);
            tGui[x][y].setIcon(icon);
            tGui[x][y].setTipo(tipo);
        } else {
            tGui[x][y].setIcon(null);
            tGui[x][y].setValues();
            tGui[x][y].setTipo(tipo);
        }
    }
       
     private void repaintPiezas(int mtablero[][]) {
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (mtablero[x][y] == c.CASILLA_VACIA) {
                    paintPieza(x, y, c.CASILLA_VACIA);
                } else {
                    paintPieza(x, y, mtablero[x][y]);
                }
            }
        }
    }
     
      private void paintPiezaComida(int tipo, int turno) {
        int x = 0;
        int y = 0;

        if (turno == c.HUMANO) {
            y = 100;
            x = wComidas * 50;
        } else {
            x = bComidas * 50;
        }

        if (turno == c.HUMANO && wComidas == 7) {
            wComidas = 0;
            x = 0;
            y = 150;
        }

        if (turno == c.PC && bComidas == 7) {
            bComidas = 0;
            x = 0;
            y = 50;
        }

        ImageIcon icon = null;
        icon = new ImageIcon(this.getClass().getResource("/imagenes/" + tipo + ".gif"));
        JButton comida = new JButton();
        comida.setIcon(icon);
        comida.setBounds(x, y, 50, 50);
        System.out.println("X: " + x + ", Y: " + y);
    //    pnl_comidasBlancas.add(comida);
      //  pnl_comidasBlancas.repaint();

        if (turno == c.HUMANO) {
            wComidas++;
        } else {
            bComidas++;
        }

        setLog("Pieza comida: " + c.getPiezaNombre(tipo));
        System.out.println("w: " + wComidas + ", b: " + bComidas);
    }

    public void setLog(String mensaje) {
        try {
            this.txta_bitacora.append(mensaje + System.getProperty("line.separator"));
        } catch (Exception e) {
        }
    }
    /*********************************tira PC**********************************/
    private void tiraPC() {
        minimax minmax = new minimax();
        int tCopy[][] = tLogico;
        tLogico = minmax.minimaxEval(3, tLogico);
        repaintPiezas(tLogico);
        int posiciones[] = compareTableros(tCopy, tLogico);
        if (posiciones[4] == -1000 && posiciones[5] == -1000) {
            paintPiezaComida(tCopy[posiciones[2]][posiciones[3]], turno);

        }
      // setLog(c.getPiezaNombre(tipoO) + " se mueve de X:" + oX + ", Y:" + oY
        //               + " a X:" + dX + ", Y:" + dY);
        turno = c.HUMANO;
        lbl_turno.setText("BLANCAS - Humano");
        setLog("Turno: BLANCAS - Humano (jugadas: "+jugadasBlanco++ +")");
        minmax = null;
        liberarMemoria();
    }

     private void liberarMemoria() {
        try {
            System.out.println("Inicio de limpieza de memoria");
            Runtime garbage = Runtime.getRuntime();
            System.out.println("Memoria total de JVM " + garbage.totalMemory());
            System.out.println("Memoria libre antes de liberar " + garbage.freeMemory());
            garbage.gc();
            System.out.println("Memoria libre despues de liberar " + garbage.freeMemory());
        } catch (Exception e) {
        }
    }
      private int[] compareTableros(int[][] copia, int[][] nuevo) {

        int posiciones[] = new int[6];

        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                if (copia[i][k] != nuevo[i][k]) {
                    // if (tGui[dX][dY].getTipo() >= 1 && tGui[dX][dY].getTipo() <= 6) {//comio una blanca
                    if (copia[i][k] >= 1 && copia[i][k] <= 6) {//destino era una blanca
                        posiciones[2] = i;
                        posiciones[3] = k;
                        posiciones[4] = -1000;
                    } else if (copia[i][k] >= -6 && copia[i][k] <= -1) {//inicio negra
                        posiciones[0] = i;
                        posiciones[1] = k;
                        posiciones[5] = -1000;
                    }
                }
            }
        }
        return posiciones;
    }
      
/************************************************************************************/
public void actionPerformed(ActionEvent e) {
    pieza temp = (pieza) e.getSource();
    if (!release) {
        oX = temp.getXposT();
        oY = temp.getYposT();
        tipoO = temp.getTipo();
        /***********************************************************************/
        int estadoReyes = verificarReyes();
        if (estadoReyes == c.wREY) {
            int a =jugadasBlanco -1;
            JOptionPane.showMessageDialog(null, "Rey Negro capturado. Ganan las Blancas (jugadas: "+a +")");
            setLog("Fin del juego: El Rey NEGRO fue eliminado.");
            return;
        }
        /////////////////////////////////////////////////////////////////////////
            if (turno == c.PC && (tipoO <= -1 && tipoO >= -6)) {
                release = true;
            }

            if (turno == c.HUMANO && (tipoO >= 1 && tipoO <= 6)) {
                release = true;
            }
        } else {
            dX = temp.getXposT();
            dY = temp.getYposT();
            
            if (heu.getValidacionPieza(oX, oY, dX, dY, tLogico, tipoO)) 
            { //revisa si el movimiento es valido
                //si me comi ua pieza la coloco en la parte de comidas
                //De una cambio de turno
                if (turno == c.HUMANO) 
                {
                    if (tGui[dX][dY].getTipo() <= -1 && tGui[dX][dY].getTipo() >= -6) {//comio una negra
                        paintPiezaComida(temp.getTipo(), turno);
                    }
                    turno = c.PC;
                    lbl_turno.setText("ROJAS - PC");

                } else {
                    if (tGui[dX][dY].getTipo() >= 1 && tGui[dX][dY].getTipo() <= 6) {//comio una blanca
                        paintPiezaComida(temp.getTipo(), turno);
                    }
                    turno = c.HUMANO;
                    lbl_turno.setText("BLANCAS - Humano");
                }


                tLogico[oX][oY] = c.CASILLA_VACIA;
                tLogico[dX][dY] = tipoO;
                paintPieza(oX, oY, c.CASILLA_VACIA);
                paintPieza(dX, dY, tipoO);
            // TORRE EN ENROQUE*************************************************
            if (tipoO == c.wREY && oX == 7 && oY == 4) { // Enroque blanco
                if (dY == 6) { // Enroque corto
                    tLogico[7][7] = c.CASILLA_VACIA;
                    tLogico[7][5] = c.wTORRE;
                    paintPieza(7, 7, c.CASILLA_VACIA);
                    paintPieza(7, 5, c.wTORRE);
                } else if (dY == 2) { // Enroque largo
                    tLogico[7][0] = c.CASILLA_VACIA;
                    tLogico[7][3] = c.wTORRE;
                    paintPieza(7, 0, c.CASILLA_VACIA);
                    paintPieza(7, 3, c.wTORRE);
                }
            } 
            ////////////////////////////////////////////////////////////////////
                setLog(c.getPiezaNombre(tipoO) + " se mueve de X:" + oX + ", Y:" + oY
                        + " a X:" + dX + ", Y:" + dY);
                if (turno == c.HUMANO) {
                    setLog("Turno: BLANCAS - Humano");
                } else {
                    jugadasNegro++;/*******************************************/
                    setLog("Turno: ROJAS - PC (jugadas:"+jugadasNegro+")");
                    tiraPC();
                }
                //comprueba si se esta en jaque
                int jaque = heu.isJaque(tipoO, turno);
                if (jaque == c.HUMANO) {
                    JOptionPane.showMessageDialog(null, "Jaque a Blancas");
                    setLog("Fin del juego: El Rey BLANCO fue eliminado.");
                    setLog("Jaque a Blancas");
                    //heu.isJaqueMate(c.HUMANO);//********************************
                    jugadasNegro++;
                    JOptionPane.showMessageDialog(null, "Jaque mate. Negras ganan cantidada de jugadas " +
                            (turno == c.HUMANO ? jugadasNegro : jugadasBlanco));
                    
                } else if (jaque == c.PC) {
                    JOptionPane.showMessageDialog(null, "Jaque a ROJAS");
                    setLog("Jaque a ROJAS");
                    //heu.isJaqueMate(c.PC);//************************************
                    
                }
            }else{
                 JOptionPane.showMessageDialog(null, "Movimiento invalido...");
            }
            release = false;
        }
    }        
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_turno;
    private javax.swing.JPanel pnl_tablero;
    private javax.swing.JTextArea txta_bitacora;
    // End of variables declaration//GEN-END:variables

}
/*int estadoReyes = verificarReyes();
if (estadoReyes == c.bREY) {
    JOptionPane.showMessageDialog(null, "El Rey Blanco ha sido capturado. ¡Ganan las Negras!");
    setLog("Fin del juego: El Rey Blanco fue eliminado.");
    // juegoTerminado = true;
    return;
} else if (estadoReyes == c.wREY) {
    JOptionPane.showMessageDialog(null, "El Rey Negro ha sido capturado. ¡Ganan las Blancas!");
    setLog("Fin del juego: El Rey Negro fue eliminado.");
    // juegoTerminado = true;
    return;
}
*/


/*else if (tipoO == c.bREY && oX == 0 && oY == 4) { // Enroque negro
    if (dY == 6) { // Enroque corto
        tLogico[0][7] = c.CASILLA_VACIA;
        tLogico[0][5] = c.bTORRE;
        paintPieza(0, 7, c.CASILLA_VACIA);
        paintPieza(0, 5, c.bTORRE);
    } else if (dY == 2) { // Enroque largo
        tLogico[0][0] = c.CASILLA_VACIA;
        tLogico[0][3] = c.bTORRE;
        paintPieza(0, 0, c.CASILLA_VACIA);
        paintPieza(0, 3, c.bTORRE);
    }
}*/