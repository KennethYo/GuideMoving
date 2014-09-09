package com.example.kenneth.guidemoving;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class GuideFragmentAdapter extends FragmentPagerAdapter {
	/**
	 * 作用: FRAGMENT数量
	 */
	private int NUMS = 4;
	public GuideFragmentAdapter(FragmentManager fm) {
		super(fm);
	}
	@Override
	public Fragment getItem(int arg0) {
		switch (arg0) {
		case 0:
			return GuideFragment.newInstance(arg0,R.drawable.bg_guide_1);
		case 1:
			return GuideFragment.newInstance(arg0,R.drawable.bg_guide_2);
		case 2:
			return GuideFragment.newInstance(arg0,R.drawable.bg_guide_3);
		case 3:
			return GuideFragment.newInstance(arg0,R.drawable.bg_guide_4);
		default:
			break;
		}
		return null;
	}

	@Override
	public int getCount() {
		return NUMS;
	}
	

}
