FRAGMENT

___

ĐỊNH NGHĨA FRAGMENT

- Fragment có vai trò làm giảm tải gánh nặng của Activity.
- nếu ở 1 màn hinh lớn như Tablet, hay các điện thoại có kích thước màn hình lớn, việc 1 Activity sẽ phải gồng gánh các chức năng sẽ làm Activity hoạt động không hiệu quả trong việc đa dụng trên các thể loại màn hình khác nhau.
- Fragment có chức năng tương tự như 1 Activity là hiển thị giao diện, nhưng nó được quản lý bởi Activity.
___

ĐẶC ĐIỂM CỦA FRAGMENT

- quản lý 1 không gian màn hình hoặc toàn bộ màn hình của Activity quản lý nó.
- 1 Fragment phải nằm trong 1 Activity (vì Activity quản lý Fragment).
- nhiều Fragment có thể nằm trong 1 Activity.
- nếu có nhiều Fragment nằm trong 1 Activity, các Fragment đó có thể:
	- đồng thời hiển thị trong Activity đó.
	- luân phiên hiển thị trong Activity đó (tùy theo nhiệm vụ của Fragment).
- 1 Fragment có thể được khai báo và sử dụng bởi nhiều Activity khác nhau.
- Fragment cũng có vòng đời của riêng nó, nhưng vòng đời của nó phụ thuộc cao vào vòng đời của Activity quản lý nó.

___

TẠI SAO LẠI DÙNG FRAGMENT

- khi 1 ứng dụng được thiết kế ra, ta hoàn toàn có thể nắm được cần đến bao nhiều Activity trong ứng dụng đó.
- nhưng đối với Fragment, tùy vào nhu cầu thực tế của từng Activity mà ta nên sử dụng và sử dụng bao nhiêu Fragment cho Activity đó.
- vì vậy, đôi khi có những ứng dụng hoàn toàn không dùng đến Fragment, có ứng dụng lại sử dụng nhiều Fragment trong quá trình xây dựng ứng dụng.
- ưu điểm khi dùng Fragment trong Activity sẽ tiết kiệm thời gian thiết kế và sửa lỗi.
- sử dụng Fragment giúp giảm tải công việc khi phải thiết kế giao diện có thể linh động trên nhiều màn hình kích cỡ khác nhau.

___

FRAGMENT VÀ TƯƠNG THÍCH NGƯỢC

- Fragment ra đời để hỗ trợ giao diện trên tablet. Nên Fragment rất gắn liền với sự ra đời của tablet. 
- hệ điều hành đánh dấu cho việc hỗ trợ chính thức tablet chính là hệ điều hành __Android 3.0 (APL level 11)__.
- nếu project khai báo __minSdkVersion__ từ 11 trở lên, thì nếu sử dụng Fragment mọi thứ hoạt động bình thường.
	- sử dụng Fragment trong gói __android.app__
	- sử dụng phương thức ``getFragmentManager()`` khi cần hiển thị động Fragment lên Activity.
- nếu minSdkVersion nhỏ hơn 11, hệ thống vẫn có hỗ trợ tương thích ngược đối với API < 11, nhưng sẽ có một chút khác biệt đối với việc quyết định sử dụng lớp Fragment.
	- sử dụng Fragment trong gói tương thích ngược __android.support.v4.app__
	- phải dùng phương thức ``getSupportFragmentManager()`` cho mục đích hiển thị động Fragment.
	- Và Activity quản lý Fragment khi này không phải Activity thường mà phải là FragmentActivity.
	- Tuy nhiên nếu Activity hiện tại đang kế thừa từ AppCompatActivity rồi thì cũng yên tâm nhé, vì AppCompatActivity vừa hỗ trợ ActionBar đến các hệ điều hành Android cũ hơn, cũng vừa hỗ trợ cả Fragment.

____

CÁCH XÂY DỰNG 1 FRAGMENT

