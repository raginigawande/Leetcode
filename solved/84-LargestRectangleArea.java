class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] right = new int[heights.length];
        int[] left = new int[heights.length];
        int count=0;
        int maxHeight=0;
        int notFoundIndex = heights.length;
        Stack<Integer> s = new Stack<>();

        for(int i=heights.length-1; i>=0; i--){
            if(s.isEmpty())
                right[i] = notFoundIndex;
            else if(heights[s.peek()] < heights[i])
                right[i] = s.peek();
            else if(heights[s.peek()] >= heights[i]){
                while(!s.isEmpty() && heights[s.peek()] >= heights[i])
                    s.pop();
                if(s.isEmpty())
                    right[i] = notFoundIndex;
                else
                    right[i] = s.peek();
            }
            s.push(i);
        }
        while(!s.isEmpty())
            s.pop();

        notFoundIndex = -1;
        for(int i=0; i<heights.length; i++){
           if(s.isEmpty())
                left[i] = notFoundIndex;
            else if(heights[s.peek()] < heights[i])
                left[i] = s.peek();
            else if(heights[s.peek()] >= heights[i]){
                while(!s.isEmpty() && heights[s.peek()] >= heights[i])
                    s.pop();
                if(s.isEmpty())
                    left[i] = notFoundIndex;
                else
                    left[i] = s.peek();
            }
            s.push(i);
        }
        for(int i=0; i<heights.length; i++){
            maxHeight = Math.max(maxHeight,((right[i] - left[i] - 1) * heights[i]));
        }

        return maxHeight;
    }   
}