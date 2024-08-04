class FinalPrices {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> s = new Stack<>();

        for(int i=prices.length-1; i>=0; i--){
            if(s.isEmpty()){
                result[i] = prices[i];
            }else if(s.peek() <= prices[i]){
                result[i] = prices[i] - s.peek();
            }else if(s.peek() > prices[i]){
                while(!s.isEmpty() && s.peek() > prices[i])
                    s.pop();
                if(s.isEmpty())
                    result[i] = prices[i];
                else
                    result[i] = prices[i] - s.peek();
            }
            s.push(prices[i]);
        }
        return result;
    }
}