- việc tổ chức và quản lý UI của Fragment rất giống với Activity.
- nếu như Activity được điểu khiển bởi bộ đôi Java và XML thì Fragment cũng như vậy.
- UI của Fragment được quản lý bởi bộ đôi:
	- __XyzFragment.java__ (chịu trách nhiệm xử lý các logic)
	- __fragment_xyz.xml__ (chịu trách nhiệm hiển thị UI)
- việc khởi tạo Fragment cũng được thực hiện bởi wizard tích hợp sẵn trong Android Studio
- điểm khác biệt của Fragment so với Activity
	- không cần phải khai báo trong AndroidManifest.xml, vì đây không phải là thành phần cơ bản trong ứng dụng
	- không cần sử dụng Intent để kích hoạt 1 Fragment
- chúng ta vẫn sẽ dùng wizard để tạo mới Fragment. Cách tạo này sẽ giúp tạo bộ java và xml.
- để tạo mới Fragment ta thực hiện các bước sau:
  - chuột phải vào thư mục __main/java/[package name]/__ -> __New__ -> __Fragment__ -> chọn 1 Fragment template
  - sau khi chọn 1 template Fragment, 1 dialog tùy chỉnh Fragment mới sẽ xuất hiện gồm các nội dung sau:
    - Fragment name: tên của Fragment java (nên đặt theo mẫu XyzFragment)
    - Fragment Layout name: tên của Fragment xml (hệ thống sẽ tự tạo theo Fragment java với mẫu - fragment_xyz)
    - Source language: chỉ định ngôn ngữ dùng lập trình trên Fragment java (Java hoặc Kotlin)
    - Finish: hoàn tất quá trình tạo Fragment
  - sau khi hoàn tất tạo mới Fragment, 1 file XyzFragment.java và 1 file fragment_xyz.xml sẽ được tạo ra
- hoặc có thể tạo thủ công từng thành phần layout và logic code sau đó kết nối chúng với nhau:
	- tạo layout cho fragment
	- tạo class fragment (extends Fragment)
		- API >= 11, extends Fragment của API androidx.fragment.app.Fragment hoặc android.app.Fragment
		- API < 11, extends Fragment của API android.support.v4.app
	- trong class fragment ta liên kết với layout của fragment

___
___

FRAGMENT DEMO - XÂY DỰNG FRAGMENT VÀ THÊM FRAGMENT VÀO ACTIVITY BẰNG XML

___

XÂY DỰNG FRAGMENT

- đầu tiên ta tạo project __Fragment Demo__
- tạo layout __fragment_a__: chuột phải __res/layout/__ chọn __new/Layout Resource Files__
- __fragment_a.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#FFEB3B"
    android:orientation="vertical">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Fragment A"
        android:textSize="50sp" />

</LinearLayout>
```
- tạo class __FragmentA__: chuột phải __java/package_của_project__ chọn __new/Java Class__
- __FragmentA__ sẽ __extends Fragment__ (android.app.Fragment)
- trong __FragmentA__ ta override method __onCreateView()__
- __onCreateView()__ là callback truyền vào 2 tham số cần chú ý là __LayoutInflater inflater__ và __ViewGroup container__
- chỉnh sửa __return__ của __onCreateView()__ để liên kết class __FragmentA__ với Layout __fragment_a__ của nó
- __FragmentA.java__
```java
package com.hienqp.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class FragmentA extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    		// chỉnh sửa return view của Fragment thông qua inflater bởi method inflate
        return inflater.inflate(R.layout.fragment_a, container, false);
    }
}
```
- tương tự, ta tạo Layout __fragment_b__ và Class __FragmentB__, sau đó liên kết chúng lại
- __fragment_b.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="#E91E63"
    android:orientation="vertical">

    <TextView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="Fragment B"
        android:textSize="50sp" />

</LinearLayout>
```
- __FragmentB.java__
```java
package com.hienqp.fragmentdemo;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

public class FragmentB extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
    		// chỉnh sửa return view của Fragment thông qua inflater bởi method inflate
        return inflater.inflate(R.layout.fragment_b, container, false);
    }
}
```

