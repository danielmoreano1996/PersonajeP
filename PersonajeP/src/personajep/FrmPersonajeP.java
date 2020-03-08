/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package personajep;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;


public class FrmPersonajeP extends javax.swing.JFrame implements KeyListener
{
    //figura 1
    int filas1;
    int columnas1;
    int movimiento = 300;
    int Salto = 300;
    int intercalarIzqDerSalto = 0;
    int intercalarBrazo = 1;
    int camiPara;
    int contadorSalto;
    int escala = 2;
    int a = new Color(25,10,245).getRGB();
    int n = new Color(0,0,0).getRGB();
    int r = new Color(228,28,28).getRGB();
    int b = new Color(255,255,255).getRGB();
    int g = new Color(110,105,105).getRGB();
    
    int puroHueso1[][]={{a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a},
                        {a,a,n,n,n,n,n,n,n,n,n,n,a,a,a,a,a,a,a},
                        {a,n,n,r,r,r,r,r,r,r,r,r,n,a,a,a,a,a,a},
                        {n,n,n,r,b,b,b,b,b,b,b,r,n,a,a,a,a,a,a},
                        {n,n,n,r,b,n,n,b,n,n,b,r,n,a,a,n,g,g,g},
                        {n,n,n,r,b,n,n,b,n,n,b,r,n,a,a,n,g,g,g},
                        {n,n,n,r,b,b,b,b,b,b,b,r,n,a,a,n,g,g,g},
                        {n,n,n,r,r,b,b,b,b,b,r,r,n,a,a,n,g,g,a},
                        {n,n,n,r,r,b,b,b,b,b,r,r,n,a,a,n,g,a,a},
                        {n,a,n,n,n,b,n,b,b,b,n,n,a,a,a,n,a,a,a},
                        {n,a,a,a,a,b,b,n,n,n,b,a,a,a,a,n,a,a,a},
                        {n,n,a,a,a,b,b,b,b,b,b,n,a,a,a,n,a,a,a},
                        {a,a,a,a,n,b,b,b,b,b,b,n,n,a,a,n,a,a,a},
                        {a,a,a,n,n,b,b,b,b,b,b,a,n,n,b,b,b,a,a},
                        {a,a,n,n,a,a,n,n,n,n,a,a,a,n,b,n,a,a,a},
                        {a,n,n,a,a,a,a,n,n,n,n,a,a,a,a,b,a,a,a},
                        {a,b,b,a,a,a,a,n,n,n,n,n,a,a,a,n,a,a,a},
                        {a,b,a,b,a,a,a,a,n,n,n,n,n,a,a,n,a,a,a},
                        {a,b,a,a,a,a,a,n,n,n,n,n,n,a,a,n,a,a,a},
                        {a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a}};
    
    int puroHueso2[][]={{a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a},
                        {a,a,n,n,n,n,n,n,n,n,n,n,a,a,a,a,a,a,a},
                        {a,n,n,r,r,r,r,r,r,r,r,r,n,a,a,a,a,a,a},
                        {n,n,n,r,b,b,b,b,b,b,b,r,n,a,a,a,a,a,a},
                        {n,n,n,r,b,n,n,b,n,n,b,r,n,a,a,a,a,a,a},
                        {n,n,n,r,b,n,n,b,n,n,b,r,n,a,a,a,a,a,a},
                        {n,n,n,r,b,b,b,b,b,b,b,r,n,a,a,a,a,a,a},
                        {n,n,n,r,r,b,b,b,b,b,r,r,n,a,a,a,a,a,a},
                        {n,n,n,r,r,b,b,b,b,b,r,r,n,a,a,a,a,a,a},
                        {n,a,n,n,n,b,n,b,b,b,n,n,a,a,a,a,a,a,a},
                        {n,a,a,a,a,b,b,n,n,n,b,a,a,a,a,a,a,a,a},
                        {n,n,a,a,a,b,b,b,b,b,b,n,a,a,a,a,a,a,a},
                        {a,a,a,a,n,b,b,b,b,b,b,n,n,a,a,a,a,a,a},
                        {a,a,a,n,n,b,b,b,b,b,b,a,n,n,b,b,b,a,a},
                        {a,a,n,n,a,a,n,n,n,n,a,a,a,n,b,a,a,a,a},
                        {n,n,n,a,a,a,a,n,n,n,n,a,a,a,a,b,a,a,a},
                        {n,b,b,a,a,a,a,n,n,n,n,n,a,a,a,a,a,a,a},
                        {a,b,n,b,a,a,a,a,n,n,n,n,n,a,a,a,a,a,a},
                        {a,b,n,n,a,a,a,n,n,n,n,n,n,a,a,a,a,a,a},
                        {a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a}};
    
