# DialogLoading
---------------------------
**DialogLoading is a pop-up loading box, there will be multi style loading**

![design sketch](https://img-blog.csdnimg.cn/20210310011926890.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L1RvYmV5X3Ix,size_16,color_FFFFFF,t_70#pic_center)

# Quick Setup
**Add it in your root build.gradle at the end of repositories:**

```java
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```
**Then add the dependency:**
```java
dependencies {
	        implementation 'com.github.Tobeyr1:DialogLoading:Tag'
	}
```
# Basic Usage

**Open a DialogLoading:**
```java
Dialog dialog = DialogUtil.createLoadingDialog(context,"text content");
```
**When network or local data loading ends, use it to close the DialogLoading**
```java
 DialogUtil.closeDialog(dialog);
```

详细使用效果等可以参考博文[我的第一个开源库-DialogLoading弹出加载框](https://blog.csdn.net/Tobey_r1/article/details/114612478)
