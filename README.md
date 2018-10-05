# android-sample-appium

This project fuels the automated mobile
testing, it uses Appium and the tests are
written in Java.


## Installing Appium
 
### Prerequisites

In order to run an automatic test in Appium, it is needed to install few things. Let's start.

#### Node.js

##### Linux

If you are running Debian, you will need to have a recent version of nodejs, to achieve
this:

```
cd ~
curl -sL https://deb.nodesource.com/setup_6.x -o nodesource_setup.sh
sudo bash nodesource_setup.sh
sudo apt-get install build-essential
```

Appium requires Node.js to be installed in order to run. This could be install via

```
sudo apt-get install -y nodejs
```

Or equivalent in your Linux distribution.

##### Mac

On Mac it is recommended to install Node.js via Homebrew

```
brew install node
```

#### Appium Server

According to your operative system, Appium Server installation will vary. For Windows and Mac it is possible to download a
server with GUI from http://appium.io/ ,but there is no GUI on Linux. For Linux, Appium should be installed via npm

```
npm install appium
```

If you installed appium but it doesn't seem to appear on the path, make sure
you add to your .bashrc or your preferred init script of your shell the
bin dir of your node_modules

```
export PATH="$PATH:~/node_modules/.bin"
```

#### Android Studio

For Android projects, it is necessary to [download](https://developer.android.com/studio/index.html) Android SDK or Android Studio, that will give us the possibility to use Android Virtual Devices for ru$
For Linux it could be advisable to add $ANDROID_HOME/tools/bin ot use uiautomatorviewer, tool that will be used to identify interface elements on Android apps.
$PATH could be set by adding some few lines to ~/.bashrc. Please check following example before you start working with Appium,

```
vim ~/.bashrc

#At the end of the file paste something like the following
#export ANDROID_HOME=$HOME/Android/Sdk
#export PATH=$PATH:$ANDROID_HOME/tools
#export PATH=$PATH:$ANDROID_HOME/platform-tools
#export PATH=$PATH:$ANDROID_HOME/tools/bin
#export JAVA_HOME=/usr/lib/jvm/java-8-oracle
#export PATH=$PATH:$JAVA_HOME/bin
```

#### Appium Doctor

Since Appium needs a lot of configuration, it is needed to double check all is configured accordingly using Appium Doctor,
that is available on the Appium Server GUI or could be installed via npm
```
npm install appium-doctor
```
Be sure all is checked.It is possible that this step could lead you to install a lot of things or correct JAVA_HOME or ANDROID_HOME. It will also check that Carthage was found. If you have any issue, run$

### Getting your APK and install it to an emulator

If you don't have your APK, you could download it from https://apkpure.com/, in case you want to play with an app that is
available in the Play Store. You can install the app on your emulator using ADB.
```
adb install '/path_to_your_apk.apk'
```
Or you can drag your APK and drop it on the emulator you want to install it.

### Capabilities
Working on emulators or real devices requires configuration of capabilities. Main capabilities are 'platformName' , 
'platformVersion' , 'deviceName' , and 'app'. You might change this on the code accordingly if you want to test on a
different emulator form the default one (Android 7.1.1) .

For more information about capabilities, please refer to https://appium.io/slate/en/master/?ruby#appium-server-capabilities .

### Running Appium

To start Appium Server through terminal just write
```
appium --address 127.0.0.1 --port 4723
```

Or click on play button at GUI (Only for OSX and Windows)

### Running tests

To run test, you can use any IDE or use Maven to run available tests. Please, wait for Appium server to be ready before
trying to run tests.

### Having fun

Automatic tests could take some time to program but never forget to have fun playing with them!