    int puroHueso3[][]={{a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a},
                        {a,a,a,a,n,n,n,n,n,n,n,n,n,n,n,a,a,a,a},
                        {a,a,a,n,n,r,r,r,r,r,r,r,r,r,r,n,a,a,a},
                        {a,a,n,n,n,r,b,b,b,b,b,b,b,b,r,n,a,a,a},
                        {a,a,n,n,n,r,b,n,n,b,b,n,n,b,r,n,a,a,a},
                        {a,a,n,n,n,r,b,n,n,b,b,n,n,b,r,n,a,a,a},
                        {a,a,n,n,n,r,b,b,b,b,b,b,b,b,r,n,a,a,a},
                        {a,a,n,n,n,r,r,r,b,b,b,b,r,r,r,n,a,a,a},
                        {a,a,n,n,n,r,r,r,b,b,b,b,r,r,n,a,a,a,a},
                        {a,a,n,a,n,n,n,n,b,b,b,b,n,n,a,a,a,a,a},
                        {a,a,n,a,a,a,a,b,n,b,b,n,b,a,a,a,a,a,a},
                        {a,a,n,n,a,a,n,b,n,n,n,n,b,n,a,a,a,a,a},
                        {a,a,a,a,a,n,n,b,b,b,b,b,b,n,n,a,a,a,a},
                        {a,b,b,b,n,n,a,n,n,n,n,n,n,a,n,n,b,b,b},
                        {a,a,a,b,n,a,a,a,n,n,n,n,a,a,a,n,b,a,a},
                        {a,a,b,a,a,a,a,a,n,n,n,n,a,a,a,a,a,b,a},
                        {a,a,a,a,a,a,a,n,n,n,n,n,n,a,a,a,a,a,a},
                        {a,a,a,a,a,a,a,n,n,n,n,n,n,a,a,a,a,a,a},
                        {a,a,a,a,a,a,a,n,n,n,n,n,n,a,a,a,a,a,a},
                        {a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a}};
    int puroHueso4[][]={{a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a},
                        {a,a,n,n,n,n,n,n,n,n,n,n,a,a,a,a,a,a,a},
                        {a,n,n,r,r,r,r,r,r,r,r,r,n,a,a,a,a,a,a},
                        {n,n,n,r,b,b,b,b,b,b,b,r,n,a,a,a,a,a,a},
                        {n,n,n,r,b,n,n,b,n,n,b,r,n,a,a,a,a,a,a},
                        {n,n,n,r,b,n,n,b,n,n,b,r,n,a,a,a,a,a,a},
                        {n,n,n,r,b,b,b,b,b,b,b,r,n,a,a,a,a,a,a},
                        {n,n,n,r,r,b,b,b,b,b,r,r,n,a,a,a,a,a,a},
                        {n,n,n,r,r,b,b,b,b,b,r,r,n,a,b,b,a,a,a},
                        {n,a,n,n,n,b,n,b,b,b,n,n,a,n,b,b,a,a,a},
                        {n,a,a,a,a,b,b,n,n,n,b,a,n,n,a,a,a,a,a},
                        {n,n,a,a,a,b,b,b,b,b,b,n,n,a,a,a,a,a,a},
                        {a,a,a,a,a,b,b,b,b,b,b,n,a,a,a,a,a,a,a},
                        {a,a,a,a,a,b,b,b,b,b,b,a,a,a,a,a,a,a,a},
                        {a,a,a,a,a,a,n,n,n,n,a,a,a,a,a,a,a,a,a},
                        {a,a,a,a,a,n,n,n,n,n,a,a,a,a,a,a,a,a,a},
                        {a,a,a,a,n,n,n,n,n,a,a,a,a,a,a,a,a,a,a},
                        {a,a,a,a,n,n,n,n,n,a,a,a,a,a,a,a,a,a,a},
                        {a,a,a,a,a,n,n,n,n,n,a,a,a,a,a,a,a,a,a},
                        {a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a,a}};
    

    

