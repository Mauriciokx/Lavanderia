/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
import Controlador.ControladorClientes;
import static Controlador.ControladorClientes.vClientes;
import Controlador.ControladorPedido;
import static Controlador.ControladorPedido.vPedidos;
import Controlador.ControladorProducto;
import static Controlador.ControladorProducto.vProductos;
import Controlador.ControladorPromocion;
import static Controlador.ControladorPromocion.vPromociones;
/**
 *
 * @author Mauricio Pacheco
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    public Principal() {
        initComponents();
    }
    
    //Pedidos p1 = new Pedidos();

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        principal = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        menu6 = new javax.swing.JMenu();
        pedidos = new javax.swing.JMenuItem();
        menu1 = new javax.swing.JMenu();
        clientes = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        catalogo = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        promociones = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout principalLayout = new javax.swing.GroupLayout(principal);
        principal.setLayout(principalLayout);
        principalLayout.setHorizontalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 897, Short.MAX_VALUE)
        );
        principalLayout.setVerticalGroup(
            principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 471, Short.MAX_VALUE)
        );

        jMenuBar1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        menu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Imagenes icon/pedido.png"))); // NOI18N
        menu6.setText("Pedidos");
        menu6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu6ActionPerformed(evt);
            }
        });

        pedidos.setText("Pedidos");
        pedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pedidosActionPerformed(evt);
            }
        });
        menu6.add(pedidos);

        jMenuBar1.add(menu6);

        menu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Imagenes icon/clientes.png"))); // NOI18N
        menu1.setText("Clientes");
        menu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menu1ActionPerformed(evt);
            }
        });

        clientes.setText("Clientes");
        clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clientesActionPerformed(evt);
            }
        });
        menu1.add(clientes);

        jMenuBar1.add(menu1);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Imagenes icon/producto.png"))); // NOI18N
        jMenu3.setText("Productos");

        catalogo.setText("Catalogo");
        catalogo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                catalogoActionPerformed(evt);
            }
        });
        jMenu3.add(catalogo);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Imagenes icon/promocion.png"))); // NOI18N
        jMenu4.setText("Promociones");

        promociones.setText("Promociones");
        promociones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                promocionesActionPerformed(evt);
            }
        });
        jMenu4.add(promociones);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vistas/Imagenes icon/cerrar.png"))); // NOI18N
        jMenu5.setText("Cerrar sesión");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principal)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menu6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_menu6ActionPerformed

    private void pedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pedidosActionPerformed
        // TODO add your handling code here:
        ControladorPedido.mostrar(principal, vPedidos);
    }//GEN-LAST:event_pedidosActionPerformed

    private void menu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menu1ActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_menu1ActionPerformed

    private void clientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clientesActionPerformed
        // TODO add your handling code here:
        ControladorClientes.mostrar(principal, vClientes);
    }//GEN-LAST:event_clientesActionPerformed

    private void catalogoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_catalogoActionPerformed
        // TODO add your handling code here:
        ControladorProducto.mostrar(principal, vProductos);
    }//GEN-LAST:event_catalogoActionPerformed

    private void promocionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_promocionesActionPerformed
        // TODO add your handling code here:
        ControladorPromocion.mostrar(principal, vPromociones);
    }//GEN-LAST:event_promocionesActionPerformed

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
    private javax.swing.JMenuItem catalogo;
    private javax.swing.JMenuItem clientes;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu menu1;
    private javax.swing.JMenu menu6;
    private javax.swing.JMenuItem pedidos;
    public javax.swing.JDesktopPane principal;
    private javax.swing.JMenuItem promociones;
    // End of variables declaration//GEN-END:variables
}
