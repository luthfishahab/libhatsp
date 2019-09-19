package penelitian05;

public class HasilAsymmetricTSP {

    public static void main(String[] args) {
        String file[] = {
            "1.br17.atsp.txt", //0 39
            "2.ftv33.atsp.txt", //1 1286
            "3.ftv35.atsp.txt", //2 1473
            "4.ftv38.atsp.txt", //3 1530
            "5.p43.atsp.txt", //4 5620
            "6.ftv44.atsp.txt", //5 1613
            "7.ftv47.atsp.txt", //6 1776
            "8.ry48p.atsp.txt", //7 14422
            "9.ft53.atsp.txt", //8 6905
            "10.ftv55.atsp.txt", //9 1608
            "11.ftv64.atsp.txt", //10 1839
            "12.ft70.atsp.txt", //11 38673
            "13.ftv70.atsp.txt", //12 1950
            "14.kro124p.atsp.txt", //13 36230
            "15.ftv170.atsp.txt", //14 2755
            "16.rbg323.atsp.txt", //15 1326
            "17.rbg358.atsp.txt", //16 1163
            "18.rbg403.atsp.txt", //17 2465
            "19.rbg443.atsp.txt" //18 2720
        };
        
        
        int index = 17;
        String path = "D:\\2. Articles or Conference Papers\\05. LIBHATSP, A Library of Heuristic Algorithms for The Traveling Salesman Problem\\2. Data\\6. Data Full Matrix\\" + file[index];
        Library.LoadD(path);
        
        int s[] = Library.RandomPermutation();
        int d = Library.GetDistance(s);
        int e[] = {d};
        System.out.println(d);
        
        s = Library.FasterReverseHeuristicAlgorithmATSP(s, 100, e);
        System.out.println("hasil : " + e[0]);
        System.out.println("hasil : " + Library.GetDistance(s));
        
        /*
        int jumlah_percobaan = 30;
        for(int index = 0; index < file.length; index++) {
            String path = "D:\\2. Articles or Conference Papers\\05. LIBHATSP, A Library of Heuristic Algorithms for The Traveling Salesman Problem\\2. Data\\6. Data Full Matrix\\" + file[index];
            Library.LoadD(path);

            int I = jumlah_percobaan;
            int skor[] = new int[I];
            long startTime1 = 0;
            long totalTime1 = 0;
            for(int i = 0; i < I; i++) {
                startTime1 = System.nanoTime();
                
                int s[] = Library.AsymmetricTSP();
                
                totalTime1 += System.nanoTime() - startTime1;

                skor[i] = Library.GetDistance(s);
                
                //Library.Print(s);
                //System.out.println(skor[i]);
            }
            System.out.print(file[index] + "\t");
            System.out.print(Library.Min(skor) + "\t");
            System.out.println(((double)totalTime1/1000000000)/I);
            //System.out.println();
        }
        */
    }
    
}