package com.albion.common.maps.simple;

import java.util.ArrayList;

public class SimpleHashMap {
	
	int mBucketSize = -1;
	SimpleBucket[] mSimpleBuckets = null;
	
	public SimpleHashMap(int aBucketSize) {
		mBucketSize = aBucketSize;
		SimpleBucket[] mSimpleBuckets = new SimpleBucket[aBucketSize];
		for(int i = 0; i < mSimpleBuckets.length; i++) {
			mSimpleBuckets[i] = (SimpleBucket) new ArrayList<Integer>();
		}
	}

	public int getIndex(Integer anInteger) {
		return anInteger.hashCode() % mBucketSize;
	}
	
	public void insert(Integer anInteger) {
		int index = getIndex(anInteger);
		mSimpleBuckets[index].add(anInteger);
	}
}
