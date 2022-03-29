/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package claseprimitivasgraficas;

import Modelos.Circulo;
import Modelos.Cuadrado;
import Modelos.FiguraGeometrica;
import Modelos.Imagen;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.LinkedList;

/**
 *
 * @author pipet
 */
public class Lienzo extends javax.swing.JPanel {
    private LinkedList<FiguraGeometrica> figuras;
    /**
     * Creates new form Lienzo
     */
    public Lienzo() {
        initComponents();
        this.figuras=new LinkedList<>();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        dibujarFiguras(g);
    }
    public void dibujarFiguras(Graphics g){
        for(FiguraGeometrica estaFigura:this.figuras){
            if(estaFigura instanceof Cuadrado){
                dibujarCuadrado(g, (Cuadrado)estaFigura);
            }else if(estaFigura instanceof Circulo){
                dibujarCirculo(g, (Circulo)estaFigura);
            }else if(estaFigura instanceof Imagen){
                dibujarImagen(g, (Imagen)estaFigura);
            }
        }
    }
    public void dibujarCuadrado(Graphics g, Cuadrado square){
        g.setColor(square.getColorRelleno());
        g.fillRect(square.getX(), square.getY(), square.getLado(), square.getLado());
        g.setColor(square.getBorde());
        g.drawRect(square.getX(), square.getY(), square.getLado(), square.getLado());
    }
    public void dibujarCirculo(Graphics g, Circulo elCirculo){
        g.setColor(elCirculo.getColorRelleno());
        g.fillOval(elCirculo.getX(), elCirculo.getY(), elCirculo.getRadio(), elCirculo.getRadio());
        g.setColor(elCirculo.getBorde());
        g.drawOval(elCirculo.getX(), elCirculo.getY(), elCirculo.getRadio(), elCirculo.getRadio());
    }
    public void dibujarImagen(Graphics g, Imagen laImagen){
        Toolkit t = Toolkit.getDefaultToolkit();
        Image imagen = t.getImage(laImagen.getRuta());
        g.drawImage(imagen, laImagen.getX(), laImagen.getY(), laImagen.getAncho(), laImagen.getAlto(), this);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @return the figuras
     */
    public LinkedList<FiguraGeometrica> getFiguras() {
        return figuras;
    }

    /**
     * @param figuras the figuras to set
     */
    public void setFiguras(LinkedList<FiguraGeometrica> figuras) {
        this.figuras = figuras;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
