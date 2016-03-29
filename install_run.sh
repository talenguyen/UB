./gradlew $1 
adb shell am start  -n "vn.tale.ub.mock/vn.tale.ub.ui.list.ListUserActivity" -a android.intent.action.MAIN -c android.intent.category.LAUNCHER

