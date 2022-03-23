object Versions {

    val OKHTTP_LOGGING_INTERCEPTOR_VERSION ="4.9.0"
    val GLIDE_COMPILER ="4.11.0"
    val GLIDE ="4.12.0"
    val AUTO_IMAGE_SLIDER ="1.4.0-appcompat"
    val DAGGER_PROCESSOR="2.20"
    val DAGGER_SUPPORT ="2.22.1"
    val DAGGER="2.35.1"
    val MULTIDEX ="2.0.1"
    val LIFE_CYCLE_VERSION="2.4.1"
    val NAVIGATION_UI_KTX="2.4.1"
    val NAVIGATION_FRAGMENT_KTX="2.4.1"
    val LIFE_CYCLE_EXT ="2.2.0"
    val TIMBER ="4.7.1"
    val SHIMMER ="0.5.0"
    val COROUTINES ="1.4.3"
    val GSON_CONVERTER ="2.9.0"
    val RETROFIT_VERSION="2.9.0"
    val SDP_SSP="1.0.6"
    val SVG_VIEW="1.0.6"

    val KOTLIN = "1.3.72"
    val COMPILE_SDK = 32
    val MIN_SDK_VERSION = 21
    val TARGET_SDK_VERSION = 32
    val VERSION_CODE = 1
    val VERSION_NAME = "1.0"

    val CORE_KTX = "1.7.0"
    val APP_COMPAT_VERSION="1.4.1"
    val MATERIAL="1.5.0"
    val CONSTRAINT_LAYOUT="2.1.3"
    val LEGACY ="1.0.0"
    val JUNIT="4.13.2"
    val JUNIT_EXT="1.1.3"
    val ESPRESSO="3.4.0"

}

object BuildPlugins {
    val androidApplication = "com.android.application"
    val kotlinAndroid = "kotlin-android"
    val kotlinKapt = "kotlin-kapt"
    val kotlinAndroidExtensions = "kotlin-android-extensions"
//    val androidGradle = "com.android.tools.build:gradle:${Versions.ANDROID_GRADLE_VERSION}"
//    val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"
}

object Android {
    val minSDK = Versions.MIN_SDK_VERSION
    val targetSDK = Versions.TARGET_SDK_VERSION
    val versionCode = Versions.VERSION_CODE
    val versionName = Versions.VERSION_NAME
    val compileSDK = Versions.COMPILE_SDK
    val applicationId = "com.develop.sary"
}

object Libs {
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.KOTLIN}"
    val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.CONSTRAINT_LAYOUT}"
    val livedata = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.LIFE_CYCLE_VERSION}"
    val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:${Versions.NAVIGATION_FRAGMENT_KTX}"
    val navigationUiKtx = "androidx.navigation:navigation-ui-ktx:${Versions.NAVIGATION_UI_KTX}"
    val lifecycleExtensions = "androidx.lifecycle:lifecycle-extensions:${Versions.LIFE_CYCLE_EXT}"
    val appCompat = "androidx.appcompat:appcompat:${Versions.APP_COMPAT_VERSION}"
    val coreExt = "androidx.core:core-ktx:${Versions.CORE_KTX}"
    val material = "com.google.android.material:material:${Versions.MATERIAL}"
    val legacy = "androidx.legacy:legacy-support-v4:${Versions.LEGACY}"
    val animatedSvg = "com.jaredrummler:animated-svg-view:${Versions.SVG_VIEW}"
    val sdp = "com.intuit.sdp:sdp-android:${Versions.SDP_SSP}"
    val ssp = "com.intuit.ssp:ssp-android:${Versions.SDP_SSP}"
    val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.COROUTINES}"
    val facebookShimmer = "com.facebook.shimmer:shimmer:${Versions.SHIMMER}"
    val multidex = "androidx.multidex:multidex:${Versions.MULTIDEX}"
    val autoimageslider = "com.github.smarteist:autoimageslider:${Versions.AUTO_IMAGE_SLIDER}"
    val glide = "com.github.bumptech.glide:glide:${Versions.GLIDE}"
    val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.GLIDE_COMPILER}"

    val dagger = "com.google.dagger:dagger-android:${Versions.DAGGER}"
    val daggerSupport = "com.google.dagger:dagger-android-support:${Versions.DAGGER_SUPPORT}"
    val daggerProcessor = "com.google.dagger:dagger-android-processor:${Versions.DAGGER_PROCESSOR}"
    val daggerCompiler= "com.google.dagger:dagger-compiler:${Versions.DAGGER_PROCESSOR}"
    val retrofit = "com.squareup.retrofit2:retrofit:${Versions.RETROFIT_VERSION}"
    val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.OKHTTP_LOGGING_INTERCEPTOR_VERSION}"
    val gsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.GSON_CONVERTER}"
    val timber =  "com.jakewharton.timber:timber:${Versions.TIMBER}"
}

object TestLibs {
    val junit = "junit:junit:${Versions.JUNIT}"
    val junit_ext = "androidx.test.ext:junit:${Versions.JUNIT_EXT}"
    val espresso = "androidx.test.espresso:espresso-core:${Versions.ESPRESSO}"
}