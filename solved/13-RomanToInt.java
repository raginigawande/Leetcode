class Solution {
    public int romanToInt(String s) {
        int i=1;
        int v=5;
        int x=10;
        int l=50;
        int c=100;
        int d=500;
        int m=1000;
        int number=0;
        for(int z=0; z<s.length(); z++){
            if(s.charAt(z)=='I'){
                number+=1;
            }else if(s.charAt(z)=='V'){
                if(z != 0 && s.charAt(z-1)=='I')
                   number+=4;
                else 
                    number+=5;
            }else if(s.charAt(z)=='X'){
                if(z != 0 && s.charAt(z-1)=='I')
                   number+=9;
                else 
                    number+=10;
            }else if(s.charAt(z)=='L'){
                if(z != 0 && s.charAt(z-1)=='X')
                   number+=40;
                else 
                    number+=50;
            }else if(s.charAt(z)=='C'){
                if(z != 0 && s.charAt(z-1)=='X')
                   number+=90;
                else 
                    number+=100;
            }else if(s.charAt(z)=='D'){
                if(z != 0 && s.charAt(z-1)=='C')
                   number+=400;
                else 
                    number+=500;
            }else if(s.charAt(z)=='M'){
                if(z != 0 && s.charAt(z-1)=='C')
                   number+=900;
                else 
                    number+=1000;
            }
        }
        return number;
    }
}