package proyectox.view;

import java.io.File;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import proyectox.ProyectoX;
import proyectox.model.Pelicula;


/**
 *
 * @author Carlos Cedeño <caencede@espol.edu.ec>
 */
public class GUI extends javax.swing.JFrame {
    public static final String MOVIES_TITLES = "data/download/movie_titles.txt";
    public static String NOMBRERESUMEN = "resumen.x";
    ArrayList<Pelicula> peliculas;
    /**
     * Crea el Form principal
     */
    
    public GUI() {
        initComponents();
    }

    /**
     *Codigo generado por el GUI Builder de Netbeans, donde se declaran los componentes
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        noexiste = new javax.swing.JFrame();
        progreso = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        BtnOK = new javax.swing.JButton();
        resumenEncontrado = new javax.swing.JFrame();
        jLabel2 = new javax.swing.JLabel();
        BtnAnteriorResumen = new javax.swing.JButton();
        BtnNuevoResumen = new javax.swing.JButton();
        jFrame2 = new javax.swing.JFrame();
        Txt1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        ListaOperacion = new javax.swing.JComboBox();
        Label1 = new javax.swing.JLabel();
        ListaCategoria = new javax.swing.JComboBox();
        BtnGenerarReporte = new javax.swing.JButton();
        comentarioResumen = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        saveMenuItem = new javax.swing.JMenuItem();
        saveAsMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        cutMenuItem = new javax.swing.JMenuItem();
        copyMenuItem = new javax.swing.JMenuItem();
        pasteMenuItem = new javax.swing.JMenuItem();
        deleteMenuItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        contentsMenuItem = new javax.swing.JMenuItem();
        aboutMenuItem = new javax.swing.JMenuItem();

        noexiste.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        noexiste.setAlwaysOnTop(true);
        noexiste.setMinimumSize(null);
        noexiste.setResizable(false);

        jLabel3.setText("Resumen no encontrado.Al seleccionar 'Ok' se empezará a generar el resumen");

        BtnOK.setText("Ok");
        BtnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnOKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout noexisteLayout = new javax.swing.GroupLayout(noexiste.getContentPane());
        noexiste.getContentPane().setLayout(noexisteLayout);
        noexisteLayout.setHorizontalGroup(
            noexisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noexisteLayout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(progreso)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noexisteLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addGroup(noexisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noexisteLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, noexisteLayout.createSequentialGroup()
                        .addComponent(BtnOK)
                        .addGap(210, 210, 210))))
        );
        noexisteLayout.setVerticalGroup(
            noexisteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(noexisteLayout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(progreso)
                .addGap(18, 18, 18)
                .addComponent(BtnOK)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        noexiste.pack();

        resumenEncontrado.setAlwaysOnTop(true);
        resumenEncontrado.setFocusableWindowState(false);
        resumenEncontrado.setResizable(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Se ha encontrado un anterior archivo de resumen, ¿Desea cargar ese o generar uno nuevo?");

        BtnAnteriorResumen.setText("Cargar anterior resumen");
        BtnAnteriorResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAnteriorResumenActionPerformed(evt);
            }
        });

        BtnNuevoResumen.setText("Generar nuevo resumen");
        BtnNuevoResumen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnNuevoResumenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout resumenEncontradoLayout = new javax.swing.GroupLayout(resumenEncontrado.getContentPane());
        resumenEncontrado.getContentPane().setLayout(resumenEncontradoLayout);
        resumenEncontradoLayout.setHorizontalGroup(
            resumenEncontradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, resumenEncontradoLayout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addGroup(resumenEncontradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2)
                    .addGroup(resumenEncontradoLayout.createSequentialGroup()
                        .addComponent(BtnAnteriorResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(BtnNuevoResumen, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(101, 101, 101))
        );
        resumenEncontradoLayout.setVerticalGroup(
            resumenEncontradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(resumenEncontradoLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(resumenEncontradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BtnAnteriorResumen)
                    .addComponent(BtnNuevoResumen))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        resumenEncontrado.pack();
        resumenEncontrado.setVisible(false);

        javax.swing.GroupLayout jFrame2Layout = new javax.swing.GroupLayout(jFrame2.getContentPane());
        jFrame2.getContentPane().setLayout(jFrame2Layout);
        jFrame2Layout.setHorizontalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame2Layout.setVerticalGroup(
            jFrame2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        Txt1.setToolTipText("");
        Txt1.setVerifyInputWhenFocusTarget(false);

        jLabel1.setText("Seleccione operación a realizar: ");

        ListaOperacion.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Consultar top 10 por categoría", "Listar películas por año","Buscar película","Mostrar películas por orden alfabético descendente","Mostrar películas por año descendente","Mostrar películas ordenadas por categoría" }));
        ListaOperacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListaOperacionActionPerformed(evt);
            }
        });

        Label1.setText("Id Cliente: ");
        Label1.setEnabled(true);

        ListaCategoria.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1 estrella", "2 estrellas", "3 estrellas", "4 estrellas", "5 estrellas" }));

        BtnGenerarReporte.setText("Generar Reporte");
        BtnGenerarReporte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnGenerarReporteActionPerformed(evt);
            }
        });

        comentarioResumen.setText("No se cargo ningun resumen.");

        fileMenu.setMnemonic('f');
        fileMenu.setText("File");

        openMenuItem.setMnemonic('o');
        openMenuItem.setText("Open");
        fileMenu.add(openMenuItem);

        saveMenuItem.setMnemonic('s');
        saveMenuItem.setText("Save");
        fileMenu.add(saveMenuItem);

        saveAsMenuItem.setMnemonic('a');
        saveAsMenuItem.setText("Save As ...");
        saveAsMenuItem.setDisplayedMnemonicIndex(5);
        fileMenu.add(saveAsMenuItem);

        exitMenuItem.setMnemonic('x');
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        menuBar.add(fileMenu);

        editMenu.setMnemonic('e');
        editMenu.setText("Edit");

        cutMenuItem.setMnemonic('t');
        cutMenuItem.setText("Cut");
        editMenu.add(cutMenuItem);

        copyMenuItem.setMnemonic('y');
        copyMenuItem.setText("Copy");
        editMenu.add(copyMenuItem);

        pasteMenuItem.setMnemonic('p');
        pasteMenuItem.setText("Paste");
        editMenu.add(pasteMenuItem);

        deleteMenuItem.setMnemonic('d');
        deleteMenuItem.setText("Delete");
        editMenu.add(deleteMenuItem);

        menuBar.add(editMenu);

        helpMenu.setMnemonic('h');
        helpMenu.setText("Help");

        contentsMenuItem.setMnemonic('c');
        contentsMenuItem.setText("Contents");
        helpMenu.add(contentsMenuItem);

        aboutMenuItem.setMnemonic('a');
        aboutMenuItem.setText("About");
        helpMenu.add(aboutMenuItem);

        menuBar.add(helpMenu);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(Label1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ListaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ListaOperacion, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(114, 114, 114))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnGenerarReporte)
                    .addComponent(comentarioResumen))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(ListaOperacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label1)
                    .addComponent(ListaCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(comentarioResumen)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(BtnGenerarReporte)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ListaCategoria.setVisible(false);
        comentarioResumen.setVisible(false);

        pack();
    }// </editor-fold>                        

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {                                             
        System.exit(0);
    }                                            

    private void ListaOperacionActionPerformed(java.awt.event.ActionEvent evt) {                                               
        /**
         * Establece el ambiente de trabajo al seleccionar una operación.
         * No genera ningun reporte.
         * @author Carlos Cedeño <caencede@espol.edu.ec>
         */
        if (ListaOperacion.getSelectedItem().toString().equals("Consultar top 10 por categoría")){
            Label1.setVisible(true);
            Label1.setText("Seleccione categoría: ");
            activarLista();
        }
        
