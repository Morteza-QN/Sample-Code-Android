plugins {
	alias(libs.plugins.android.application)
	alias(libs.plugins.kotlin.android)
	alias(libs.plugins.kapt)
	alias(libs.plugins.hilt)

}

kapt {
	generateStubs = true
	showProcessorStats = true
	// Allow references to generated code
	correctErrorTypes = true
	includeCompileClasspath = false
	// Increase the max count of errors from annotation processors.
	javacOptions { option("-Xmaxerrs", 500) } // vault is 100.
	//    arguments { arg("room.schemaLocation", "$projectDir/schemas") }
}

android {
	namespace = "me.mqn.mvvm"
	compileSdk = 34

	defaultConfig {
		applicationId = "me.mqn.mvvm"
		minSdk = 25
		targetSdk = 34
		versionCode = 1
		versionName = "1.0"

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
		}
	}
	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}
	kotlinOptions {
		jvmTarget = "1.8"
	}
}

dependencies {

	implementation(libs.androidx.core.ktx)
	implementation(libs.androidx.appcompat)
	implementation(libs.material)
	implementation(libs.androidx.activity)
	implementation(libs.androidx.constraintlayout)
	testImplementation(libs.junit)
	androidTestImplementation(libs.androidx.junit)
	androidTestImplementation(libs.androidx.espresso.core)

	implementation(libs.datastore.preferences)
	implementation(libs.hilt.android)
	kapt(libs.hilt.android.compiler)
}