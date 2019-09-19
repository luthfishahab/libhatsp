package penelitian05;

import java.util.HashMap;

public class Library {
    private static int n; //number of nodes
    private static int d[][]; //distance matrix
    private static int coordinate[][];
    private static int result[];
    
    // 15 September 2019, 17:00
    public static void ScaleCoordinate(int max) {
        int x[] = new int[n];
        int y[] = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = coordinate[i][0];
            y[i] = coordinate[i][1];
        }
        
        int minx = Min(x);
        int maxx = Max(x);
        int rentangx = maxx - minx;
        
        int miny = Min(y);
        int maxy = Max(y);
        int rentangy = maxy - miny;
        
        for(int i = 0; i < n; i++) {
            x[i] = x[i] - minx;
            y[i] = y[i] - miny;
        }
        
        minx = Min(x);
        maxx = Max(x);
        rentangx = maxx - minx;
        
        miny = Min(y);
        maxy = Max(y);
        rentangy = maxy - miny;
        
        double pembagi = 1;
        if(rentangx > rentangy) {
            pembagi = maxx/max;
        }
        else {
            pembagi = maxy/max;
        }
        
        double X[] = new double[n];
        double Y[] = new double[n];
        for(int i = 0; i < n; i++) {
            X[i] = (double)x[i]/pembagi;
            Y[i] = (double)y[i]/pembagi;
        }
        
        System.out.println("(" + X[result[0]] + "," + Y[result[0]] + ")");
        for(int i = 1; i < result.length; i++) {
            System.out.println("-- (" + X[result[i]] + "," + Y[result[i]] + ")");
        }
        System.out.println("-- (" + X[result[0]] + "," + Y[result[0]] + ");");
        
        System.out.println("");
        System.out.println("");
        
