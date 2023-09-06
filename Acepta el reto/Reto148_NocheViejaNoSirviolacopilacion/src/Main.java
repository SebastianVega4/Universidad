import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int i=0;
        int p=0;
        int s=0;
        String[] n=new String[5];
        while(p!=1440){
            n[i]=sc.nextLine();
            String z=String.valueOf(n[i].charAt(0));
            String x=String.valueOf(n[i].charAt(1));
            String c=String.valueOf(n[i].charAt(3));
            String v=String.valueOf(n[i].charAt(4));
            p=Integer.parseInt(z+x);
            s=Integer.parseInt(c+v);
            if(p!=0){
                p=60*(23-p);
            }else {
                p=1380;
            }
            p=p+60-s;
            n[i]=String.valueOf(p);
            ++i;
        }
        for (String v:n)if (v!=null&&!v.equals("1440")){System.out.println(v);}
    }
}