package jajedres;
import java.awt.Color; 
import java.awt.Image; 
public class pieza  extends javax.swing.JButton {
     private int tipo;
    private int xpos;
    private int ypos;
    private int ocupa;
    private Color color;
    private Image imagen;
    private int xposT;
    private int yposT;
    public Image getImagen() {
        return imagen;
    }
    public int getXposT() {
        return xposT;
    }
    public void setXposT(int xposT) {
        this.xposT = xposT;
    }
    public int getYposT() {
        return yposT;
    }
    public void setYposT(int yposT) {
        this.yposT = yposT;
    }
    public void setImagen(Image imagen) {
        this.imagen = imagen;
    }
    public pieza() {
    }
    public void setValues(){
        this.setBackground(getColor());
        this.setBounds(getXpos(), getYpos(), 50, 50);
    }
    public int getOcupa() {
        return ocupa;
    }
    public void setOcupa(int ocupa) {
        this.ocupa = ocupa;
    }
    public int getTipo() {
        return tipo;
    }
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
    public int getXpos() {
        return xpos;
    }
    public void setXpos(int xpos) {
        this.xpos = xpos;
    }
    public int getYpos() {
        return ypos;
    }
    public void setYpos(int ypos) {
        this.ypos = ypos;
    }
    public Color getColor() {
        return color;
    }
    public void setColor(Color color) {
        this.color = color;
    }
}