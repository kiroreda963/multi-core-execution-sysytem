import java.util.ArrayList;

class MasterCore  {
    static ArrayList<Core> cores = new ArrayList<Core>();
    static Core currCore;    

    public static void run(){
        for (int index = 0; index < cores.size(); index++) {
            cores.get(index).start();
            if(index+1<cores.size()) cores.get(index+1).start();
            index+=2;
        }
    }
    
}