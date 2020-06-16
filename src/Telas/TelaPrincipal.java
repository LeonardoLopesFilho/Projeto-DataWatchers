/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Telas;

import Classes.Economia;
import Classes.Login;
import dao.DadosDAO;
import dao.EconomiaDao;
import dao.EnigmaDAO;
import dao.LoginDAO;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author leo_z
 */
public class TelaPrincipal extends javax.swing.JFrame {
        Economia eco = new Economia();
        TelaDados dado = new TelaDados();
        //Thread cronometro = new Thread();
        boolean confirmacao = false;
        DadosDAO dados = new DadosDAO();
        Random random = new Random();
        EnigmaDAO enig = new EnigmaDAO();
        EconomiaDao ecod = new EconomiaDao();
        Login log =  new Login();
        LoginDAO logdao =  new LoginDAO();
        public String user;
        public float moedas;
    /**
     * Creates new form TelaPrincipal
     */
    public TelaPrincipal() {
        this.setIconImage(new javax.swing.ImageIcon(getClass().getResource("/imagens/icon.png")).getImage());
        initComponents();
        Botao1.setVisible(true);
        Botao2.setVisible(false);
       
        botaofim.setVisible(false);
        botaoatualizarcomprados.setVisible(false);
        cronometro.start();
        setLocationRelativeTo(null);
        eco.zerar();
        dados.zerarcompletos();
        enig.zerarcomprado();
        user = logdao.Pegarusuariologado();
        if(logdao.PegarEco(this.user) == 0){
          lblmoeda.setText(Float.toString(eco.getMoedas()));
        }else
          lblmoeda.setText(Integer.toString(logdao.PegarEco(this.user)));
          moedas = (float)logdao.PegarEco(this.user);
          eco.click(moedas);
        
        this.setTitle("DataWatchers");
    }
    
