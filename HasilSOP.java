package penelitian05;

public class HasilSOP {

    public static void main(String[] args) {
        String file[] = {
            "esc07.sop.txt", //0 2125
            "esc12.sop.txt", //1 1675
        };
        
        int index = 0;
        String path = "D:\\2. Articles or Conference Papers\\05. LIBHATSP, A Library of Heuristic Algorithms for The Traveling Salesman Problem\\2. Data\\9. Data Full Matrix\\" + file[index];
        Library.LoadDSOP(path);
        Library.PrintD();
        
        //int s[] = Library.NearestNeighborAlgorithmSOP();
        int s[] = {0,3,2,1,6,7,4,5,8};
        Library.Print(s);
        System.out.println(Library.GetDistanceSOP(s));
        System.out.println();
        
        //s = Library.FasterShahabHeuristicAlgorithmSOP(s, 200); 
        int distance[] = {Library.GetDistanceSOP(s)};
        //s = Library.FasterShahabOperatorSOP(s, 1, 2, distance);
        //s = Library.FasterShahabAlgorithmSOP(s, 2, distance);
        Library.Print(s);
        System.out.println(Library.GetDistanceSOP(s));
        System.out.println();
    }
    
}
