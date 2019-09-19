package penelitian05;

public class PrintU1060 {

    public static void main(String[] args) throws Exception{
        String file[] = {
            "1.burma14.tsp.txt", //0
            "2.ulysses16.tsp.txt", //1
            "3.gr17.tsp.txt", //2
            "4.gr21.tsp.txt", //3
            "5.ulysses22.tsp.txt", //4
            "6.gr24.tsp.txt", //5
            "7.fri26.tsp.txt", //6
            "8.bayg29.tsp.txt", //7
            "9.bays29.tsp.txt", //8
            "10.dantzig42.tsp.txt", //9
            "11.swiss42.tsp.txt", //10
            "12.att48.tsp.txt", //11
            "13.gr48.tsp.txt", //12
            "14.hk48.tsp.txt", //13
            "15.eil51.tsp.txt", //14
            "16.berlin52.tsp.txt", //15
            "17.brazil58.tsp.txt", //16
            "18.st70.tsp.txt", //17
            "19.eil76.tsp.txt", //18
            "20.pr76.tsp.txt", //19
            "21.gr96.tsp.txt", //20
            "22.rat99.tsp.txt", //21
            "23.kroA100.tsp.txt", //22
            "24.kroB100.tsp.txt", //23
            "25.kroC100.tsp.txt", //24
            "26.kroD100.tsp.txt", //25
            "27.kroE100.tsp.txt", //26
            "28.rd100.tsp.txt", //27
            "29.eil101.tsp.txt", //28
            "30.lin105.tsp.txt", //29
            "31.pr107.tsp.txt", //30
            "32.gr120.tsp.txt", //31
            "33.pr124.tsp.txt", //32
            "34.bier127.tsp.txt", //33
            "35.ch130.tsp.txt", //34
            "36.pr136.tsp.txt", //35
            "37.gr137.tsp.txt", //36
            "38.pr144.tsp.txt", //37
            "39.ch150.tsp.txt", //38
            "40.kroA150.tsp.txt", //39
            "41.kroB150.tsp.txt", //40
            "42.pr152.tsp.txt", //41
            "43.u159.tsp.txt", //42
            "44.si175.tsp.txt", //43
            "45.brg180.tsp.txt", //44
            "46.rat195.tsp.txt", //45
            "47.d198.tsp.txt", //46
            "48.kroA200.tsp.txt", //47
            "49.kroB200.tsp.txt", //48
            "50.gr202.tsp.txt", //49
            "51.ts225.tsp.txt", //50
            "52.tsp225.tsp.txt", //51
            "53.pr226.tsp.txt", //52
            "54.gr229.tsp.txt", //53
            "55.gil262.tsp.txt", //54
            "56.pr264.tsp.txt", //55
            "57.a280.tsp.txt", //56
            "58.pr299.tsp.txt", //57
            "59.lin318.tsp.txt", //58
            "61.rd400.tsp.txt", //59
            "62.fl417.tsp.txt", //60
            "63.gr431.tsp.txt", //61
            "64.pr439.tsp.txt", //62
            "65.pcb442.tsp.txt", //63
            "66.d493.tsp.txt", //64
            "67.att532.tsp.txt", //65
            "68.ali535.tsp.txt", //66
            "69.si535.tsp.txt", //67
            "70.pa561.tsp.txt", //68
            "71.u574.tsp.txt", //69
            "72.rat575.tsp.txt", //70
            "73.p654.tsp.txt", //71
            "74.d657.tsp.txt", //72
            "75.gr666.tsp.txt", //73
            "76.u724.tsp.txt", //74
            "77.rat783.tsp.txt", //75
            "78.dsj1000.tsp.txt", //76
            "79.pr1002.tsp.txt", //77
            "80.si1032.tsp.txt", //78
            "81.u1060.tsp.txt", // 79
            "82.vm1084.tsp.txt", //80
            "83.pcb1173.tsp.txt", //81
            "84.d1291.tsp.txt", //82
            "85.rl1304.tsp.txt", //83
            "86.rl1323.tsp.txt", //84
            "87.nrw1379.tsp.txt", //85
            "88.fl1400.tsp.txt", //86
            "89.u1432.tsp.txt", //87
            "90.fl1577.tsp.txt", //88
            "91.d1655.tsp.txt", //89
            "92.vm1748.tsp.txt", //90
            "93.u1817.tsp.txt", //91
            "94.rl1889.tsp.txt", //92
            "95.d2103.tsp.txt", //93
            "96.u2152.tsp.txt", //94
            "97.u2319.tsp.txt", //95
            "98.pr2392.tsp.txt", //96
            "99.pcb3038.tsp.txt", //97
            "100.fl3795.tsp.txt", //98
            "101.fnl4461.tsp.txt" //99
        };
        
        int index = 79;
        String path = "D:\\2. Articles or Conference Papers\\05. LIBHATSP, A Library of Heuristic Algorithms for The Traveling Salesman Problem\\2. Data\\2. Data Setelah Disederhanakan\\" + file[index];
        Library.LoadCoordinate(path);
        
        String path_result = "D:\\2. Articles or Conference Papers\\06. An improved heuristic algorithm for the symmetric and asymmetric traveling salesman problem\\3. Hasil\\Hasil STSP\\contoh solusi u1060.txt";
        Library.LoadResult(path_result);
        
        // coordinate maksimum adalah 10,10
        Library.ScaleCoordinate(15);
    }
    
}