    //Cronometro do jogo
    Thread cronometro = new Thread(){
    
    public void run(){
    int hor=0, min=0, seg=0;
    
    for(;;){
    try{
        
     seg++;
     
     if(seg>59){
         seg = 0;
         min++;
     }
     if(min>59){
         seg = 0;
         min = 0;
         hor++;
     }
     //caso o cronometro chegue em 30 minutos o jogo vai fazer algo nao sei oq ainda kkkkk
     if(min == 30){ 
         TelaTempoEsgotado fim = new TelaTempoEsgotado();
         fim.setVisible(true);
         cronometro.stop();
         dispose();
        }
     tiempo.setText(hor + ":" + min + ":" +seg);
     
     Thread.sleep(999);
     
    }catch(InterruptedException e){
            }
    }
        }
    };
  

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        Botao1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        BotaoAtivar2 = new javax.swing.JButton();
        Botao2 = new javax.swing.JButton();
        lblmoeda = new javax.swing.JLabel();
        tiempo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        labelcomprados = new javax.swing.JLabel();
        botaoatualizarcomprados = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        botaofim = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnSalvarBitcoin = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Botao1.setText("+1 BitCoin");
        Botao1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botao1ActionPerformed(evt);
            }
        });
        jPanel2.add(Botao1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 340, -1, -1));

        jLabel1.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 255, 0));
        jLabel1.setText("Seus BitCoins:");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        BotaoAtivar2.setText("Ativar Click Duplo");
        BotaoAtivar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoAtivar2ActionPerformed(evt);
            }
        });
        jPanel2.add(BotaoAtivar2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, -1, -1));

        Botao2.setText("+2 BitCoin");
        Botao2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Botao2ActionPerformed(evt);
            }
        });
        jPanel2.add(Botao2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 370, -1, -1));

        lblmoeda.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        lblmoeda.setForeground(new java.awt.Color(0, 255, 0));
        lblmoeda.setText("0");
        jPanel2.add(lblmoeda, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        tiempo.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        tiempo.setForeground(new java.awt.Color(51, 255, 0));
        tiempo.setText("0:0:0");
        jPanel2.add(tiempo, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(0, 0, 0));
        jTextArea1.setColumns(20);
        jTextArea1.setForeground(new java.awt.Color(0, 255, 0));
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("Olá senhor thiago, como o \nsenhor está? quanto tempo o \nsenhor não entra nos nossos \nserviços em! \nentão sinto lhe informar que a partir do dia 29 teremos que \nencerrar as nossas atividades, \npois entrará em vigor uma lei queacabará com a venda e compra de \ndados dos usuários, então caso \nqueira usar nossos serviços \nestará sozinho e sofrerá as \nconsequências;");
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 270, 260));

        jButton1.setText("Comprar Dados");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 400, -1, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 255, 0));
        jLabel2.setText("Dados Comprados :");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 40, 130, -1));

        labelcomprados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelcomprados.setForeground(new java.awt.Color(0, 255, 0));
        labelcomprados.setText("0");
        jPanel2.add(labelcomprados, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 40, -1, -1));

        botaoatualizarcomprados.setText("Atualizar Dados Comprados");
        botaoatualizarcomprados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoatualizarcompradosActionPerformed(evt);
            }
        });
        jPanel2.add(botaoatualizarcomprados, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 255, 51));
        jLabel3.setText("/5");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, -1, -1));

        botaofim.setText("Sair Do Jogo");
        botaofim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaofimActionPerformed(evt);
            }
        });
        jPanel2.add(botaofim, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 100, 20));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 255, 0));
        jLabel4.setText("28/12/2020");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, -1, -1));

        btnSalvarBitcoin.setText("Salvar BitCoin");
        btnSalvarBitcoin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarBitcoinActionPerformed(evt);
            }
        });
        jPanel2.add(btnSalvarBitcoin, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 461, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Botao1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botao1ActionPerformed
        // TODO add your handling code here:
        eco.click(1);
        lblmoeda.setText(Float.toString(eco.getMoedas()));
        if(dados.Pegarcompletos() == 0){
            botaoatualizarcomprados.setVisible(false);
        }else{
            botaoatualizarcomprados.setVisible(true);
        }
        if (dados.Pegarcompletos() == 5){
           botaofim.setVisible(true);
        }
    }//GEN-LAST:event_Botao1ActionPerformed

    private void BotaoAtivar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoAtivar2ActionPerformed
        // TODO add your handling code here:
        if(eco.getMoedas()>=100 && confirmacao == false){
            Botao1.setVisible(false);
            Botao2.setVisible(true);
            BotaoAtivar2.setVisible(false);
          
            eco.comprar(100);
            confirmacao = true;
            lblmoeda.setText(Float.toString(eco.getMoedas()));
        }else if (eco.getMoedas()<100){
            JOptionPane.showMessageDialog(null,"BitCoin insuficiente, junte 100 pra comprar");
        }else if (confirmacao == true){
            JOptionPane.showMessageDialog(null,"Click duplo já foi ativado");
        }
        
    }//GEN-LAST:event_BotaoAtivar2ActionPerformed

    private void Botao2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Botao2ActionPerformed
        // TODO add your handling code here:
        eco.click(2);
        lblmoeda.setText(Float.toString(eco.getMoedas()));
        if(dados.Pegarcompletos() == 0){
            botaoatualizarcomprados.setVisible(false);
        }else{
            botaoatualizarcomprados.setVisible(true);
        }
        if (dados.Pegarcompletos() == 5){
           botaofim.setVisible(true);
        }
    }//GEN-LAST:event_Botao2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        dado.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void botaoatualizarcompradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoatualizarcompradosActionPerformed
        // TODO add your handling code here:
        labelcomprados.setText(Integer.toString(dados.Pegarcompletos()));
        
        log.atualizareco();
    }//GEN-LAST:event_botaoatualizarcompradosActionPerformed

    private void botaofimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaofimActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botaofimActionPerformed

    private void btnSalvarBitcoinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarBitcoinActionPerformed
        // TODO add your handling code here:
        
        logdao.Pegarusuariologado();
        log.setEconomia(ecod.PegarMoedasBanco());
        log.atualizareco();
        JOptionPane.showMessageDialog(null,"Economia salva");
        
    }//GEN-LAST:event_btnSalvarBitcoinActionPerformed
        
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Botao1;
    private javax.swing.JButton Botao2;
    private javax.swing.JButton BotaoAtivar2;
    private javax.swing.JButton botaoatualizarcomprados;
    private javax.swing.JButton botaofim;
    private javax.swing.JButton btnSalvarBitcoin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel labelcomprados;
    private javax.swing.JLabel lblmoeda;
    private javax.swing.JLabel tiempo;
    // End of variables declaration//GEN-END:variables
}