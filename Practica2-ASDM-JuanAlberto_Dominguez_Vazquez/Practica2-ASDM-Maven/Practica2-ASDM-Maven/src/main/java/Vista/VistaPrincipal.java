/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

/**
 *
 * @author juald
 */
public class VistaPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form VistaPrincipal
     */
    public VistaPrincipal() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        Vuelos = new javax.swing.JMenu();
        GestionVuelos = new javax.swing.JMenuItem();
        Salir = new javax.swing.JMenu();
        salirDeLaAplicacion = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Vuelos.setText("Vuelos");

        GestionVuelos.setText("Gestión Vuelos");
        GestionVuelos.setActionCommand("GestionVuelos");
        GestionVuelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GestionVuelosActionPerformed(evt);
            }
        });
        Vuelos.add(GestionVuelos);

        jMenuBar1.add(Vuelos);

        Salir.setText("Salir");

        salirDeLaAplicacion.setText("Salir de la aplicación");
        Salir.add(salirDeLaAplicacion);

        jMenuBar1.add(Salir);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 313, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GestionVuelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GestionVuelosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GestionVuelosActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JMenuItem GestionVuelos;
    public javax.swing.JMenu Salir;
    public javax.swing.JMenu Vuelos;
    public javax.swing.JMenuBar jMenuBar1;
    public javax.swing.JMenuItem salirDeLaAplicacion;
    // End of variables declaration//GEN-END:variables
}