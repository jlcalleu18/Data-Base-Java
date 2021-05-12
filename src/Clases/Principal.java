package Clases;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Principal extends javax.swing.JFrame {
    ConexionBD con = new ConexionBD();
    Connection cn = con.conexion();
    String atributo,ad;
    
    Validar valid = new Validar();
    
    public Principal() {
        initComponents();
        mostrartabla("");
        agregarItem();
        validacion();
        bloquear();
        if (tabladatos==null) {
            modi.setEnabled(false);
        } else {
            //modi.setEnabled(true);
        }


    }
    void bloquear(){
        txtnombre.setEnabled(false);
        txtapellido.setEnabled(false);
        txtid.setEnabled(false);
        txtedad.setEnabled(false);
        txtcorreo.setEnabled(false);
        clean.setEnabled(false);
        save.setEnabled(false);
        add.setEnabled(false);
    }
    void desbloqueo(){
        txtnombre.setEnabled(true);
        txtapellido.setEnabled(true);
        txtid.setEnabled(true);
        txtedad.setEnabled(true);
        txtcorreo.setEnabled(true);
        add.setEnabled(true);
    }
        void validacion(){
        valid.ValidarSoloLetras(txtnombre);
        valid.ValidarSoloLetras(txtapellido);
        valid.ValidarSoloNumeros(txtid);
        valid.ValidarSoloNumeros(txtedad);
               
                 
        valid.Limitar(txtnombre, 30);
        valid.Limitar(txtapellido, 30);
        valid.Limitar(txtid, 10);
        valid.Limitar(txtedad, 3);
        valid.Limitar(txtcorreo, 40);
    }
    void agregarItem(){
       combo.addItem("Id");
       combo.addItem("Nombre");
       combo.addItem("Apellido");
       combo.addItem("Edad");
       combo.addItem("Correo");
    }
    
    void mostrartabla(String valor) {
        DefaultTableModel modelo = new  DefaultTableModel();
        modelo.addColumn("Id");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("Edad");
        modelo.addColumn("Correo");
        tabladatos.setModel(modelo);
        
        String sql = "";
        if (valor.equals("")) {
            sql="SELECT * FROM usuario";
        }else{
            sql="SELECT * FROM usuario WHERE "+atributo+"='"+valor+"'";
        }
        String datos[]=new String [5];
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {                
                datos[0]=rs.getString(1);
                datos[1]=rs.getString(2);
                datos[2]=rs.getString(3);
                datos[3]=rs.getString(4);
                datos[4]=rs.getString(5);
                modelo.addRow(datos);
            }
            tabladatos.setModel(modelo);
            
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void limpiar(){
        txtid.setText("");
        txtnombre.setText("");
        txtapellido.setText("");
        txtedad.setText("");
        txtcorreo.setText("");
        buscar.setText("");
        
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtid = new javax.swing.JTextField();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtedad = new javax.swing.JTextField();
        txtcorreo = new javax.swing.JTextField();
        add = new javax.swing.JButton();
        clean = new javax.swing.JButton();
        save = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        combo = new javax.swing.JComboBox<>();
        buscar = new javax.swing.JTextField();
        busc = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        modi = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabladatos = new javax.swing.JTable();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        nuevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nuevo Registro", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jPanel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel12.setOpaque(false);

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Id: ");

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Nombre: ");

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Apellido: ");

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Edad: ");

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Correo: ");

        txtid.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtnombre.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtapellido.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtedad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        txtcorreo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24)
                    .addComponent(jLabel26)
                    .addComponent(jLabel22)
                    .addComponent(jLabel25))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtedad, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtid)
                    .addComponent(txtapellido))
                .addGap(33, 33, 33))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel24))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtedad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25))
                .addGap(18, 18, 18)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(txtcorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosJorge/Iconos/Agregar.png"))); // NOI18N
        add.setText("Agregar");
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });

        clean.setBackground(new java.awt.Color(204, 204, 204));
        clean.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosJorge/Iconos/cambio-de-cepillo-de-escoba-de-barrer-claro-icono-5768-16.png"))); // NOI18N
        clean.setText("Limpiar");
        clean.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cleanActionPerformed(evt);
            }
        });

        save.setBackground(new java.awt.Color(204, 204, 204));
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosJorge/Iconos/Guardar.png"))); // NOI18N
        save.setText("Guardar Cambios");
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });

        combo.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        combo.setOpaque(false);

        buscar.setFont(new java.awt.Font("Times New Roman", 2, 14)); // NOI18N

        busc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        busc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosJorge/Iconos/Buscar.png"))); // NOI18N
        busc.setText("Buscar");
        busc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buscActionPerformed(evt);
            }
        });

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosJorge/Iconos/Eliminar.png"))); // NOI18N
        jButton4.setText("Eliminar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        modi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        modi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosJorge/Iconos/editar-usuario-icono-9786-16.png"))); // NOI18N
        modi.setText("Modificar");
        modi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modiActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosJorge/Iconos/Añadir.png"))); // NOI18N
        jButton5.setText("Mostrar");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        tabladatos.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        tabladatos.setFont(new java.awt.Font("Tahoma", 2, 12)); // NOI18N
        tabladatos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabladatos.setOpaque(false);
        jScrollPane1.setViewportView(tabladatos);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(busc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 143, Short.MAX_VALUE)
                .addComponent(modi, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(109, 109, 109)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(busc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(combo, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE))
        );

        nuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosJorge/nuevo.png"))); // NOI18N
        nuevo.setText("Nuevo");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IconosJorge/link-registrarse.png"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(224, 224, 224))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(jSeparator3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(save)
                            .addComponent(clean, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nuevo))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(nuevo)
                        .addGap(28, 28, 28)
                        .addComponent(add, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clean, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(save, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed

        try {
             if (txtid.getText().equals("") || txtnombre.getText().equals("") || txtapellido.getText().equals("") || txtedad.getText().equals("") || txtcorreo.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Para guardar los datos llene todos los parametros"); 

             } else {
               
                PreparedStatement pps = cn.prepareStatement("INSERT INTO usuario (Id,Nombre,Apellido,Edad,Correo) VALUES(?,?,?,?,?)");
                pps.setString(1, txtid.getText());
                pps.setString(2, txtnombre.getText());
                pps.setString(3, txtapellido.getText());
                pps.setString(4, txtedad.getText());
                pps.setString(5, txtcorreo.getText());
                pps.executeUpdate();
                mostrartabla("");
                JOptionPane.showMessageDialog(null, "Datos Guardados");
                limpiar();
            bloquear();

            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_addActionPerformed

    private void cleanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cleanActionPerformed
        limpiar();bloquear();
    }//GEN-LAST:event_cleanActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed

        try {
            PreparedStatement pps = cn.prepareStatement("UPDATE usuario SET Id='"+txtid.getText()+"',Nombre='"+txtnombre.getText()+"',Apellido='"
                +txtapellido.getText()+"',Edad='"+txtedad.getText()+"',Correo='"+txtcorreo.getText()+"' WHERE Id='"+buscar.getText()+"'");
            pps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Datos Actualizados");
            limpiar();
            mostrartabla("");
            bloquear();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_saveActionPerformed

    private void buscActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buscActionPerformed
        atributo=combo.getSelectedItem().toString();
        mostrartabla(buscar.getText());
    }//GEN-LAST:event_buscActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int fila = tabladatos.getSelectedRow();
        
        if (fila>=0) {
            String valor = tabladatos.getValueAt(fila, 0).toString();
            try {
                PreparedStatement pps = cn.prepareStatement("DELETE FROM usuario WHERE Id='"+valor+"'");
                pps.executeUpdate();
                mostrartabla("");
                JOptionPane.showMessageDialog(null, "Dato Eliminado");

            } catch (SQLException ex) {
                Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
           
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void modiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modiActionPerformed
        int fila = tabladatos.getSelectedRow();

        if (fila>=0) {
            buscar.setText(tabladatos.getValueAt(fila, 0).toString());
            txtid.setText(tabladatos.getValueAt(fila, 0).toString());
            txtnombre.setText(tabladatos.getValueAt(fila, 1).toString());
            txtapellido.setText(tabladatos.getValueAt(fila, 2).toString());
            txtedad.setText(tabladatos.getValueAt(fila, 3).toString());
            txtcorreo.setText(tabladatos.getValueAt(fila, 4).toString());
            save.setEnabled(true);
            txtnombre.setEnabled(true);
            txtapellido.setEnabled(true);
            txtid.setEnabled(true);
            txtedad.setEnabled(true);
            txtcorreo.setEnabled(true);
      
            
        } else {
            JOptionPane.showMessageDialog(null, "Fila no seleccionada");
           
        }
    }//GEN-LAST:event_modiActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        mostrartabla("");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
      desbloqueo();
    }//GEN-LAST:event_nuevoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton add;
    private javax.swing.JButton busc;
    private javax.swing.JTextField buscar;
    private javax.swing.JButton clean;
    private javax.swing.JComboBox<String> combo;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton modi;
    private javax.swing.JButton nuevo;
    private javax.swing.JButton save;
    private javax.swing.JTable tabladatos;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcorreo;
    private javax.swing.JTextField txtedad;
    private javax.swing.JTextField txtid;
    private javax.swing.JTextField txtnombre;
    // End of variables declaration//GEN-END:variables
}
