// 22 Agustus 2019, 09:00
package penelitian05;

import java.awt.*;
import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.*;

public class ShowResult extends JFrame{
    public ShowResult() throws Exception{
        Surface1 tampilan = new Surface1();
        add(tampilan); 
        setTitle("Result");
        setSize(1366, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        getSaveSnapShot(tampilan, "gambar.jpg");
    }
    
    public void getSaveSnapShot(Component a, String b) throws Exception {
        BufferedImage img = getScreenShot(a);
        ImageIO.write(img, "png", new File(b));
    }
    
    public BufferedImage getScreenShot(Component a) {
        BufferedImage image = new BufferedImage(a.getWidth(), a.getHeight(),BufferedImage.TYPE_INT_RGB);
        a.paint(image.getGraphics());
        return image;
    }
}

class Surface1 extends JPanel{ 
    private int[] X;
    private int[] Y;
    private int Jumlah;
    private int[] result = Library.GetResult();
    private double pembagi = 0.1;
    
    public Surface1 (){
        int[][] x = Library.GetCoordinate();
        int n = x.length;
        Jumlah = n;
        X = new int[n];
        Y = new int[n];
        for(int i = 0; i < n; i++) {
            // ini diganti menyusuaian ukuran
            X[i] = (int)x[i][0];
            Y[i] = (int)x[i][1];
        }
        
        /*
        int min_x = Library.Min(X);
        int max_x = Library.Max(X);
        
        int min_y = Library.Min(Y);
        int max_y = Library.Max(Y);
        
        int rentang_x = max_x - min_x;
        int rentang_y = max_y - min_y;
        
        for(int i = 0; i < n; i++) {
            X[i] = X[i] - min_x;
            Y[i] = Y[i] - min_y;
        }
        
        for(int i = 0; i < n; i++) {
            X[i] = (int)((double)X[i] * 750 / (double)rentang_x) + 25;
            Y[i] = (int)((double)Y[i] * 550 / (double)rentang_y) + 25;
            Y[i] = 600 - Y[i];
        }
        */
    }
    
    private void doDrawing(Graphics g){
        Graphics g2d = (Graphics2D) g;
        
        Color r = Color.RED;
        Color bc = Color.BLACK;
        
        g2d.setColor(bc);
        for(int i = 0 ; i < Jumlah-1 ; i++) {
            //g2d.drawLine(X[result[i]],Y[result[i]],X[result[i+1]],Y[result[i+1]]);
        }
        //g2d.drawLine(X[result[0]],Y[result[0]],X[result[Jumlah-1]],Y[result[Jumlah-1]]);
        
        g2d.setColor(r);
        for(int i = 0 ; i < Jumlah ; i++) {
            //ini jari-jari lingkaran
            int z = 0;
            //g2d.fillOval(X[i]-z,Y[i]-z,2*z+1,2*z+1);
            
            //g2d.drawLine(X[i]-1,Y[i]-1,X[i]-1,Y[i]-1);
            g2d.drawLine(X[i]  ,Y[i]-1,X[i]  ,Y[i]-1);
            //g2d.drawLine(X[i]+1,Y[i]-1,X[i]+1,Y[i]-1);
            g2d.drawLine(X[i]-1,Y[i]  ,X[i]-1,Y[i]);
            g2d.drawLine(X[i]  ,Y[i]  ,X[i]  ,Y[i]);
            g2d.drawLine(X[i]+1,Y[i]  ,X[i]+1,Y[i]);
            //g2d.drawLine(X[i]-1,Y[i]+1,X[i]-1,Y[i]+1);
            g2d.drawLine(X[i]  ,Y[i]+1,X[i]  ,Y[i]+1);
            //g2d.drawLine(X[i]+1,Y[i]+1,X[i]+1,Y[i]+1);
            
            //g2d.drawString(i + "", X[i]+2, Y[i]-2);
        }
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        doDrawing(g);
    }
}