/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renamefilebytext;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import static javax.swing.JFileChooser.DIRECTORIES_ONLY;
import static javax.swing.JFileChooser.FILES_AND_DIRECTORIES;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author msi1
 */
public class Form extends javax.swing.JFrame {

    /**
     * Creates new form Form
     */
    public Form() {
        try {
          UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch(Exception e){}
        initComponents();
    }
    
    public static String getFileExtension(File file) {
		String fileName = file.getName();
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
			return fileName.substring(i + 1);
		}
		// Возвращаем пустую строку если нет расширения
		return "";
	}
    
    public void save_files(){
        String[] directory_output_lines=jTA_Directory_Output.getText().split("\n");
        
        for(Integer change_file_index: change_files_index){
               try{    
                    File newfile=new File(folder_path.toString()+"\\"+directory_output_lines[change_file_index]);          
                    files.get(change_file_index).renameTo(newfile); 
               }catch(Exception ex){
                   int i=JOptionPane.showConfirmDialog(null,"не удается переименовать файл: "+
                           folder_path.toString()+"\\"+directory_output_lines[change_file_index],
                                 "Error",JOptionPane.OK_CANCEL_OPTION,JOptionPane.ERROR_MESSAGE);
                   if(i==JOptionPane.CANCEL_OPTION){
                       break;
                   }
               }
        }
    }
    
    public void save_txtfile(File file){
        try(FileWriter writer = new FileWriter(file))
        {
            writer.write(jTA_File_Output.getText());          
            writer.flush();
        }catch(FileNotFoundException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        catch(IOException ex){
            JOptionPane.showMessageDialog(null,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            return;
        }
        JOptionPane.showMessageDialog(null,"Файл сохранен","Информация",JOptionPane.INFORMATION_MESSAGE);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        jFC_save = new javax.swing.JFileChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTA_File_Output = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTA_Directory_Output = new javax.swing.JTextArea();
        jB_save_files = new javax.swing.JButton();
        jB_save_txtfile = new javax.swing.JButton();
        jB_open_txtfile = new javax.swing.JButton();
        jB_open_Dir = new javax.swing.JButton();
        jB_next = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jCB_separator = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jTF_file_type = new javax.swing.JTextField();
        jL_file_name = new javax.swing.JLabel();
        jL_dir_name = new javax.swing.JLabel();
        jB_save_as_txtfile = new javax.swing.JButton();

        jFileChooser1.setCurrentDirectory(directory);

        jFC_save.setDialogType(javax.swing.JFileChooser.SAVE_DIALOG);
        jFC_save.setCurrentDirectory(directory);
        jFC_save.setFileFilter(file_filter);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Переименование файлов по шаблону");
        setResizable(false);

        jTA_File_Output.setColumns(20);
        jTA_File_Output.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTA_File_Output.setRows(5);
        jScrollPane1.setViewportView(jTA_File_Output);

        jTA_Directory_Output.setColumns(20);
        jTA_Directory_Output.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        jTA_Directory_Output.setRows(5);
        jScrollPane2.setViewportView(jTA_Directory_Output);

        jB_save_files.setText("сохранить");
        jB_save_files.setEnabled(false);
        jB_save_files.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_save_filesActionPerformed(evt);
            }
        });

