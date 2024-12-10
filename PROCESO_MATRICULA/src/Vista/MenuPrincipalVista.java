/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;

import Controlador.*;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;

/**
 *
 * @author user
 */
public class MenuPrincipalVista extends javax.swing.JFrame {

    /**
     * Creates new form menuVieweight
     */
    public MenuPrincipalVista() {
        Image icon = new ImageIcon(this.getClass().getResource("/imagenes/icon.png")).getImage();
        this.setIconImage(icon);
        
        initComponents();
        
        setTitle("Menu Principal");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(true);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        EstudianteVista instanciaEV = new EstudianteVista();
        IniciarFrame(instanciaEV);
        ControladorEstudiante ctrl =new ControladorEstudiante(instanciaEV);
        
    }
    private void IniciarFrame(JInternalFrame frame){
        
        this.jDesktopPane.removeAll();
        this.jDesktopPane.add(frame);
        this.jDesktopPane.repaint();
    }

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu3 = new javax.swing.JMenu();
        jDesktopPane = new javax.swing.JDesktopPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        estudiantesMenu = new javax.swing.JMenuItem();
        docentesMenu = new javax.swing.JMenuItem();
        horarioMenu = new javax.swing.JMenuItem();
        matriculamenu = new javax.swing.JMenuItem();

        jMenu3.setText("jMenu3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jDesktopPane.setBackground(new java.awt.Color(153, 204, 255));

        javax.swing.GroupLayout jDesktopPaneLayout = new javax.swing.GroupLayout(jDesktopPane);
        jDesktopPane.setLayout(jDesktopPaneLayout);
        jDesktopPaneLayout.setHorizontalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 767, Short.MAX_VALUE)
        );
        jDesktopPaneLayout.setVerticalGroup(
            jDesktopPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 519, Short.MAX_VALUE)
        );

        jMenu1.setText("Vistas");

        estudiantesMenu.setText("Estudiantes");
        estudiantesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estudiantesMenuActionPerformed(evt);
            }
        });
        jMenu1.add(estudiantesMenu);

        docentesMenu.setText("Docentes");
        docentesMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                docentesMenuActionPerformed(evt);
            }
        });
        jMenu1.add(docentesMenu);

        horarioMenu.setText("Horario");
        horarioMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                horarioMenuActionPerformed(evt);
            }
        });
        jMenu1.add(horarioMenu);

        matriculamenu.setText("Matricula");
        matriculamenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculamenuActionPerformed(evt);
            }
        });
        jMenu1.add(matriculamenu);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void estudiantesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estudiantesMenuActionPerformed
        EstudianteVista instanciaEV = new EstudianteVista();
        IniciarFrame(instanciaEV);
        ControladorEstudiante ctrl =new ControladorEstudiante(instanciaEV);
        
    }//GEN-LAST:event_estudiantesMenuActionPerformed

    private void docentesMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_docentesMenuActionPerformed
        DocenteVista instanciaDV=new DocenteVista();
        IniciarFrame(instanciaDV);
        ControladorDocente ctrl=new ControladorDocente(instanciaDV);
        
    }//GEN-LAST:event_docentesMenuActionPerformed

    private void horarioMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_horarioMenuActionPerformed
        HorarioVista instaciaHV=new HorarioVista();
        IniciarFrame(instaciaHV);
        ControladorHorario ctlr=new ControladorHorario(instaciaHV);
    }//GEN-LAST:event_horarioMenuActionPerformed

    private void matriculamenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculamenuActionPerformed
        // TODO add your handling code here:
        MatriculaVista instaciaMV=new MatriculaVista();
        IniciarFrame(instaciaMV);
        ControladorMatricula ctlr=new ControladorMatricula(instaciaMV);
    }//GEN-LAST:event_matriculamenuActionPerformed

    
    
    
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
            java.util.logging.Logger.getLogger(MenuPrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipalVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipalVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem docentesMenu;
    private javax.swing.JMenuItem estudiantesMenu;
    private javax.swing.JMenuItem horarioMenu;
    public javax.swing.JDesktopPane jDesktopPane;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem matriculamenu;
    // End of variables declaration//GEN-END:variables
}
