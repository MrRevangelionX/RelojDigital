package Reloj;

import java.util.*;

public class Reloj extends javax.swing.JFrame implements Runnable{  // vamos a ver algo nuevo que utiliza la interfas runnable
String  hora, minutos, segundos, ampm;
Calendar calendario;
Thread h1;
    
    
      public Reloj() {
        initComponents();
        //ACA VAMOS A INICIAR EL HILO QUE HEMOS CREADO
        h1 = new Thread(this);
        h1.start();
        
          setLocationRelativeTo(null);
          setTitle("Reloj");
          setVisible(true);
          
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        BlReloj = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        BlReloj.setFont(new java.awt.Font("Dialog", 1, 72)); // NOI18N
        BlReloj.setForeground(new java.awt.Color(255, 0, 0));
        BlReloj.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BlReloj.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BlReloj, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(BlReloj, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
               

    @Override
    public void run() {
        Thread ct= Thread.currentThread();
        
        while(ct==h1){
            calcula();
            BlReloj.setText(hora+":"+minutos+":"+ segundos + "   "+ampm);
                    try{
                        Thread.sleep(1000);
                               }catch (InterruptedException e){}
        
    }
        
}

    private void calcula() {
       Calendar calendario = new GregorianCalendar();
       Date fechaHoraActual = new Date();
       
       calendario.setTime(fechaHoraActual);
       ampm = calendario.get(Calendar.AM_PM)==Calendar.AM?"AM" : "PM";
       
       if(ampm.equals("PM")){
           int h= calendario.get(Calendar.HOUR_OF_DAY)-12;
           hora = h>9?""+h:"0"+h;
           //ACA ES DONDE SE HACE LA VALIDACION DE HORAS
       }else{
           hora= calendario.get(Calendar.HOUR_OF_DAY)>9?""+
                   calendario.get(Calendar.HOUR_OF_DAY): "0"+calendario.get(Calendar.HOUR_OF_DAY);
       }
       minutos= calendario.get(Calendar.MINUTE)>9?""+calendario.get
        (Calendar.MINUTE): "0"+calendario.get(Calendar.MINUTE);
       segundos= calendario.get(Calendar.SECOND)>9?""+calendario.get
        (Calendar.SECOND): "0"+calendario.get(Calendar.SECOND);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BlReloj;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}