        jB_save_txtfile.setText("сохранить");
        jB_save_txtfile.setEnabled(false);
        jB_save_txtfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_save_txtfileActionPerformed(evt);
            }
        });

        jB_open_txtfile.setText("Открыть файл");
        jB_open_txtfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_open_txtfileActionPerformed(evt);
            }
        });

        jB_open_Dir.setText("Открыть папку");
        jB_open_Dir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_open_DirActionPerformed(evt);
            }
        });

        jB_next.setFont(new java.awt.Font("Tahoma", 0, 8)); // NOI18N
        jB_next.setText(">>");
        jB_next.setEnabled(false);
        jB_next.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_nextActionPerformed(evt);
            }
        });

        jLabel3.setText("разделитель");

        jCB_separator.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "=", "", "-", "_" }));

        jLabel1.setText("Тип Файла");

        jTF_file_type.setText("gif");

        jL_file_name.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jL_file_name.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);

        jB_save_as_txtfile.setText("сохранить как");
        jB_save_as_txtfile.setEnabled(false);
        jB_save_as_txtfile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jB_save_as_txtfileActionPerformed(evt);
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jB_next))
                            .addComponent(jL_file_name, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jL_dir_name, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jB_save_as_txtfile)
                            .addComponent(jB_open_txtfile)
                            .addComponent(jB_save_txtfile))
                        .addGap(221, 221, 221)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jCB_separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(jTF_file_type)))
                        .addGap(168, 168, 168)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jB_save_files)
                            .addComponent(jB_open_Dir))
                        .addGap(104, 104, 104)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTF_file_type, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jCB_separator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jB_open_Dir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jB_save_files))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jB_open_txtfile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jB_save_txtfile)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jB_save_as_txtfile)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jL_file_name, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jB_next, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 605, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jL_dir_name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 613, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jB_open_txtfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_open_txtfileActionPerformed
        int ret = jFileChooser1.showDialog(null, "Открыть файл");               
        if (ret == JFileChooser.APPROVE_OPTION){
            
          FileInputStream FIS=null;
          try{
                 jTA_File_Output.setText("");
                 text_file = jFileChooser1.getSelectedFile();
                 FIS=new FileInputStream(text_file);
                 BufferedReader reader = new BufferedReader(new InputStreamReader(FIS, StandardCharsets.UTF_8));

                 while ((line = reader.readLine()) != null) {
                        jTA_File_Output.setText(jTA_File_Output.getText()+line+"\n");
                    }
                 jB_next.setEnabled(true);//активируем кнопку >>
                 jB_save_txtfile.setEnabled(true);//активируем кнопку "Сохранить"
                 jB_save_as_txtfile.setEnabled(true);//активируем кнопку "Сохранить как"
            }catch(FileNotFoundException e){
               jTA_File_Output.setText("файл не найден\n");
            }catch (IOException e){
               jTA_File_Output.setText("ошибка в открытии файла\n");
            }finally {
                    try {
                        if(FIS!=null)
                           FIS.close();
                    } catch (IOException ex) {
                        jTA_File_Output.setText(ex.getMessage());
                    }
            }
          jL_file_name.setText(text_file.getPath());
        }
    }//GEN-LAST:event_jB_open_txtfileActionPerformed

    private void jB_open_DirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_open_DirActionPerformed
        jTA_Directory_Output.setText("");
        jFileChooser1.setFileSelectionMode(DIRECTORIES_ONLY);
        int ret = jFileChooser1.showDialog(null, "Открыть папку");               
        if (ret == JFileChooser.APPROVE_OPTION){
           int i=0;
           directory=jFileChooser1.getSelectedFile();
           folder_path=directory.toPath();
           // если объект представляет каталог
           if(directory.isDirectory()){
                // получаем все вложенные объекты в каталоге
                for(File item : directory.listFiles()){  
                   if(item.isFile()){
                       if(jTF_file_type.getText().isEmpty() || 
                               getFileExtension(item).equals(jTF_file_type.getText())){
                          files.add(item);
                          files_name.add(item.getName());
                          jTA_Directory_Output.setText(jTA_Directory_Output.getText()+item.getName()+"\n"); 
                       }
                   }                
                }
                jB_save_files.setEnabled(true);
           }
           jL_dir_name.setText(directory.getPath());
        }
    }//GEN-LAST:event_jB_open_DirActionPerformed

    private void jB_nextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_nextActionPerformed
      if(!jTA_File_Output.getText().isEmpty()){
                   
         String file_type="."+jTF_file_type.getText();
         String directory_output_text="";
         String[] directory_output_lines=jTA_Directory_Output.getText().split("\n");
         String[] File_Output_lines=jTA_File_Output.getText().split("\n");
         
         for(String item : File_Output_lines){             
             String[] items=item.split(jCB_separator.getSelectedItem().toString());
             if(!items[0].isEmpty()){
                 for(int i=0;i<directory_output_lines.length;i++){
                     if((items[0]+file_type).equals(directory_output_lines[i])){
                         change_files_index.add(i);
                         directory_output_lines[i]=items[1]+file_type;
                         break;
                     }
                 }
             }    
         }
         jTA_Directory_Output.setText(""); 
         for(String directory_output_line : directory_output_lines){
            jTA_Directory_Output.setText(jTA_Directory_Output.getText()+directory_output_line+'\n'); 
         }
       }
    }//GEN-LAST:event_jB_nextActionPerformed

    private void jB_save_txtfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_save_txtfileActionPerformed
        save_txtfile(text_file);
    }//GEN-LAST:event_jB_save_txtfileActionPerformed

    private void jB_save_filesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_save_filesActionPerformed
        save_files();
    }//GEN-LAST:event_jB_save_filesActionPerformed

    private void jB_save_as_txtfileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jB_save_as_txtfileActionPerformed
        int ret = jFC_save.showDialog(null, "сохранить файл");               
        if (ret == JFileChooser.APPROVE_OPTION){            
            save_txtfile(jFC_save.getSelectedFile());
        }
    }//GEN-LAST:event_jB_save_as_txtfileActionPerformed

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
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }
    
//my variables
    final String dir = System.getProperty("user.dir");//выбор с текущей дерриктории
    File directory=new File(dir);
    File text_file=new File(dir);
    FileFilter file_filter = new FileNameExtensionFilter("TXT file","txt");
    String line;
    List<File> files= new ArrayList<>();
    List<String> file_lines= new ArrayList<>(); 
    List<String> files_name= new ArrayList<>();
    List<Integer> change_files_index= new ArrayList<>();
    Path folder_path;
//my variables end
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jB_next;
    private javax.swing.JButton jB_open_Dir;
    private javax.swing.JButton jB_open_txtfile;
    private javax.swing.JButton jB_save_as_txtfile;
    private javax.swing.JButton jB_save_files;
    private javax.swing.JButton jB_save_txtfile;
    private javax.swing.JComboBox<String> jCB_separator;
    private javax.swing.JFileChooser jFC_save;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jL_dir_name;
    private javax.swing.JLabel jL_file_name;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTA_Directory_Output;
    private javax.swing.JTextArea jTA_File_Output;
    private javax.swing.JTextField jTF_file_type;
    // End of variables declaration//GEN-END:variables
}
