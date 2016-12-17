package com.albion.common.maps.hashmap;

import java.util.ArrayList;

public class KyHashMap {
	
	int mBucketSize = -1;
	Bucket[] mBuckets = null;
	
	public KyHashMap(int aBucketSize)
	{		
		mBucketSize = aBucketSize;
		Bucket[] mBuckets = new Bucket[aBucketSize];
		for(int i = 0; i < mBuckets.length; i++)
		{
			mBuckets[i] = (Bucket) new ArrayList<Integer>();
		}
	}

	public int getIndex(Integer anInteger)
	{
		return anInteger.hashCode() % mBucketSize;
	}
	
	public void insert(Integer anInteger)
	{
		int index = getIndex(anInteger);
		mBuckets[index].add(anInteger);
	}
	
	
}