        if (ListaOperacion.getSelectedItem().toString().equals("Listar películas por año")){
            Label1.setEnabled(true);
            Label1.setText("Ingrese año: ");
            activarTxt();
        }
        if (ListaOperacion.getSelectedItem().toString().equals("Buscar película")){
            Label1.setEnabled(true);
            Label1.setVisible(true);
            Label1.setText("Ingrese palabras a comparar");
            activarTxt();
            Txt1.requestFocus();
        }
        if (ListaOperacion.getSelectedItem().toString().equals("Mostrar películas por orden alfabético descendente")){
            Label1.setVisible(false);
            Txt1.setVisible(false);
            ListaCategoria.setVisible(false);
        }
        if (ListaOperacion.getSelectedItem().toString().equals("Mostrar películas por año descendente" )){
            Label1.setVisible(false);
            Txt1.setVisible(false);
            ListaCategoria.setVisible(false);
        }
        if (ListaOperacion.getSelectedItem().toString().equals("Mostrar películas ordenadas por categoría" )){
            Label1.setVisible(false);
            Txt1.setVisible(false);
            ListaCategoria.setVisible(false);     
        }
    }                                              

    private void BtnOKActionPerformed(java.awt.event.ActionEvent evt) {                                      
        /*
         * Procede a generar el resumen de no ser encontrado un anterior.
         * @author Carlos Cedeño <caencede@espol.edu.ec>
         */
        noexiste.setVisible(false);
        JOptionPane.showMessageDialog(null,"Espere a que se haya terminado la carga");
        peliculas= ProyectoX.cargar(true);
        comentarioResumen.setText("Resumen Cargado");
        comentarioResumen.setVisible(false);
        BtnGenerarReporte.setVisible(true);

    }                                     

    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  
        /*
         * Establece si se generará un nuevo resumen o su usara el anterior encontrado.
         * @author Carlos Cedeño <caencede@espol.edu.ec>
         */
        String sFichero = "resumen.x";
        ListaOperacion.setSelectedItem("Consultar top 10 por categoría");
        File fichero = new File(sFichero);
        if (fichero.exists()){
            System.out.println("existe");
            BtnGenerarReporte.setVisible(false);
            comentarioResumen.setVisible(true);
            resumenEncontrado.setVisible(true);
        }else{
            System.out.println("no existe");
            BtnGenerarReporte.setVisible(false);
            comentarioResumen.setVisible(true);
            noexiste.setVisible(true);
          }
    }                                 

    private void BtnAnteriorResumenActionPerformed(java.awt.event.ActionEvent evt) {                                                   
          /*
           * Acciones a realizar en caso querer usar un resumen antiguo.
           * @author Carlos Cedeño <caencede@espol.edu.ec>
           */
          resumenEncontrado.setVisible(false);
          JOptionPane.showMessageDialog(null,"Se usará el resumen anterior.");
          comentarioResumen.setVisible(false);
          BtnGenerarReporte.setVisible(true);
          peliculas= ProyectoX.cargar(false);
        
    }                                                  

    private void BtnNuevoResumenActionPerformed(java.awt.event.ActionEvent evt) {                                                
        /*
           * Acciones a realizar en caso querer generar un nuevo resumen.
           * @author Carlos Cedeño <caencede@espol.edu.ec>
           */
        resumenEncontrado.setVisible(false);
        JOptionPane.showMessageDialog(null,"Se creará un nuevo resumen, esta operación puede tardar algun tiempo. Por favor espere.");
        peliculas= ProyectoX.cargar(true);
        BtnGenerarReporte.setVisible(true);
        comentarioResumen.setVisible(false);
    }                                               

    private void BtnGenerarReporteActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        /*
         * Establece los rumbos que toma la aplicacion al momento de generar el resumen.
         * @author Carlos Cedeño <caencede@espol.edu.ec>
         */
        if (ListaOperacion.getSelectedItem().toString().equals("Consultar top 10 por categoría")){
            JOptionPane.showMessageDialog (null,"Trabajando en ello ;)");
        }
        
        if (ListaOperacion.getSelectedItem().toString().equals("Listar películas por año")){
            try{
            int ano= Integer.parseInt(Txt1.getText().trim());
            ProyectoX.generarListaDeAnio(peliculas,ano );
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Datos ingresados inválidos");
            }
        }
        if (ListaOperacion.getSelectedItem().toString().equals("Buscar película")){
            try{
            String frase = Txt1.getText().toLowerCase().trim().replaceAll(" ", "");
            ProyectoX.generarCoincidenciasDePalabra(peliculas,frase);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Datos ingresados inválidos");
            }
        }
        if (ListaOperacion.getSelectedItem().toString().equals("Mostrar películas por orden alfabético descendente")){
            try{
            ProyectoX.generarListaABC(peliculas);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Oops! algo salió mal!");
            }
        }
        if (ListaOperacion.getSelectedItem().toString().equals("Mostrar películas por año descendente" )){
            try{
            ProyectoX.generarListaXAno(peliculas);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Oops! algo salió mal!");
            }
        }
        if (ListaOperacion.getSelectedItem().toString().equals("Mostrar películas ordenadas por categoría" )){
            try{
            ProyectoX.generarListaXCalificacion(peliculas);
            }catch (Exception e){
                JOptionPane.showMessageDialog(null,"Oops! algo salió mal!");
            }
        }
    }                                                 
    
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
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new GUI().setVisible(true);   
            }
        });
        
     
        
    }
    // Variables declaration - do not modify                     
    private javax.swing.JButton BtnAnteriorResumen;
    private javax.swing.JButton BtnGenerarReporte;
    private javax.swing.JButton BtnNuevoResumen;
    private javax.swing.JButton BtnOK;
    private javax.swing.JLabel Label1;
    private javax.swing.JComboBox ListaCategoria;
    private javax.swing.JComboBox ListaOperacion;
    public javax.swing.JTextField Txt1;
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JLabel comentarioResumen;
    private javax.swing.JMenuItem contentsMenuItem;
    private javax.swing.JMenuItem copyMenuItem;
    private javax.swing.JMenuItem cutMenuItem;
    private javax.swing.JMenuItem deleteMenuItem;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JFrame jFrame2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenuBar menuBar;
    private static javax.swing.JFrame noexiste;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.JMenuItem pasteMenuItem;
    public static javax.swing.JLabel progreso;
    private static javax.swing.JFrame resumenEncontrado;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    // End of variables declaration                   

private void activarTxt(){
    Txt1.setVisible(true);
    ListaCategoria.setVisible(false);
    Txt1.setEditable(true);
    Txt1.requestFocusInWindow();
}

private void activarLista(){
    ListaCategoria.setVisible(true);
    Txt1.setVisible(false);
}

}

