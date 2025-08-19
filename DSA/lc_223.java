public class lc_223 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int l1 = ax2 - ax1, l2 = bx2 - bx1, b1 = ay2 - ay1, b2 = by2 - by1;
        int area1 = l1 * b1, area2 = l2 * b2;
        int l3 = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1)), b3 = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));
        int area3 = Math.abs(l3) * Math.abs(b3);
        return (area1 + area2) - area3;
    }
}

