# Nanochips for Android

Nanochips is a library for Android that provides a custom TextView allowing users to enter text and create material chips in the text field.

# Installation
**Step 1:** Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```
**Step 2:** Add the dependency

```
dependencies {
	        implementation 'com.github.969rishi:nanochips:1.0.0'
	}
 ```
 
 # Basic Usage
 Include a ```RecyclerView``` in your xml layout as follows:
 ```
     <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/nanochips_tags_recyclerview"
        android:layout_width="match_parent"
        android:layout_height="150dp"
        android:orientation="vertical"
        android:padding="5dp" />
```

To initialize nano chips **without pre loaded** chips just do the following:
```
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.nanochips_tags_recyclerview);
        new NanoChipClass(MainActivity.this, recyclerView);
    }
 ```
 
To initialize nano chips **with pre-loaded** chips, just do the following:
```
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.message_textview);
        RecyclerView recyclerView = findViewById(R.id.nanochips_tags_recyclerview);
        ArrayList<String> list = new ArrayList<>();
        list.add("Mango");
        list.add("Grapes");
        list.add("Banana");
        list.add("Avocados");
        list.add("Dragon Fruit");
        list.add("strawberries");
        list.add("blueberries");
        new NanoChipClass(MainActivity.this, recyclerView, list);
    }
 ```
 
 # To get the values of chips
 It returns the list even if it is null, it will return empty list to avoid **NullPointerException**
 ```
 button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<String> list = NanoChipClass.getAllChipsValues();

                Log.d(TAG, "onClick: lenght of nano chips " + list.size());
                for (String s : list) {
                    Log.d(TAG, "Values = " + s);
                }
            }
        });
```

You can get values with any for loop
```
 List<String> list = NanoChipClass.getAllChipsValues();
                for (int i = 0; i < list.size(); i++) {
                    Log.d(TAG, "Values = " + list.get(i));
                }
```

# License
Nanochips is released under the MIT License. See [LICENSE](#LICENSE) for details. 

Hello, this is some text to fill in this, [LICENSE](https://github.com/969rishi/nanochips/blob/master/LICENSE), is a link to the second place.

Place one has the fun times of linking here, but I can also link back [LICENSE](#place-1).
 