___

THÊM FRAGMENT VÀO ACTIVITY VỚI XML (KHÔNG LINH HOẠT)

- để thêm cứng Fragment vào Activity bằng XML bắt buộc class Fragment và layout của nó phải được liên kết với nhau như ở trên (FragmentA và FragmentB)
- khai báo thẻ fragment trong activity, với 2 thuộc tính quan trọng cần phải có là:
	- id
	- name
- __main_activity.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="28dp"
        android:text="Hello World"
        android:textSize="50sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <fragment
        android:id="@+id/fragmentA"
        android:name="com.hienqp.fragmentdemo.FragmentA"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="56dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView" />

    <fragment
        android:id="@+id/fragmentB"
        android:name="com.hienqp.fragmentdemo.FragmentB"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="224dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.498"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/fragmentA" />

</androidx.constraintlayout.widget.ConstraintLayout>
```

___

THÊM FRAGMENT VÀO ACTIVITY VỚI CODE JAVA (LINH HOẠT)

- việc thêm Fragment vào Activity bằng cách sử dụng code logic sẽ linh hoạt hơn so với việc gắn cứng bằng XML
- quay trở lại với project __Fragment Demo__, vì bây giờ ta sẽ dùng code để gắn Fragment vào Activity, nên trong __main_activity.xml__ ta xóa bỏ 2 thẻ của __fragmentA_ và __fragmentB__
- vì ta sẽ sử dụng code để gắn Fragment vào Activity nên trong layout của Activity ta khai báo 1 layout dùng để chứa Fragment
- khai báo thẻ __FrameLayout__ trong layout của Activity
- __main_activity.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="28dp"
        android:text="Hello World"
        android:textSize="50sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <FrameLayout
    	android:id="@+id/frameContent"
        android:layout_width="363dp"
        android:layout_height="574dp"
        android:layout_marginTop="44dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView">

    </FrameLayout>

</androidx.constraintlayout.widget.ConstraintLayout>
```

- để thêm Fragment bằng code Java trong MainActivity, bắt buộc phải có những thành phần sau:
	- FragmentManager (android.app)
	- FragmentTransaction (android.app)
- trong __onCreate()__ ta khai báo FragmentManager và FragmentTransaction
```java
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
```
- khai báo 2 object FragmentA và FragmentB
```java
        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();
```
- thêm 2 object FragmentA và FragmentB vào Layout dùng để chứa Fragment trong Layout của Activity đã khai báo trước đó (FrameLayout) thông qua FragmentTransaction
```java
        fragmentTransaction.add(R.id.frameContent, fragmentA);
        fragmentTransaction.add(R.id.frameContent, fragmentB);
```
- cuối cùng để việc thêm Fragment thành công, từ FragmentTransaction ta gọi method commit()
```java
        fragmentTransaction.commit();
```
- __MainActivity.java__
```java
package com.hienqp.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        FragmentManager được lấy từ method getSupportFragmentManager trong trường hợp ta đang
        thao tác với Fragment từ API androidx
        tương tự API của FragmentTransaction cũng theo API của FragmentManager
         */
//        FragmentManager fragmentManager = getSupportFragmentManager();

        /*
        FragmentManager được lấy từ method getFragmentManager trong trường hợp ta đang thao tác
        với Fragment từ API android.app
        tương tự API của FragmentTransaction cũng theo API của FragmentManager
         */
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();

        fragmentTransaction.add(R.id.frameContent, fragmentA);
        fragmentTransaction.add(R.id.frameContent, fragmentB);

        fragmentTransaction.commit();
    }
}
```
- tuy nhiên việc gắn đồng thời 2 FragmentA và FragmentB như trên không hiệu quả, vì Fragment nào được thêm cuối cùng sẽ được hiển thị, các Fragment được thêm trước đó sẽ bị che khuất   

