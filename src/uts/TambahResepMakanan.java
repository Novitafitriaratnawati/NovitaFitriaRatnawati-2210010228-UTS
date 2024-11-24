/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package uts;

/**
 *
 * @author ASUS
 */
import javax.swing.*;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.util.List;

public class TambahResepMakanan extends javax.swing.JFrame {
    private int currentRecipeId = -1;
    private RecipeTableModel tableModel;
    private DefaultListModel<String> listModel;
    private JList<String> recipeList;
    private static final Color BLUE_BACKGROUND = new Color(173, 216, 230); 
    /**
     * Creates new form TambahResepMakanan
     */
    public TambahResepMakanan() {
        initComponents();
        this.setLocationRelativeTo(null);
        setupComponents();
        setupListeners();
        DatabaseHelper.initializeDatabase();
        refreshTable();
        listModel = new DefaultListModel<>(); 
        recipeList = new JList<>(listModel);  
        refreshRecipeList(); 
        getContentPane().setBackground(BLUE_BACKGROUND);
    }

        private void refreshTable() {
        List<Recipe> recipes = DatabaseHelper.getAllRecipes();
        tableModel = new RecipeTableModel(recipes);
        jTable1.setModel(tableModel);
    }

       private void setupComponents() {
        // Inisialisasi
        List<Recipe> recipes = DatabaseHelper.getAllRecipes();
        tableModel = new RecipeTableModel(recipes);
        jTable1.setModel(tableModel);
        
        // Set lebar kolom
        TableColumn column = jTable1.getColumnModel().getColumn(0);
        column.setPreferredWidth(50);
        column = jTable1.getColumnModel().getColumn(1);
        column.setPreferredWidth(150);
        column = jTable1.getColumnModel().getColumn(2);
        column.setPreferredWidth(300);
        
        // Set button text
        jButton1.setText("Simpan");
        jButton2.setText("Ubah");
        jButton3.setText("Hapus");
        
        // Set label text
        jLabel1.setText("Tambah Resep Makanan");
        jLabel1.setFont(new Font("Segoe UI", Font.BOLD, 18));
        jLabel2.setText("Nama:");
        jLabel3.setText("Resep:");
    }
    

    private void setupListeners() {
         jButton1.addActionListener(e -> {
            String name = jTextField1.getText();
            String instructions = jTextArea1.getText();
            
            if (name.isEmpty() || instructions.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama dan resep harus diisi!");
                return;
            }
            
            DatabaseHelper.addRecipe(name, instructions);
            clearFields();
            refreshTable();
        });

        // Update BUTTON
        jButton2.addActionListener(e -> {
            if (currentRecipeId == -1) {
                JOptionPane.showMessageDialog(this, "Pilih resep yang akan diubah!");
                return;
            }
            
            String name = jTextField1.getText();
            String instructions = jTextArea1.getText();
            
            if (name.isEmpty() || instructions.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Nama dan resep harus diisi!");
                return;
            }
            
            DatabaseHelper.updateRecipe(currentRecipeId, name, instructions);
            clearFields();
            refreshTable();
            currentRecipeId = -1;
        });

        // Delete button
        jButton3.addActionListener(e -> {
            if (currentRecipeId == -1) {
                JOptionPane.showMessageDialog(this, "Pilih resep yang akan dihapus!");
                return;
            }
            
            int confirm = JOptionPane.showConfirmDialog(this,
                "Apakah Anda yakin ingin menghapus resep ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION);
                
            if (confirm == JOptionPane.YES_OPTION) {
                DatabaseHelper.deleteRecipe(currentRecipeId);
                clearFields();
                refreshTable();
                currentRecipeId = -1;
            }
    });
        jTable1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = jTable1.getSelectedRow();
                if (selectedRow != -1) {
                    currentRecipeId = (int) tableModel.getValueAt(selectedRow, 0);
                    jTextField1.setText((String) tableModel.getValueAt(selectedRow, 1));
                    jTextArea1.setText((String) tableModel.getValueAt(selectedRow, 2));
                }
            }
        });
    }
    private void clearFields() {
        jTextField1.setText("");
        jTextArea1.setText("");
        jTable1.clearSelection();
    }

      private void refreshRecipeList() {
    listModel.clear();
    List<Recipe> recipes = DatabaseHelper.getAllRecipes(); // Ambil daftar resep dari database
    for (Recipe recipe : recipes) {
        listModel.addElement(recipe.getName()); 
    }
}
    // ... (rest of the existing code remains the same)

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Tambah Resep Makanan");

        jLabel2.setText("Nama:");

        jLabel3.setText("Resep:");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jButton1.setText("Simpan");

        jButton2.setText("Ubah");

        jButton3.setText("Hapus");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Nama Resep ", "Instruksi"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        jButton4.setText("Halaman Awal");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jButton4)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton3))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1)
                    .addComponent(jScrollPane1))
                .addGap(82, 82, 82))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel1)
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(58, 58, 58)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
    new HalamanAwal().setVisible(true);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(TambahResepMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TambahResepMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TambahResepMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TambahResepMakanan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TambahResepMakanan().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
