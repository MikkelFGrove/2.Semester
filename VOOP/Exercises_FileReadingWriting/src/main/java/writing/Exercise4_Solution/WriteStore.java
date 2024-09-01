package writing.Exercise4_Solution;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class WriteStore {

        private String outFile;

        public WriteStore (String outFile) {
            this.outFile=outFile;
        }

        public void writeFile(Set<Store> set) {
            double revenue=0.0;


            for(Store s: set){
                revenue=revenue+s.getRevenue();
        }

        try(PrintWriter p = new PrintWriter(outFile))
        {
            p.write("Total revenue of all stores= "+ revenue);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        Store  f1=new Store (103,500.000000,"Rental","Express","New",2,5853000);
        Store  f2=new Store (89,500.000000,"Owned","Express","New",3,17252000);
        Store  f3=new Store (112,650.000000,"Cooperate","Express","New",3,12976000);

        Set<Store> s=new LinkedHashSet<>();
        s.add(f1);
        s.add(f2);
        s.add(f3);
        WriteStore fileIO = new WriteStore ("storeInfo.txt");
        fileIO.writeFile(s);

    }
}

