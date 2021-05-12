package Clases;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class Validar {
    public void ValidarSoloLetras(JTextField campo){
        campo.addKeyListener(new KeyAdapter(){
        public void keyTyped(KeyEvent e){
            char c= e.getKeyChar();
            
            if(Character.isDigit(c)){
                e.consume();
            }
        }
        });
    }
    public void ValidarSoloNumeros(JTextField campo){
        campo.addKeyListener(new KeyAdapter(){
        public void keyTyped(KeyEvent e){
            char c= e.getKeyChar();
            
            if(!Character.isDigit(c)){
                e.consume();
            }
        }
        });
}
      public void Limitar(JTextField campo, int Cantidad){
        campo.addKeyListener(new KeyAdapter(){
        public void keyTyped(KeyEvent e){
            char c= e.getKeyChar();
            int tam= campo.getText().length();
            if(tam>=Cantidad){
                e.consume();
            }
        }
        });
      }
      
}
