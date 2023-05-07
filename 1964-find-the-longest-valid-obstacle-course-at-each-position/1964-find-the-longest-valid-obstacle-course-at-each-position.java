class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] arr) {
     
        int n = arr.length;
        int[] arrClone = arr.clone();
        Arrays.sort(arrClone);
        
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        
        for(int ele : arrClone) {
            
            if(!map.containsKey(ele)) {
                
                map.put(ele, index++);
            }
        }
        
        SegmentTree tree = new SegmentTree(new int[n]);
        
        int[] ans = new int[n];
        
        for(int i = 0 ; i < n ; i++) {
            
            int actualIndex = map.get(arr[i]);
            int longestObs = tree.query(0, actualIndex);
            ans[i] = longestObs + 1;
            tree.update(actualIndex, ans[i]);
        }
        
        return ans;
    }
}

class SegmentTree {

	int[] seg;
	int n; // arr length not seg length

	SegmentTree(int[] arr) {

		this.n = arr.length;
		seg = new int[4 * n];
		build(0, 0, n - 1, arr);
	}

	int rangeFn(int val1, int val2) {

		//return req functionality(min, max, sum....)

		return Math.max(val1, val2);
	}

	int defaultValue() {

		//return default val for no overlap condition in query

		return Integer.MIN_VALUE;
	}

	void build(int idx, int low, int high, int[] arr) {

		if(low == high) {

			seg[idx] = arr[low];
			return; 
		}

		int mid = (low + high) >> 1;

		build(2 * idx + 1, low, mid, arr);
		build(2 * idx + 2, mid + 1, high, arr);

		seg[idx] = rangeFn(seg[2 * idx + 1], seg[2 * idx + 2]);
	}

	int query(int idx, int low, int high, int left, int right) {

		//complete overlap
		if(left <= low && high <= right) {

			return seg[idx];
		}

		//no overlap
		if(high < left || right < low) {

			return defaultValue();
		}

		//partial overlap
		int mid = (low + high) >> 1;

		int l = query(2 * idx + 1, low, mid, left, right);
		int r = query(2 * idx + 2, mid + 1, high, left, right);

		return rangeFn(l, r);
	}

	int query(int left, int right) {

		return query(0, 0, n - 1, left, right);
	}

	void update(int idx, int low, int high,int pos, int val) {

		if(low == high) {

			seg[idx] = val;
			return;
		}

		int mid = (low + high) >> 1;

		if(pos <= mid) {

			update(2 * idx + 1, low, mid, pos, val);
		}
		else {

			update(2 * idx + 2, mid + 1, high, pos, val);
		}

		seg[idx] = rangeFn(seg[2 * idx + 1], seg[2 * idx + 2]);
	}

	void update(int pos, int val) {

		update(0, 0, n - 1, pos, val);
	}
}