___

REPLACE FRAGMENT - THAY THẾ HOÁN ĐỔI LUÂN PHIÊN FRAGMENT TRÊN ACTIVITY

- việc __add__ FragmentA và FragmentB như trên, thì chỉ có Fragment cuối cùng được add sẽ hiển thị lên màn hình, như vậy sẽ không linh động.
- để việc hiển thị Fragment được linh động, các Fragment có thể hiển thị luân phiên nhau, ta phải replace (thay thế các Fragment với nhau tùy theo nhu cầu)

CHỈNH SỬA LAYOUT CỦA MAIN ACTIVITY

- ta thêm 2 Button vào MainActivity, với mỗi Button khi click vào sẽ hiển thị Fragment tương ứng
- __activity_main.xml__
```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_marginTop="28dp"
        android:text="Hello World"
        android:textSize="50sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent" />

    <FrameLayout
        android:id="@+id/frameContent"
        android:layout_width="350dp"
        android:layout_height="467dp"
        android:layout_marginTop="8dp"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.459"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/buttonAddA">

    </FrameLayout>

    <Button
        android:id="@+id/buttonAddA"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="28dp"
        android:layout_marginTop="8dp"
        android:text="Add Fragment A"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/textView"/>

    <Button
        android:id="@+id/buttonAddB"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:text="Add Fragment B"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.241"
        app:layout_constraintStart_toEndOf="@+id/buttonAddA"
        app:layout_constraintTop_toBottomOf="@+id/textView"/>

</androidx.constraintlayout.widget.ConstraintLayout>
```

- khai báo Button

```
    Button btnAddA, btnAddB;
```

- ánh xạ các Button

```
				btnAddA = findViewById(R.id.buttonAddA);
        btnAddB = findViewById(R.id.buttonAddB);
```  

- ta khai báo FragmentManager bình thường, nhưng với FragmentTransaction có yêu cầu trong 1 Activity chỉ được commit 1 lần, nếu cùng 1 FragmentTransaction mà commit đến lần thứ 2 thì sẽ xảy ra Exception commit already called
- vì thế với mỗi lần click Button ta sẽ tạo mới lại FragmentTransaction và commit với FragmentTransaction đó
- __MainActivity.java__
```java
package com.hienqp.fragmentdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddA, btnAddB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAddA = findViewById(R.id.buttonAddA);
        btnAddB = findViewById(R.id.buttonAddB);

        FragmentA fragmentA = new FragmentA();
        FragmentB fragmentB = new FragmentB();

        /*
        FragmentManager được lấy từ method getSupportFragmentManager trong trường hợp ta đang
        thao tác với Fragment từ API androidx
        tương tự API của FragmentTransaction cũng theo API của FragmentManager
         */
//        FragmentManager fragmentManager = getSupportFragmentManager();

        /*
        FragmentManager được lấy từ method getFragmentManager trong trường hợp ta đang thao tác
        với Fragment từ API android.app
        tương tự API của FragmentTransaction cũng theo API của FragmentManager
         */
        FragmentManager fragmentManager = getFragmentManager();

        /*
        với mỗi sự kiện click Button ta sẽ tạo mới lại FragmentTransaction, vì FragmentTransaction chỉ được
        commit 1 lần, nhưng Button thì được click luân phiên, và ta phải commit luân phiên, nên sẽ xảy ra
        lỗi Exception commit already called nếu dùng 1 FragmentTransaction commit đến lần thứ 2
         */

        btnAddA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // với mỗi sự kiện click Button ta sẽ tạo mới lại FragmentTransaction
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameContent, fragmentA);
                fragmentTransaction.commit();
            }
        });

        btnAddB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // với mỗi sự kiện click Button ta sẽ tạo mới lại FragmentTransaction
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frameContent, fragmentB);
                fragmentTransaction.commit();
            }
        });


    }
}
```

