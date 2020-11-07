package com.android.kisaanyard.Storage;

import android.provider.BaseColumns;

class BeneficiaryContract {
    public static final class BeneficiaryEntry implements BaseColumns {

        public static final String TABLE_NAME = "RegistrationDetails";

        public static final String registrationProfileImage = "RegistrationProfileImage";
        public static final String registrationAadharImage = "RegistrationAadharImage";
    }
}