        for(int i = 0; i < n; i++) {
            System.out.println("\\draw [color=red] (" + X[i] + "," + Y[i] + ") circle (0.015);");
        }
    }
    
    // 15 September 2019, 09:50
    public static void LoadResult(String path) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            int n = input.nextInt();
            result = new int[n];
            for(int i = 0; i < n; i++) {
                result[i] = input.nextInt();
            }
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    // 15 September 2019, 07:55
    public static void PrintMinMaxCoordinate() {
        int x[] = new int[n];
        int y[] = new int[n];
        for(int i = 0; i < n; i++) {
            x[i] = coordinate[i][0];
            y[i] = coordinate[i][1];
        }
        
        int minx = Min(x);
        int maxx = Max(x);
        int rentangx = maxx - minx;
        
        int miny = Min(y);
        int maxy = Max(y);
        int rentangy = maxy - miny;
        
        System.out.println("min x = " + minx);
        System.out.println("max x = " + maxx);
        System.out.println("rentang = " + rentangx);
        
        System.out.println("min y = " + miny);
        System.out.println("max y = " + maxy);
        System.out.println("rentang = " + rentangy);
        
        for(int i = 0; i < n; i++) {
            x[i] = x[i] - minx;
            y[i] = y[i] - miny;
        }
        
        minx = Min(x);
        maxx = Max(x);
        rentangx = maxx - minx;
        
        miny = Min(y);
        maxy = Max(y);
        rentangy = maxy - miny;
        
        System.out.println("min x = " + minx);
        System.out.println("max x = " + maxx);
        System.out.println("rentang = " + rentangx);
        
        System.out.println("min y = " + miny);
        System.out.println("max y = " + maxy);
        System.out.println("rentang = " + rentangy);
        
        for(int i = 0; i < n; i++) {
            x[i] = x[i]/15;
            y[i] = y[i]/15;
        }
        
        minx = Min(x);
        maxx = Max(x);
        rentangx = maxx - minx;
        
        miny = Min(y);
        maxy = Max(y);
        rentangy = maxy - miny;
        
        System.out.println("min x = " + minx);
        System.out.println("max x = " + maxx);
        System.out.println("rentang = " + rentangx);
        
        System.out.println("min y = " + miny);
        System.out.println("max y = " + maxy);
        System.out.println("rentang = " + rentangy);
        
        for(int i = 0; i < n; i++) {
            x[i] = x[i] + 30;
            y[i] = y[i] + 30;
        }
        
        minx = Min(x);
        maxx = Max(x);
        rentangx = maxx - minx;
        
        miny = Min(y);
        maxy = Max(y);
        rentangy = maxy - miny;
        
        System.out.println("min x = " + minx);
        System.out.println("max x = " + maxx);
        System.out.println("rentang = " + rentangx);
        
        System.out.println("min y = " + miny);
        System.out.println("max y = " + maxy);
        System.out.println("rentang = " + rentangy);
        
        for(int i = 0; i < n; i++) {
            coordinate[i][0] = x[i];
            coordinate[i][1] = y[i];
        }
    }
    
    // 14 September 2019, 18:05
    public static void VoidReverseAlgorithmATSP2(int b[], int distance[]) {
        int d0 = distance[0];
        
        // i adalah banyaknya yang akan diputar
        for(int i = 2; i <= (n-1)/2; i++) {
            // j adalah index pertama yang diputar
            for(int j = 0; j < n; j++) {
                int k = j;
                int l = (j+i-1)%n;
                
                int p = b[(k-1+n)%n];
                int q = b[k];
                int r = b[l];
                int s = b[(l+1)%n];
                
                // ... p q a b c r s ...
                // menjadi ... p r c b a q s ...
                int d1 = d0 - d[p][q] - d[r][s] + d[p][r] + d[q][s];

                // tambahan untuk kasus ATSP
                for(int x = 1; x < 2; x++) {
                    int y = b[(k+x-1)%n];
                    int z = b[(k+x)%n];
                    d1 += - d[y][z] + d[z][y];
                }

                if(d1 < d0) {
                    VoidReverseOperator(b, k, l);
                    d0 = d1;
                }
            }
        }
    }
    
    // 14 September 2019, 16:00
    public static void VoidReverseAlgorithmATSP(int b[], int distance[]) {
        int d0 = distance[0];
        
        // dari i sampai j diputar
        for(int i = 0; i < n-1; i++) {
            for(int j = i+1; j < n; j++) {
                if(j-i < n-2) {
                    int p = b[(i-1+n)%n];
                    int q = b[i];
                    int r = b[j];
                    int s = b[(j+1)%n];
                    
                    // ... p q a b c r s ...
                    // menjadi ... p r c b a q s ...
                    int d1 = d0 - d[p][q] - d[r][s] + d[p][r] + d[q][s];
                    
                    // tambahan untuk kasus ATSP
                    for(int x = i+1; x < j+1; x++) {
                        int y = b[(x-1+n)%n];
                        int z = b[x%n];
                        d1 += - d[y][z] + d[z][y];
                    }
                    
                    if(d1 < d0) {
                        VoidReverseOperator(b, i, j);
                        d0 = d1;
                    }
                }
            }
        }
        distance[0] = d0;
    }
    
    // 14 September 2019, 15:20
    public static int[] FasterReverseHeuristicAlgorithmATSP(int a[], int max_iteration, int distance[]) {
        for(int i = 0; i < max_iteration; i++) {
            int distance1 = distance[0];
            VoidReverseAlgorithmATSP(a, distance);
            if(distance[0] == distance1) {
                break;
            }
        }
        return a;
    }
    
    // 10 September 2019, 08:00
    public static int[] AsymmetricTSP() {
        int s[] = NearestNeighborAlgorithm();
        int distance[] = {GetDistance(s)};
        
        int a = 100;
        int b = 20;
        
        s = FasterShahabHeuristicAlgorithm(s, a, distance); //perlu
        s = Library.FasterReverseHeuristicAlgorithmATSP(s, 100, distance);
        
        s = FasterShahabHeuristicAlgorithm(s, a, distance); //perlu
        s = Library.FasterReverseHeuristicAlgorithmATSP(s, 100, distance);
        
        s = FasterShahabHeuristicAlgorithm1_5(s, b, distance); //perlu
        s = Library.FasterReverseHeuristicAlgorithmATSP(s, 100, distance);
        
        s = FasterShahabHeuristicAlgorithm2_0(s, b, distance); //perlu
        s = Library.FasterReverseHeuristicAlgorithmATSP(s, 100, distance);
        
        s = FasterShahabHeuristicAlgorithm2_5(s, b, distance); //perlu
        s = Library.FasterReverseHeuristicAlgorithmATSP(s, 100, distance);
        
        s = FasterShahabHeuristicAlgorithm3_0(s, b, distance); //perlu
        s = Library.FasterReverseHeuristicAlgorithmATSP(s, 100, distance);
        
        s = FasterShahabHeuristicAlgorithm3_5(s, b, distance); //perlu
        s = Library.FasterReverseHeuristicAlgorithmATSP(s, 100, distance);
        
        return s;
    }
    
    // 10 September 2019, 05:45
    public static int[] FasterShahabHeuristicAlgorithm3_5(int a[], int max_iteration, int distance[]) {
        int K = (int)(Math.sqrt(n)*3.5);
        
        for(int i = 0; i < max_iteration; i++) {
            a = FasterShahabAlgorithm(a, K, distance);
        }
        
        return a;
    }
        
    // 10 September 2019, 05:45
    public static int[] FasterShahabHeuristicAlgorithm3_0(int a[], int max_iteration, int distance[]) {
        int K = (int)(Math.sqrt(n)*3);
        
        for(int i = 0; i < max_iteration; i++) {
            a = FasterShahabAlgorithm(a, K, distance);
        }
        
        return a;
    }
    
    // 10 September 2019, 05:45
    public static int[] FasterShahabHeuristicAlgorithm2_5(int a[], int max_iteration, int distance[]) {
        int K = (int)(Math.sqrt(n)*2.5);
        
        for(int i = 0; i < max_iteration; i++) {
            a = FasterShahabAlgorithm(a, K, distance);
        }
        
        return a;
    }
    
    // 10 September 2019, 05:45
    public static int[] FasterShahabHeuristicAlgorithm2_0(int a[], int max_iteration, int distance[]) {
        int K = (int)(Math.sqrt(n)*2);
        
        for(int i = 0; i < max_iteration; i++) {
            a = FasterShahabAlgorithm(a, K, distance);
        }
        
        return a;
    }
    
    // 10 September 2019, 05:45
    public static int[] FasterShahabHeuristicAlgorithm1_5(int a[], int max_iteration, int distance[]) {
        int K = (int)(Math.sqrt(n)*1.5);
        
        for(int i = 0; i < max_iteration; i++) {
            a = FasterShahabAlgorithm(a, K, distance);
        }
        
        return a;
    }
    
    // 10 September 2019, 05:40
    public static int[] FasterReverseHeuristicAlgorithm(int a[], int max_iteration, int distance[]) {
        for(int i = 0; i < max_iteration; i++) {
            int distance1 = distance[0];
            VoidReverseAlgorithm(a, distance);
            if(distance[0] == distance1) {
                break;
            }
        }
        return a;
    }
    
    // 10 September 2019, 05:40
    public static int[] FasterShahabHeuristicAlgorithm(int a[], int max_iteration, int distance[]) {
        int K = (int)Math.sqrt(n) + 1;
        
        for(int i = 0; i < max_iteration; i++) {
            a = FasterShahabAlgorithm(a, K, distance);
        }
        
        return a;
    }
    
    // 10 September 2019, 05:35
    public static int[] SymmetricTSP() {
        int s[] = NearestNeighborAlgorithm();
        int distance[] = {GetDistance(s)};
        
        int a = 100;
        int b = 20;
                
        s = FasterShahabHeuristicAlgorithm(s, a, distance); //perlu
        s = FasterReverseHeuristicAlgorithm(s, 100, distance); //perlu

        s = FasterShahabHeuristicAlgorithm(s, a, distance); //perlu
        s = FasterReverseHeuristicAlgorithm(s, 100, distance);

        s = FasterShahabHeuristicAlgorithm1_5(s, b, distance); //perlu
        s = FasterReverseHeuristicAlgorithm(s, 100, distance);

        s = FasterShahabHeuristicAlgorithm2_0(s, b, distance); //perlu
        s = FasterReverseHeuristicAlgorithm(s, 100, distance); //perlu

        s = FasterShahabHeuristicAlgorithm2_5(s, b, distance); //perlu
        s = FasterReverseHeuristicAlgorithm(s, 100, distance);

        s = FasterShahabHeuristicAlgorithm3_0(s, b, distance); //perlu
        s = FasterReverseHeuristicAlgorithm(s, 100, distance); //perlu

        s = FasterShahabHeuristicAlgorithm3_5(s, b, distance); //perlu
        s = FasterReverseHeuristicAlgorithm(s, 100, distance); //perlu
        
        return s;
    }
    
    // 5 September 2019, 21:35
    public static int[] FasterShahabHeuristicAlgorithmSOP(int a[], int max_iteration) {
        int K = (int)Math.sqrt(n) + 1;
        
        int distance[] = {GetDistanceSOP(a)};
        
        for(int i = 0; i < max_iteration; i++) {
            a = FasterShahabAlgorithmSOP(a, K, distance);
        }
        
        return a;
    }
    
    // 5 September 2019, 21:35
    public static int[] FasterShahabAlgorithmSOP(int a[], int K, int distance[]) {
        // nilai terkecil dari index adalah 1
        // nilai terbesar dari index adalah 
        for(int i = 1; i < n-K; i++) {
            System.out.println("index : " + i);
            a = FasterShahabOperatorSOP(a, i, K, distance);
        }
        return a;
    }
    
    // 5 September 2019, 21:35
    public static int[] FasterShahabOperatorSOP(int a[], int index, int K, int distance[]) {
        int distance0 = distance[0];
        // buat b[] dan c[]
        // b[] adalah a[] setelah dikurangi elemen yang dibuang
        // c[] adalah elemen-elemen yang dibuang, sebanyak K, dimulai dari index
        int b[] = new int[n - K];
        int c[] = new int[K];
        for(int i = 0; i < index; i++) {
            b[i] = a[i];
        }
        for(int i = index; i < index+K; i++) {
            c[i-index] = a[i];
        }
        for(int i = index+K; i < n; i++) {
            b[i-K] = a[i];
        }
        Print(b);
        Print(c);
        //return a;
        
        // distance1 adalah distance dari b[]
        int distance1 = distance0 + d[b[b.length-1]][b[0]] - d[b[b.length-1]][c[0]] - GetDistance(c) - d[c[c.length-1]][b[0]] + d[c[c.length-1]][c[0]];
        int distance2 = GetDistanceSOP(b);
        
        if(distance1 != distance2)
            distance1 = distance2;
        //return a;
        
        Shuffle(c);
        //Print(c);
        
        for(int i = 0; i < K; i++) {
            // untuk setiap c[i], mencari j terbaik
            // c[i] bisa diletakkan di posisi ke 1,2,..., b.length
            int s[] = new int[b.length-1];
            for(int j = 0; j < b.length-1; j++) {
                s[j] = 1000000;
            }
            for(int j = 0; j < b.length-1; j++) {
                int e = b[j];
                int f = b[j+1];
                int g = c[i];
                if(d[e][g] == 1000000) {
                    break;
                }
                // ef menjadi egf
                s[j] = - d[e][f] + d[e][g] + d[g][f];
            }
            int index_of_min_s = IndexOfMin(s);
            b = Add(b, c[i], index_of_min_s+1);
            //Print(b);
            //distance1 = distance1 + s[index_of_min_s];
            distance1 = GetDistanceSOP(b);
        }
        
        if(distance1 < distance0) {
            distance[0] = distance1;
            return b;
        }
        else {
            return a;
        }
        
    }
    
    // 5 September 2019, 21:30
    public static void LoadDSOP(String path) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            n = input.nextInt();
            d = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    d[i][j] = input.nextInt();
                    if(d[i][j] == -1) {
                        d[i][j] = 1000000;
                    }
                }
            }
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    // 5 September 2019, 20:55
    public static int GetDistanceSOP(int[] a) {
        int n = a.length;
        int result = 0;
        for(int i = 1; i < n; i++) {
            result += d[a[i-1]][a[i]];
        }
        return result;
    }
    
    // 5 September 2019, 20:50
    public static int[] NearestNeighborAlgorithmSOP() {
        int N = n;
        int n = N-1;
        int permutation[] = new int[n];
        for(int i = 0; i < n; i++) {
            permutation[i] = i;
        }
        
        int a[] = new int[n];
        int index = 0;
        a[0] = permutation[index];
        SwapOperator2(permutation, index, n-1);
        
        for(int i = 1; i < n; i++) {
            // mencari titik yang paling dekat dengan a[i-1]
            index = 0;
            int min1 = d[a[i-1]][permutation[0]];
            for(int j = 1; j < n-i; j++) {
                int min2 = d[a[i-1]][permutation[j]];
                if(min2 < min1) {
                    index = j;
                    min1 = min2;
                }
            }
            
            a[i] = permutation[index];
            SwapOperator2(permutation, index, n-1-i);
        }
        
        int b[] = new int[N];
        for(int i = 0; i < n; i++) {
            b[i] = a[i];
        }
        b[N-1] = N-1;
        
        return b;
    }
        
    // 5 September 2019, 15:25
    // beda nilai K
    public static int[] FasterShahabHeuristicAlgorithm3_5(int a[], int max_iteration) {
        int K = (int)(Math.sqrt(n)*3.5);
        
        int distance[] = {GetDistance(a)};
        
        for(int i = 0; i < max_iteration; i++) {
            a = FasterShahabAlgorithm(a, K, distance);
        }
        
        return a;
    }
        
    // 5 September 2019, 15:00
    // beda nilai K
    public static int[] FasterShahabHeuristicAlgorithm3_0(int a[], int max_iteration) {
        int K = (int)(Math.sqrt(n)*3);
        
        int distance[] = {GetDistance(a)};
        
        for(int i = 0; i < max_iteration; i++) {
            a = FasterShahabAlgorithm(a, K, distance);
        }
        
        return a;
    }
    
    // 5 September 2019, 14:55
    // beda nilai K
    public static int[] FasterShahabHeuristicAlgorithm2_5(int a[], int max_iteration) {
        int K = (int)(Math.sqrt(n)*2.5);
        
        int distance[] = {GetDistance(a)};
        
        for(int i = 0; i < max_iteration; i++) {
            a = FasterShahabAlgorithm(a, K, distance);
        }
        
        return a;
    }
    
    // 5 September 2019, 14:50
    // beda nilai K
    public static int[] FasterShahabHeuristicAlgorithm2_0(int a[], int max_iteration) {
        int K = (int)(Math.sqrt(n)*2);
        
        int distance[] = {GetDistance(a)};
        
        for(int i = 0; i < max_iteration; i++) {
            a = FasterShahabAlgorithm(a, K, distance);
        }
        
        return a;
    }
    
    // 5 September 2019, 14:45
    // beda nilai K
    public static int[] FasterShahabHeuristicAlgorithm1_5(int a[], int max_iteration) {
        int K = (int)(Math.sqrt(n)*1.5);
        
        int distance[] = {GetDistance(a)};
        
        for(int i = 0; i < max_iteration; i++) {
            a = FasterShahabAlgorithm(a, K, distance);
        }
        
        return a;
    }
    
    // 5 September 2019, 10:40
    public static void CreateMatrix(String path, String hasil) {
        java.io.File file = new java.io.File(path);

        try (java.util.Scanner input = new java.util.Scanner(file);) {
            int typeInput = input.nextInt();

            // EUC_2D
            if(typeInput == 6) {
                int n = input.nextInt();
                double[][] a = new double[n][2];
                for(int i = 0; i < n; i++) {
                    input.nextInt();
                    a[i][0] = input.nextDouble();
                    a[i][1] = input.nextDouble();
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        if(i != j) {
                            double xd = a[i][0] - a[j][0];
                            double yd = a[i][1] - a[j][1];
                            double distance = Math.sqrt(xd*xd + yd*yd) + 0.5;
                            int dij = (int)distance;
                            output.print(dij + "\t");
                        }
                        else {
                            output.print("0\t");
                        }
                    }
                    output.println("");
                }
                output.close();
            }

            // GEO
            else if(typeInput == 1) {
                int n = input.nextInt();
                double[][] a = new double[n][2];
                for(int i = 0; i < n; i++) {
                    input.nextInt();
                    a[i][0] = input.nextDouble();
                    a[i][1] = input.nextDouble();
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        if(i != j) {
                            double xi = a[i][0];
                            double yi = a[i][1];
                            double xj = a[j][0];
                            double yj = a[j][1];
                            double pi = 3.141592;
                            double deg, min;

                            deg = (int)xi;
                            min = xi - deg;
                            double latitudei = pi*(deg+5.0*min/3.0)/180.0;
                            deg = (int)yi;
                            min = yi - deg;
                            double longitudei = pi*(deg+5.0*min/3.0)/180.0;

                            deg = (int)xj;
                            min = xj - deg;
                            double latitudej = pi*(deg+5.0*min/3.0)/180.0;
                            deg = (int)yj;
                            min = yj - deg;
                            double longitudej = pi*(deg+5.0*min/3.0)/180.0;

                            double RRR = 6378.388;
                            double q1 = Math.cos(longitudei - longitudej);
                            double q2 = Math.cos(latitudei - latitudej);
                            double q3 = Math.cos(latitudei + latitudej);

                            double Dij = RRR*Math.acos(0.5*((1.0+q1)*q2 - (1.0-q1)*q3))+1.0;

                            int dij = (int)Dij;

                            output.print(dij + "\t");
                        }
                        else {
                            output.print("0\t");
                        }
                    }
                    output.println("");
                }
                output.close();
            }

            // LOWER_DIAG_ROW
            else if(typeInput == 2) {
                int n = input.nextInt();
                int[][] a = new int[n][n];
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j <= i; j++) {
                        a[i][j] = input.nextInt();
                        a[j][i] = a[i][j];
                    }
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        int distance = a[i][j];
                        output.print(distance + "\t");
                    }
                    output.println("");
                }
                output.close();
            }

            // UPPER_ROW
            else if(typeInput == 3) {
                int n = input.nextInt();
                int[][] a = new int[n][n];
                for(int i = 0; i < n-1; i++) {
                    for(int j = i+1; j < n; j++) {
                        a[i][j] = input.nextInt();
                        a[j][i] = a[i][j];
                    }
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        int distance = a[i][j];
                        output.print(distance + "\t");
                    }
                    output.println("");
                }
                output.close();
            }

            // FULL_MATRIX
            else if(typeInput == 4) {
                int n = input.nextInt();
                int[][] a = new int[n][n];
                for(int i = 0; i < n; i++) {
                    for(int j = 0; j < n; j++) {
                        a[i][j] = input.nextInt();
                    }
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        int distance = a[i][j];
                        output.print(distance + "\t");
                    }
                    output.println("");
                }
                output.close();
            }

            // ATT
            else if(typeInput == 5) {
                int n = input.nextInt();
                double[][] a = new double[n][2];
                for(int i = 0; i < n; i++) {
                    input.nextInt();
                    a[i][0] = input.nextDouble();
                    a[i][1] = input.nextDouble();
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        if(i != j) {
                            double xd = a[i][0] - a[j][0];
                            double yd = a[i][1] - a[j][1];
                            double rij = Math.sqrt((xd*xd + yd*yd)/10.0);
                            int tij = (int)rij;
                            int dij;
                            if((double)tij < rij) {
                                dij = tij+1;
                            }
                            else {
                                dij = tij;
                            }
                            output.print(dij + "\t");
                        }
                        else {
                            output.print("0\t");
                        }
                    }
                    output.println("");
                }
                output.close();
            }

            // UPPER_DIAG_ROW
            else if(typeInput == 7) {
                int n = input.nextInt();
                int[][] a = new int[n][n];
                for(int i = 0; i < n; i++) {
                    for(int j = i; j < n; j++) {
                        a[i][j] = input.nextInt();
                        a[j][i] = a[i][j];
                    }
                }

                java.io.File file1 = new java.io.File(hasil);
                java.io.PrintWriter output = new java.io.PrintWriter(file1);

                output.println(n);
                for(int i = 0; i < a.length; i++) {
                    for(int j = 0; j < a.length; j++) {
                        int distance = a[i][j];
                        output.print(distance + "\t");
                    }
                    output.println("");
                }
                output.close();
            }
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    // 5 September 2019, 00:00
    public static int[] FasterShahabHeuristicAlgorithmKTurun(int a[]) {
        int K = (int)Math.sqrt(n) + 1;
        
        int distance[] = {GetDistance(a)};
        
        for(int i = K-1; i > 0; i--) {
            a = FasterShahabAlgorithm(a, i, distance);
        }
        
        return a;
    }
    
    // 4 September 2019, 23:15
    // _2 adalah versi yang lebih cepat, namun lebih rumit
    public static int[] Opt2Algorithm_2(int a[]) {
        int b[] = a.clone();
        int d0 = GetDistance(b);
        // i adalah panjang yang akan diputar
        // j adalah index pertama yang diputar
        for(int i = 2; i <= n/2; i++) {
            for(int j = 0; j < n; j++) {
                int c[] = b.clone();
                Opt2Operator(c, i, j);
                int d1 = GetDistance(c);
                
                if(d1 < d0) {
                    b = c;
                    d0 = d1;
                }
            }
        }
        return b;
    }
    
    // 3 September 2019, 23:10
    // _1 adalah versi yang paling mudah dipahami
    public static int[] Opt2IterativeAlgorithm_1(int a[], int max_iteration) {
        int b[] = a.clone();
        int d0 = GetDistance(b);
        
        for(int i = 0; i < max_iteration; i++) {
            int c[] = Opt2Algorithm_1(b);
            int d1 = GetDistance(c);
                
            if(d1 < d0) {
                b = c;
                d0 = d1;
            }
            else {
                break;
            }
        }
        
        return b;
    }
    
    // 3 September 2019, 23:00
    // _1 adalah versi yang paling mudah dipahami
    public static int[] Opt2Algorithm_1(int a[]) {
        int b[] = a.clone();
        int d0 = GetDistance(b);
        // i adalah panjang yang akan diputar
        // j adalah index pertama yang diputar
        for(int i = 2; i <= n/2; i++) {
            for(int j = 0; j < n; j++) {
                int c[] = b.clone();
                Opt2Operator(c, i, j);
                int d1 = GetDistance(c);
                
                if(d1 < d0) {
                    b = c;
                    d0 = d1;
                }
            }
        }
        return b;
    }
    
    // 3 September 2019, 22:50
    public static void Opt2Operator(int a[], int I, int J) {
        for(int i = 0; i < I/2; i++) {
            int b = (J+i)%a.length;
            int c = (J+I-i-1)%a.length;
            int dummy = a[b];
            a[b] = a[c];
            a[c] = dummy;
        }
    }
    
    // 3 September 2019
    public static int[] OrderedPermutation() {
        int a[] = new int[n];
        for(int i = 0; i < n; i++) {
            a[i] = i;
        }
        return a;
    }
    
    // 25 Agustus 2019, 05:00
    // edge dari i ke i+1, dari j ke j+1, dan dari k ke k+1 dibuang
    // kemudian dicari semua kemungkinan solusi baru
    // dan kemudian dipilih solusi yang paling kecil distance-nya
    public static void K3Opt(int a[], int i, int j, int k) {
        // 123ab456cd789ef
        // kemungkinan hasil
        // 123ab456ce987df  - d[c][d] - d[e][f] + d[c][e] + d[d][f]
        // 123ac654bd789ef  - d[a][b] - d[c][d] + d[a][c] + d[b][d]
        // 123ac654be987df  - d[a][b] - d[c][d] - d[e][f] + d[a][c] + d[b][e] + d[d][f]
        // 123ad789eb456cf  - d[a][b] - d[c][d] - d[e][f] + d[a][d] + d[e][b] + d[c][f]
        // 123ad789ec654bf  - d[a][b] - d[c][d] - d[e][f] + d[a][d] + d[e][c] + d[b][f]
        // 123ae987db456cf  - d[a][b] - d[c][d] - d[e][f] + d[a][e] + d[d][b] + d[c][f]
        // 123ae987dc654bf  - d[a][b] - d[c][d] - d[e][f] + d[a][e] + d[d][c] + d[b][f]
        
        
    }
    
    // 26 Agustus 2019, 07:00
    public static void K2OptAlgorithm(int A[]) {
        // 123ab456cd
        // kemungkinan hasil
        // 123ac654bd  - d[a][b] - d[c][d] + d[a][c] + d[b][d]
        int distance0 = GetDistance(A);
        
        // i mewakili a
        // j mewakili c
        int n = 6;
        for(int i = 0; i < n-2; i++) {
            for(int j = i+2; j < n; j++) {
                // yang diputar adalah dari b sampai c
                int a = i;
                int b = i + 1;
                int c = j;
                int d = (j + 1) % n;
                int n1 = c - a;
                int n2 = n - n1;
                int m = Math.min(n1, n2);
                if(m >= 2) {
                    System.out.println("a : " + a);
                    System.out.println("b : " + b);
                    System.out.println("c : " + c);
                    System.out.println("d : " + d);
                    System.out.println("n1 : " + n1);
                    System.out.println("n2 : " + n2);
                    System.out.println("");
                }
            }
        }
    }
    
    // 2 September 2019, 14:00
    public static void K2OptOperator(int A[], int a, int c) {
        // 0123456789
        // 123ab456cd
        // 123ac654bd (hasil)
        
        // a = 3
        // c = 8
        // n1 adalah banyaknya titik dari b sampai c
        int n1 = c - a;
        // n2 adalah banyaknya titik dari d sampai a
        int n2 = n - n1;
        
        int b = a+1;
        int d = (c+1)%n;
        
        System.out.println("a : " + a);
        System.out.println("b : " + a);
        System.out.println(n1);
        System.out.println(n2);
        
        int B[] = new int[n];
        for(int i = 0; i < a; i++) {
            B[i] = A[i];
        }
        for(int i = a; i < c; i++) {
            B[i] = A[c+a-i+1];
        }
        for(int i = c; i < n; i++) {
            B[i] = A[i];
        }
        Print(B);
    }
    
    // 23 Agustus 2019, 14:20
    public static int[] BestNearestNeighborAlgorithm() {
        int index = 0;
        int solution[] = NearestNeighborAlgorithm(index);
        int min = GetDistance(solution);
        
        for(int i = 1; i < n; i++) {
            int solution2[] = NearestNeighborAlgorithm(i);
            int min2 = GetDistance(solution2);
            if(min2 < min) {
                solution = solution2;
                min = min2;
            }
        }
        
        return solution;
    }
    
    // 21 Agustus 2019, 22:45
    public static int[] NearestNeighborAlgorithm(int index) {
        int permutation[] = new int[n];
        for(int i = 0; i < n; i++) {
            permutation[i] = i;
        }
        
        int a[] = new int[n];
        a[0] = permutation[index];
        SwapOperator2(permutation, index, n-1);
        
        for(int i = 1; i < n; i++) {
            // mencari titik yang paling dekat dengan a[i-1]
            index = 0;
            int min1 = d[a[i-1]][permutation[0]];
            for(int j = 1; j < n-i; j++) {
                int min2 = d[a[i-1]][permutation[j]];
                if(min2 < min1) {
                    index = j;
                    min1 = min2;
                }
            }
            
            a[i] = permutation[index];
            SwapOperator2(permutation, index, n-1-i);
        }
        
        return a;
    }
    
    // 22 Agustus 2019, 18:00
    // membentuk soluti baru berdasarkan urutannya dari yang paling jauh jumlah jaraknya terhadap titik2 yang lain
    public static void NewSolution() {
        // mencari jarak dari titik ke-i terhadap semua titik lainnya
        int distance_to_others[] = new int[n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                distance_to_others[i] += d[i][j];
            }
        }
        
        
        // mengurutkan titik berdasarkan yang terjauh
        
        // membentuk solusi dengan menempatkan titik baru pada posisi yang paling baik
    }
    
    // 22 Agustus 2019, 17:30
    public static void Sort(int a[]) {
        int n = a.length;
        for(int i = 1; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(a[i] < a[i-j-1]) {
                    SwapOperator2(a, i, j);
                }
            }
        }
    }
    
    // 22 Agustus 2019, 10:30
    public static int[] AddToBestPosition(int a[], int x) {
        int min1 = - d[a[a.length-1]][a[0]] + d[a[a.length-1]][x] + d[x][a[0]];
        int index = 0;
        
        for(int i = 1; i < a.length; i++) {
            int min2 = - d[a[i-1]][a[i]] + d[a[i-1]][x] + d[x][a[i]];
            if(min2 < min1) {
                index = i;
            }
        }
        
        int b[] = Add(a, x, index);
        return b;
    }
    
    // 22 Agustus 2019, 09:00
    public static void SetResult(int a[]) {
        result = a;
    }
    
    // 22 Agustus 2019, 09:00
    public static int[] GetResult() {
        return result;
    }
    
    // 21 Agustus 2019, 22:45
    public static int[] NearestNeighborAlgorithm() {
        int permutation[] = new int[n];
        for(int i = 0; i < n; i++) {
            permutation[i] = i;
        }
        
        int a[] = new int[n];
        int index = (int)(Math.random()*(n));
        a[0] = permutation[index];
        SwapOperator2(permutation, index, n-1);
        
        for(int i = 1; i < n; i++) {
            // mencari titik yang paling dekat dengan a[i-1]
            index = 0;
            int min1 = d[a[i-1]][permutation[0]];
            for(int j = 1; j < n-i; j++) {
                int min2 = d[a[i-1]][permutation[j]];
                if(min2 < min1) {
                    index = j;
                    min1 = min2;
                }
            }
            
            a[i] = permutation[index];
            SwapOperator2(permutation, index, n-1-i);
        }
        
        return a;
    }
    
    // 21 Agustus 2019, 02:00
    public static int[] FasterShahabHeuristicAlgorithm(int a[], int max_iteration) {
        int K = (int)Math.sqrt(n) + 1;
        
        int distance[] = {GetDistance(a)};
        
        for(int i = 0; i < max_iteration; i++) {
            a = FasterShahabAlgorithm(a, K, distance);
        }
        
        return a;
    }
    
    // 21 Agustus 2019, 01:45
    public static int[] FasterShahabAlgorithm(int a[], int K, int distance[]) {
        for(int i = 0; i < n; i++) {
            a = FasterShahabOperator(a, i, K, distance);
        }
        return a;
    }
    
    // 21 Agustus 2019, 01:30
    public static int[] FasterShahabOperator(int a[], int index, int K, int distance[]) {
        int distance0 = distance[0];
        // buat b[] dan c[]
        // b[] adalah a[] setelah dikurangi elemen yang dibuang
        // c[] adalah elemen-elemen yang dibuang, sebanyak K, dimulai dari index
        int b[] = new int[n - K];
        for(int i = K; i < n; i++) {
            b[i-K] = a[(index+i)%n];
        }
        //Print(b);
        
        int c[] = new int[K];
        for(int i = 0; i < K; i++) {
            c[i] = a[(index+i)%n]; 
        }
        //Print(c);
        
        // distance1 adalah distance dari b[]
        int distance1 = distance0 + d[b[b.length-1]][b[0]] - d[b[b.length-1]][c[0]] - GetDistance(c) - d[c[c.length-1]][b[0]] + d[c[c.length-1]][c[0]];
        
        Shuffle(c);
        //Print(c);
        
        for(int i = 0; i < K; i++) {
            // untuk setiap c[i], mencari j terbaik
            // c[i] bisa diletakkan di posisi ke 1,2,..., b.length
            int s[] = new int[b.length];
            for(int j = 0; j < b.length; j++) {
                int e = b[j];
                int f = b[(j+1)%b.length];
                int g = c[i];
                // ef menjadi egf
                s[j] = - d[e][f] + d[e][g] + d[g][f];
            }
            int index_of_min_s = IndexOfMin(s);
            b = Add(b, c[i], index_of_min_s+1);
            //Print(b);
            distance1 = distance1 + s[index_of_min_s];
        }
        
        if(distance1 < distance0) {
            distance[0] = distance1;
            
            return b;
        }
        else {
            return a;
        }
    }
    
    // 21 Agustus 2019, 01:25
    public static int[] ShahabHeuristicAlgorithm(int a[], int max_iteration) {
        int b[] = a.clone();
        int K = (int)Math.sqrt(n) + 1;
        
        for(int i = 0; i < max_iteration; i++) {
            b = ShahabAlgorithm(b, K);
        }
        
        return b;
    }
    
    // 21 Agustus 2019, 01:20
    public static int[] ShahabAlgorithm(int a[], int K) {
        for(int i = 0; i < n; i++) {
            a = ShahabOperator(a, i, K);
            //Print(a);
            //System.out.println(GetDistance(a));
            //System.out.println();
        }
        return a;
    }
    
    // 21 Agustus 2019, 01:15
    public static int[] ShahabOperator(int a[], int index, int K) {
        int distance0 = GetDistance(a);
        // buat b[] dan c[]
        // b[] adalah a[] setelah dikurangi elemen yang dibuang
        // c[] adalah elemen-elemen yang dibuang, sebanyak K, dimulai dari index
        int b[] = new int[n - K];
        for(int i = K; i < n; i++) {
            b[i-K] = a[(index+i)%n];
        }
        //Print(b);
        
        int c[] = new int[K];
        for(int i = 0; i < K; i++) {
            c[i] = a[(index+i)%n];
        }
        //Print(c);
        
        Shuffle(c);
        //Print(c);
        
        for(int i = 0; i < K; i++) {
            // untuk setiap c[i], mencari j terbaik
            // c[i] bisa diletakkan di posisi ke 1,2,..., b.length
            int s[] = new int[b.length];
            for(int j = 0; j < b.length; j++) {
                int e = b[j];
                int f = b[(j+1)%b.length];
                int g = c[i];
                s[j] = - d[e][f] + d[e][g] + d[g][f];
            }
            int index_of_min_s = IndexOfMin(s);
            b = Add(b, c[i], index_of_min_s+1);
            //Print(b);
        }
        int distance1 = GetDistance(b);
        
        if(distance1 < distance0) {
            return b;
        }
        else {
            return a;
        }
    }
    
    // 21 Agustus 2019, 01:00
    // ide dari FasterReverseHeuristicAlgorithm adalah sedikit mungkin menghitung ulang dengan GetDistance
    public static int[] FasterReverseHeuristicAlgorithm(int a[], int max_iteration) {
        int distance[] = {GetDistance(a)};
        
        for(int i = 0; i < max_iteration; i++) {
            int distance1 = distance[0];
            VoidReverseAlgorithm(a, distance);
            if(distance[0] == distance1) {
                break;
            }
        }
        return a;
    }
    
    // 21 Agustus 2019, 00:45
    public static void VoidReverseAlgorithm(int b[], int distance[]) {
        int d0 = distance[0];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int k = Math.min(i, j);
                int l = Math.max(i, j);
                if(k != l && l-k != n-2 && l-k != n-1) {
                    int p = b[(k-1+n)%n];
                    int q = b[k];
                    int r = b[l];
                    int s = b[(l+1)%n];
                    int d1 = d0 - d[p][q] - d[r][s] + d[p][r] + d[q][s];
                    
                    if(d1 < d0) {
                        VoidReverseOperator(b, k, l);
                        d0 = d1;
                    }
                }
            }
        }
        distance[0] = d0;
    }
    
    // 21 Agustus 2019, 00:30
    public static void VoidReverseOperator(int a[], int pos1, int pos2) {
        int k = Math.min(pos1, pos2);
        int l = Math.max(pos1, pos2);
        
        // yang direverse adalah yang sedikit
        int n1 = l - k + 1;
        int n2 = n - n1;
        if(n1 < n2) {
            for(int i = 0; i < n1/2; i++) {
                int dummy = a[k + i];
                a[k + i] = a[l - i];
                a[l - i] = dummy;
            }
        }
        else {
            for(int i = 0; i < n2/2; i++) {
                int x = (k-i-1+n)%n;
                int y = (l+i+1)%n;
                int dummy = a[x];
                a[x] = a[y];
                a[y] = dummy;
            }
        }
    }
    
    // 20 Agustus 2019, 00:01
    public static int[] ReverseHeuristicAlgorithm(int a[], int max_iteration) {
        int b[] = a.clone();
        int d0 = GetDistance(b);
        
        for(int i = 0; i < max_iteration; i++) {
            b = FasterReverseAlgorithm(b);
            int d1 = GetDistance(b);
            if(d0 == d1) {
                break;
            }
            else {
                d0 = d1;
            }
        }
        
        return b;
    }
    
    // 19 Agustus 2019, 23:00
    public static int[] FasterReverseAlgorithm(int a[]) {
        int b[] = a.clone();
        int d0 = GetDistance(b);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int k = Math.min(i, j);
                int l = Math.max(i, j);
                if(k != l && l-k != n-2 && l-k != n-1) {
                    int p = b[(k-1+n)%n];
                    int q = b[k];
                    int r = b[l];
                    int s = b[(l+1)%n];
                    int d1 = d0 - d[p][q] - d[r][s] + d[p][r] + d[q][s];
                    
                    if(d1 < d0) {
                        b = ReverseOperator(b, k, l);
                        d0 = d1;
                    }
                }
            }
        }
        return b;
    }
    
    // 19 Agustus 2019, 22:35
    public static int[] ReverseAlgorithm(int a[]) {
        int b[] = a.clone();
        int d0 = GetDistance(b);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                int k = Math.min(i, j);
                int l = Math.max(i, j);
                if(i != j && l-k != 12 && l-k != 13) {
                    int c[] = ReverseOperator(b, i, j);
                    int d1 = GetDistance(c);
                    
                    if(d1 < d0) {
                        b = c;
                        d0 = d1;
                    }
                }
            }
        }
        return b;
    }
    
    // 19 Agustus 2019, 22:30
    public static int[] ReverseOperator(int A[], int pos1, int pos2) {
        int a[] = A.clone();
        int k = Math.min(pos1, pos2);
        int l = Math.max(pos1, pos2);
        
        // yang direverse adalah yang sedikit
        int n1 = l - k + 1;
        int n2 = n - n1;
        if(n1 < n2) {
            for(int i = 0; i < n1/2; i++) {
                int dummy = a[k + i];
                a[k + i] = a[l - i];
                a[l - i] = dummy;
            }
        }
        else {
            for(int i = 0; i < n2/2; i++) {
                int x = (k-i-1+n)%n;
                int y = (l+i+1)%n;
                int dummy = a[x];
                a[x] = a[y];
                a[y] = dummy;
            }
        }
        return a;
    }
    
    // 19 Agustus 2019, 21:30
    public static int[] FasterSwapHeuristicAlgorithm(int a[], int max_iteration) {
        int d0[] = {GetDistance(a)};
        
        for(int i = 0; i < max_iteration; i++) {
            int e0 = d0[0];
            SwapAlgorithm(a, d0);
            if(d0[0] == e0) {
                break;
            }
        }
        return a;
    }
    
    // 19 Agustus 2019, 21:25
    public static void SwapAlgorithm(int b[], int D0[]) {
        int d0 = D0[0];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    // tambahan
                    int k = Math.min(i, j);
                    int l = Math.max(i, j);
                    int d1;
                    
                    if(!(l - k == 1 || l - k == n-1)) {
                        int p = b[(k-1+n)%n]; // a
                        int q = b[k]; // b
                        int r = b[(k+1)%n]; //c
                        int s = b[(l-1+n)%n]; //f
                        int t = b[l]; //g
                        int u = b[(l+1)%n]; //h
                        d1 = d0 - d[p][q] - d[q][r] - d[s][t] - d[t][u]
                                + d[p][t] + d[t][r] + d[s][q] + d[q][u];
                    }
                    else if(l - k == 1) {
                        int e = b[(k-1+n)%n];
                        int f = b[k];
                        int g = b[l];
                        int h = b[(l+1)%n];
                        d1 = d0 - d[e][f] - d[g][h] + d[e][g] + d[f][h];
                    }
                    else {
                        k = l;
                        l = 0;
                        int e = b[(k-1+n)%n];
                        int f = b[k];
                        int g = b[l];
                        int h = b[(l+1)%n];
                        d1 = d0 - d[e][f] - d[g][h] + d[e][g] + d[f][h];
                    }
                    
                    if(d1 < d0) {
                        int dummy = b[i];
                        b[i] = b[j];
                        b[j] = dummy;
                        d0 = d1;
                    }
                }
            }
        }
        D0[0] = d0;
    }
    
    // 19 Agustus 2019, 20:45
    public static int[] SwapHeuristicAlgorithm(int a[], int max_iteration) {
        int b[] = a.clone();
        int d0 = GetDistance(b);
        
        for(int i = 0; i < max_iteration; i++) {
            b = SwapAlgorithm(b);
            int d1 = GetDistance(b);
            if(d0 == d1) {
                break;
            }
            else {
                d0 = d1;
            }
        }
        
        return b;
    }
    
    // 19 Agustus 2019, 20:00
    public static int[] SwapAlgorithm(int a[]) {
        int b[] = a.clone();
        int d0 = GetDistance(b);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    // tambahan
                    int k = Math.min(i, j);
                    int l = Math.max(i, j);
                    int d1;
                    
                    if(!(l - k == 1 || l - k == n-1)) {
                        int p = b[(k-1+n)%n]; // a
                        int q = b[k]; // b
                        int r = b[(k+1)%n]; //c
                        int s = b[(l-1+n)%n]; //f
                        int t = b[l]; //g
                        int u = b[(l+1)%n]; //h
                        d1 = d0 - d[p][q] - d[q][r] - d[s][t] - d[t][u]
                                + d[p][t] + d[t][r] + d[s][q] + d[q][u];
                    }
                    else if(l - k == 1) {
                        int e = b[(k-1+n)%n];
                        int f = b[k];
                        int g = b[l];
                        int h = b[(l+1)%n];
                        d1 = d0 - d[e][f] - d[g][h] + d[e][g] + d[f][h];
                    }
                    else {
                        k = l;
                        l = 0;
                        int e = b[(k-1+n)%n];
                        int f = b[k];
                        int g = b[l];
                        int h = b[(l+1)%n];
                        d1 = d0 - d[e][f] - d[g][h] + d[e][g] + d[f][h];
                    }
                    
                    if(d1 < d0) {
                        b = SwapOperator(b, i, j);
                        d0 = d1;
                    }
                }
            }
        }
        return b;
    }
    
    // 19 Agustus 2019, 16:00
    public static void SwapOperator2(int a[], int i, int j) {
        int dummy = a[i];
        a[i] = a[j];
        a[j] = dummy;
    }
    
    // 19 Agustus 2019, 16:00
    public static int[] SwapOperator(int a[], int i, int j) {
        int b[] = a.clone();
        
        int dummy = b[i];
        b[i] = b[j];
        b[j] = dummy;
        
        return b;
    }
    
    public static void BruteForceAlgorithm() {
        
    }
    
    public static void AllPermutation(int n) {
        int a = 1;
        for(int i = 1; i < n; i++) {
            a = a*(i+1);
        }
        System.out.println(a);
        
        int b[] = new int[a];
        
    }
    
    public static void HeldKarpAlgorithm() {
        HashMap<String, Integer> g = new HashMap<String, Integer>();
        g.put("1", 2);
        
        // dari 0, melewati {a,b,c}, berakhir di x
        
        System.out.println(g); 
    }
    
    public static void LoadD(String path) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            n = input.nextInt();
            d = new int[n][n];
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    d[i][j] = input.nextInt();
                }
            }
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    //membuat d dari beberapa x_i dan y_i yang diketahui
    public static void LoadD(int x[], int y[]) {
        n = x.length;
        d = new int[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(i != j) {
                    double xd = x[i] - x[j];
                    double yd = y[i] - y[j];
                    double distance = Math.sqrt(xd*xd + yd*yd) + 0.5;
                    int dij = (int)distance;
                    d[i][j] = dij;
                }
                else {
                    d[i][j] = 0;
                }
            }
        }
    }
    
    public static void LoadCoordinate(String path) {
        java.io.File file = new java.io.File(path);
        
        try (java.util.Scanner input = new java.util.Scanner(file);) {
            input.nextInt();
            n = input.nextInt();
            coordinate = new int[n][2];
            for(int i = 0; i < n; i++) {
                input.nextInt();
                coordinate[i][0] = (int)input.nextDouble();
                coordinate[i][1] = (int)input.nextDouble();
            }
        }
        catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void LoadCoordinate(int x[], int y[]) {
        n = x.length;
        coordinate = new int[n][2];
        for(int i = 0; i < n; i++) {
            coordinate[i][0] = x[i];
            coordinate[i][1] = y[i];
        }
        LoadD(x, y);
    }
    
    public static int Min(int[] a) {
        int min = a[0];
        for(int i = 1; i < a.length; i++) {
            if(min > a[i]) {
                min = a[i];
            }
        }
        return min;
    }
    
    public static int Max(int[] a) {
        int max = a[0];
        for(int i = 1; i < a.length; i++) {
            if(max < a[i]) {
                max = a[i];
            }
        }
        return max;
    }
    
    // index 0 diletakkan di depan
    public static int[] Rearrange0(int[] a) {
        int[] b = new int[a.length];
        
        int position = 0;
        if(a[0] != 0) {
            for(int i = 1; i < a.length; i++) {
                if(a[i] == 0) {
                    position = i;
                    break;
                }
            }
        }
        for(int i = position; i < a.length; i++) {
            b[i-position] = a[i];
        }
        for(int i = 0; i < position; i++) {
            b[i+a.length-position] = a[i];
        }
        
        if(b[1] < b[a.length-1]) {
            return b;
        }
        else {
            int[] c = new int[a.length];
            c[0] = b[0];
            for(int i = 1; i < a.length; i++) {
                c[i] = b[a.length-i];
            }
            return c;
        }
    }
    
    public static int GetDistance(int[] a) {
        int n = a.length;
        int result = 0;
        for(int i = 1; i < n; i++) {
            result += d[a[i-1]][a[i]];
        }
        result += d[a[n-1]][a[0]];
        return result;
    }
    
    public static int IndexOfMin(int a[]) {
        int index = 0;
        double min = a[0];
        for(int i = 1; i < a.length; i++) {
            if(min > a[i]) {
                min = a[i];
                index = i;
            }
        }
        return index;
    }
    
    // 19 Agustus 12:12
    public static void Shuffle(int b[]) {
        int n = b.length;
        // Shuffle the cards
        for (int i = 0; i < n; i++) {
            // Generate an index randomly
            int index = (int)(Math.random() * n);
            int temp = b[i];
            b[i] = b[index];
            b[index] = temp;
        }
    }
    
    public static int[] Add(int a[], int b, int position) {
        int[] c = new int[a.length+1];
        for(int i = 0; i < position; i++) {
            c[i] = a[i];
        }
        c[position] = b;
        for(int i = position+1; i < a.length+1; i++) {
            c[i] = a[i-1];
        }
        return c;
    }
    
    public static int[] Remove(int a[], int position) {
        int[] c = new int[a.length-1];
        for(int i = 0; i < position; i++) {
            c[i] = a[i];
        }
        for(int i = position+1; i < a.length; i++) {
            c[i-1] = a[i];
        }
        return c;
    }
        
    public static void ImprovedHeuristicAlgorithm() {
        
    }
    
    public static int[] RandomPermutation() {
        int a[] = new int[n];
        
        // Initialize the cards
        for (int i = 0; i < n; i++)
            a[i] = i;
        
        // Shuffle the cards
        for (int i = 0; i < n; i++) {
            // Generate an index randomly
            int index = (int)(Math.random() * n);
            int temp = a[i];
            a[i] = a[index];
            a[index] = temp;
        }
        
        return a;
    }
    
    public static void SetD(int a[][]) {
        d = a;
        n = a.length;
    }
    
    public static int GetN() {
        return n;
    }
    
    public static int[][] GetD() {
        return d;
    }
    
    public static int[][] GetCoordinate() {
        return coordinate;
    }
    
    public static void PrintN() {
        System.out.println(n + "\n");
    }
    
    public static void PrintD() {
        for(int i = 0; i < d.length; i++) {
            for(int j = 0; j < d[0].length; j++) {
                System.out.print(d[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public static void PrintCoordinate() {
        for(int i = 0; i < n; i++) {
            System.out.println(coordinate[i][0] + "\t" + coordinate[i][1]);
        }
        System.out.println();
    }
    
    public static void Print(int a[]) {
        for(int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
}