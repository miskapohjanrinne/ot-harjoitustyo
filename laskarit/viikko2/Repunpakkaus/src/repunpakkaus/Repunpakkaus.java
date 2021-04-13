/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repunpakkaus;

/**
 *
 * @author Miska
 */
public class Repunpakkaus {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        boolean[] painot = new boolean[14];
        int[] p = new int [4];

        p[0] = 2;
        p[1] = 3;
        p[2] = 3;
        p[3] = 5;
        painot[0] = true;
        for (int i = 1; i < 14; i++) {
            painot[i] = false;
        }
        int s = 2+3+3+5;
        
        for (int i = 0; i < 4; i++) {
            for (int j = s; j >= 0; j--) {
                if (painot[j]) {
                    painot[j+p[i]] = true;
                }
            }
        }
        
        for (int i = 0; i < s; i++) {
            if (painot[i]) {
                System.out.println("T");
            } else {
                System.out.println("F");
            }
        }
        
    }
    
}
