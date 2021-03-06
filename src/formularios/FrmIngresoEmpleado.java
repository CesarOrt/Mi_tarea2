/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import archivo.Archivo;

import entidades.Empleado;
import formularios.FrmPrincipal.hora;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;

import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Cesar
 */
//public class FrmIngresoEmpleado extends javax.swing.JFrame {
public class FrmIngresoEmpleado extends javax.swing.JFrame implements Printable {
    
    /**
     * Creates new form FrmIngresoPersona
     */
    public FrmIngresoEmpleado() {
        initComponents();
                setLocationRelativeTo(null);

         setTitle ("Registro de Datos Personales");
         setIconImage(new ImageIcon(getClass().getResource("/iconos/usuario2.jpg")).getImage());
        ((JPanel)getContentPane()).setOpaque(false);
        ImageIcon uno=new ImageIcon(this.getClass().getResource("/imagenes/azules.jpg"));
        JLabel Salir= new JLabel();
         Salir.setIcon(uno);
        getLayeredPane().add(Salir,JLayeredPane.FRAME_CONTENT_LAYER);
       Salir.setBounds(0,0,uno.getIconWidth(),uno.getIconHeight());
    }
    private boolean formularioValido(){
        
               
        if(tfId.getText().equals("") || 
           tfNombres.getText().equals("") ||
           tfApellidos.getText().equals("") ||
                cbxestado_civil.getSelectedItem().equals("")||
                tfDia.getText().equals("") ||
                tfE_Mail.getText().equals("") ||
                tfTelefono.getText().equals("") ||
                tfEdad.getText().equals("")){
            JOptionPane.showMessageDialog(this
                    , "Formulario Incompleto", "Error en la validación"
                    , JOptionPane.ERROR_MESSAGE);
            return false;
       }
        
        
        try{
            Integer.parseInt(tfId.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this
                    , "EL id debe ser numerico", "Error en la validación"
                    , JOptionPane.ERROR_MESSAGE);
            return false;
        }    
        
        boolean v = valida(tfId.getText()) ;
           if(v==false)    {   
                    JOptionPane.showMessageDialog(this
                    , "El número de cédula no es válido", "Error en el ingreso"
                    , JOptionPane.ERROR_MESSAGE);               
              
               return false;}
          
              //System.out.println("Cedula no valida");
        try{
            Integer.parseInt(tfEdad.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this
                    , "La edad debe ser un número", "Error en la validación"
                    , JOptionPane.ERROR_MESSAGE);
            return false;
        }    
        
        try{
            ArrayList<Empleado> registros = Archivo.obtener_registros();
            for(Empleado e:registros){
                if(e.getId().equals(tfId.getText())){
                    JOptionPane.showMessageDialog(this
                    , "La cédula ya está registrada", "Error en la validación"
                    , JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(this
                    , "Error al verificar la duplicidad de la cédula", "Error en la validación"
                    , JOptionPane.ERROR_MESSAGE);
            
        }
        
        return true;    
    }
    

    
    private void limpiarFormulario(){
        tfId.setText(null);
        tfNombres.setText("");
        tfApellidos.setText("");
        cbxestado_civil.setSelectedItem("") ;
        tfDia.setText("");
        tfE_Mail.setText("");
        tfTelefono.setText("");
        tfEdad.setText("");    
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jBDatos = new javax.swing.JButton();
        jBId = new javax.swing.JButton();
        jBNombres = new javax.swing.JButton();
        jBApellidos = new javax.swing.JButton();
        jBEstado_Civil = new javax.swing.JButton();
        jBDia = new javax.swing.JButton();
        jBE_Mail = new javax.swing.JButton();
        jBTelefono = new javax.swing.JButton();
        jBEdad = new javax.swing.JButton();
        tfId = new javax.swing.JTextField();
        tfNombres = new javax.swing.JTextField();
        tfApellidos = new javax.swing.JTextField();
        tfDia = new javax.swing.JTextField();
        tfE_Mail = new javax.swing.JTextField();
        tfEdad = new javax.swing.JTextField();
        tfTelefono = new javax.swing.JTextField();
        cbxestado_civil = new javax.swing.JComboBox();
        jBIngresar = new javax.swing.JButton();
        jBLimpiar = new javax.swing.JButton();
        jLFoto = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jlhora = new javax.swing.JLabel();
        jldata = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        cmdPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -10, 860, 150));

        jBDatos.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jBDatos.setForeground(new java.awt.Color(0, 153, 153));
        jBDatos.setText("::::::DATOS PERSONALES::::::");
        getContentPane().add(jBDatos, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 400, -1));

        jBId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBId.setForeground(new java.awt.Color(0, 153, 153));
        jBId.setText("ID :");
        getContentPane().add(jBId, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 130, -1));

