
package kamise;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author abderrahim
 */
public class Kamise {

   static void kmz(){
   Scanner sc = new Scanner(System.in);
        
        System.out.println("entrer  nombre de point:");
        int p =sc.nextInt();
        int []tx= new int[p]; 
        int []ty= new int[p]; 
        for(int i =0;i<p;i++){
         System.out.println("entrer  point "+((char)(i+65)));
        int x2 =sc.nextInt();
        int y2 = sc.nextInt();
        tx[i]=x2;
        ty[i]=y2;
        }
       System.out.print(" | ");
                for(int i =0;i<p;i++){

        System.out.print(((char)(i+65))+" |");
        
                }
                 System.out.println("");
                 System.out.print(" | ");
                for(int i =0;i<p;i++){

        System.out.print(tx[i]+" |");
                }
                                 System.out.println("");
                                 System.out.print(" | ");

                for(int i =0;i<p;i++){

        System.out.print(ty[i]+" |");
                }
                 System.out.println("");

                
                
                
                
                
                
         System.out.println("nombre centre:");
         int k= sc.nextInt();
         int tc[]= new int[k];
         for(int i =0;i<k;i++){
          System.out.println("choisire le centre "+i+1);
           char c = sc.next().charAt(0);
           tc[i]=c;
         }
         
         
         
           double mat[][]=new double[p][k];
          for(int j=0;j<k;j++){
                           int z = tc[j]-65;

                           
                int d1=tx[z];
                int d2= ty[z];
                int t[]= new int[p];
                
                for(int i=0;i<p;i++){
                t[i]=Math.abs(tx[i]-d1)+Math.abs(ty[i]-d2);
                
                            mat[i][j]= t[i];

                }
                /*for(int i=0;i<p;i++){
                  System.out.print(t[i]+" |");
                    
                }*/
          }
           System.out.println();
                        System.out.println(" ....................................");

          for(int j=0;j<k;j++){
               System.out.print("D(pt, "+(char)(tc[j])+" ) : |");
              for(int i=0;i<p;i++){
                                    System.out.print(mat[i][j]+" |");
                  
              
              }
               System.out.println();
          }
          
          
    
          double min[][]= new double[p][p];
          for(int i =0; i<p;i++){
                                           min[i][0]=mat[i][0];
                                             min[i][1]= 1;

          }
                   
              for(int j=0;j<k-1;j++){         
                for(int i=0; i<p;i++){
                  
                    if(min[i][0]>mat[i][j+1]){
                        min[i][0]=mat[i][j+1];
                        min[i][1]= j+2;
        
                    }
            
                }         
              }  
               System.out.println(" min:  ");
                for(int j=0; j<2;j++){                        
           for(int i=0;i<p;i++){
                                    System.out.print(min[i][j]+" |");
                  
              
              }
            System.out.println("");
           
            }  
                    double  mat_G[][]=new double[k][2];       
                  for(int j=1; j<=k;j++){   
                      double div=0;
                      int i;
                           int clx=0;
                int cly=0;
           for(i=0;i<p;i++){
                        if( min[i][1]==j){
                            clx=clx+ tx[i];
                             cly=cly+ ty[i];
                            div++;
                        }
                  
              
              }
                        double cllx=0;   cllx=clx/div;
                         double clly=0;   clly=cly/div;
                         mat_G[j-1][0]=cllx;              
                         mat_G[j-1][1]=clly;

                          System.out.println("");
                       System.out.println(" centre cl"+j+":  g"+j+"("+cllx+","+clly+")");

           
                  }
                  
                  
                  double pt[]= new double [p];
                 int i=0;
                   Boolean tr= false;
                     while(!tr){
                         System.out.println("#it");
                       tr= true;
                             for(int j=0;j<k;j++){
                           int z = tc[j]-65;

                           
                double d1= mat_G[j][0];
                double d2= mat_G[j][1];
                double t[]= new double[p];
                
                for(int a=0;a<p;a++){
                    
                t[a]=Math.abs(tx[a]-d1)+Math.abs(ty[a]-d2);
                
                            mat[a][j]= t[a];

                }
                /*for(int i=0;i<p;i++){
                  System.out.print(t[i]+" |");
                    
                }*/
          }
              for(int j=0;j<k;j++){
                  int x=j+1;
               System.out.print("D( pt, g"+x+" ) : |");
              for(int a=0;a<p;a++){
                                    System.out.print(
                                           mat[a][j] +" |");
                  
              
              }
               System.out.println();
          }
                     i++;
                     for(int j=0;j<k;j++){
                     pt[j]=min[j][1];
                     }
                     
                     
                         for(int j =0; j<p;j++){
                                           min[j][0]=mat[j][0];
                                             min[j][1]= 1;

          }
                   
              for(int j=0;j<k-1;j++){         
                for(int a=0; a<p;a++){
                  
                    if(min[a][0]>mat[a][j+1]){
                        min[a][0]=mat[a][j+1];
                        min[a][1]= j+2;
        
                    }
            
                }         
              }  
               System.out.println(" min:  ");
                for(int j=0; j<2;j++){                        
           for(int a=0;a<p;a++){
                                    System.out.print(min[a][j]+" |");
                  
              
              }
            System.out.println("");
           
            } 
                     
                     for(int x=0;x<k;x++){
                      if(pt[x]!=min[x][1]) tr = false;
                     }
                     }
                     
                     
                  System.out.println("fine algo");
                 
   }
   
   
   
   
    public static void main(String[] args) {
     
        kmz();
        
    }
    
}

