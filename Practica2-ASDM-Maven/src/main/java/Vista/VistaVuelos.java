/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista;

/**
 *
 * @author juald
 */
public class VistaVuelos extends javax.swing.JPanel {

    /**
     * Creates new form VistaVuelos
     */
    public VistaVuelos() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        TablaVuelos = new javax.swing.JTable();
        jButtonInsertarVuelo = new javax.swing.JButton();
        jButtonEliminarVuelo = new javax.swing.JButton();
        jButtonModificarVuelo = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(440, 336));

        TablaVuelos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        TablaVuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TablaVuelos.setPreferredSize(new java.awt.Dimension(770, 330));
        jScrollPane1.setViewportView(TablaVuelos);

        jButtonInsertarVuelo.setText("Insertar Vuelo");
        jButtonInsertarVuelo.setActionCommand("InsertarVuelo");

        jButtonEliminarVuelo.setText("Eliminar Vuelo");
        jButtonEliminarVuelo.setActionCommand("EliminarVuelo");

        jButtonModificarVuelo.setText("Modificar Vuelo");
        jButtonModificarVuelo.setActionCommand("ModificarVuelo");
        jButtonModificarVuelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarVueloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonInsertarVuelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonEliminarVuelo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonModificarVuelo)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonInsertarVuelo)
                    .addComponent(jButtonEliminarVuelo)
                    .addComponent(jButtonModificarVuelo))
                .addGap(14, 14, 14))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonModificarVueloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarVueloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonModificarVueloActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TablaVuelos;
    public javax.swing.JButton jButtonEliminarVuelo;
    public javax.swing.JButton jButtonInsertarVuelo;
    public javax.swing.JButton jButtonModificarVuelo;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