        jBNombres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBNombres.setForeground(new java.awt.Color(0, 153, 153));
        jBNombres.setText("NOMBRE :");
        getContentPane().add(jBNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 130, -1));

        jBApellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBApellidos.setForeground(new java.awt.Color(0, 153, 153));
        jBApellidos.setText("APELLIDO :");
        getContentPane().add(jBApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 130, -1));

        jBEstado_Civil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBEstado_Civil.setForeground(new java.awt.Color(0, 153, 153));
        jBEstado_Civil.setText("ESTADO_CIVIL :");
        getContentPane().add(jBEstado_Civil, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 180, -1));

        jBDia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBDia.setForeground(new java.awt.Color(0, 153, 153));
        jBDia.setText("DIA:");
        getContentPane().add(jBDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 230, -1));

        jBE_Mail.setBackground(new java.awt.Color(255, 255, 255));
        jBE_Mail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBE_Mail.setForeground(new java.awt.Color(0, 153, 153));
        jBE_Mail.setText("E_MAIL :");
        getContentPane().add(jBE_Mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, 140, -1));

        jBTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBTelefono.setForeground(new java.awt.Color(0, 153, 153));
        jBTelefono.setText("TELEFONO :");
        getContentPane().add(jBTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 280, 140, -1));

        jBEdad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBEdad.setForeground(new java.awt.Color(0, 153, 153));
        jBEdad.setText("EDAD :");
        getContentPane().add(jBEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 140, -1));

        tfId.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfId.setForeground(new java.awt.Color(0, 153, 153));
        tfId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfIdActionPerformed(evt);
            }
        });
        getContentPane().add(tfId, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 130, 150, -1));

        tfNombres.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfNombres.setForeground(new java.awt.Color(0, 153, 153));
        tfNombres.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfNombresActionPerformed(evt);
            }
        });
        tfNombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfNombresKeyTyped(evt);
            }
        });
        getContentPane().add(tfNombres, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 180, 150, -1));

        tfApellidos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfApellidos.setForeground(new java.awt.Color(0, 153, 153));
        tfApellidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfApellidosActionPerformed(evt);
            }
        });
        tfApellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfApellidosKeyTyped(evt);
            }
        });
        getContentPane().add(tfApellidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 150, -1));

        tfDia.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfDia.setForeground(new java.awt.Color(0, 153, 153));
        tfDia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfDiaKeyTyped(evt);
            }
        });
        getContentPane().add(tfDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 330, 150, -1));

        tfE_Mail.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfE_Mail.setForeground(new java.awt.Color(0, 153, 153));
        tfE_Mail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfE_MailFocusLost(evt);
            }
        });
        getContentPane().add(tfE_Mail, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 230, 150, -1));

        tfEdad.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfEdad.setForeground(new java.awt.Color(0, 153, 153));
        tfEdad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfEdadActionPerformed(evt);
            }
        });
        tfEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfEdadKeyTyped(evt);
            }
        });
        getContentPane().add(tfEdad, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 330, 150, -1));

        tfTelefono.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tfTelefono.setForeground(new java.awt.Color(0, 153, 153));
        tfTelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfTelefonoActionPerformed(evt);
            }
        });
        tfTelefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                tfTelefonoKeyTyped(evt);
            }
        });
        getContentPane().add(tfTelefono, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 150, -1));

        cbxestado_civil.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        cbxestado_civil.setForeground(new java.awt.Color(0, 153, 153));
        cbxestado_civil.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "SOLTERO", "CASADO", "DIVORSIADO", "VIUDO" }));
        cbxestado_civil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxestado_civilActionPerformed(evt);
            }
        });
        getContentPane().add(cbxestado_civil, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 280, 150, -1));

        jBIngresar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBIngresar.setForeground(new java.awt.Color(0, 153, 153));
        jBIngresar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/images_1.jpg"))); // NOI18N
        jBIngresar.setText("REGISTRAR");
        jBIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBIngresarActionPerformed(evt);
            }
        });
        getContentPane().add(jBIngresar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jBLimpiar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jBLimpiar.setForeground(new java.awt.Color(0, 153, 153));
        jBLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salir1.JPG"))); // NOI18N
        jBLimpiar.setText("LIMPIAR");
        jBLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBLimpiarActionPerformed(evt);
            }
        });
        getContentPane().add(jBLimpiar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 420, 160, 40));

        jLFoto.setForeground(new java.awt.Color(0, 153, 153));
        jLFoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/principal.jpg"))); // NOI18N
        getContentPane().add(jLFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 60, 150, 160));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(0, 153, 153));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/images_2.jpg"))); // NOI18N
        jButton1.setText("ATRAS");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 420, 160, 40));

        jlhora.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jlhora.setForeground(new java.awt.Color(0, 153, 153));
        jlhora.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlhora.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        getContentPane().add(jlhora, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 490, 160, 30));

        jldata.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jldata.setForeground(new java.awt.Color(0, 153, 153));
        jldata.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jldata.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        getContentPane().add(jldata, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 160, 30));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 0, 10));

        cmdPrint.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        cmdPrint.setForeground(new java.awt.Color(0, 153, 153));
        cmdPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/imprimir.jpg"))); // NOI18N
        cmdPrint.setText("IMPRIMIR");
        cmdPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdPrintActionPerformed(evt);
            }
        });
        getContentPane().add(cmdPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
public static boolean valida(String x){
    int suma=0;
    if(x.length()==9){
      System.out.println("Ingrese su cedula de 10 digitos");
      return false;
    }else{
      int a[]=new int [x.length()/2];
      int b[]=new int [(x.length()/2)];
      int c=0;
      int d=1;
      for (int i = 0; i < x.length()/2; i++) {
        a[i]=Integer.parseInt(String.valueOf(x.charAt(c)));
        c=c+2;
        if (i < (x.length()/2)-1) {
          b[i]=Integer.parseInt(String.valueOf(x.charAt(d)));
          d=d+2;
        }
      }
    
      for (int i = 0; i < a.length; i++) {
        a[i]=a[i]*2;
        if (a[i] >9){
          a[i]=a[i]-9;
        }
        suma=suma+a[i]+b[i];
      } 
      int aux=suma/10;
      int dec=(aux+1)*10;
      if ((dec - suma) == Integer.parseInt(String.valueOf(x.charAt(x.length()-1))))
        return true;
      else
        if(suma%10==0 && x.charAt(x.length()-1)=='0'){
          return true;
        }else{
          return false;
        }
     
  }
 }

    private void jBIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBIngresarActionPerformed
   // TODO add your handling code here:
        if(formularioValido()){
            
            String id = tfId.getText();   
            String nombres = tfNombres.getText();
            String apellidos = tfApellidos.getText();
            
            String estado_civil =cbxestado_civil.getSelectedItem().toString();
            
            String direccion_actual = tfDia.getText();
            String e_mail = tfE_Mail.getText();
            String telefono =tfTelefono.getText();
            
            int edad = Integer.parseInt(tfEdad.getText());
            Empleado e = new Empleado(id,nombres,apellidos,estado_civil,direccion_actual,e_mail,telefono,edad);
            if(Archivo.insertar_registro(e)){
                JOptionPane.showMessageDialog(this
                    , "Se ingresó correctamente el registro", "Ingreso"
                    , JOptionPane.INFORMATION_MESSAGE);  
                limpiarFormulario();
            }else{
                JOptionPane.showMessageDialog(this
                    , "Error al ingresar el registro", "Error en el ingreso"
                    , JOptionPane.ERROR_MESSAGE);            
            }
        }else{
                    JOptionPane.showMessageDialog(this
                    , "Verifique datos de ingreso", "Error en el ingreso"
                    , JOptionPane.ERROR_MESSAGE); 
                    }   

        
       

    }//GEN-LAST:event_jBIngresarActionPerformed

    private void jBLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBLimpiarActionPerformed
        // TODO add your handling code here:
         limpiarFormulario();
    }//GEN-LAST:event_jBLimpiarActionPerformed

    private void tfIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfIdActionPerformed
        // TODO add your handling code here:
        
  
    }//GEN-LAST:event_tfIdActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
     FrmMantenimientoEmpleado frm = new FrmMantenimientoEmpleado();
        frm.setVisible(true);
        setLocationRelativeTo(null);    //centrar y no salga en la ezquina
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        //data
Date dataSistema = new Date();
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
jldata.setText(formato.format(dataSistema));

