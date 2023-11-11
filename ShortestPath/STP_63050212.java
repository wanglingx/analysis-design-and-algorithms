package ShortestPath;
import java.util.Arrays;
public class STP_63050212 {
    public static void main(String[] args) {
        ShortestPath source = new ShortestPath();
        source.process();
        source.display();
    }
}

class ShortestPath {
    private int count=6;
    private int point=1;
    private boolean check[] = new boolean[count];
    private int way[] = new int[count];
    private String format[] = {"A","B","C","D","E","F","G","H"};
    private int graph[][]= {{0,1,2,3,4,5},
                            {1,0,3,5,12,0},
                            {2,3,0,8,0,0},
                            {3,5,8,0,4,9},
                            {4,12,0,4,0,6},
                            {5,0,0,9,6,0},
                     };
                     
    public int MinimumSource(){
        int round = way.length;
        int vertexmin = 0;
        int wayMin = Integer.MAX_VALUE;
        for(int i = 1; i < round ; i++){
            if(!check[i] && way[i] < wayMin){
                wayMin = way[i];
                vertexmin = i;
                
            }
        }
        return vertexmin;
    }
    public void process(){
        Arrays.fill(check,false);
        Arrays.fill(way,Integer.MAX_VALUE);
        way[point] = 0;
        for(int i=1;i<count;i++){
            int X = MinimumSource();
            check[X] = true;
            for(int Y = 1; Y < count ;Y++){
                if(!check[Y] && graph[X][Y] !=0 && (way[X]+graph[X][Y] < way[Y])){
                    way[Y] = way[X] + graph[X][Y]; }
            }
        }
    }
    public void display(){
        //String format[] = {"a","b","c","d","e","z"};
        String path[] = new String[count];
        try{ 
            for(int i=0;i < count ;i++){
                System.out.print("Step "+i+" Vertex was use ");
            if(i==0){
                path[0] = format[0]; 
                System.out.println(String.format("%2s",path[0]));
                System.out.print(String.format("       Edge   is  %s",path[0]));
            }
            if(i==1){
                path[0] = format[0];
                path[1] = format[1];
                System.out.println(String.format("%2s",path[0]));
                System.out.print(String.format("       Edge   is  %s %s",path[0],path[1]));
            }
            if(i>=2){
                int position =0;
                String Vertex[] = new String[count];
                for(int k=0; k+1<=i ;k++){
                    Vertex[i] = format[k];
                    switch(i){
                       //String format[] = {"a","b","c","e","d","z"};
                        case 2: path[i] = format[position] +" "+ format[i]; break;
                        case 3: path[i] = format[position] +" "+ format[i-1]+" "+ format[i]; break;
                        case 4: path[i] = format[position] +" "+ format[i-2]+" "+ format[i-1]+" "+ format[i]; break;
                        case 5: path[i] = format[position] +" "+ format[i-3]+" "+ format[i-2]+" "+format[i-1]+" "+format[i]; break;
                        case 6: path[i] = format[position] +" "+ format[i-4]+" "+ format[i-3]+" "+ format[i-2]+" "+format[i-1]+" "+format[i]; break;
                        case 7: path[i] = format[position] +" "+ format[i-5]+" "+ format[i-4]+" "+ format[i-3]+" "+ format[i-2]+" "+format[i-1]+" "+format[i]; break;
                    }// switch
                    System.out.print(String.format("%2s",Vertex[i]));
                }// end for loop k    
                if(path[i]!=null){
                    System.out.println();
                    System.out.print(String.format("       Egde   is  %2s",path[i])); 
                }
            }//check 2-6
            System.out.println();
            System.out.println(String.format("This Shortest path have the distance is %1.5s",way[i+1]));
            System.out.println("---------------------------------------------");
            }// end for loop i
        }// try
        catch(ArrayIndexOutOfBoundsException e){ 
                System.out.println("        Distance is not found");
                System.out.println("--------end find shortest path---------");
        }//catch
    }
}
