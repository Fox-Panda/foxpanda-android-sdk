package com.example.sampleApp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.sdk.foxpanda.main.AppBackgroundHelper
import com.sdk.foxpanda.main.FoxPanda
import com.sdk.foxpanda.utils.ForceUpdateUtil
import java.util.HashMap

class MainActivity : AppCompatActivity() {
    val myApp = FoxApplication().instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init foxpanda sdk
        FoxPanda.initialize(this,"XXXXXXXXXXXX")

        // track user engagement in activites
        AppBackgroundHelper.init(/*"Your application class instance"*/myApp,this)


       // check for for update
        ForceUpdateUtil.checkForceUpdate(this)

        // set tags to the user
        setUserAttribute()


        // set custom tags to the user
        val map = HashMap<String,String>()
        map.put("preferred_lang_1","Hindi")
        map.put("preferred_lang_2","English")
        FoxPanda.setTagToPanda(this,map)


    }

    private  fun setUserAttribute(){
        FoxPanda.setUniqueID("1212",this)
        FoxPanda.setUserGender(FoxPanda.MALE,this)
        FoxPanda.setUserEmail("xyz@mail.com",this)
        FoxPanda.setUserFirstName("X",this)
        FoxPanda.setUserLastName("Z",this)
        FoxPanda.setUserFullName("XYZ",this)
        FoxPanda.setUserMobile("XXXXXXXXXXX",this)
        FoxPanda.setUserBirthDate("DD/MM/YYYY",this)
    }
}