//hora
Timer timer =new Timer(1000 ,new hora());
timer.start();
     
    }//GEN-LAST:event_formWindowOpened

    private void tfApellidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfApellidosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfApellidosActionPerformed

    private void cbxestado_civilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxestado_civilActionPerformed
  
        
    }//GEN-LAST:event_cbxestado_civilActionPerformed

    private void cmdPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdPrintActionPerformed
    
         //del sistema, si no hay, retorna NULL
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        //Se pasa la instancia del JFrame al PrinterJob
        printerJob.setPrintable(this);
                
        //muestra ventana de dialogo para imprimir
        if ( printerJob.printDialog())
        {
            try {
                printerJob.print();
            } catch (PrinterException ex) {
            System.out.println("Error:" + ex);
            }
        }  
    }//GEN-LAST:event_cmdPrintActionPerformed

    private void tfEdadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfEdadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEdadActionPerformed

    private void tfNombresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfNombresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfNombresActionPerformed

    private void tfTelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfTelefonoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfTelefonoActionPerformed

    private void tfTelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfTelefonoKeyTyped
        // TODO add your handling code here:
        
        //Declaramos una variable y le asignamos un evento.
       
 char car=evt.getKeyChar();

if((car<'0' || car >'9' )&&(car!=(char)KeyEvent.VK_BACK_SPACE)){  
evt.consume();
getToolkit().beep();//emite sonido
  JOptionPane.showMessageDialog(this
                    , "Solo se admiten numeros", "Validar Numeros "
                    , JOptionPane.INFORMATION_MESSAGE);  
}     
        
        
        
    }//GEN-LAST:event_tfTelefonoKeyTyped

    private void tfNombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNombresKeyTyped
        // TODO add your handling code here:
          char car=evt.getKeyChar();

