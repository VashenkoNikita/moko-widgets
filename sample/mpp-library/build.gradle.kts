/*
 * Copyright 2019 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("multiplatform-library-convention")
    id("detekt-convention")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dev.icerock.mobile.multiplatform-resources")
    id("dev.icerock.mobile.multiplatform.ios-framework")
    id("dev.icerock.mobile.multiplatform.cocoapods")
}

android {
    buildFeatures.dataBinding = true

    lintOptions {
        disable("ImpliedQuantity")
    }
}

dependencies {
    commonMainImplementation(libs.coroutines)

    commonMainApi(libs.mokoMedia)
    commonMainApi(libs.mokoPermissions)
    commonMainApi(libs.mokoResources)
    commonMainApi(libs.mokoMvvmCore)
    commonMainApi(libs.mokoUnits)
    commonMainApi(libs.mokoGraphics)
    
    commonMainApi(projects.widgets)
    commonMainApi(projects.widgetsBottomsheet)
    commonMainApi(projects.widgetsCollection)
    commonMainApi(projects.widgetsDatetimePicker)
    commonMainApi(projects.widgetsImageNetwork)
    commonMainApi(projects.widgetsMedia)
    commonMainApi(projects.widgetsPermissions)
    commonMainApi(projects.widgetsSms)

    androidMainImplementation(libs.recyclerView)
    androidMainImplementation(libs.appCompat)
    androidMainImplementation(libs.material)
    androidMainImplementation(libs.mokoMvvmDataBinding)
}

framework {
    export(libs.mokoWidgets)
    export(libs.mokoWidgetsBottomSheet)
    export(libs.mokoWidgetsCollection)
    export(libs.mokoWidgetsDateTimePicker)
    export(libs.mokoWidgetsImageNetwork)
    export(libs.mokoWidgetsMedia)
    export(libs.mokoWidgetsPermissions)
    export(libs.mokoWidgetsSms)
}

multiplatformResources {
    multiplatformResourcesPackage = "com.icerockdev.library"
}

cocoaPods {
    podsProject = file("../ios-app/Pods/Pods.xcodeproj")

    pod("moko-widgets-bottomsheet", "mokoWidgetsBottomSheet", onlyLink = true)
    pod("moko-widgets-collection", "mokoWidgetsCollection", onlyLink = true)
    pod("moko-widgets-datetime-picker", "mokoWidgetsDateTimePicker", onlyLink = true)
    pod("moko-widgets-image-network", "mokoWidgetsImageNetwork", onlyLink = true)
    pod("mppLibraryIos")
}
