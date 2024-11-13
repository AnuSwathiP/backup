package appiumscenarios;

import java.util.List;

import org.testng.annotations.Test;

import generic.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestPerformanceParametersForDevice_4 {
	 //https://appium.readthedocs.io./en/latest/en/commands/device/performance-data/get-performance-data/#get-performance-data
	  //https://appium.readthedocs.io./en/latest/en/commands/device/performance-data/README/
  @Test
  public void deviceTest() throws InterruptedException {
	//create a driver session
	  AppiumDriver driver =Utility.createdriversession();
	  //PerformanceDataTypes
	  System.out.println("Get the Performance Data Types");
	  List<String> dataType=((AndroidDriver)driver).getSupportedPerformanceDataTypes();
	  System.out.println(dataType);
	  //output:-[cpuinfo, memoryinfo, batteryinfo, networkinfo]
	  System.out.println("Performance Parameters for battery");
	  //apppackagename-io.appium.android.apis
	  List<List<Object>> batterydata=((AndroidDriver)driver).getPerformanceData("io.appium.android.apis", "batteryinfo", 5);
	  //packagename,datatype,readtimeout
	  System.out.println(batterydata);
	  //output:-[[power], [100]]
	  System.out.println("Performance Parameters for Memory");
	  List<List<Object>> memorydata=((AndroidDriver)driver).getPerformanceData("io.appium.android.apis", "memoryinfo", 5);
	  System.out.println(memorydata);
	  //[[totalPrivateDirty, nativePrivateDirty, dalvikPrivateDirty, eglPrivateDirty, glPrivateDirty, totalPss, nativePss, dalvikPss, eglPss, glPss, nativeHeapAllocatedSize, nativeHeapSize, nativeRss, dalvikRss, totalRss], [24868, 12580, 1836, null, null, 38284, 12677, 1898, null, null, 16797, 22412, 13764, 2588, 118236]]
	  System.out.println("Performance Parameters for Network");
	  List<List<Object>> networkdata=((AndroidDriver)driver).getPerformanceData("io.appium.android.apis", "networkinfo", 5);
	  System.out.println(networkdata);
	  //[[st, activeTime, rb, rp, tb, tp, op, bucketDuration], [1723064400, null, 0, 0, 914, 14, 0, 3600], [NetworkStatsHistory: bucketDuration=, null, 0, 0, 914, 14, 0, 3600], [1723050000, null, 0, 0, 75, 1, 0, 3600], [1723064400, null, 924, 3, 1852, 7, 0, 3600], [1723086000, null, 1076, 2, 2152, 4, 0, 3600], [NetworkStatsHistory: bucketDuration=, null, 1076, 2, 2152, 4, 0, 3600], [1723050000, null, 9820648, 8072, 557925, 3287, 0, 3600], [1723053600, null, 449563, 701, 144765, 549, 0, 3600], [1723057200, null, 667553, 759, 155961, 558, 0, 3600], [1723060800, null, 31486, 91, 33041, 250, 0, 3600], [1723064400, null, 647553, 797, 147449, 1312, 0, 3600], [1723068000, null, 41738, 114, 38542, 104, 0, 3600], [1723071600, null, 15065, 58, 11508, 36, 0, 3600], [1723075200, null, 318062, 426, 123252, 358, 0, 3600], [1723078800, null, 6066525, 4405, 191443, 1198, 0, 3600], [1723082400, null, 55080, 153, 97397, 265, 0, 3600], [1723086000, null, 11322, 39, 12777, 65, 0, 3600], [, null, 11322, 39, 12777, 65, 0, 3600], [BPF, null, 11322, 39, 12777, 65, 0, 3600]]
	  Thread.sleep(2000);
	  System.out.println("Performance Parameters for CPU");
	  List<List<Object>> cpudata=((AndroidDriver)driver).getPerformanceData("io.appium.android.apis", "cpuinfo", 5);
	  System.out.println(cpudata);
	  //[[user, kernel], [0, 0]]
  }
}