if((car<'a' || car >'z' )&&(car<'A' || car >'Z' ) && (car!=(char)KeyEvent.VK_BACK_SPACE)&&(car!=(char)KeyEvent.VK_SPACE)){  
evt.consume();
getToolkit().beep();//emite sonido
  JOptionPane.showMessageDialog(this
                    , "Solo se admiten Texto", "Validar Texto "
                    , JOptionPane.INFORMATION_MESSAGE);  
}     
        
        
    }//GEN-LAST:event_tfNombresKeyTyped

    private void tfApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfApellidosKeyTyped
        // TODO add your handling code here:
          char car=evt.getKeyChar();

if((car<'a' || car >'z' )&&(car<'A' || car >'Z' ) && (car!=(char)KeyEvent.VK_BACK_SPACE)&&(car!=(char)KeyEvent.VK_SPACE)){  
evt.consume();
getToolkit().beep();//emite sonido
  JOptionPane.showMessageDialog(this
                    , "Solo se admiten Texto", "Validar Texto "
                    , JOptionPane.INFORMATION_MESSAGE);  
}     
        
    }//GEN-LAST:event_tfApellidosKeyTyped

    private void tfDiaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfDiaKeyTyped
        // TODO add your handling code here:
        
          char car=evt.getKeyChar();