    FrmPersonajeP() 
    {
        initComponents();
        this.getContentPane().setBackground(new Color(25,10,245));
        addKeyListener(this);
    }
    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) 
    {
        intercalarIzqDerSalto = 0;
    }
    public void keyPressed(KeyEvent e)
    {
       System.out.println(e.getKeyCode());
//       if((e.getKeyCode() == 68) && e.getKeyCode()== 87)
//       {
//           
//       }
           
       if(e.getKeyCode() == 68)
       {
           movimiento+=1;
           intercalarBrazo *= -1; 
           intercalarIzqDerSalto = 1;
       }
       else if(e.getKeyCode() == 65)
       {
           movimiento-=1;
           intercalarBrazo *= -1;
           intercalarIzqDerSalto = 2; 
       }
       else if (e.getKeyCode() == 87)
       {
           intercalarIzqDerSalto = 3;
       }
       
       
    }
    
    public void paint(Graphics g)
    {
        super.paint(g);
        
        
        if(intercalarIzqDerSalto == 0)
        {
            for(filas1=0 ; filas1<=19*escala ; filas1++)
                {
                    for(columnas1=0;columnas1<19*escala;columnas1++)
                    {
                        g.setColor(new Color(puroHueso3[filas1/escala][columnas1/escala]));
                        g.drawRect(movimiento+(columnas1),Salto+(filas1),1,1);
                    }
                }
        }
    
        //Movimiento Derecha
        else if(intercalarIzqDerSalto == 1)
        {
            if(intercalarBrazo == 1)
            {
                for(filas1=0 ; filas1<=19*escala ; filas1++)
                {
                    for(columnas1=0;columnas1<19*escala;columnas1++)
                    {
                        g.setColor(new Color(puroHueso1[filas1/escala][columnas1/escala]));
                        g.drawRect(movimiento+(columnas1),Salto+(filas1),1,1);
                    }
                }
            }
            else if(intercalarBrazo == -1)
            {
                for(filas1=0 ; filas1<=19*escala ; filas1++)
                {
                    for(columnas1=0;columnas1<19*escala;columnas1++)
                    {
                        g.setColor(new Color(puroHueso2[filas1/escala][columnas1/escala]));
                        g.drawRect(movimiento+(columnas1),Salto+(filas1),1,1);
                    }
                }
            }
        }
        
        //Movimiento Izq
        else if(intercalarIzqDerSalto == 2)
        {
            if(intercalarBrazo == 1)
            {
                for(filas1=0 ; filas1<=19*escala ; filas1++)
                {
                    for(columnas1=0;columnas1<19*escala;columnas1++)
                    {
                        g.setColor(new Color(puroHueso1[filas1/escala][columnas1/escala]));
                        g.drawRect(movimiento+(19-columnas1),Salto+(filas1),1,1);
                    }
                }
            }
            else if(intercalarBrazo == -1)
            {
                for(filas1=0 ; filas1<=19*escala ; filas1++)
                {
                    for(columnas1=0;columnas1<19*escala;columnas1++)
                    {
                        g.setColor(new Color(puroHueso2[filas1/escala][columnas1/escala]));
                        g.drawRect(movimiento+(19-columnas1),Salto+(filas1),1,1);
                    }
                }
            }
        }
        else if (intercalarIzqDerSalto == 3)
        { 
            for (int x = 0 ; x < 50 ; x ++)
            { 
                for(filas1=0 ; filas1<=19*escala ; filas1++)
                {
                    for(columnas1=0 ; columnas1<19*escala ; columnas1++)
                    {
                        g.setColor(new Color(puroHueso4[filas1/escala][columnas1/escala]));
                        g.drawRect(movimiento+(columnas1),Salto+(filas1),1,1);
                    }
                }   
                Salto--;
            }
            
            for (int x = 0 ; x < 50 ; x ++)
            {
                Salto++;
                for(filas1=0 ; filas1<=19*escala ; filas1++)
                {
                    for(columnas1=0;columnas1<19*escala;columnas1++)
                    {
                        g.setColor(new Color(puroHueso4[filas1/escala][columnas1/escala]));
                        g.drawRect(movimiento+(columnas1),Salto+(filas1),1,1);
                    }
                }    
            }                   
        }
        
        
    }
        
    Timer tiempo = new Timer(150 , new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            repaint();
        }
    });
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(20, 10, 245));
        setPreferredSize(new java.awt.Dimension(3000, 3000));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        tiempo.start();
    }//GEN-LAST:event_formWindowOpened

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
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
            java.util.logging.Logger.getLogger(FrmPersonajeP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPersonajeP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPersonajeP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPersonajeP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPersonajeP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
