# **Android MVVM**

## **Intro**
If you are not yet sold on Android Data Binding [please click here](https://developer.android.com/topic/libraries/data-binding/index.html). Once you start using Android data binding its imperative that you design your apps using the [MVVM architecture](https://www.codeproject.com/Articles/100175/Model-View-ViewModel-MVVM-Explained).

This is where Android MVVM can be helpful. Just extend from our VMActivity / VMFragment and forget about *Android Configuration* changes. Its all taken care of for you... so just *MVVM*....

## **Usage**
 - Your Activities should extend the **VMActivity`<T>`** class.
 - Your Fragments should extend the **VMFragment`<T>`** class.
 - Provide your ViewModel using the *T provideViewModel()* method.
 - If you don't want your viewModel to be persisted across Android configuration change set the boolean *saveOnConfigChange  to false* (*default - true*).
 - Now your *viewModel* variable should be ready for use; in most cases you would set it to your [layout binding class](https://developer.android.com/topic/libraries/data-binding/index.html).

## **Sample Code**

    public class MainActivity extends VMActivity<MainViewModel> {

     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         ActivityMainBinding binding = DataBindingUtil
                 .setContentView(this, R.layout.activity_main);
         binding.setViewModel(viewModel);
     }

     @NonNull
     @Override
     public MainViewModel provideViewModel() {
        return new MainViewModel(VenueRepository.getInstance());
     }
    }


##Download

    allprojects {
        repositories {
            jcenter()
            maven { url "https://jitpack.io" }
        }
    }

and:

    dependencies {
        compile 'com.github.aprofromindia:android-mvvm:{latest-version}'
    }

Latest Version - ![Release](https://jitpack.io/v/aprofromindia/android-mvvm.svg)

Note: do not add the jitpack.io repository under `buildscript`.

##Licenses

*Released under the [Apache 2.0 license](https://www.apache.org/licenses/LICENSE-2.0).*