if((car<'a' || car >'z' )&&(car<'A' || car >'Z' ) && (car!=(char)KeyEvent.VK_BACK_SPACE)&&(car!=(char)KeyEvent.VK_SPACE)){  
evt.consume();
getToolkit().beep();//emite sonido
  JOptionPane.showMessageDialog(this
                    , "Solo se admiten Texto", "Validar Texto "
                    , JOptionPane.INFORMATION_MESSAGE);  
}     
    }//GEN-LAST:event_tfDiaKeyTyped

    private void tfEdadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfEdadKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_tfEdadKeyTyped

    public boolean isEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        mat = pat.matcher(correo);
        if (mat.find()) {
            //System.out.println("[" + mat.group() + "]");
            JOptionPane.showMessageDialog(this
                    , "El E_mail Ingresado es :[" + mat.group() + "]", "E_mail "  //ventana
                    , JOptionPane.INFORMATION_MESSAGE);  
    
            return true;
        }else{
            return false;
        }        
    }
    
    private void tfE_MailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfE_MailFocusLost
        // TODO add your handling code here:
             if(isEmail(tfE_Mail.getText())){
}else{
getToolkit().beep();//emite sonido
JOptionPane.showMessageDialog(null
                    , "Email incorrecto", "Validar Email "
                    , JOptionPane.INFORMATION_MESSAGE);  
tfE_Mail.requestFocus();
}      
    }//GEN-LAST:event_tfE_MailFocusLost

    
    
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException  {
        if (pageIndex == 0)
        {
            Graphics2D g2d = (Graphics2D) graphics;
            g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
            this.printAll(graphics);
            return PAGE_EXISTS;
        }
        else
            return NO_SUCH_PAGE;        
    }

    private java.awt.Button button1;

    
    
    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbxestado_civil;
    private javax.swing.JButton cmdPrint;
    private javax.swing.JButton jBApellidos;
    private javax.swing.JButton jBDatos;
    private javax.swing.JButton jBDia;
    private javax.swing.JButton jBE_Mail;
    private javax.swing.JButton jBEdad;
    private javax.swing.JButton jBEstado_Civil;
    private javax.swing.JButton jBId;
    private javax.swing.JButton jBIngresar;
    private javax.swing.JButton jBLimpiar;
    private javax.swing.JButton jBNombres;
    private javax.swing.JButton jBTelefono;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLFoto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel jldata;
    private javax.swing.JLabel jlhora;
    private javax.swing.JTextField tfApellidos;
    private javax.swing.JTextField tfDia;
    private javax.swing.JTextField tfE_Mail;
    private javax.swing.JTextField tfEdad;
    private javax.swing.JTextField tfId;
    private javax.swing.JTextField tfNombres;
    private javax.swing.JTextField tfTelefono;
    // End of variables declaration//GEN-END:variables

class hora implements ActionListener{
    public void actionPerformed(ActionEvent e){
        Calendar now = Calendar.getInstance();
jlhora.setText(String.format("%1$tH:%1$tM:%1$tS", now));
}
    }
}


