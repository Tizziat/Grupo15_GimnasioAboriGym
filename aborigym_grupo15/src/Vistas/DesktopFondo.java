/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Vistas;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

public class DesktopFondo extends JDesktopPane {

    private final Image fondo;

    public DesktopFondo() {
        this("/imagenes/fondo.jpeg");
    }
    
    public DesktopFondo(String rutaImagen) {
        java.net.URL ruta = DesktopFondo.class.getResource(rutaImagen);
        fondo = new ImageIcon(ruta).getImage();
}
     

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (fondo != null) {
            g.drawImage(fondo, 0, 0, getWidth(), getHeight(), this);
        }
    }
}

    
    

