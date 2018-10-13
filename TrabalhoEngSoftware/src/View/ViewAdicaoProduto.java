/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.ControllerVenda;
import Model.ModelProduto;
import java.util.LinkedList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Marcos
 */
public class ViewAdicaoProduto extends javax.swing.JFrame {

    ControllerVenda controllerVenda = new ControllerVenda();
    ViewVenda viewVenda = new ViewVenda();
    private LinkedList<ModelProduto> produtosViewVenda = new LinkedList<>();
    private LinkedList<ModelProduto> listaParaTabela = new LinkedList<>();
    JTable tabela;
    JTextField texto;

    public ViewAdicaoProduto(LinkedList pListaProdutos, JTable pTabela, JTextField pTexto) {
        produtosViewVenda = pListaProdutos;
        tabela = pTabela;
        texto = pTexto;
        initComponents();
        addRowToJTable();
        setLocationRelativeTo(null);
    }

    public ViewAdicaoProduto() {
        initComponents();
        setLocationRelativeTo(null);
    }

    /**
     * Creates new form ViewAdicaoProduto
     */
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tbProdutosAdicao = new javax.swing.JTable();
        btnAdd = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Selecionar produto");

        tbProdutosAdicao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Código", "Produto", "Preço", "Estoque"
            }
        ));
        jScrollPane1.setViewportView(tbProdutosAdicao);

        btnAdd.setText("Adicionar");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAdd))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        produtosViewVenda.add(listaParaTabela.get(tbProdutosAdicao.getSelectedRow()));
//        System.out.println("adicionado produto no viewAdicaoProduto");
//        for (int i = 0; i < produtosViewVenda.size(); i++) {
//            System.out.println("produto no viewAdicaoProduto: " + produtosViewVenda.get(i).getNome());
//        } 
//        controllerVenda.notificar();

        viewVenda.atualizaLista(produtosViewVenda, texto);
        viewVenda.clearTable(tabela);
        viewVenda.addRowToJTable(tabela, texto);

        this.dispose();

        //PAREI AQUI TESTANDO PRA VER SE A TABELA DO ADICAOPRODUTO ESTA ADICIONANDO

    }//GEN-LAST:event_btnAddActionPerformed

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
            java.util.logging.Logger.getLogger(ViewAdicaoProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewAdicaoProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewAdicaoProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewAdicaoProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewAdicaoProduto().setVisible(true);
            }
        });
    }

    public void addRowToJTable() {
        listaParaTabela = controllerVenda.buscaListaProdutos();
        clearTable();

        DefaultTableModel model = (DefaultTableModel) tbProdutosAdicao.getModel();
        Object rowData[] = new Object[4];

        for (int i = 0; i < listaParaTabela.size(); i++) {
            if (listaParaTabela.get(i).getEstoque() > 0) {
                rowData[0] = listaParaTabela.get(i).getCod();
                rowData[1] = listaParaTabela.get(i).getNome();
                rowData[2] = listaParaTabela.get(i).getPreco();
                rowData[3] = listaParaTabela.get(i).getEstoque();
                model.addRow(rowData);
            }
        }

        tbProdutosAdicao.repaint();
    }

    public void clearTable() {

        tbProdutosAdicao.setModel(new DefaultTableModel(null, new String[]{"Código", "Produto", "Preço", "Estoque"}));

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbProdutosAdicao;
    // End of variables declaration//GEN-END:variables
}
