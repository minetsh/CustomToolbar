# Custom Toolbar

## TitleToolbar

在xml文件中加入`xmlns:app="http://schemas.android.com/apk/res-auto"`，使用自定属性

### 1. 标题

标题的样式是居中的，不可修改，有以下样式可以修改:

- title: 标题内容
- titleTextAppearance: 标题的样式
- titleTextColor: 标题颜色，会覆盖titleTextAppearance中指定的颜色
- titleTextSize: 标题大小，会覆盖titleTextAppearance中指定的大小
- titleVisible: 是否显示标题，默认显示

示例：
![标题图片](/screenshots/title.png)


``` xml
<me.kareluo.custom.toolbar.TitleToolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?attr/actionBarSize"
        android:background="?attr/colorPrimary"
        app:title="标题"
        app:titleTextAppearance="@style/Title_Appearance"
        app:titleTextColor="@android:color/white"
        app:title_gravity="center" />
```

### 2. 副标题

副标题在标题的下面，默认与标题是左对齐

- title_gravity: 用于指定标题和副标题的对其方式

副标题的可修改样式:

- subtitle: 副标题内容
- subtitleTextAppearance: 副标题样式
- subtitleVisible: 是否显示副标题，默认不显示
- subtitleTextColor: 副标题字体颜色，会覆盖subtitleTextAppearance中指定的颜色
- subtitleTextSize: 副标题字体大小，会覆盖subtitleTextAppearance中指定的大小

### 3. 返回按钮

返回按钮的可修改样式:

- backText: 返回按钮内容
- backTextAppearance: 返回按钮的样式
- backTextColor: 返回按钮的颜色，会覆盖backTextAppearance中指定的颜色
- backTextSize: 返回按钮的大小，会覆盖backTextAppearance中指定的大小
- backVisible: 返回按钮是否可见，默认不可见
- backIcon: 返回按钮的drawabkeLeft
- backMarginRight: 返回按钮的marginRight

### 4. 关闭按钮

在返回按钮的右边，用于带有WebView的Activity使用，返回按钮作为WebView的返回，关闭按钮作为整个Activity的关闭

关闭按钮的可修改样式:

- closeText: 关闭按钮内容
- closeTextAppearance: 关闭按钮样式
- closeTextColor: 关闭按钮的颜色，可覆盖closeTextAppearance中指定的颜色
- closeTextSize: 关闭按钮的大小，可覆盖closeTextAppearance中指定的大小
- closeVisible: 关闭按钮是否可见