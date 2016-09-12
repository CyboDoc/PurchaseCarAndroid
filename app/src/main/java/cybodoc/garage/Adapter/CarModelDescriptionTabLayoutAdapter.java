package cybodoc.garage.Adapter;

/**
 * Created by pratheesh on 10-09-2016.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import cybodoc.garage.TabLayoutFragment.Utils.CarModelGalleryFragment;
import cybodoc.garage.TabLayoutFragment.Utils.CarModelPricingFragment;
import cybodoc.garage.TabLayoutFragment.Utils.CarModelReviewsFragment;
import cybodoc.garage.TabLayoutFragment.Utils.CarModelSpecsDetailsFragment;


/**
 * Created by pratheesh on 28-08-2016.
 */
public class CarModelDescriptionTabLayoutAdapter extends FragmentStatePagerAdapter {
    private int mNumOfTabs;

    public CarModelDescriptionTabLayoutAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                CarModelSpecsDetailsFragment tab1 = new CarModelSpecsDetailsFragment();
                return tab1;
            case 1:
                CarModelGalleryFragment tab2 = new CarModelGalleryFragment();
                return tab2;
            case 2:
                CarModelReviewsFragment tab3 = new CarModelReviewsFragment();
                return tab3;
            case 3:
                CarModelPricingFragment tab4 = new CarModelPricingFragment();
                return tab4;

            default:
                return null;


        }
    }


    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

