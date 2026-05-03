class Solution {
    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int answer = 0;
        
        int start = h1 * 3600 + m1 * 60 + s1;
        int end = h2 * 3600 + m2 * 60 + s2;
        
        for (int i = start; i < end; i++) {
            double hNow = (i * (1.0 / 120.0)) % 360;
            double mNow = (i * (0.1)) % 360;
            double sNow = (i * 6) % 360;
            
            double hNext = ((i + 1) * (1.0 / 120.0)) % 360;
            double mNext = ((i + 1) * (0.1)) % 360;
            double sNext = ((i + 1) * 6) % 360;
            
            if (hNext == 0) hNext = 360;
            if (mNext == 0) mNext = 360;
            if (sNext == 0) sNext = 360;
            
            boolean hMatch = sNow < hNow && sNext >= hNext;
            boolean mMatch = sNow < mNow && sNext >= mNext;
            
            if (hMatch && mMatch) {
                if (hNext == mNext) answer += 1;
                else answer += 2;
            } else if (hMatch || mMatch) {
                answer += 1;
            }
        }
        
        if (start == 0 || start == 12 * 3600) answer += 1;
        
        return answer;
    }
}