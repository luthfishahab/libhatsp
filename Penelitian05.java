package penelitian05;

public class Penelitian05 {

    public static void main(String[] args) throws Exception{
        for(int i = 1; i <= 8; i++) {
            System.out.println("\\draw (" + (double)i*1.5 + ",0) node [below] {\\scriptsize $" + i*10 +"$};");
        }
        
        for(int i = 91; i <= 100; i++) {
            System.out.println("\\draw (0," + (double)(i-90)/2 + ") node [left] {\\scriptsize $" + i +"$};");
        }
        
        for(int i = 1; i <= 8; i++) {
            System.out.println("\\draw [-] (" + (double)i*1.5 + ",-0.05) -- (" + (double)i*1.5 + ",0.05);");
        }
        
        for(int i = 91; i <= 100; i++) {
            System.out.println("\\draw [-] (-0.05," + (double)(i-90)/2 + ") -- (0.05," + (double)(i-90)/2 + ");");
        }
    }
    
}