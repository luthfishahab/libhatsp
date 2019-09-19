package penelitian05;

public class MendapatkanFullMatrix {

    public static void main(String[] args) {
        String file[] = {
            "1.br17.atsp.txt", //0
            "2.ftv33.atsp.txt", //1
            "3.ftv35.atsp.txt", //2
            "4.ftv38.atsp.txt", //3
            "5.p43.atsp.txt", //4
            "6.ftv44.atsp.txt", //5
            "7.ftv47.atsp.txt", //6
            "8.ry48p.atsp.txt", //7
            "9.ft53.atsp.txt", //8
            "10.ftv55.atsp.txt", //9
            "11.ftv64.atsp.txt", //10
            "12.ft70.atsp.txt", //11
            "13.ftv70.atsp.txt", //12
            "14.kro124p.atsp.txt", //13
            "15.ftv170.atsp.txt", //14
            "16.rbg323.atsp.txt", //15
            "17.rbg358.atsp.txt", //16
            "18.rbg403.atsp.txt", //17
            "19.rbg443.atsp.txt" //18
        };
        
        for(int i = 0; i < 19; i++) {
            String path = "D:\\2. Articles or Conference Papers\\05. LIBHATSP, A Library of Heuristic Algorithms for The Traveling Salesman Problem\\2. Data\\5. Data Setelah Disederhanakan\\" + file[i];
            Library.CreateMatrix(path, file[i]);
        }
    }

}