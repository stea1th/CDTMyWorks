/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ipadress;

import java.util.Scanner;

/**
 *
 * @author vvlasov
 */
public class IpAdress {
    public static int schritt;
public static void main(String[] args) {
    System.out.println("Please set IP: ");
    String line = getLines();
    String[] ipAsString = line.split("\\.");
        byte[] ip = new byte[4];
        for (int i = 0; i < ip.length; i++) {
        int x = Integer.valueOf(ipAsString[i]);
        ip[i] =  (byte)x;
        }
        
        System.out.println("Please set SBM: ");
        String[] maskeAsString = getLines().split("\\.");
        byte[] mask = new byte[4];
        for (int i = 0; i < mask.length; i++) {
        int x = Integer.valueOf(maskeAsString[i]);
        mask[i] =  (byte)x;
        }
        //new byte[]{(byte) 112, (byte) 132, (byte)149, 12};
        //new byte[]{(byte) 255, (byte) 255, (byte) 255, (byte)240};
        byte[] netAddress = getNetAddress(ip, mask);
        //print(ip);          //11000000 10101000 00000001 00000010
        //print(mask);        //11111111 11111111 11111110 00000000
        
        System.out.println("Network-Address: "+print(netAddress));  //11000000 10101000 00000000 00000000
        System.out.println("BroadCast-Address: "+print(getBroadCast(netAddress, mask)));
        getNetworksAndHosts(mask);

    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {

        byte[] net = new byte[4];
        for (int i = 0; i <net.length ; i++) {
            net[i] = (byte)(ip[i]&mask[i]);
        }
        for(byte b :mask){
            int x = b<0? b+256 : b;
            if(x!=0&&x!=255){
                switch (x){
                    case 128 :
                        schritt = 128;
                        break;
                    case 192 :
                        schritt = 64;
                        break;
                    case 224 :
                        schritt = 32;
                        break;
                    case 240 :
                        schritt = 16;
                        break;
                    case 248 : 
                        schritt = 8;
                        break;
                    case 252 :
                        schritt = 4;
                        break;
                    case 254 :
                        schritt = 2;
                        break;
                }
            }
        }
        return net;
    }
    
    public static byte[] getBroadCast(byte[] net, byte[] mask){
        
        for (int i = 0; i < mask.length; i++) {
            int x = mask[i]<0? mask[i]+256 : mask[i];
            if(x!=0&&x!=255){
                net[i]+=schritt-1;
                
            }else if(x==0){
                net[i]= (byte)255;
            }
                
        }
        return net;
    }
    
    public static void getNetworksAndHosts(byte[] mask){
        int networks = 0;
        int hosts = 1;
        int SubNetworks = 1;
        for (int i = 0; i < mask.length; i++) {
            int x = mask[i]<0? mask[i]+256 : mask[i];
            if (x==255){
                networks++;
            }else if(x==0){
                hosts++;
            }else{
                SubNetworks = 256/schritt;
            }
        }
        networks = (int)Math.pow(256, networks)*SubNetworks;
        hosts = (int)Math.pow(256, hosts)*schritt-2;
        System.out.println("Possible Networks: "+networks);
        System.out.println("Hosts: "+hosts);
    }
    
    public static String getLines(){
        
        return new Scanner(System.in).nextLine();
    }

    public static String print(byte[] bytes) {
        //StringBuilder builder = new StringBuilder();
        StringBuilder builder2 = new StringBuilder();
        for (byte b : bytes){
            //String line = "";
            int x = b<0? b+256 : b;
            if (builder2.length()==0){
                builder2.append(x);
            }else{
                builder2.append(".").append(x);
                
            }
            /*for (int i = 7; i >-1 ; i--) {
                line +=""+(x>>i)%2;
            }
            builder = builder.append(line).append(" ");*/
        }
        return builder2.toString();
    }
}

