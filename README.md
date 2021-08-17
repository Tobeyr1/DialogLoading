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
	       implementation 'com.github.Tobeyr1:DialogLoading:1.0.4'
	}
```
# Basic Usage

**Open a DialogLoading:**
```java
Dialog dialog = DialogUtils.Companion.createLoading(context,"text content");
```
**When network or local data loading ends, use it to close the DialogLoading**
```java
 DialogUtils.Companion.closeDialog(dialog);
```
**Compared with 1.0.1, 1.0.2 adds a second loading box：**

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210329135355477.gif#pic_center)

# Basic Usage


**Open a AlertDialog:**

```java
AlertDialog dialog = AlertDialogUtil.Companion.createLoading(this,"登录中..."); //是androidx的分包alertdialog
```

**When network or local data loading ends, use it to close the AlertLoading**

```java
 AlertDialogUtil.Companion.closeDialog(dialog);
```

**Added a new method to change the loading color gradient:**

```java
AlertDialogUtils.setProgressColor(getResources().getColor(R.color.colorAccent));
//used color
<color name="colorAccent">#1C66B6</color>
```

The effect is as follows:

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210329140130486.gif#pic_center)

详细使用效果等可以参考博文[我的第一个开源库-DialogLoading弹出加载框（Kotlin版）](https://blog.csdn.net/Tobey_r1/article/details/114612478)
